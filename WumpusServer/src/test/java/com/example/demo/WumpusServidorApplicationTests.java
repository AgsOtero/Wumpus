package com.example.demo;


import com.example.demo.Tablero.Tablero;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;


@SpringBootTest
class WumpusServidorApplicationTests {



	@Test
	@DisplayName("Revisa el metodo reset")
	void testReset() {
		//Arrange
		Tablero tablero = new Tablero();

		//Act
		tablero.generarMundo();

		//Assert
		Assertions.assertEquals(1, tablero.ubicacionJugador[6][0]);

		//Act
		tablero.derecha();

		//Assert
		Assertions.assertEquals(3,tablero.ubicacionJugador[6][1]);

		//Act
		tablero.reset();

		//Assert
		Assertions.assertEquals(1, tablero.ubicacionJugador[6][0]);
	}
	@Test
	@DisplayName("Revisa el valor de la posicion Inicial. ")
	void testInicio() {
		//Arrange
		Tablero tablero = new Tablero();

		//Act
		tablero.generarMundo();

		//Assert
		Assertions.assertEquals(1, tablero.ubicacionJugador[6][0]);
	}
	@Test
	@DisplayName("Revisa el valor numero de casillas generadas. ")
	void testNumeroCasillas() {
		//Arrange
		Tablero tablero = new Tablero();

		//Act
		tablero.generarMundo();

		//Assert
		Assertions.assertEquals(49 , Arrays.deepToString(tablero.tablero).length());
	}
	@Test
	@DisplayName("Revisa el valor numero de Wumpus. ")
	void testNumeroWumpus() {
		//Arrange
		Tablero tablero = new Tablero();

		//Act
		tablero.generarMundo();

		//Assert
		Assertions.assertEquals(2,tablero.wumpusGenerados);


	}
	@Test
	@DisplayName("Revisa el numero de Agujeros. ")
	void testNumeroAgujeros() {
		//Arrange
		Tablero tablero = new Tablero();

		//Act
		tablero.generarMundo();

		//Assert
		Assertions.assertTrue(tablero.pozosGenerados <= 10);
	}
	@Test
	@DisplayName("Revisar oro en el mapa. ")
	void testOroGenerado() {
		//Arrange
		Tablero tablero = new Tablero();

		//Act
		tablero.generarMundo();

		//Assert
		Assertions.assertEquals(1,tablero.orosGenerado );
	}
	@Test
	@DisplayName("Revisar Limites del tablero. ")
	void testLimitesDelMundo() {

		//Arrange
		Tablero tablero = new Tablero();

		//Act
		tablero.generarMundo();

		//Assert

	}
	@Test
	@DisplayName("Revisar movimiento del agente. ")
	void testMovimiento() {
		//Arrange
		Tablero tablero = new Tablero();

		//Act
		tablero.generarMundo();

		//Assert
		Assertions.assertEquals(1, tablero.ubicacionJugador[6][0]);

		//Act
		tablero.derecha();

		//Assert
		Assertions.assertEquals(3,tablero.ubicacionJugador[6][1]);

		//Act
		tablero.izquierda();

		//Assert
		Assertions.assertEquals(1,tablero.ubicacionJugador[6][0]);

		//Act
		tablero.arriba();

		//Assert
		Assertions.assertEquals(2,tablero.ubicacionJugador[5][0]);

		//Act

		tablero.abajo();

		//Assert
		Assertions.assertEquals(4,tablero.ubicacionJugador[6][0]);

	}
	@Test
	@DisplayName("Revisar disparo. ")
	void testDisparo() {
		//Assertions.assertEquals("No siente nada.",tablero.sentir());
	}
	@Test
	@DisplayName("Revisar Sentir. ")
	void testSentir() {
		//Assertions.assertEquals("No siente nada.",tablero.sentir());
	}
	@Test
	@DisplayName("Revisar Interaccion Agente-Mundo. ")
	void testAgenteMundo() {
		//Assertions.assertEquals("No siente nada.",tablero.sentir());
	}
	@Test
	@DisplayName("Revisar Casilla inicio Agente ")
	void testCasillaInicio() {
		//Assertions.assertEquals("No siente nada.",tablero.sentir());
	}






}
