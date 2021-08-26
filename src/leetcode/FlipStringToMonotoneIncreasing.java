package leetcode;

import java.util.Arrays;

public class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {
        int oneCount = 0;
        int flips = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '0') {
                if(oneCount == 0) continue;
                ++flips;
            } else ++oneCount;
            if(oneCount < flips) flips = oneCount;
        }
        return flips;
    }

    public static void main(String[] args) {
        System.out.println(new FlipStringToMonotoneIncreasing().minFlipsMonoIncr("00011000"));
    }
}
