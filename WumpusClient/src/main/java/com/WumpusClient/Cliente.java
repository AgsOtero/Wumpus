package com.WumpusClient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Cliente {

    public String getResetCall() {

        RestTemplate restTemplate = new RestTemplate();
        final String resetCall = "http://localhost:8080/reset";
        String respuesta = restTemplate.getForObject(resetCall, String.class);

        return respuesta;

    }

    public String getDerechaCall() {

        RestTemplate restTemplate = new RestTemplate();
        final String resetCall = "http://localhost:8080/derecha";
        String respuesta = restTemplate.getForObject(resetCall, String.class);
        return respuesta;

    }
    public String getIzquierdaCall() {

        RestTemplate restTemplate = new RestTemplate();

        final String resetCall = "http://localhost:8080/izquierda";
        String respuesta = restTemplate.getForObject(resetCall, String.class);

        return respuesta;

    }
    public String getArribaCall() {

        RestTemplate restTemplate = new RestTemplate();
        final String resetCall = "http://localhost:8080/arriba";
        String respuesta = restTemplate.getForObject(resetCall, String.class);

        return respuesta;

    }
    public String getAbajoCall() {

        RestTemplate restTemplate = new RestTemplate();

        final String resetCall = "http://localhost:8080/abajo";
        String respuesta = restTemplate.getForObject(resetCall, String.class);

        return respuesta;

    }
    public String getTableroCall() {

        RestTemplate restTemplate = new RestTemplate();

        final String resetCall = "http://localhost:8080/tablero";
        String respuesta = restTemplate.getForObject(resetCall, String.class);
        return respuesta;

    }
    public String getUbicacionCall() {

        RestTemplate restTemplate = new RestTemplate();

        final String resetCall = "http://localhost:8080/ubicacion";
        String respuesta = restTemplate.getForObject(resetCall, String.class);
        return respuesta;

    }
    public String getSentir() {

        RestTemplate restTemplate = new RestTemplate();

        final String resetCall = "http://localhost:8080/sentir";
        String respuesta = restTemplate.getForObject(resetCall, String.class);
        return respuesta;

    }
    public String getDisparar() {

        RestTemplate restTemplate = new RestTemplate();

        final String resetCall = "http://localhost:8080/disparar";
        String respuesta = restTemplate.getForObject(resetCall, String.class);
        return respuesta;

    }


}
