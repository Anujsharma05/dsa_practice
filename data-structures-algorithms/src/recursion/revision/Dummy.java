package recursion.revision;

import java.util.ArrayList;
import java.util.List;

public class Dummy {
  public static void main(String[] args) {
    int r=3;
    int c=3;
    List<String> res = maze("", r, c);
    System.out.println(res);
  }
  static List<String> maze(String p, int r, int c) {

    List<String> list = new ArrayList<>();
    if(r == 1 && c == 1) {
      list.add(p);
      return list;
    }
    List<String> next = new ArrayList<>();
    if(r>1) {
      //go down
      next = maze(p + "D",r-1,c);
    }
    if(c>1) {
      //go right
      next = maze(p + "R",r, c-1);
    }
    if(!next.isEmpty()) {
      list.addAll(next);
    }
    return list;
  }
}
