
val taxTiers = arrayOf(
    TaxTier(band = 26000.0, tier = .31),
    TaxTier(band = 33000.0, tier = .37),
    TaxTier(band = 55000.0, tier = .45),
    TaxTier(band = 120000.0, tier = .55),
)
fun main(args: Array<String>) {
    var salary: Double
    var netSalary: Salary
    println("Hi, enter your monthly salary:")
    salary = readLine()!!.toDouble()
    netSalary = CalculateSalary(salary, taxTiers)
    println("Your net salary is: ${netSalary.net}")
    println("And your tax is ${netSalary.taxRate.rateText}")
}

fun  CalculateSalary(salary: Double, taxRates: Array<TaxTier> ): Salary{
    var taxTier = FindTaxRate(salary,taxRates)

    return Salary(gross = salary, taxRate = taxTier)

}

fun  FindTaxRate (grossSalary: Double, taxRate: Array<TaxTier> ): TaxTier{
    for ( tier in taxRate.sortedByDescending { T -> T.band })
    {
        if (grossSalary >= tier.band)
        {
            return tier
        }
    }

    return TaxTier(band = grossSalary, tier = 0.0)
}
data class TaxTier(
    var band: Double,
    var tier: Double,
    var rateText: String = "${tier * 100} %",

)

data class Salary (
    var gross: Double,
    var taxRate: TaxTier,
    var taxAmount: Double = gross * taxRate.tier,
    var net: Double = gross - taxAmount
)