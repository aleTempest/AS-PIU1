package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa.CustomLayouts.FunctionLayout
import upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa.CustomLayouts.RestrictionContainer
import upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa.EquationObjects.ZFunction
import java.util.ArrayList

class InputActivity : AppCompatActivity() {
    private lateinit var backBtn: Button
    private lateinit var continueBtn: Button
    private lateinit var spinner: Spinner
    private lateinit var functionLayout: FunctionLayout
    private lateinit var resContainer: RestrictionContainer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        spinner = findViewById(R.id.options)
        backBtn = findViewById(R.id.btn_back)
        continueBtn = findViewById(R.id.btn_continue2)
        functionLayout = findViewById(R.id.eq_layout2)
        resContainer = findViewById(R.id.res_container)

        val count1 = intent.getIntExtra("COUNT1",0)
        val count2 = intent.getIntExtra("COUNT2",0)
        makeContainer(count2,count1)

        backBtn.setOnClickListener {
            finish()
        }
        ArrayAdapter.createFromResource(
            this,
            R.array.equation_type,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }


        makeFunction(count1)
        continueBtn.setOnClickListener {
            if (functionLayout.areFieldsNotEmpty()) {
                val toast = Toast.makeText(this,"",Toast.LENGTH_SHORT)
                var coeffArr = Array(functionLayout.getVarCount()) { 0.0 }
                var restrArr = ArrayList<Array<Double>>()
                for ((index,value) in functionLayout.inputs.withIndex()) {
                    val coeff = value.text.toString().toDouble()
                    coeffArr[index] = coeff
                }
                if (coeffArr.isNotEmpty()) {
                    val zfunc = ZFunction(coeffArr)
                    toast.setText(zfunc.toString())
                    toast.show()

                }

            }
        }


    }
    private fun makeContainer(resCount : Int, varCount : Int) {
        resContainer.generateRestrictions(resCount,varCount)
    }

    /* private fun makeEquation(varCount : Int) {
        val equationLayout = findViewById<RestrictionLayout>(R.id.eq_layout)
        equationLayout.generateRestriction(varCount)
    }*/
    private fun makeFunction(varCount : Int) {
        functionLayout.generateFunction(varCount)
    }

    /*private fun customExample() {
        val horizontalTextViewContainer = findViewById<HorizontalTextViewContainer>(R.id.horizontalTextViewContainer)
        val texts = arrayOf("TextView 1", "TextView 2", "TextView 3")
        horizontalTextViewContainer.setTexts(texts)
    }*/
}