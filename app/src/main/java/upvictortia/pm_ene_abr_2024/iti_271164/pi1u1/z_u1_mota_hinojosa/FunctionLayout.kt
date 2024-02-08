package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa

import android.R
import android.content.Context
import android.util.AttributeSet
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class FunctionLayout(context: Context, attrs: AttributeSet? = null) : EquationLayout(context, attrs) {
    // private lateinit var spinner: Spinner
    fun generateFunction(count : Int) {
        val layoutParams = LayoutParams(
            0,
            LayoutParams.WRAP_CONTENT,
            1f
        )

        this.generateInputs(count)
        val equalityText = TextView(context)
        equalityText.text = "= 0"
        addView(equalityText)
    }

    /* private fun setSpinnerOptions(options : List<String>) {
        val adapter = ArrayAdapter(context, R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    } */
}