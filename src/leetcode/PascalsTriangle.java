package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numRows; ++i) {
            Integer[] list = new Integer[i + 1];
            list[0] = 1;
            list[i] = 1;
            if( i == 0) {
                ans.add(Arrays.asList(list));
                continue;
            }
            List<Integer> lastList = ans.get(i -1);
            for(int j = 1; j <= i - 1; ++j){
                list[j] = lastList.get(j- 1) + lastList.get(j);
            }
            ans.add(Arrays.asList(list));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(5));
    }
}
