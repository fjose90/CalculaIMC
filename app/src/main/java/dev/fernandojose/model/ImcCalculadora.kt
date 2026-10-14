package dev.fernandojose.model

class ImcCalculadora {
    fun calcular(peso: Double, altura: Double): Pair<Double, String> {
        if (altura <= 0 || peso <= 0) {
            throw IllegalArgumentException("Peso e altura devem ser maiores que zero.")
        }

        val imc = peso / (altura * altura)
        val classificacao = when {
            imc < 18.5 -> "Abaixo do peso"
            imc < 25.0 -> "Peso normal"
            imc < 30.0 -> "Sobrepeso"
            imc < 35.0 -> "Obesidade Grau I"
            imc < 40.0 -> "Obesidade Grau II"
            else -> "Obesidade Grau III (Mórbida)"
        }

        return Pair(imc, classificacao)
    }
}