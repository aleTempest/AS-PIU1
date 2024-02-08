package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

open class HorizontalTextViewContainer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val textViews: MutableList<TextView> = mutableListOf()

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
    }

    fun setTexts(texts: Array<String>) {
        // Remove existing TextViews
        removeAllViews()

        // Create TextViews for each text and add them to the container
        for (text in texts) {
            val textView = TextView(context)
            textView.text = text
            textViews.add(textView)
            addView(textView)
        }
    }

    fun getTexts(): Array<String> {
        return textViews.map { it.text.toString() }.toTypedArray()
    }
}
