package binary_trees.practice.bst;

public class BST {

  private Node root;

  private int height(Node node) {
    if (node == null) {
      return -1;
    }
    return node.height;
  }

  public void populate(int[] values) {
    for (int val : values) {
      insert(val);
    }
  }

  public Node insert(int value) {
    this.root = insert(root, value);
    return root;
  }

  private Node insert(Node node, int value) {

    if (node == null) {
      return new Node(value);
    }

    if (value <= node.value) {
      node.left = insert(node.left, value);
    } else {
      node.right = insert(node.right, value);
    }

    node.height = Math.max(height(node.left), height(node.right)) + 1;

    return rotate(node);
  }

  private Node rotate(Node node) {

    if (height(node.left) - height(node.right) > 1) {

      if (height(node.left.left) < height(node.left.right)) {
        node.left = leftRotate(node.left);
      }
      return rightRotate(node);
    } else if (height(node.left) - height(node.right) < -1) {

      if (height(node.right.left) > height(node.right.right)) {
        node.right = rightRotate(node.right);
      }
      return leftRotate(node);
    }

    return node;
  }

  private Node leftRotate(Node p) {
    Node c = p.right;
    p.right = c.left;
    c.left = p;

    p.height = Math.max(height(p.left), height(p.right)) + 1;
    c.height = Math.max(height(c.left), height(c.right)) + 1;

    return c;
  }

  private Node rightRotate(Node p) {
    Node c = p.left;
    p.left = c.right;
    c.right = p;

    p.height = Math.max(height(p.left), height(p.right)) + 1;
    c.height = Math.max(height(c.left), height(c.right)) + 1;

    return c;
  }

  public boolean isBalanced() {
    return isBalanced(root);
  }

  private boolean isBalanced(Node node) {

    if (node == null) {
      return true;
    }

    return Math.abs(height(node.left) - height(node.right)) <= 1
        && isBalanced(node.left) && isBalanced(node.right);
  }

  public void preOrderDisplay() {
    preOrderDisplay(root, "Root node is: ");
  }

  private void preOrderDisplay(Node node, String message) {

    if (node == null) {
      return;
    }

    System.out.println(message + node.value + "(Height=" + node.height + ")");
    preOrderDisplay(node.left, "Left of " + node.value + " is: ");
    preOrderDisplay(node.right, "Right of " + node.value + " is: ");
  }

  private class Node {

    private int value;
    private Node left;
    private Node right;
    private int height;

    public Node(int value) {
      this.value = value;
    }
  }
}
