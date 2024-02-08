package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class FunctionLayout(context: Context, attrs: AttributeSet? = null) : EquationLayout(context, attrs) {
    fun generateFunction(count : Int) {
        this.generateInputs(count)
        val equalityText = TextView(context)
        equalityText.text = "= 0"
        addView(equalityText)
    }
}