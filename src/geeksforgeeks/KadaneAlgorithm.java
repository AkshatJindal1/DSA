package geeksforgeeks;

public class KadaneAlgorithm {

    public static void main (String[] args) {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }

    private static int maxSubArraySum(int[] a) {
        int currentMax = a[0];
        int overAllMax = a[0];
        int n = a.length;
        for(int i = 1; i < n; ++i) {
            currentMax = Math.max(a[i], currentMax + a[i]);
            overAllMax = Math.max(overAllMax, currentMax);
        }
        return overAllMax;
    }
}
