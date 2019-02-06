package powergeneration

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TestConstantSolarPanel {
    private lateinit var startDateTime: LocalDateTime
    private lateinit var endDateTime: LocalDateTime
    private lateinit var constantSolarPanel: ConstantSolarPanel
    private val hourlyPowerGenerationRate = 2.0

    @BeforeEach
    fun beforeEach() {
        startDateTime = LocalDateTime.of(2019, 2, 6, 0, 0)
        endDateTime = startDateTime.plusHours(1L)
        constantSolarPanel = ConstantSolarPanel(startDateTime, hourlyPowerGenerationRate)
    }

    @Test
    fun houseWithConstantSolarPanelReturnsItsConstant() {
        val powerGenerated = constantSolarPanel.powerGeneratedForDateTime(endDateTime)
        assertEquals(powerGenerated, hourlyPowerGenerationRate)
    }

    @Test fun constantSolarPanelForOverADayHandledCorrectly() {
        endDateTime = startDateTime.plusHours(25L)
        val powerGenerated = constantSolarPanel.powerGeneratedForDateTime(endDateTime)
        assertEquals(powerGenerated, hourlyPowerGenerationRate * 25)
    }
}