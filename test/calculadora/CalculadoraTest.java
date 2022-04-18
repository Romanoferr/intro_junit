package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}

	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubtracaoDoisNumeros() {
		int sub = calc.subtracao(10, 5);
		Assertions.assertEquals(5, sub);
	}

	@DisplayName("Testa multiplicação de 2 inteiros")
	@Test
	public void testMultiplicacaoDoisNumeros(){
		int mult = calc.multiplicacao(2, 3);
		Assertions.assertEquals(6, mult);
	}
	
	@DisplayName("Teste multiplicação 0x0")
	@Test
	public void testMultiplicacaoDoisNumeros(){
		int multComZero = calc.multiplicacao(0, 0);
		Assertions.assertEquals(0, multComZero);
	}
	
	@DisplayName("Teste multiplicação com um termo 'neutro' (=1)")
	@Test
	public void testMultiplicacaoComValorNeutro(){
		int valorNaoNeutro = 10;
		int multComUm = calc.multiplicacao(1, valorNaoNeutro);
		Assertions.assertEquals(intmultComUm, valorNaoNeutro)
	} 

	@DisplayName("Teste multiplicação com um valor negativo")
	@Test
	public void testMultiplicacaoComValorNegativo() {
		int valorPositivo = 15;
		int multComNegativo = calc.multiplicacao(-2, valorPositivo);
		Assertions.assertEquals(-30, multComNegativo);
	}
	
	@DisplayName("Testa divisão 2 inteiros")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@DisplayName("Testa divisão por zero")
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@DisplayName("Testa divisão por zero com assert throws")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@DisplayName("Teste somatório de um inteiro negativo")
	@Test
	public void testSomatorioInteiroNegativo(){
		int valorSomatorio = calc.somatoria(-20);
		Assertions.assertEquals(0, valorSomatorio);
	}

	@DisplayName("Teste valor Positivo")
	@Test
	public void testValorPositivo() {
		boolean positivo = calc.ehPositivo(1);
		Assertions.assertTrue(positivo);
	}

	@DisplayName("Teste valor Negativo")
	@Test
	public void testeValorNegativo(){
		boolean negativo = calc.ehPositivo(-1);
		Assertions.assertFalse(negativo);
	}

	@DisplayName("Teste comparação a > b")
	@Test
	public void testAMaiorQueB() {
		int comp = calc.compara(10, 5);
		Assertions.assertTrue(comp);
	}

	@DisplayName("Teste comparação a < b")
	@Test
	public void testAMenorQueB() {
		int comp = calc.compara(5, 10);
		Assertions.assertEquals(-1, comp);
	}

	@DisplayName("Teste comparação a=b")
	@Test
	public void testAigualB() {
		int comp = calc.compara(1, 1);
		Assertions.assertFalse(comp);
	}

}
