/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman.codering;

/**
 *
 * @author Jelle
 */
public class HuffKnoop {
    public char karakter;
    public int  frequentie;
    public HuffKnoop leftChild, rightChild;
   
    public HuffKnoop(char karakter, int freq, HuffKnoop leftChild, HuffKnoop rightChild)
    {
        this.karakter = karakter;
        this.frequentie = freq;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
