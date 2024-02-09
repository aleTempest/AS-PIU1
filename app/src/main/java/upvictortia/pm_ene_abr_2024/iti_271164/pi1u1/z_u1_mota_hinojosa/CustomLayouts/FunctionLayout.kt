package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa.CustomLayouts

import android.content.Context
import android.util.AttributeSet
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa.R

class FunctionLayout(context: Context, attrs: AttributeSet? = null) : EquationLayout(context, attrs) {
    /*private lateinit var spinner: Spinner*/
    fun generateFunction(count : Int) {
        this.generateInputs(count)
        val equalityText = TextView(context)
        equalityText.text = "= 0"
        addView(equalityText)
    }

    /*init {
        spinner = Spinner(context)
        ArrayAdapter.createFromResource(
            context,
            R.array.equation_type,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        addView(spinner)
    }*/
}