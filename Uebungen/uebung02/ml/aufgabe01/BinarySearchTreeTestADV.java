/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Sun Sep 22 13:31:09 CEST 2019
 */

package uebung02.ml.aufgabe01;

public class BinarySearchTreeTestADV {

  public static void main(String[] args) {

    BinarySearchTree<Integer, String> bts = 
        new BinarySearchTreeADV<>("Deleting internal node", 0, 4);

    // Example from script: deleting internal node (slide 14):
    int[] iarr = { 1, 3, 2, 8, 6, 9, 5 };
    for (int i : iarr) {
      bts.insert(i, "Str" + i);
    }
    bts.remove(bts.find(3));

  }

}

