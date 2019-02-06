package powerconsumption

import java.time.LocalDateTime

class RealConsumption(previousDateTime: LocalDateTime)
    : BasePowerConsumption(previousDateTime), PowerConsumption {
    override fun powerConsumedForDateTime(currentDateTime: LocalDateTime): Double {
        // TODO: Ideally this class reads data from a sensor
        return 999.9
    }
}