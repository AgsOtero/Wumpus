package com.example.demo;


import com.example.demo.Tablero.Tablero;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;



@SpringBootTest
class WumpusServidorApplicationTests {

	Tablero tablero = new Tablero();

	@Test
	@DisplayName("Revisa el metodo reset")
	void testReset() {
		Assertions.assertEquals("El Juego ha sido reiniciado", tablero.reset());
	}
	@Test
	@DisplayName("Revisa el metodo sentir")
	void testSentir() {
		Assertions.assertEquals("No siente nada.",tablero.sentir());
	}
	@Test
	@DisplayName("Revisa el metodo sentir")
	void testInicio() {
		Assertions.assertEquals("No siente nada.",tablero.sentir());
	}

}
