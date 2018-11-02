class Cash constructor(money: Double) {
    var money: Double = 0.0
    val bills: IntArray?
    init {
        this.money = money
        this.bills = determineBills() // calculate bills from the money passed in
    }

    private fun determineBills(): IntArray? {
        //We lose any value that is less than a penny by casting to Int (think stocks)
        var remainingMoney: Int = (this.money*100).toInt()
        if (remainingMoney < 0) {
            return null
        }
        var bills = IntArray(9)
        // these values are multiplied by 100 since we multipled by 100 earlier in our application
        val denominations: IntArray = intArrayOf(5000, 2000, 1000, 500, 100, 25, 10, 5, 1)
        //loop through the various denominations, decreasing our remaining money each time our remaining money fits into a bill
        for (i in denominations.indices) {
            //denomations[i] is the current bill
            while (remainingMoney >= denominations[i]) {
                // decrease money by the amount of the current bill
                remainingMoney -= denominations[i]
                // increase the quantity of that particular bill
                bills[i]++
            }
        }
        return bills
    }

    //override toString method of Any
    override fun toString(): String {
        // handle null case
        if (this.bills == null) return "Negative money"
        // now bills can be assumed not null
        var outputString = "[" // this is to make output string look like an array
        for (bill in this.bills) {
            outputString += bill.toString() + ", "
        }
        //remove last comma and space, add end array bracket
        outputString = outputString.substring(0, outputString.length - 2) + ']'
        return outputString
    }


}