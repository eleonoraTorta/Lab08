/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {

	Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	void doCalcolaConfini(ActionEvent event) {
		
		String input = txtAnno.getText();
		int anno = Integer.parseInt(input);
		
		model.createGraph(anno);
		txtResult.appendText("Creo il grafo relativo all'anno "+ anno + ":\n");
		
		txtResult.appendText("\n");
		int nazioniTotali = model.getCountries().size();
		txtResult.appendText("Sono state trovate " + nazioniTotali + " nazioni.\n");
		
		txtResult.appendText("\n");
		txtResult.appendText("Numero di stati confinanti per ogni stato:\n");
		Map<Country, Integer> stats = model.getCountryCounts();
		for (Country country : stats.keySet()){
			txtResult.appendText(country.getAbbreviazione() + ": " + stats.get(country) + "\n");
		}
		
		txtResult.appendText("\n");
		txtResult.appendText("Numero di componenti connesse: " + model.getNumberOfConnectedComponents() + "\n");
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";
	}

	public void setModel(Model model2) {
		this.model = model2;	
	}
}
