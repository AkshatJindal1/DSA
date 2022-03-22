package interviewbit.math;

public class HammingDistance {
    int hammingDistance(int x, int y) {
        int m = Math.max(x, y);
        int ans = 0;
        while(m > 0) {
            int c1 = x & 1;
            int c2 = y & 1;
            if(c1 != c2) ans += 1;
            m = m >> 1;
            x = x >> 1;
            y = y >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(2, 6));
    }

}
