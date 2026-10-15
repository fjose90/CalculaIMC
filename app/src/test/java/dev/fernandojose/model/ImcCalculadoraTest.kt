package dev.fernandojose.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class ImcCalculadoraTest {

  private val calculadora = ImcCalculadora()

  @Test
  fun calcular_pesoNormal_retornaClassificacaoCorreta() {
    // Peso 70kg, Altura 1.75m -> IMC = 70 / (1.75 * 1.75) ≈ 22.86
    val resultado = calculadora.calcular(70.0, 1.75)
    assertEquals(22.86, resultado.first, 0.01)
    assertEquals("Peso normal", resultado.second)
  }

  @Test
  fun calcular_abaixoDoPeso_retornaClassificacaoCorreta() {
    // Peso 50kg, Altura 1.80m -> IMC ≈ 15.43
    val resultado = calculadora.calcular(50.0, 1.80)
    assertEquals("Abaixo do peso", resultado.second)
  }

  @Test
  fun calcular_sobrepeso_retornaClassificacaoCorreta() {
    // Peso 85kg, Altura 1.75m -> IMC ≈ 27.76
    val resultado = calculadora.calcular(85.0, 1.75)
    assertEquals("Sobrepeso", resultado.second)
  }

  @Test
  fun calcular_obesidadeGrauI_retornaClassificacaoCorreta() {
    // Peso 100kg, Altura 1.75m -> IMC ≈ 32.65
    val resultado = calculadora.calcular(100.0, 1.75)
    assertEquals("Obesidade Grau I", resultado.second)
  }

  @Test
  fun calcular_valoresInvalidos_lancaExcecao() {
    assertThrows(IllegalArgumentException::class.java) { calculadora.calcular(0.0, 1.75) }
    assertThrows(IllegalArgumentException::class.java) { calculadora.calcular(70.0, -1.75) }
  }
}
