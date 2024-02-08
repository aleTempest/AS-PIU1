package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

// Si no se usa @JvmOverloads la aplicación crashea sin siquiera ejecutar nada
open class EquationLayout @JvmOverloads constructor(
    context : Context,
    attribSet : AttributeSet? = null,
    defStyleAttr: Int = 0
)
    : LinearLayout(context,attribSet,defStyleAttr) {
    val coeffInputs = mutableListOf<EditText>()

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
    }

    fun generateInputs(count : Int) {
        if (count != 0) {
            for (i in 0 until count) {
                val editText = EditText(context)
                val sumText = TextView(context)
                sumText.text = "+"
                val params = LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1f
                )
                params.setMargins(0, 0, 0, 20)
                editText.layoutParams = params
                coeffInputs.add(editText)
                if (i != 0) {
                    addView(sumText)
                }
                addView(editText)
            }
        }
    }
}