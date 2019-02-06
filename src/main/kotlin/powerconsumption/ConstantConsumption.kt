package powerconsumption

import java.time.LocalDateTime

class ConstantConsumption(
    previousDateTime: LocalDateTime,
    private val hourlyPowerConsumptionRate: Double
) : BasePowerConsumption(previousDateTime), PowerConsumption {

    override fun powerConsumedForDateTime(currentDateTime: LocalDateTime): Double {
        val hoursElapsed = timeDifferenceInHours(previousDateTime, currentDateTime)
        val powerConsumed = hoursElapsed * hourlyPowerConsumptionRate
        previousDateTime = currentDateTime
        return powerConsumed
    }
}
