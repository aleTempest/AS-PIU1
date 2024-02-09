package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa.CustomLayouts

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class RestrictionContainer @JvmOverloads constructor(
    context : Context,
    attribSet : AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context,attribSet,defStyleAttr) {
    val restrictions = ArrayList<RestrictionLayout>()

    fun generateRestrictions(count : Int, varCount : Int) {
        for (i in 0 until count) {
            val res = RestrictionLayout(context)
            res.generateRestriction(varCount)
            addView(res)
        }
    }

}