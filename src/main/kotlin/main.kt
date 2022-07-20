fun main() {
    // MasterCard, Maestro, Visa, Mir, VK Pay
    val paymentSystem = "Mir"
    val amountTransfersMonth = 1_000_00
    val amount = 100_00

    println(getCommission(paymentSystem, amountTransfersMonth, amount))
}

fun getCommission(paymentSystem: String, amountTransfersMonth: Int = 0, amount: Int): Int {
    return when (paymentSystem) {
        "MasterCard", "Maestro" -> {
            val percentageCommission = 0.6
            val limitAmountTransfersMonth = 75_000_00
            val additionalFee = 20_00

            if (amountTransfersMonth < limitAmountTransfersMonth) 0
            else (amount * percentageCommission / 100).toInt() + additionalFee
        }
        "Visa", "Mir" -> {
            val percentageCommission = 0.75
            val minimumCommission = 35_00
            val commission = (amount * percentageCommission / 100).toInt()

            if (commission < minimumCommission) minimumCommission else commission
        }
        else -> 0
    }
}
