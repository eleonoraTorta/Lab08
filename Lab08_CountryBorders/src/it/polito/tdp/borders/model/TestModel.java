package it.polito.tdp.borders.model;

import java.util.List;
import java.util.Map;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		System.out.println("Creo il grafo relativo al 2000");
		model.createGraph(2000);
		
		System.out.println();
		List<Country> countries = model.getCountries();
		System.out.format("Trovate %d nazioni\n", countries.size());

		System.out.println();
		System.out.format("Numero componenti connesse: %d\n", model.getNumberOfConnectedComponents());
		
		System.out.println();
		Map<Country, Integer> stats = model.getCountryCounts();
		for (Country country : stats.keySet())
			System.out.format("%s %d\n", country, stats.get(country));		
		
	}

}
