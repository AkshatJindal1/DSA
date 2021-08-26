package leetcode;

public class CountPrimes {

    public int countPrimes(int n) {
        int[] sieve = new int[n + 1];
        int ans = 0;
        for(int i = 2; i <= n; ++i) {
            if(sieve[i] == 0) {
                ++ans;
                for(int j = i + i; j <= n; j += i)
                    sieve[j] = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(0));
    }

}
