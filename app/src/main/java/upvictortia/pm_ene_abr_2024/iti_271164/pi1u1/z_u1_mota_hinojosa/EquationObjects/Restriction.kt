package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa.EquationObjects

/*
class Restriction(
    private val coefficients: List<Double>,
    private val inequalityType: InequalityType,
    private val restrictionValue: Double
) {
    fun getRestrictionValue() : Double {
        return restrictionValue
    }

    private fun getInType() : String {
        return when (inequalityType) {
            InequalityType.EQUAL_LESS_THAN -> "\\leq"
            InequalityType.EQUAL_GREATER_THAN -> "\\geq"
            InequalityType.EQUAL -> "="
        }
    }

    override fun toString(): String {
        val str = StringParser.printListAsEquation(coefficients)
        return "$str ${this.getInType()} ${StringParser.formatDouble(restrictionValue)}"
    }
}
*/