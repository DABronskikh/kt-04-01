import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    @Test
    fun getCommission_masterBeforeLimitAmountTransfersMonth() {
        val paymentSystem = "MasterCard"
        val amountTransfersMonth = 1_000_00
        val amount = 100_00

        val result = getCommission(
            paymentSystem = paymentSystem,
            amountTransfersMonth = amountTransfersMonth,
            amount = amount
        )

        assertEquals(0, result)
    }

    @Test
    fun getCommission_masterAfterLimitAmountTransfersMonth() {
        val paymentSystem = "MasterCard"
        val amountTransfersMonth = 77_000_00
        val amount = 100_00

        val result = getCommission(
            paymentSystem = paymentSystem,
            amountTransfersMonth = amountTransfersMonth,
            amount = amount
        )

        assertEquals(20_00, result)
    }

    @Test
    fun getCommission_mirBeforeMinCommission() {
        val paymentSystem = "Mir"
        val amountTransfersMonth = 1_000_00
        val amount = 100_00

        val result = getCommission(
            paymentSystem = paymentSystem,
            amountTransfersMonth = amountTransfersMonth,
            amount = amount
        )

        assertEquals(35_00, result)
    }

    @Test
    fun getCommission_mirAfterMinCommission() {
        val paymentSystem = "Mir"
        val amountTransfersMonth = 1_000_00
        val amount = 5_000_00

        val result = getCommission(
            paymentSystem = paymentSystem,
            amountTransfersMonth = amountTransfersMonth,
            amount = amount
        )

        assertEquals(37_50, result)
    }

    @Test
    fun getCommission_vk() {
        val paymentSystem = "VK Pay"
        val amountTransfersMonth = 1_000_00
        val amount = 5_000_00

        val result = getCommission(
            paymentSystem = paymentSystem,
            amountTransfersMonth = amountTransfersMonth,
            amount = amount
        )

        assertEquals(0, result)
    }
}