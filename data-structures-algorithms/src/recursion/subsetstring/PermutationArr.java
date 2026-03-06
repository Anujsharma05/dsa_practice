package recursion.subsetstring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationArr {
  public static void main(String[] args) {
    int[] arr = {1,2,3};
    List<List<Integer>> ans = permute(arr);
    System.out.println(ans);
  }

  public static List<List<Integer>> permute(int[] nums) {
    return permutation(nums, new ArrayList<>());
  }
  static List<List<Integer>> permutation(int[] arr, List<Integer> temp) {

    List<List<Integer>> ans = new ArrayList<>();
    if(arr.length == temp.size()) {
      ans.add(List.copyOf(temp));
      return ans;
    }
    for(int i=0; i<arr.length; i++) {
      if(!temp.contains(arr[i])) {
        temp.add(arr[i]);
        List<List<Integer>> next = permutation(arr, temp);
        ans.addAll(next);
        temp.removeLast();
      }
    }
    return ans;
  }
}
