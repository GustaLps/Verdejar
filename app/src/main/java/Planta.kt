data class Planta(
    val nome: String,
    val dataPlantio: String,
    val nivelCuidado: String,
    val quantidadeAgua: Int,
    var precisaDeAgua: Boolean = true
)
