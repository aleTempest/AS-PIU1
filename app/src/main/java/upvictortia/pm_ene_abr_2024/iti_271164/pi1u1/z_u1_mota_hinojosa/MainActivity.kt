package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeEquation(3)
    }

    private fun makeEquation(eqCount : Int) {
        val equationLayout = findViewById<TestChild>(R.id.eq_layout)
        equationLayout.generateInputs(eqCount)
    }

    /*private fun customExample() {
        val horizontalTextViewContainer = findViewById<HorizontalTextViewContainer>(R.id.horizontalTextViewContainer)
        val texts = arrayOf("TextView 1", "TextView 2", "TextView 3")
        horizontalTextViewContainer.setTexts(texts)
    }*/
}