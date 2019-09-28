/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Sun Sep 22 14:00:28 CEST 2019
 */

package uebung02.as.aufgabe01;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import java.util.*;

public class BinarySearchTree<K extends Comparable<? super K>, V> {

  protected Node root;
  
  public static class Entry<K, V> {

    private K key;
    private V value;

    public Entry(K key, V value) {
      this.key = key;
      this.value = value;
    }

    protected K setKey(K key) {
      K oldKey = this.key;
      this.key = key;
      return oldKey;
    }

    public K getKey() {
      return key;
    }

    public V setValue(V value) {
      V oldValue = this.value;
      this.value = value;
      return oldValue;
    }

    public V getValue() {
      return value;
    }
    
    @Override
    public String toString() {
      StringBuilder result = new StringBuilder();
      result.append("[").append(key).append("/").append(value).append("]");
      return result.toString();
    }
    
  } // End of class Entry

  protected class Node {

    private Entry<K, V> entry;
    private Node leftChild;
    private Node rightChild;

    public Node(Entry<K, V> entry) {
      this.entry = entry;
    }

    public Node(Entry<K, V> entry, Node leftChild, Node rightChild) {
      this.entry = entry;
      this.leftChild = leftChild;
      this.rightChild = rightChild;
    }
    
    public Entry<K, V> getEntry() {
      return entry;
    }

    public Entry<K, V> setEntry(Entry<K, V> entry) {
      Entry<K, V> oldEntry = entry;
      this.entry = entry;
      return oldEntry;
    }

    public Node getLeftChild() {
      return leftChild;
    }

    public void setLeftChild(Node leftChild) {
      this.leftChild = leftChild;
    }

    public Node getRightChild() {
      return rightChild;
    }

    public void setRightChild(Node rightChild) {
      this.rightChild = rightChild;
    }





  } // End of class Node

  public Entry<K, V> insert(K key, V value) {
    // TODO Implement here...
    Entry<K, V> newEntry = new Entry<>(key, value);
    root = insert(root, newEntry);
    return newEntry;
    //return null;
  }
  protected Node insert(Node node, Entry<K, V> entry){
    if(node == null){
      return newNode(entry);
    }else if(entry.getKey().compareTo(node.getEntry().getKey())<=0){
      node.leftChild=insert(node.getLeftChild(), entry);
    }else{
      node.rightChild=insert(node.getRightChild(), entry);
    }
    return node;
  }

  /**
   * Factory-Method: Creates a new node.
   * 
   * @param entry
   *          The entry to be inserted in the new node.
   * @return The new created node.
   */
  protected Node newNode(Entry<K, V> entry) {
    return new Node(entry);
  }

  public void clear() {

    // TODO Implement here...??


  }

  public Entry<K, V> find(K key) {
    // TODO Implement here...
    return find(root, key);
  }

  public Entry<K, V> find (Node node, K key){
    if(node == null){
      return null;
    }
    if(key == node.getEntry().getKey()){
      return node.getEntry();
    }else{
      if(node.getEntry().getKey().compareTo(key)<=0){
        node = node.getLeftChild();
        return find(node, key);
      }else{
        node = node.getRightChild();
        return find(node, key);
      }
    }
  }

  /**
   * Returns a collection with all entries with key.
   * 
   * @param key
   *          The key to be searched.
   * @return Collection of all entries found. An empty collection is returned if
   *         no entry with key is found.
   */
  public Collection<Entry<K, V>> findAll(K key) {
    // TODO Implement here...
    ArrayList<Entry<K, V>> allKeys = new ArrayList<>();
    while(root==null){
      allKeys.add(find(key));
      root=root.getLeftChild();
      allKeys.add(find(key));
      root=root.getRightChild();
      allKeys.add(find(key));
    }
    return null;
  }
  
  /**
   * Returns a collection with all entries in inorder.
   * 
   * @return Inorder-Collection of all entries.
   */
  public Collection<Entry<K, V>> inorder() {
    // TODO Implement here...
    return inorder(root);
  }
  public Collection<Entry<K, V>> inorder(Node node){
    ArrayList<Entry<K,V>> inorderList = new ArrayList<>();
    if(node.leftChild != null){
      inorderList.addAll(inorder(node.leftChild));
    }
    inorderList.add(node.entry);
    if(node.rightChild !=null){
      inorderList.addAll(inorder(node.rightChild));
    }
    return inorderList;
  }
  
  /**
   * Prints the entries of the tree as a list in inorder to the console.
   */
  public void printInorder() {
    // TODO Implement here...
    System.out.println(inorder());
  }

  public Entry<K, V> remove(Entry<K, V> entry) {
    // TODO Implement here...
    Entry<K, V> toRemove=entry;
    root =remove(root, entry);
    return toRemove;
  }
  protected Node remove(Node node, Entry<K, V> entry){
    if(node == null || entry== null){
      return node;
    }
    if(entry.getKey().compareTo(node.getEntry().getKey())<= 0){
      node.leftChild = remove(node.leftChild, entry);
    }else{
      if(entry.getKey().compareTo(node.getEntry().getKey())>0){
        node.rightChild = remove(node.rightChild, entry);
      }else{
        if(node.leftChild == null){
          return node.rightChild;
        }if(node.rightChild == null){
          return node.leftChild;
        }
        Node node1 = vatersymnach(node);
        if(node1 == node){
          node.getEntry().setKey(node.rightChild.getEntry().getKey());
          node1.rightChild = node1.rightChild.rightChild;
        }else{
          node.getEntry().setKey(node1.leftChild.getEntry().getKey());
          node1.rightChild=node1.leftChild.rightChild;

        }
      }
    }
    return node;
  }
  protected Node vatersymnach(Node node){
    if(node.rightChild.leftChild != null){
      node = node.rightChild;
      while (node.leftChild.leftChild !=null){
        node = node.leftChild;
      }
    }
    return node;
  }


  /**
   * The height of the tree.
   * 
   * @return The actual height. -1 for an empty tree.
   */
  public int getHeight() {
    // TODO Implement here...
    return -1;
  }
  public int getHeight(Node node){
    return -1;
  }

  public int size() {
    // TODO Implement here...
    return -1;
  }

  public boolean isEmpty() {
    // TODO Implement here...
    return true;
  }
  
  public static void main(String[] args) {
    
    // Example from lecture "Löschen (IV/IV)":
    BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
    //BinarySearchTree<Integer, String> bst = new BinarySearchTreeADV<>("Löschen (IV/IV)", 0, 4);
    System.out.println("Inserting:");
    bst.insert(1, "Str1");
    bst.printInorder();
    bst.insert(3, "Str3");
    bst.printInorder();
    bst.insert(2, "Str2");
    bst.printInorder();
    bst.insert(8, "Str8");
    bst.printInorder();
    bst.insert(9, "Str9");
    bst.insert(6, "Str6");
    bst.insert(5, "Str5");
    bst.printInorder();
    
    System.out.println("Removeing 3:");
    Entry<Integer, String> entry = bst.find(3);
    System.out.println(entry);
    bst.remove(entry);
    bst.printInorder();
    
  }

  /* Session-Log:

  Inserting:
  [1/Str1] 
  [1/Str1] [3/Str3] 
  [1/Str1] [2/Str2] [3/Str3] 
  [1/Str1] [2/Str2] [3/Str3] [8/Str8] 
  [1/Str1] [2/Str2] [3/Str3] [5/Str5] [6/Str6] [8/Str8] [9/Str9] 
  Removeing 3:
  [3/Str3]
  [1/Str1] [2/Str2] [5/Str5] [6/Str6] [8/Str8] [9/Str9] 

  */


} // End of class BinarySearchTree
 
