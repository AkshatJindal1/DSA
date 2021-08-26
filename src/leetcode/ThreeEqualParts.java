package leetcode;

import java.util.Arrays;

public class ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int totalOne = 0;
        for(int i: arr)
            totalOne += i;
        if(totalOne % 3 != 0) return new int[]{-1, -1};

        int targetOne = totalOne / 3;
        if(targetOne == 0) return new int[]{0, n -1};

        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1;

        int oneCount = 0;
        for(int i = 0; i < n; ++i) {
            if(arr[i] == 1) {
                oneCount++;
                if(oneCount == 1) i1 = i;
                if(oneCount == targetOne) j1 = i;
                if(oneCount == targetOne + 1) i2 = i;
                if(oneCount == 2 * targetOne) j2 = i;
                if(oneCount == 2 * targetOne + 1) i3 = i;
                if(oneCount == 3 * targetOne) j3 = i;
            }
        }
        System.out.println(n);
        System.out.println(i1 + " "+ j1 + " " + i2 + " " + j2 + " "+ i3 + " "+ j3);
//         int[] part1 = Arrays.copyOfRange(arr, i1, j1 + 1);
//         int[] part2 = Arrays.copyOfRange(arr, i2, j2 + 1);
//         int[] part3 = Arrays.copyOfRange(arr, i3, j3 + 1);
        if(compareArrays(arr, i1, j1 + 1, i2, j2 + 1)
                || compareArrays(arr, i1, j1 + 1, i3, j3 + 1))
//             if(!Arrays.equals(part1, part2) || !Arrays.equals(part2, part3))
            return new int[]{-1, -1};

        int trailingZerosleft = i2 - j1 - 1;
        int trailingZerosMid = i3 - j2 - 1;
        int trailingZeros = n - j3 - 1;

        if(trailingZeros > Math.min(trailingZerosleft, trailingZerosMid))
            return new int[]{-1, -1};

        return new int[]{j1 + trailingZeros, j2 + trailingZeros + 1};

    }

    private boolean compareArrays(int[] arr, int i, int j, int k, int l) {
        if(j - i != l - k) return true;
        for(; i < j; ++i, ++k) {
            if(arr[i] != arr[k]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ThreeEqualParts().threeEqualParts(new int[]{1, 0, 1, 0, 1})));
    }
}
