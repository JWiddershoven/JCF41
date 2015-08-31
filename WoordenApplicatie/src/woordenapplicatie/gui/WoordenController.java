package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {
    
   private static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Heb je dan geen hoedje meer\n" +
                                                "Maak er één van bordpapier\n" +
                                                "Eén, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "En als het hoedje dan niet past\n" +
                                                "Zetten we 't in de glazenkas\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier";
    
    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;
    
    private String[] woorden;
    private Set<String> set;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
        set = new TreeSet<>();
    }
    
    //We hebben de input gesplitst op 
    //We hebben TreeSet gebruikt omdat hier geen dubbele waardes in kunnen.
    @FXML
    private void aantalAction(ActionEvent event) {
        woorden = taInput.getText().split(",*\\s");
        set.addAll(Arrays.asList(woorden));
        taOutput.setText("Aantal woorden: " + woorden.length + "\nAantal verschillende woorden: " + set.size());
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
        woorden = taInput.getText().split(",*\\s");
        set.addAll(Arrays.asList(woorden));
        woorden = set.toArray(new String[set.size()]);
        Arrays.sort(woorden, Collections.reverseOrder());   
        taOutput.setText(Arrays.toString(woorden));
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
          
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
         throw new UnsupportedOperationException("Not supported yet."); 
    }
   
}
