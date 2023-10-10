package growimgs.example.testwork

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testwork.databinding.ActivityRulesBinding
import com.google.gson.Gson
import java.io.IOException


class Rules : AppCompatActivity() {
    private lateinit var binding: ActivityRulesBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRulesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jsonString: String
        var i: Int = 1
        try {
            jsonString = applicationContext.assets.open("myjson.json").bufferedReader().use { it.readText() }
            val obj: PojoClass = Gson().fromJson(jsonString, PojoClass::class.java)

            for (o in obj.rules){
                if (i == 1){
                    binding.textView2.setText("${i.toString()}. $o")
                }else{
                    binding.textView2.setText("${binding.textView2.text}\n\n${i.toString()}. $o")
                }
                i++
            }

        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
    }
}




