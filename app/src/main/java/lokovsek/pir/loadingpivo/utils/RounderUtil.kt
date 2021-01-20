package lokovsek.pir.loadingpivo.utils

import java.math.BigDecimal
import java.math.RoundingMode

fun roundValue(value: Double?, scale: Int): BigDecimal? {
    return value?.let { BigDecimal(it).setScale(scale, RoundingMode.HALF_EVEN) }
}

