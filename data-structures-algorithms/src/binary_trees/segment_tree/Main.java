package binary_trees.segment_tree;

public class Main {

  public static void main(String[] args) {
    SegmentTree st = new SegmentTree();
    int[] values = {3,8,7,6,-2,-8,4,9};
    st.populate(values);
//    st.display();
    System.out.println("===================================");
    st.update(3, 14);
//    st.display();
  }
}
