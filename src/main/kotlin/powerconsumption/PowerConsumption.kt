package powerconsumption

import java.time.LocalDateTime

interface PowerConsumption {
    fun powerConsumedForDateTime(currentDateTime: LocalDateTime): Double
}