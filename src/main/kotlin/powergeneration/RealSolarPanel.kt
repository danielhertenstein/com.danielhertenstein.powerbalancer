package powergeneration

import java.time.LocalDateTime

class RealSolarPanel(previousDateTime: LocalDateTime)
    : BasePowerGenerator(previousDateTime), PowerGenerator{
    override fun powerGeneratedForDateTime(currentDateTime: LocalDateTime): Double {
        // TODO: Ideally this class reads data from a sensor
        return 999.9
    }
}