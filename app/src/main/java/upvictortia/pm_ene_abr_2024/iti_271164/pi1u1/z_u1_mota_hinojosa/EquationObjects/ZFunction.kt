package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa.EquationObjects

open class ZFunction(
    val coefficients: Array<Double> = emptyArray()
) {
    override fun toString(): String {
        return "${StringParser.printListAsEquation(coefficients)} = 0"
    }
}