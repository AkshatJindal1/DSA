package geeksforgeeks;

public class SumOfBitDiffAmongAllPairs {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5 };
        int n = arr.length;

        System.out.println(sumBitDifferences(
                arr, n));
    }

    private static int sumBitDifferences(int[] arr, int n) {
        int ans = 0;
        for(int i = 0; i < 32; ++i) {
            int ones = 0;
            for(int j: arr) {
                if((j & (1 << i)) != 0) ++ones;
            }
            ans += ones * (n - ones) * 2;
        }
        return ans;
    }
}
