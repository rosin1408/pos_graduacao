package br.edu.utfpr.aulaVraptor.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		LocalDate data = LocalDate.now();
		System.out.println(data);
		
		List<String> cpfsArquivo = new ArrayList<String>();
		List<String> cpfsBanco = new ArrayList<String>();
		
		cpfsArquivo.add("a");
		cpfsArquivo.add("b");
		cpfsArquivo.add("c");
		cpfsArquivo.add("d");
		
		cpfsBanco.add("a");
		cpfsBanco.add("b");
		cpfsBanco.add("c");
		
		System.out.println(cpfsBanco.containsAll(cpfsArquivo));
		
		cpfsArquivo.removeAll(cpfsBanco);
		System.out.println(cpfsArquivo);
	}
}
