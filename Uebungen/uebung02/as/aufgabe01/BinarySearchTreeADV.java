/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Sun Sep 22 14:00:28 CEST 2019
 */

package uebung02.as.aufgabe01;

import ch.hsr.adv.commons.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.commons.tree.logic.domain.ADVBinaryTreeNode;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.tree.logic.binarytree.BinaryTreeModule;

@SuppressWarnings("unchecked")
public class BinarySearchTreeADV<K extends Comparable<? super K>, V>
    extends BinarySearchTree<K, V> {

  protected BinaryTreeModule advTree;

  protected class NodeADV extends BinarySearchTree<K, V>.Node
      implements ADVBinaryTreeNode<String> {

    protected NodeADV(Entry<K, V> entry) {
      super(entry);
    }

    @Override
    public String getContent() {
      return getEntry().getKey() + " / " + getEntry().getValue();
    }

    @Override
    public ADVStyle getStyle() {
      return null;
    }

    @Override
    public NodeADV getLeftChild() {
      return (NodeADV) super.getLeftChild();
    }

    @Override
    public NodeADV getRightChild() {
      return (NodeADV) super.getRightChild();
    }

  } // class BinaryTreeTestADV.NodeADV

  public BinarySearchTreeADV(String sessionName) {
    this(sessionName, -1, -1);
  }

  public BinarySearchTreeADV(String sessionName, 
                             int maxLeftHeight, int maxRightHeight) {
    advTree = new BinaryTreeModule(sessionName);
    if ((maxLeftHeight != -1) && (maxLeftHeight != -1)) {
      advTree.setFixedTreeHeight(maxLeftHeight, maxRightHeight);
    }
    try {
      ADV.launch(null);
    } catch (ADVException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  @Override
  protected Node newNode(Entry<K, V> entry) {
    return new NodeADV(entry);
  }

  @Override
  public Entry<K, V> insert(K key, V value) {
    Entry<K, V> newEntry = super.insert(key, value);
    displayOnADV("insert(" + key + "," + value + ")");
    return newEntry;
  }

  @Override
  public Entry<K, V> remove(Entry<K, V> entry) {
    Entry<K, V> deletedEntry = super.remove(entry);
    displayOnADV("remove(" + entry + ")");
    return deletedEntry;
  }

  protected void displayOnADV(String advMessage) {
    advTree.setRoot((NodeADV) root);
    try {
      ADV.snapshot(advTree, "\n" + advMessage);
    } catch (ADVException e) {
      e.printStackTrace();
      System.exit(2);
    }
  }

}
