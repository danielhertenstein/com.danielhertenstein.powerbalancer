package powergeneration

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class TestTimeSeriesIntegratingSolarPanel {
    private lateinit var startDateTime: LocalDateTime
    private lateinit var timeSeriesSolarPanel: TimeSeriesIntegratingSolarPanel

    @BeforeEach
    fun beforeEach() {
        startDateTime = LocalDateTime.of(2019, 2, 6, 0, 0)
        val timeSeriesFile = javaClass.getResource("testTimeSeries.csv").path
        timeSeriesSolarPanel = TimeSeriesIntegratingSolarPanel(startDateTime, timeSeriesFile)
    }

    @Test
    fun timeSeriesSolarPanelReadsFromFile() {
        val endDateTime = startDateTime.plusHours(3L)
        val powerGenerated = timeSeriesSolarPanel.powerGeneratedForDateTime(endDateTime)
        val expectedPower = 3 * 1.5 / 2.0
        assertEquals(powerGenerated, expectedPower)
    }

    @Test
    fun timeSeriesSolarPanelHandlesMultipleDayTimeGap() {
        val endDateTime = startDateTime.plusDays(3L).plusHours(1L)
        val powerGenerated = timeSeriesSolarPanel.powerGeneratedForDateTime(endDateTime)
        val fullDayPower = 24.0 * 12.0 / 2.0
        val expectedPower = 3 * fullDayPower + 1 * 0.5 / 2
        assertEquals(powerGenerated, expectedPower)
    }
}