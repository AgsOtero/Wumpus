package com.example.demo;
import com.example.demo.Tablero.Tablero;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;


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
		Assertions.assertEquals(7 , tablero.tablero.length);
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
		Assertions.assertEquals("Te chocaste la pared, intenta otra direccion",tablero.izquierda()); //Me muevo a la izquierda para salirme del tablero.


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
	@DisplayName("Revisar las distintas Interacciones Agente-Mundo. ")
	void testAgenteMundo() {
		//Arrange
		Tablero tablero = new Tablero();

		//Act
		tablero.generarMundo();
		tablero.reset();
		tablero.ubicacionWumpus = tablero.generarElemento(tablero.ubicacionWumpus,5,0);
		tablero.arriba();

		//Assert
		Assertions.assertTrue(tablero.juegoPerdido); //Reviso si pierdo al encontrarme al Wumpus.

		//Act
		tablero.generarMundo();
		tablero.reset();
		tablero.ubicacionPozo = tablero.generarElemento(tablero.ubicacionPozo,5,0);
		tablero.arriba();

		//Assert
		Assertions.assertTrue(tablero.juegoPerdido); //Reviso si pierdo al caerme al pozo.

		//Act
		tablero.generarMundo();
		tablero.reset();
		tablero.ubicacionOro = tablero.generarElemento(tablero.ubicacionOro,5,0);
		tablero.arriba();

		//Assert
		Assertions.assertTrue(tablero.tieneOro); //Reviso si junta el oro al pasar por encima.

	}


	@Test
	@DisplayName("Testea el si el metodo disparar mata al wumpus y lo reemplaza correctamente la posicion del wumpus con un 0 y pone un 1 en el tablero de wumpusMuerto. ")
	void testDisparo() {
		//Arrange
		Tablero tablero = new Tablero();

		//Act
		tablero.generarMundo();
		tablero.ubicacionWumpus = tablero.generarElemento(tablero.ubicacionWumpus,4,0);


		tablero.arriba(); // Nos movemos una casilla asi tenemos la direccion de disparo hacia arriba.
		tablero.disparar();

		//Assert
		Assertions.assertEquals(0,tablero.ubicacionWumpus[4][0]);
		Assertions.assertEquals(1,tablero.ubicacionWumpusMuerto[4][0]);



	}
	@Test
	@DisplayName("Revisa cada uno de las posibles salidas del metodo sentir. ")
	void testSentir() {
		//Arrange
		Tablero tablero = new Tablero();

		//Act
		tablero.generarMundo();

		//Assert
		Assertions.assertEquals("No siente nada.",tablero.sentir());

		//Act
		tablero.generarMundo();
		tablero.ubicacionOlor = tablero.generarElemento(tablero.ubicacionOlor,6,0); //Genero un olor cerca

		//Assert
		Assertions.assertEquals("-Siente un olor raro cerca-",tablero.sentir());

		//Act
		tablero.generarMundo();
		tablero.ubicacionBrisa = tablero.generarElemento(tablero.ubicacionBrisa,6,0); //Genero una brisa cerca

		//Assert
		Assertions.assertEquals("-Siente una brisa cerca-",tablero.sentir());

		//Act
		tablero.generarMundo();
		tablero.ubicacionBrillo = tablero.generarElemento(tablero.ubicacionBrillo,6,0); //Genero un brillo cerca

		//Assert
		Assertions.assertEquals("-Siente algo que brilla cerca-",tablero.sentir());

	}

}
