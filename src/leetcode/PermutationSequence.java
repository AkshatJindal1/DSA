package leetcode;

import java.util.LinkedList;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int smallerFactorial = 1;
        boolean[] used = new boolean[n];
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i = 1; i < n; ++i) {
            smallerFactorial *= i;
            ll.add(i);
        }
        ll.add(n);
        k--;
        StringBuilder sb = new StringBuilder();
        while(ll.size() > 0) {
            sb.append(ll.get(k / smallerFactorial));
            ll.remove(k / smallerFactorial);
            k = k % smallerFactorial;
            n--;
            if(n > 0) smallerFactorial /= n;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(4, 9));
    }
}
