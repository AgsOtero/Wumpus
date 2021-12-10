package com.WumpusClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class WumpusClientApplication {

	public static void main(String[] args) throws IOException {


		SpringApplication.run(WumpusClientApplication.class, args);

		Cliente cliente = new Cliente();
		while (true) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			String accion = reader.readLine();
			switch (accion) {
				case "arriba":
					System.out.println(cliente.getArribaCall());
					break;
				case "abajo":
					System.out.println(cliente.getAbajoCall());
					break;
				case "derecha":
					System.out.println(cliente.getDerechaCall());
					break;
				case "izquierda":
					System.out.println(cliente.getIzquierdaCall());
					break;
				case "tablero":
					System.out.println(cliente.getTableroCall());
					break;
				case "reset":
					System.out.println(cliente.getResetCall());
					break;
				case "ubicacion":
					System.out.println(cliente.getUbicacionCall());
					break;
				case "sentir":
					System.out.println(cliente.getSentir());
					break;
				case "disparar":
					System.out.println(cliente.getDisparar());
					break;
				case "-help":
					System.out.println("Los comandos validos son: arriba,abajo,izquierda,derecha,reset,tablero,sentir");
					break;
				default:
					System.out.println("Ingrese una Opcion valida, si necesita ayuda use el comando -help");
					break;
			}
		}

	}

}
