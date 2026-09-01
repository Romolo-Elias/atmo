package br.com.atmo.data

data class SearchResponse(val results: List<SearchResult>)
data class SearchResult(val activity_id: String)

data class EstimateRequest(
    val emission_factor: EmissionFactorSelector,
    val parameters: MoneyParameters
)

data class EmissionFactorSelector(
    val activity_id: String,
    val data_version: String = "^0"
)

data class MoneyParameters(val money: Double, val money_unit: String = "brl")

data class EstimateResponse(val co2e: Double, val co2e_unit: String)

fun categoriaParaBusca(categoria: String): String {
    return when (categoria.trim().lowercase()) {
        "transporte" -> "transport"
        "alimentação", "alimentacao" -> "food"
        "casa" -> "electricity"
        "digital" -> "software"
        else -> categoria
    }
}

