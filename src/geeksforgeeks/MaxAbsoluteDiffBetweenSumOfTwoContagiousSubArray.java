package geeksforgeeks;

public class MaxAbsoluteDiffBetweenSumOfTwoContagiousSubArray {

    private static int kadaneAlgo(int[] arr, int[] result) {
        int currentMax = arr[0];
        int overAllMax = arr[0];
        for(int i = 1; i < arr.length; ++i) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            overAllMax = Math.max(currentMax, overAllMax);
            result[i] = overAllMax;
        }
        return overAllMax;
    }

    private static int reverseKadane(int[] arr, int[] result) {
        int n = arr.length;
        int currentMax = arr[ n - 1];
        int overAllMax = arr[n - 1];
        for(int i = n - 2; i >= 0; --i) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            overAllMax = Math.max(currentMax, overAllMax);
            result[i] = overAllMax;
        }
        return overAllMax;
    }

    private static int findMaxAbsDiff(int[] a, int n) {
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        kadaneAlgo(a, leftMax);
        reverseKadane(a, rightMax);
        for(int i = 0; i < n; ++i) a[i] = -a[i];
        kadaneAlgo(a, leftMin);
        reverseKadane(a, rightMin);
        for(int i = 0; i < n; ++i) leftMin[i] = -leftMin[i];
        for(int i = 0; i < n; ++i) rightMin[i] = -rightMin[i];
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; ++i) {
            ans = Math.max(ans, Math.max(Math.abs(leftMax[i] - rightMin[i + 1]), Math.abs(leftMin[i] - rightMax[i + 1])));
        }
        return ans;

    }

    public static void main(String[] args) {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = a.length;
        System.out.print(findMaxAbsDiff(a, n));
    }

}
