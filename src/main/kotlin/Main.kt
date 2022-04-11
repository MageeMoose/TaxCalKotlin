
val taxTiers = arrayOf(
    TaxTier(band = 26000.0, tier = .31),
    TaxTier(band = 33000.0, tier = .37),
    TaxTier(band = 55000.0, tier = .45),
    TaxTier(band = 120000.0, tier = .55),
)
fun main(args: Array<String>) {

}

data class TaxTier(
    var band: Double,
    var tier: Double
)