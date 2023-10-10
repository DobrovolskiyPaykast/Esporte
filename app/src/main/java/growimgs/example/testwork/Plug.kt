package growimgs.example.testwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testwork.databinding.ActivityPlugBinding

class Plug : AppCompatActivity() {
    private lateinit var binding: ActivityPlugBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlugBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageButton.setOnClickListener{
            val intent = Intent(this, Rules::class.java)
            startActivity(intent)
        }
        binding.imageButton2.setOnClickListener{
            val intent = Intent(this, Food::class.java)
            startActivity(intent)
        }
        binding.imageButton3.setOnClickListener{
            val intent = Intent(this, Training::class.java)
            startActivity(intent)
        }

        binding.button5.setOnClickListener{
            val intent = Intent(this, Rules::class.java)
            startActivity(intent)
        }
        binding.button6.setOnClickListener{
            val intent = Intent(this, Food::class.java)
            startActivity(intent)
        }
        binding.button7.setOnClickListener{
            val intent = Intent(this, Training::class.java)
            startActivity(intent)
        }

    }
}