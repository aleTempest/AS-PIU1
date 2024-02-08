package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa

import android.R
import android.content.Context
import android.util.AttributeSet
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner

class RestrictionLayout(context: Context, attrs: AttributeSet? = null) : EquationLayout(context, attrs) {
    private lateinit var spinner: Spinner
    private lateinit var restrictionValue: EditText

    enum class INEQUATION_SYMBOL {
        EQUAL,EQUAL_LESS,EQUAL_GREATER
    }

    fun generateRestriction(count : Int) {
        generateInputs(count)
        spinner = Spinner(context)
        val layoutParams = LayoutParams(
            0,
            LayoutParams.WRAP_CONTENT,
            1f
        )
        spinner.layoutParams = layoutParams
        setSpinnerOptions(listOf("=",">=","<="))
        addView(spinner)
        restrictionValue = EditText(context)
        restrictionValue.layoutParams = params
        addView(restrictionValue)
    }

    private fun setSpinnerOptions(options: List<String>) {
        val adapter = ArrayAdapter(context, R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
}