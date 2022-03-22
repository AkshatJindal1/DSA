package interviewbit.backtracking;

import java.util.*;

public class PalindromePartitioning {

    int[][] isPalin;

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        isPalin = new int[a.length()][a.length()];
        for(int[] arr: isPalin) Arrays.fill(arr, -1);
        solve(a, new ArrayList<>(), ans, 0);
        return ans;
    }

    private void solve(String a, ArrayList<String> row, ArrayList<ArrayList<String>> ans, int startIndex) {
        if(startIndex == a.length()) {
            ans.add(new ArrayList<>(row));
            return;
        }
        for(int i = startIndex; i < a.length(); ++i) {
            if(isPalindrome(a, startIndex, i)) {
                row.add(a.substring(startIndex, i + 1));
                solve(a, row, ans, i + 1);
                row.remove(row.size() - 1);
            }
        }
    }

    private void printMatrix(int[][] mat) {
        for(int[] arr: mat) {
            for(int x: arr) System.out.print(x + " ");
            System.out.println();
        }
    }

    private boolean isPalindrome(String a, int startIndex, int endIndex) {
        if(isPalin[startIndex][endIndex] != -1) return isPalin[startIndex][endIndex] == 1;
        int start = startIndex;
        int end = endIndex;
        while(start < end) {
            if(a.charAt(start) != a.charAt(end)) {
                isPalin[startIndex][endIndex] = 0;
                return false;
            }
            start++;
            end--;
        }
        isPalin[startIndex][endIndex] = 1;
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning ob = new PalindromePartitioning();
        System.out.println(ob.partition("aab"));
    }
}
