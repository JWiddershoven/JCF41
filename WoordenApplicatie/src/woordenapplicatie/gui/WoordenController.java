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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
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

    private static final String DEFAULT_TEXT = "Een, twee, drie, vier\n"
            + "Hoedje van, hoedje van\n"
            + "Een, twee, drie, vier\n"
            + "Hoedje van papier\n"
            + "\n"
            + "Heb je dan geen hoedje meer\n"
            + "Maak er één van bordpapier\n"
            + "Eén, twee, drie, vier\n"
            + "Hoedje van papier\n"
            + "\n"
            + "Een, twee, drie, vier\n"
            + "Hoedje van, hoedje van\n"
            + "Een, twee, drie, vier\n"
            + "Hoedje van papier\n"
            + "\n"
            + "En als het hoedje dan niet past\n"
            + "Zetten we 't in de glazenkas\n"
            + "Een, twee, drie, vier\n"
            + "Hoedje van papier";

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
        set = new HashSet<>();
    }

    //We hebben de input gesplitst op 
    //We hebben TreeSet gebruikt omdat hier geen dubbele waardes in kunnen.
    @FXML
    private void aantalAction(ActionEvent event) {
        taOutput.clear();
        woorden = taInput.getText().split(",*\\s");
        set.addAll(Arrays.asList(woorden));
        taOutput.setText("Aantal woorden: " + woorden.length + "\nAantal verschillende woorden: " + set.size());
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
        taOutput.clear();
        woorden = taInput.getText().split(",*\\s");
        set.addAll(Arrays.asList(woorden));
        woorden = set.toArray(new String[set.size()]);
        Arrays.sort(woorden, Collections.reverseOrder());
        for (String s : woorden) {
            taOutput.setText(taOutput.getText() + s + "\n");
        }
        //taOutput.setText(Arrays.toString(woorden));
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
        taOutput.clear();

        woorden = taInput.getText().split(",*\\s");
        set.addAll(Arrays.asList(woorden));

        Iterator it = set.iterator();
        HashMap<String, Integer> hm = new HashMap<>();

        while (it.hasNext()) {

            String woord = (String) it.next();
            int count = Collections.frequency(Arrays.asList(woorden), woord);

            hm.put(woord, count);
        }

        hm = sortByValues(hm);

        for (String name : hm.keySet()) {

            String key = name;
            String value = hm.get(name).toString();
            taOutput.setText(taOutput.getText() + "Key: " + key + ", Value: " + value + "\n");
        }
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
        /*
         1. Unieke woorden uit tekst halen d.m.v. HashSet
         2. Regels splitten en in een HashMap zetten
         3. Loop door de HashSet en vergelijk ieder woord met regels in de HashMap
         4. Sla het woord op als key in een nieuwe HashMap en het aantal regels
         waar het woord op voorkomt, als value
         5. Laat zien taOutput
         */
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
        String woord = "";

        taOutput.clear();

        woorden = taInput.getText().split(",*\\s");
        set.addAll(Arrays.asList(woorden));

        String[] regels = taInput.getText().split("\n");
        ArrayList<Integer> regelnummers;

        Iterator it = set.iterator();

        while (it.hasNext()) {
            woord = it.next().toString();
            regelnummers = new ArrayList<>();
            for (int i = 0; i < regels.length; i++) {
                if (regels[i].contains(woord)) {
                    //TODO
                    regelnummers.add(i + 1);
                }
            }

            hm.put(woord, regelnummers);
        }

        for (String name : hm.keySet()) {

            String value = hm.get(name).toString();
            taOutput.setText(taOutput.getText() + name + ": " + value + "\n");
        }

    }

    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
