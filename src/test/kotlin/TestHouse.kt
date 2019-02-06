import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import powergeneration.ConstantSolarPanel
import powergeneration.SolarPanel
import java.time.LocalDateTime

class TestHouse {

    @Test
    fun switchingFromRealSolarPanelToConstantSolarPanel() {
        val startDateTime = LocalDateTime.of(2019, 2, 6, 0, 0)
        val endDateTime = startDateTime.plusHours(1L)

        val hourlyPowerGenerationRate = 2.0
        val constantSolarPanel = ConstantSolarPanel(startDateTime, hourlyPowerGenerationRate)
        val solarPanel = SolarPanel(startDateTime)
        val house = House(solarPanel)

        var powerGenerated = house.getPowerGeneratedForDateTime(endDateTime)
        assertEquals(powerGenerated, 999.9)

        house.setPowerGenerator(constantSolarPanel)
        powerGenerated = house.getPowerGeneratedForDateTime(endDateTime)
        assertEquals(powerGenerated, hourlyPowerGenerationRate)
    }
}