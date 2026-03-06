package binary_trees.practice.bst;

public class Main {

  public static void main(String[] args) {
    BST b = new BST();
    int[] values = {10, 4,6};
//    int[] values = {15,10,20,6,3};
    b.populate(values);
    b.preOrderDisplay();
    System.out.println(b.isBalanced());
  }
}
