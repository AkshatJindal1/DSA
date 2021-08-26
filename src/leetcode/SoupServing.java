package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SoupServing {
    private Map<String, Double> dp = new HashMap<>();
    public double soupServings(int n) {
        if(n > 4800) return 1.0;
        return calculate(n ,n);
    }

    private double calculate(int m, int n) {
        if(dp.containsKey(m + "-" + n)) return dp.get(m + "-" + n);
        if(m <= 0 && n <= 0) return 0.5;
        if(m <= 0) return 1.0;
        if(n <= 0) return 0.0;
        double prob = 0.25 * (calculate(m - 100, n)
                + calculate(m - 75, n - 25)
                + calculate(m - 50, n - 50)
                + calculate(m - 25, n - 75));
        dp.put(m + "-" + n, prob);
        return prob;
    }

    public static void main(String[] args) {
        System.out.println(new SoupServing().soupServings(660295675));
    }
}
