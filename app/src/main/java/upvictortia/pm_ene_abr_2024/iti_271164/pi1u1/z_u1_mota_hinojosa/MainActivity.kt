package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var continueBtn: Button
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        continueBtn = findViewById(R.id.btn_continue)
        textView1 = findViewById(R.id.text_view1)
        textView2 = findViewById(R.id.text_view2)
        continueBtn.setOnClickListener { view ->
            val toast = Toast.makeText(this,"",Toast.LENGTH_SHORT)
            try {
                if (textView1.text.isNotEmpty() || textView2.text.isNotEmpty()) {
                    val count1 = Integer.parseInt(textView1.text.toString())
                    val count2 = Integer.parseInt(textView2.text.toString())
                    if (count1 > 0 && count2 > 0) {
                        val intent = Intent(this,InputActivity::class.java).apply {
                            putExtra("COUNT1",count1)
                            putExtra("COUNT2",count2)
                        }
                        startActivity(intent)
                    }
                    else {
                        throw NumberFormatException("Número Inválido")
                    }
                } else {
                    throw IllegalArgumentException("Ningún campo debe de estar vacío")
                }
            } catch (e : IllegalArgumentException) {
                showToast(e.message.toString(),toast)
            } catch (e : NumberFormatException) {
                showToast(e.message.toString(),toast)
            }
        }
    }

    private fun showToast(msg : String, toast : Toast) {
        toast.setText(msg)
        toast.show()
    }
}