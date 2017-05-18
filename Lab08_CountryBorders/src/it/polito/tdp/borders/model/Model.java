package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	private BordersDAO b;
	private List <Country> nazioni;
	private List <Border> confini;
	private UndirectedGraph <Country, Border> grafo; 

	public Model() {
		b = new BordersDAO();
		nazioni = new ArrayList <Country>();
		confini = new ArrayList <Border>();
		
	}
	
	
	public List<Country> getCountries(){
		nazioni=  b.loadAllCountries();
		return nazioni;
	}
	
	public List <Border> getCoppie(int anno){
		confini = b.getCountryPairs(anno);
		return confini;
	}
	

	//per stamparlo?
	public void createGraph(int anno){
		
		this.grafo = new SimpleGraph<Country, Border> (Border.class);
		
		// creo i vertici
		for( Border b : this.getCoppie(anno)){
			if( !grafo.containsVertex(b.getStato1())){
				grafo.addVertex(b.getStato1());
			}
			if( !grafo.containsVertex(b.getStato2())){
				grafo.addVertex(b.getStato2());
			}
			grafo.addEdge(b.getStato1(), b.getStato2(),b);
		}
		
		System.out.println(grafo);
		
		// stampo il grafo  ???
		List <String> vertici = new ArrayList <String>();
		for( Country c : grafo.vertexSet()){
			String vertice = c.getAbbreviazione() + "\n";
			vertici.add(vertice);
		}
		List <String> archi = new ArrayList <String>();
		for( Border b : grafo.edgeSet() ){
			String arco = "{" + b.getStato1().getAbbreviazione() + ", " + b.getStato2().getAbbreviazione() +"}\n";
			archi.add(arco);
		}
		vertici.addAll(archi);
	//	return vertici;
	 
	}
	
	public Map <Country, Integer> getCountryCounts(){
		if(grafo == null){
			throw new RuntimeException("Grafo non esistente");
		}
		Map <Country, Integer> mappa = new HashMap <Country, Integer>();
		for(Country c : grafo.vertexSet()){
			mappa.put(c, grafo.degreeOf(c));
		}
		return mappa;
	}
	
	public Integer getNumberOfConnectedComponents(){
		if(grafo == null){
			throw new RuntimeException("Grafo non esistente");
		}
		ConnectivityInspector <Country, Border> connessioni = new ConnectivityInspector <Country, Border>(grafo);
		return connessioni.connectedSets().size();
	}
	
	

}
