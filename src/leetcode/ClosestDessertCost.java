package leetcode;

public class ClosestDessertCost {

    int ans = Integer.MAX_VALUE;
    int minDiff = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        ans = Integer.MAX_VALUE;
        minDiff = Integer.MAX_VALUE;
        for(int base : baseCosts) {
            recursion(toppingCosts, base, target, 0);
        }
        return ans;
    }

    private void recursion(int[] toppingCosts, int sum, int target, int i) {
        if(Math.abs(sum - target) < minDiff) {
            minDiff = Math.abs(sum - target);
            ans = sum;
        }
        else if(Math.abs(sum - target) == minDiff) {
            ans = Math.min(sum, ans);
        }
        if(i == toppingCosts.length) return;
        recursion(toppingCosts, sum + toppingCosts[i], target, i + 1);
        recursion(toppingCosts, sum + 2 * toppingCosts[i], target, i + 1);
        recursion(toppingCosts, sum, target, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(new ClosestDessertCost().closestCost(new int[]{1, 7}, new int[]{3, 4}, 10));
    }
}
