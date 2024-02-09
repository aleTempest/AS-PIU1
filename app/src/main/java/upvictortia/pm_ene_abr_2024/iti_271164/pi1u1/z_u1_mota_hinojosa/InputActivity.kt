package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa.CustomLayouts.FunctionLayout
import upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa.CustomLayouts.RestrictionContainer

class InputActivity : AppCompatActivity() {
    private lateinit var backBtn: Button
    private lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        val count1 = intent.getIntExtra("COUNT1",0)
        val count2 = intent.getIntExtra("COUNT2",0)
        spinner = findViewById(R.id.options)
        ArrayAdapter.createFromResource(
            this,
            R.array.equation_type,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        makeFunction(count1)
        makeContainer(count2,count1)
        backBtn = findViewById(R.id.btn_back)
        backBtn.setOnClickListener { view ->
            finish()
        }
    }
    private fun makeContainer(resCount : Int, varCount : Int) {
        val resContainer = findViewById<RestrictionContainer>(R.id.res_container)
        resContainer.generateRestrictions(resCount,varCount)
    }

    /* private fun makeEquation(varCount : Int) {
        val equationLayout = findViewById<RestrictionLayout>(R.id.eq_layout)
        equationLayout.generateRestriction(varCount)
    }*/
    private fun makeFunction(varCount : Int) {
        val functionLayout = findViewById<FunctionLayout>(R.id.eq_layout2)
        functionLayout.generateFunction(varCount)
    }

    /*private fun customExample() {
        val horizontalTextViewContainer = findViewById<HorizontalTextViewContainer>(R.id.horizontalTextViewContainer)
        val texts = arrayOf("TextView 1", "TextView 2", "TextView 3")
        horizontalTextViewContainer.setTexts(texts)
    }*/
}