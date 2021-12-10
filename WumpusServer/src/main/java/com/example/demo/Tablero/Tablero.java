package com.example.demo.Tablero;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

@RestController
public class Tablero {

    public Tablero () {
       generarMundo();
    }

            @ApiOperation(value = "Llamadas a instrucciones para mover al jugador por el tablero")
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Movimiento o Accion realizada con exito"),
            @ApiResponse(code = 401, message = "No tenes permiso para ver este recurso"),
            @ApiResponse(code = 403, message = "No se encuentra el recurso al que queres acceder"),
            @ApiResponse(code = 404, message = "No se encuentra el recurso al que queres acceder")
    }
    )


    private void generarMundo() {


        Random rand = new Random(new Date().getTime());
        int wumpusGenerados = 0;
        int orosGenerado = 0;
        int pozosGenerados = 0;



        //Genero el tablero e inicializo las posiciones de cada componente
        for (int fila = 0; fila <tamañoTablero; fila++) {
            for (int col = 0; col <tamañoTablero; col++) {
                ubicacionPozo[fila][col] = 0;
                ubicacionOro[fila][col] = 0;
                ubicacionWumpus[fila][col] = 0;

                ubicacionBrisa[fila][col] = 0;
                ubicacionOlor[fila][col] = 0;
                ubicacionBrillo[fila][col] = 0;
            }
        }

        //Genero los pozos

        for (int fila = 0; fila < tamañoTablero; fila++) {

            for (int columna = 0; columna < tamañoTablero; columna++) {

                int x = rand.nextInt(100);

                if (x < 20 && x > 0) {

                    if (pozosGenerados < 10) {

                        ubicacionPozo[fila][columna] = 1;
                        pozosGenerados += 1;

                    }


                }


            }


        }
        //Genero los Wumpus

        for (int fila = 0; fila < tamañoTablero; fila++) {

            for (int columna = 0; columna < tamañoTablero; columna++) {

                int x = rand.nextInt(100);

                if (x < 20 && x > 0) {

                    if (wumpusGenerados < 2) {

                        ubicacionWumpus[fila][columna] = 1;
                        wumpusGenerados += 1;

                    }


                }


            }


        }
        //Genero el Oro

        for (int fila = 0; fila < tamañoTablero; fila++) {

            for (int columna = 0; columna < tamañoTablero; columna++) {

                int x = rand.nextInt(100);

                if (x < 5 && x > 0) {

                    if (orosGenerado < 3) {

                        ubicacionOro[fila][columna] = 1;
                        orosGenerado += 1;
                    }
                }
            }
        }
        //Voy a chequear que el  no haya ni pozos ni wumpus en las posiciones donde hay oro, si hay los elimino.
        for (int fila = 0; fila < tamañoTablero; fila++) {

            for (int columna = 0; columna < tamañoTablero; columna++) {

                if (ubicacionOro[fila][columna] == 1 && ubicacionWumpus[fila][columna] == 1) {

                    ubicacionWumpus[fila][columna] = 0;

                }
                if (ubicacionOro[fila][columna] == 1 && ubicacionPozo[fila][columna] == 1) {

                    ubicacionPozo[fila][columna] = 0;

                }

            }
        }

        //Ahora voy a mirar como quedo generado el mapa y empezar a poner las brisas, los olores y los brillos en cada una de las 4 posiciones.
        for (int fila = 0; fila < tamañoTablero; fila++) {
            for (int columna = 0; columna < tamañoTablero; columna++) {

                if (ubicacionPozo[fila][columna] == 1)// Busco los lugares donde hay pozos, y pongo una brisa
                {
                    try//Brisa a la izquierda del pozo
                    {
                        if (ubicacionPozo[fila][columna - 1] != 1)
                            ubicacionBrisa[fila][columna - 1] = 1;

                    }catch (ArrayIndexOutOfBoundsException e ){}
                    try//Brisa a la derecha del pozo
                    {
                        if (ubicacionPozo[fila][columna + 1] != 1)
                            ubicacionBrisa[fila][columna + 1] = 1;

                    }catch (ArrayIndexOutOfBoundsException e ){}
                    try//Brisa abajo del pozo
                    {
                        if (ubicacionPozo[fila - 1][columna] != 1)
                            ubicacionBrisa[fila - 1][columna] = 1;

                    }catch (ArrayIndexOutOfBoundsException e ){}
                    try//Brisa arriba del pozo
                    {
                        if (ubicacionPozo[fila + 1][columna] != 1)
                            ubicacionBrisa[fila + 1][columna] = 1;

                    }catch (ArrayIndexOutOfBoundsException e ){}
                }
                if (ubicacionWumpus[fila][columna] == 1)// Busco los lugares donde hay wumpus, y pongo olor
                {
                    try//Olor a la izquierda del wumpus
                    {
                        if (ubicacionWumpus[fila][columna - 1] != 1)
                            ubicacionOlor[fila][columna - 1] = 1;

                    }catch (ArrayIndexOutOfBoundsException e ){}
                    try//Olor a la derecha del wumpus
                    {
                        if (ubicacionWumpus[fila][columna + 1] != 1)
                            ubicacionOlor[fila][columna + 1] = 1;

                    }catch (ArrayIndexOutOfBoundsException e ){}
                    try//Olor abajo del wumpus
                    {
                        if (ubicacionWumpus[fila + 1][columna] != 1)
                            ubicacionOlor[fila + 1][columna] = 1;

                    }catch (ArrayIndexOutOfBoundsException e ){}
                    try//olor arriba del pozo
                    {
                        if (ubicacionWumpus[fila - 1][columna] != 1)
                            ubicacionOlor[fila - 1][columna] = 1;

                    }catch (ArrayIndexOutOfBoundsException e ){}
                }
                if (ubicacionOro[fila][columna] == 1)// Busco los lugares donde hay oro, y pongo un brillo
                {
                    try//Brillo a la izquierda del oro
                    {
                        if (ubicacionOro[fila][columna - 1] != 1) {
                             ubicacionBrillo[fila][columna - 1] = 1;
                        }
                    }catch (ArrayIndexOutOfBoundsException e ){}
                    try//Brillo a la derecha del oro
                    {
                        if (ubicacionOro[fila][columna + 1] != 1) {
                            ubicacionBrillo[fila][columna + 1] = 1;
                        }
                    }catch (ArrayIndexOutOfBoundsException e ){}
                    try//Brillo abajo del oro
                    {
                        if (ubicacionOro[fila - 1][columna] != 1) {
                            ubicacionBrillo[fila - 1][columna] = 1;
                        }
                    }catch (ArrayIndexOutOfBoundsException e ){}
                    try//Brillo arriba del oro
                    {
                        if (ubicacionOro[fila + 1][columna] != 1) {
                            ubicacionBrillo[fila + 1][columna] = 1;
                        }
                    }catch (ArrayIndexOutOfBoundsException e ){}
                }

            }

        }

        System.out.println("Asa");
    }

    @GetMapping("/sentir")
    @ResponseBody
    @ApiOperation(value  = "Usa los sentidos para detectar peligro cerca.")
    public String sentir(){

        this.sentidos="";
        if (ubicacionOlor[posicionJugadorEnY][posicionJugadorEnX] == 1){

            this.sentidos += "-Siente un olor raro cerca-";
        }
        if (ubicacionBrillo[posicionJugadorEnY][posicionJugadorEnX] == 1){
            this.sentidos +=  "-Siente algo que brilla cerca-";
        }
        if (ubicacionBrisa[posicionJugadorEnY][posicionJugadorEnX] == 1){
            this.sentidos +=  "-Siente una brisa cerca-";
        }


        if (sentidos.equals("")){
            sentidos += "No siente nada.";
        }

        return sentidos;
    }

    @GetMapping("/disparar")
    @ResponseBody
    @ApiOperation(value  = "Dispara una flecha hacia la posicion que esta mirando.")
    public String disparar(){

       flechas -= 1;
        String estado = "";
        int proximo = 0;
        int proximo_x = 0;
        int proximo_y = 0;

        if ( flechas < 0 )
        {
            flechas = 0;
            estado.concat("Te quedaste sin flechas!");
            return estado;
        }
        estado += "Flecha disparada!";

        try
        {
            if (ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX] == 1 && ubicacionWumpus[posicionJugadorEnY][posicionJugadorEnX - 1 ] == 1 ) // MIRANDO IZQUIERDA
            {
                ubicacionWumpus[posicionJugadorEnY][posicionJugadorEnX - 1] = 0;
                ubicacionWumpusMuerto[posicionJugadorEnY][posicionJugadorEnX - 1] = 1;
                estado += ". Escuchas el grito del Wumpus, esta Muerto pero cuidado que puede haber mas!!";


            }
            else if (ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX] == 2 && ubicacionWumpus[posicionJugadorEnY-1][posicionJugadorEnX] == 1 ) // MIRANDO ARRIBA
            {
                ubicacionWumpus[posicionJugadorEnY-1][posicionJugadorEnX] = 0;
                ubicacionWumpusMuerto[posicionJugadorEnY - 1][posicionJugadorEnX] = 1;
                estado += ". Escuchas el grito del Wumpus, esta Muerto pero cuidado que puede haber mas!!";

            }
            else if (ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX] == 3 && ubicacionWumpus[posicionJugadorEnY][posicionJugadorEnX+1] == 1 ) // MIRANDO DERECHA
            {
                ubicacionWumpus[posicionJugadorEnY][posicionJugadorEnX+1] = 0;
                ubicacionWumpusMuerto[posicionJugadorEnY][posicionJugadorEnX + 1] = 1;
                estado += ". Escuchas el grito del Wumpus, esta Muerto pero cuidado que puede haber mas!!";

            }
            else if (ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX] == 4 && ubicacionWumpus[posicionJugadorEnY+1][posicionJugadorEnX] == 1 ) // MIRANDO IZQUIERDA
            {
                ubicacionWumpus[posicionJugadorEnY+1][posicionJugadorEnX] = 0;
                ubicacionWumpusMuerto[posicionJugadorEnY + 1][posicionJugadorEnX] = 1;
                estado += ". Escuchas el grito del Wumpus, esta Muerto pero cuidado que puede haber mas!!";

            }

        }
        catch( ArrayIndexOutOfBoundsException e ){ System.out.println( "DEBUG: FUERA DE LOS LIMITES.");  }
        return estado;

    }


    @GetMapping("/arriba")
    @ResponseBody
    @ApiOperation(value = "Ir hacia arriba")
    public String arriba(){

        int proximo = 0;
        //Miro si no me salgo del mapa, si lo hago pierdo automaticamente;

        try
        {
            proximo = ubicacionJugador[posicionJugadorEnY - 1][posicionJugadorEnX];
        }catch (ArrayIndexOutOfBoundsException e){
            return ("Te chocaste la pared, intenta otra direccion");
        }
        //Miro si no hay Wumpus al querer subir, si lo hay pierdo automaticamente;
        if (ubicacionWumpus[posicionJugadorEnY - 1][posicionJugadorEnX] == 1)
        {
            juegoPerdido = true;
            posicionJugadorEnY --;
            return ("Te encontraste al Wumpus, perdiste!!");

        }

        //Miro si no hay pozo al querer subir, si lo hay pierdo automaticamente;
        if (ubicacionPozo[posicionJugadorEnY - 1][posicionJugadorEnX] == 1)
        {
            juegoPerdido = true;
            posicionJugadorEnY --;
            return ("Te caiste por un pozo, perdiste!!");

        }
        //Miro si hay oro al querer subir, si lo hay lo junto;
        if (ubicacionOro[posicionJugadorEnY - 1][posicionJugadorEnX] == 1)
        {
            tieneOro = true;
            posicionJugadorEnY --;
            return ("Encontraste oro, volve al inicio para ganar!");
        }

        ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX] = 0;
        //Pongo en 2 esa ubicacion, para indicar que subio
        ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX] = 2;
        //Actualizo la posicion actual del jugador
        posicionJugadorEnY --;


        if (tieneOro){
            for (int fila = 0; fila < tamañoTablero; fila ++){
                for (int columna = 0 ; columna < tamañoTablero ; columna ++){
                    ubicacionOro[fila][columna] = 0;
                }
            }
            ubicacionOro[posicionJugadorEnY][posicionJugadorEnX] = 1;
        }
        if (posicionJugadorEnY == inicioY && posicionJugadorEnX == inicioX){

            juegoGanado = true;
        }
        if (tieneOro && posicionJugadorEnY == inicioY && posicionJugadorEnX == inicioX ){

            juegoGanado = true;
            return ("Ganaste!!");
        }else {


            return ("Posicion del jugador en X : " + posicionJugadorEnX + " Posicion del jugador en Y : " + posicionJugadorEnY);
        }


    }
    @GetMapping("/abajo")
    @ResponseBody
    @ApiOperation(value = "Ir hacia abajo")
    public String abajo(){

        int proximo = 0;



        //Miro si no me salgo del mapa, si lo hago pierdo automaticamente;
        try
        {
            proximo = ubicacionJugador[posicionJugadorEnY + 1][posicionJugadorEnX];
        }catch (ArrayIndexOutOfBoundsException e){
            return ("Te chocaste la pared, intenta otra direccion");
        }
        //Miro si no hay Wumpus al querer bajar, si lo hay pierdo automaticamente;
        if (ubicacionWumpus[posicionJugadorEnY + 1][posicionJugadorEnX] == 1)
        {
            juegoPerdido = true;
            posicionJugadorEnY ++;
            return ("Te encontraste al Wumpus, perdiste!!");
        }
        //Miro si no hay pozo al querer bajar, si lo hay pierdo automaticamente;
        if (ubicacionPozo[posicionJugadorEnY + 1][posicionJugadorEnX] == 1)
        {
            juegoPerdido = true;
            posicionJugadorEnY ++;
            return ("Te caiste por un pozo, perdiste!!");
        }
        //Miro si hay oro al querer bajar, si lo hay lo junto;
        if (ubicacionOro[posicionJugadorEnY + 1][posicionJugadorEnX] == 1)
        {
            tieneOro = true;
            posicionJugadorEnY ++;
            return ("Encontraste oro, volve al inicio para ganar!");
        }

        ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX] = 0;
        //Pongo en 2 esa ubicacion, para indicar que bajo
        ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX] = 4;
        //Actualizo la posicion actual del jugador
        posicionJugadorEnY ++;

        if (tieneOro){
            for (int fila = 0; fila < tamañoTablero; fila ++){
                for (int columna = 0 ; columna < tamañoTablero ; columna ++){
                    ubicacionOro[fila][columna] = 0;
                }
            }
            ubicacionOro[posicionJugadorEnY][posicionJugadorEnX] = 1;
        }
        if (tieneOro && posicionJugadorEnY == inicioY && posicionJugadorEnX == inicioX ){

            juegoGanado = true;
            return ("Ganaste!!");
        }else {
            return (" Posicion del jugador en X : " + posicionJugadorEnX + " Posicion del jugador en Y : " + posicionJugadorEnY);
        }



    }
    @GetMapping("/izquierda")
    @ResponseBody
    @ApiOperation(value = "Ir hacia la izquierda")
    public String izquierda(){

        int proximo = 0;

        //Miro si no me salgo del mapa, si lo hago pierdo automaticamente;
        try
        {
            proximo = ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX - 1];
        }catch (ArrayIndexOutOfBoundsException e){
            return ("Te chocaste la pared, intenta otra direccion");
        }
        //Miro si no hay Wumpus al querer ir a la izquierda, si lo hay pierdo automaticamente;
        if (ubicacionWumpus[posicionJugadorEnY][posicionJugadorEnX - 1] == 1)
        {
            juegoPerdido = true;
            posicionJugadorEnX --;
            return ("Te encontraste al Wumpus, perdiste!!");
        }
        //Miro si no hay pozo al querer ir a la izquierda, si lo hay pierdo automaticamente;
        if (ubicacionPozo[posicionJugadorEnY][posicionJugadorEnX - 1] == 1)
        {
            juegoPerdido = true;
            posicionJugadorEnX --;
            return ("Te caiste por un pozo, perdiste!!");
        }
        //Miro si hay oro al querer ir a la izquierda, si lo hay lo junto;
        if (ubicacionOro[posicionJugadorEnY][posicionJugadorEnX - 1] == 1)
        {
            tieneOro = true;
            posicionJugadorEnX --;
            return ("Encontraste oro, volve al inicio para ganar!");
        }

        ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX] = 0;
        //Pongo en 1 esa ubicacion, para indicar que fue a  la izquierda
        ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX] = 1;
        //Actualizo la posicion actual del jugador
        posicionJugadorEnX --;

        if (tieneOro){
            for (int fila = 0; fila < tamañoTablero; fila ++){
                for (int columna = 0 ; columna < tamañoTablero ; columna ++){
                    ubicacionOro[fila][columna] = 0;
                }
            }
            ubicacionOro[posicionJugadorEnY][posicionJugadorEnX] = 1;
        }
        if (tieneOro && posicionJugadorEnY == inicioY && posicionJugadorEnX == inicioX ){

            juegoGanado = true;
            return ("Ganaste!!");
        }

        if (juegoPerdido){
            return  ("Perdiste");
        }else {

            return (" Posicion del jugador en X : " + posicionJugadorEnX + " Posicion del jugador en Y : " + posicionJugadorEnY);
        }


    }
    @GetMapping("/derecha")
    @ResponseBody
    @ApiOperation(value = "Ir hacia la derecha")
    public String derecha(){

        int proximo = 0;


        //Miro si no me salgo del mapa, si lo hago pierdo automaticamente;
        try
        {
            proximo = ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX + 1];
        }catch (ArrayIndexOutOfBoundsException e){
            return ("Te chocaste la pared, intenta otra direccion");
        }
        //Miro si no hay Wumpus al querer ir a la izquierda, si lo hay pierdo automaticamente;
        if (ubicacionWumpus[posicionJugadorEnY][posicionJugadorEnX + 1] == WUMPUS)
        {
            juegoPerdido = true;
            posicionJugadorEnX ++;
            return ("Te encontraste al Wumpus, perdiste!!");
        }
        //Miro si no hay pozo al querer ir a la izquierda, si lo hay pierdo automaticamente;
        if (ubicacionPozo[posicionJugadorEnY][posicionJugadorEnX + 1] == POZO)
        {
            juegoPerdido = true;
            posicionJugadorEnX ++;
            return ("Te caiste por un pozo, perdiste!!");
        }
        //Miro si hay oro al querer ir a la izquierda, si lo hay lo junto;
        if (ubicacionOro[posicionJugadorEnY][posicionJugadorEnX + 1] == ORO)
        {
            tieneOro = true;
            posicionJugadorEnX ++;
            return ("Encontraste oro, volve al inicio para ganar!");
        }

        ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX] = 0;
        //Pongo en 3 esa ubicacion, para indicar que fue a  la izquierda
        ubicacionJugador[posicionJugadorEnY][posicionJugadorEnX] = 3;
        //Actualizo la posicion actual del jugador
        posicionJugadorEnX ++;

        if (tieneOro){
            for (int fila = 0; fila < tamañoTablero; fila ++){
                for (int columna = 0 ; columna < tamañoTablero ; columna ++){
                    ubicacionOro[fila][columna] = 0;
                }
            }
            ubicacionOro[posicionJugadorEnY][posicionJugadorEnX] = 1;
        }
        if (tieneOro && posicionJugadorEnY == inicioY && posicionJugadorEnX == inicioX ){

            juegoGanado = true;
            return ("Ganaste!!");
        }
        if (juegoPerdido){
            return  ("Perdiste");
        }else {

            return (" Posicion del jugador en X : " + posicionJugadorEnX + " Posicion del jugador en Y : " + posicionJugadorEnY);
        }
    }


    @GetMapping("/reset")
    @ResponseBody
    @ApiOperation(value = "Vuelve al jugador a la posicion X=0,Y=0")
    public String reset(){
        this.posicionJugadorEnY = 6;
        this.posicionJugadorEnX = 0;
        this.juegoPerdido = false;
        return ("El Juego ha sido reiniciado");

    }
    @GetMapping("/tablero")
    @ResponseBody
    @ApiOperation(value = "Muestra el recorrido del jugador")
    public String tablero(){
           String tablero = Arrays.deepToString(ubicacionJugador).replace(']','\n').replace('[',' ').replace(',',' ');
            String vacio = " ";
            return  vacio.concat(tablero);
    }
    @GetMapping("/ubicacion")
    @ResponseBody
    @ApiOperation(value = "Nos indica en que valores de X e Y se encuentra el jugador")
    public String ubicacion(){
        return ("Posicion del jugador en X : " + posicionJugadorEnX + " Posicion del jugador en Y : " + posicionJugadorEnY);
    }




    int[][] tablero = { {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0}

    };

    int[][] ubicacionPozo = { {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0}

    };
    int[][] ubicacionOro = { {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0}
    };

    int[][] ubicacionWumpus = { {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0}

    };
    int[][] ubicacionBrisa = { {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0}

    };
    int[][] ubicacionOlor = { {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0}

    };
    int[][] ubicacionBrillo = { {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0}

    };
    int[][] ubicacionJugador = { {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0}

    };
    int[][] ubicacionWumpusMuerto = { {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0}

    };



    static final int WUMPUS      = 1;
    static final int POZO         = 1;
    static final int ORO        = 1;


    String sentidos = "";

    boolean juegoPerdido = false;
    boolean tieneOro = false;
    boolean juegoGanado = false;

    int posicionJugadorEnX = 0;
    int posicionJugadorEnY = 6;

    public static final int inicioX = 0;
    public static final int inicioY= 6;

    static final int tamañoTablero = 7;
    static final int tamañoCasillero = 49;

    int flechas = 2;

}
