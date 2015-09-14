/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman.codering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Huffman Stappenplan 1. Frequentie van tekens tellen 2. Sorteer de tekens op
 * frequentie 3. Maken van de huffman-boom 4. Aflezen van de codes 5. Coderen
 * van het berichten 6. Decoderen
 */
public class HuffmanCodering {

    public static void main(String[] args) {
        //Convert het woord naar chars
        String woord = "appel";
        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<HuffKnoop> knopen = new ArrayList<>();
        for (int i = 0; i < woord.length(); i++) {
            chars.add(woord.charAt(i));
        }

        //1. Frequentie van tekens 
        Set<Character> uniqueChars = new HashSet<>(chars);
        for (char c : uniqueChars)
        {
            knopen.add(new HuffKnoop(c, Collections.frequency(chars, c), null, null));
        }
        
        for (HuffKnoop k : knopen) {
            System.out.println("karakter: " + k.karakter + " " + "frequentie: "  + k.frequentie);
        }
        
        //2. Sorteer de tekens op frequentie
        PriorityQueue queue = new PriorityQueue(uniqueChars.size());
        
        for (char c : uniqueChars)
        {
            queue.add(c);
        }
    }

}
