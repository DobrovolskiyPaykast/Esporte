package growimgs.example.testwork


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testwork.databinding.ActivityTrainingBinding
import com.google.gson.Gson
import java.io.IOException


class Training : AppCompatActivity() {
    private lateinit var binding: ActivityTrainingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrainingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vis()

        val jsonString: String

        try {
            jsonString = applicationContext.assets.open("myjson.json").bufferedReader().use { it.readText() }
            val obj: PojoClass = Gson().fromJson(jsonString, PojoClass::class.java)

            textAdd(obj.day1, binding.textView7)
            textAdd(obj.day3, binding.textView102)
            textAdd(obj.day5, binding.textView104)
            textAdd(obj.day7, binding.textView106)
            textAdd(obj.day9, binding.textView108)
            textAdd(obj.day11, binding.textView110)
            textAdd(obj.day13, binding.textView112)
            textAdd(obj.day15, binding.textView114)
            textAdd(obj.day17, binding.textView116)
            textAdd(obj.day19, binding.textView118)
            textAdd(obj.day21, binding.textView120)
            textAdd(obj.day23, binding.textView122)
            textAdd(obj.day25, binding.textView124)
            textAdd(obj.day27, binding.textView126)
            textAdd(obj.day29, binding.textView128)

            } catch (ioException: IOException) {
            ioException.printStackTrace()
        }

    }

    fun textAdd(obj: List<List<String>>, view: TextView){
        var check = 0
        var i: Int = 1
        for (o in obj){
                check=0
                for (d in o) {
                    if (check==0) {
                        if (i == 1) {
                            view.setText("${i}. ${o.get(0)} - ${o.get(1)}\n${o.get(2)}")
                        } else {
                            view.setText("${view.text}\n\n${i}. ${o.get(0)} - ${o.get(1)}\n${o.get(2)}")
                        }
                        i++
                    }
                    check++
                }


        }
    }

    fun vis (){
        binding.textView101.setOnClickListener{
            if (binding.textView102.visibility == View.GONE){
                binding.textView102.visibility = View.VISIBLE
            }
            else{
                binding.textView102.visibility = View.GONE
            }
        }
        binding.textView103.setOnClickListener{
            if (binding.textView104.visibility == View.GONE){
                binding.textView104.visibility = View.VISIBLE
            }
            else{
                binding.textView104.visibility = View.GONE
            }
        }
        binding.textView105.setOnClickListener{
            if (binding.textView106.visibility == View.GONE){
                binding.textView106.visibility = View.VISIBLE
            }
            else{
                binding.textView106.visibility = View.GONE
            }
        }
        binding.textView107.setOnClickListener{
            if (binding.textView108.visibility == View.GONE){
                binding.textView108.visibility = View.VISIBLE
            }
            else{
                binding.textView108.visibility = View.GONE
            }
        }
        binding.textView109.setOnClickListener{
            if (binding.textView110.visibility == View.GONE){
                binding.textView110.visibility = View.VISIBLE
            }
            else{
                binding.textView110.visibility = View.GONE
            }
        }
        binding.textView111.setOnClickListener{
            if (binding.textView112.visibility == View.GONE){
                binding.textView112.visibility = View.VISIBLE
            }
            else{
                binding.textView112.visibility = View.GONE
            }
        }
        binding.textView113.setOnClickListener{
            if (binding.textView114.visibility == View.GONE){
                binding.textView114.visibility = View.VISIBLE
            }
            else{
                binding.textView114.visibility = View.GONE
            }
        }
        binding.textView115.setOnClickListener{
            if (binding.textView116.visibility == View.GONE){
                binding.textView116.visibility = View.VISIBLE
            }
            else{
                binding.textView116.visibility = View.GONE
            }
        }
        binding.textView117.setOnClickListener{
            if (binding.textView118.visibility == View.GONE){
                binding.textView118.visibility = View.VISIBLE
            }
            else{
                binding.textView118.visibility = View.GONE
            }
        }
        binding.textView119.setOnClickListener{
            if (binding.textView120.visibility == View.GONE){
                binding.textView120.visibility = View.VISIBLE
            }
            else{
                binding.textView120.visibility = View.GONE
            }
        }
        binding.textView121.setOnClickListener{
            if (binding.textView122.visibility == View.GONE){
                binding.textView122.visibility = View.VISIBLE
            }
            else{
                binding.textView122.visibility = View.GONE
            }
        }
        binding.textView123.setOnClickListener{
            if (binding.textView124.visibility == View.GONE){
                binding.textView124.visibility = View.VISIBLE
            }
            else{
                binding.textView124.visibility = View.GONE
            }
        }
        binding.textView125.setOnClickListener{
            if (binding.textView126.visibility == View.GONE){
                binding.textView126.visibility = View.VISIBLE
            }
            else{
                binding.textView126.visibility = View.GONE
            }
        }
        binding.textView127.setOnClickListener{
            if (binding.textView128.visibility == View.GONE){
                binding.textView128.visibility = View.VISIBLE
            }
            else{
                binding.textView128.visibility = View.GONE
            }
        }
        binding.textView6.setOnClickListener{
            if (binding.textView7.visibility == View.GONE){
                binding.textView7.visibility = View.VISIBLE
            }
            else{
                binding.textView7.visibility = View.GONE
            }
        }
    }
}