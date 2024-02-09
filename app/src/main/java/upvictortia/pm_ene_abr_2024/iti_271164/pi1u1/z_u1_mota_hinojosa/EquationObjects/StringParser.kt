package upvictortia.pm_ene_abr_2024.iti_271164.pi1u1.z_u1_mota_hinojosa.EquationObjects

class StringParser {
    companion object {
        @JvmStatic
        fun formatDouble(value: Double): String {
            return if (value % 1 == 0.0) {
                String.format("%.0f", value)
            } else {
                String.format("%.2f", value)
            }
        }

        @JvmStatic
        fun printListAsEquation(list: Array<Double>) : String {
            var str = list.mapIndexed {index, value ->
                // TODO Cuando todos los valores son 1, el "+" no se muestra
                when {
                    value == 1.0 -> "x_${index + 1}"
                    index != 0 && value > 0 -> "+${this.formatDouble(value)}x_${index + 1}"
                    else -> "${this.formatDouble(value)}x_${index + 1}"
                }
            }.joinToString(separator = "")
            return str
        }
    }
}