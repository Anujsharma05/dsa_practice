package binary_trees.segment_tree;

public class SegmentTree {

  private class Node {
    private Node left;
    private Node right;
    private int query;
    private int intervalStart;
    private int intervalEnd;

    @Override
    public String toString() {
      return "{" +
          "query=" + query + ", [" + intervalStart + "," + intervalEnd + "]" +
          '}';
    }
  }

  private Node root;

  public void populate(int[] values) {
    this.root = create(root, values, 0, values.length-1);
  }

  private Node create(Node node, int[] values, int start, int end) {

    if(start == end) {
      node = new Node();
      node.intervalStart = node.intervalEnd = start;
      node.query = values[start];
      return node;
    }

    int mid = start + (end-start)/2;

    node = new Node();
    node.intervalStart = start;
    node.intervalEnd = end;

    node.left = create(node, values, start, mid);
    node.right = create(node, values, mid+1, end);

    node.query = node.left.query + node.right.query;

    return node;
  }

  public void update(int index, int value) {
    if(root == null) {
      return;
    }
    update(root, index, value);
  }

  private Node update(Node node, int index, int value) {

    if(index < node.intervalStart || node.intervalEnd < index) {
      return node;
    }

    if(index == node.intervalStart && index == node.intervalEnd) {
      node.query = value;
      System.out.println("Updated for " + node);
      return node;
    }

    node.left = update(node.left, index, value);
    node.right = update(node.right, index, value);

    node.query = node.left.query + node.right.query;

    System.out.println("update for " + node);

    return node;
  }

  public void display() {
    display(root, "Root is: ");
  }

  private void display(Node node, String message) {

    if(node == null) return;

    System.out.println(message + node);
    display(node.left, "Left of " + node + ": ");
    display(node.right, "Right of " + node + ": ");
  }

}
