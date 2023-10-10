package growimgs.example.testwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.testwork.databinding.ActivityFoodBinding
import com.google.gson.Gson
import java.io.IOException

class Food : AppCompatActivity() {
    private lateinit var binding: ActivityFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jsonString: String

        try {
            jsonString = applicationContext.assets.open("myjson.json").bufferedReader().use { it.readText() }
            val obj: PojoClass = Gson().fromJson(jsonString, PojoClass::class.java)

            textAdd(obj.breakfast, binding.textView10)
            textAdd(obj.snack1, binding.textView12)
            textAdd(obj.lunch, binding.textView14)
            textAdd(obj.snack2, binding.textView16)
            textAdd(obj.dinner, binding.textView18)

        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }


        binding.textView4.setOnClickListener{
            if (binding.textView10.visibility == View.GONE){
                binding.textView10.visibility = View.VISIBLE
            }
            else{
                binding.textView10.visibility = View.GONE
            }
        }

        binding.textView11.setOnClickListener{
            if (binding.textView12.visibility == View.GONE){
                binding.textView12.visibility = View.VISIBLE
            }
            else{
                binding.textView12.visibility = View.GONE
            }
        }

        binding.textView13.setOnClickListener{
            if (binding.textView14.visibility == View.GONE){
                binding.textView14.visibility = View.VISIBLE
            }
            else{
                binding.textView14.visibility = View.GONE
            }
        }

        binding.textView15.setOnClickListener{
            if (binding.textView16.visibility == View.GONE){
                binding.textView16.visibility = View.VISIBLE
            }
            else{
                binding.textView16.visibility = View.GONE
            }
        }

        binding.textView17.setOnClickListener{
            if (binding.textView18.visibility == View.GONE){
                binding.textView18.visibility = View.VISIBLE
            }
            else{
                binding.textView18.visibility = View.GONE
            }
        }
    }
    fun textAdd(obj: List<String>, view: TextView){
        var i: Int = 1
        for (o in obj){
            if (i == 1){
                view.setText("${i.toString()}. $o")
            }else{
                view.setText("${view.text}\n\n${i.toString()}. $o")
            }
            i++
        }
    }
}