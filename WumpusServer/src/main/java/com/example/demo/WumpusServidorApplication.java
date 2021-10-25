package com.example.demo;


import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;


@SpringBootApplication
@ComponentScan
public class WumpusServidorApplication {

	@SneakyThrows
	public static void main(String[] args) {


		SpringApplication.run(WumpusServidorApplication.class, args);


		}

	}




















