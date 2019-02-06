package powerconsumption

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

abstract class BasePowerConsumption(protected var previousDateTime: LocalDateTime) {
    protected fun timeDifferenceInHours(startDateTime: LocalDateTime, endDateTime: LocalDateTime): Double{
        return startDateTime.until(endDateTime, ChronoUnit.HOURS).toDouble()
    }
}
