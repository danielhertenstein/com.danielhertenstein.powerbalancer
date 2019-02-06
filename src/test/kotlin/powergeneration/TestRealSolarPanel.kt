package powergeneration

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TestRealSolarPanel {

    @Test
    fun realSolarPanelReadsFromSensor() {
        val startDateTime = LocalDateTime.of(2019, 2, 6, 0, 0)
        val endDateTime = startDateTime.plusHours(1L)
        val solarPanel = RealSolarPanel(startDateTime)
        val powerGenerated = solarPanel.powerGeneratedForDateTime(endDateTime)
        assertEquals(powerGenerated, 999.9)
    }
}