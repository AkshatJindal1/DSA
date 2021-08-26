package leetcode;

public class Testing {

    public static int solution(String s) {
        int a[] = new int[26];
        for(char c: s.toCharArray()) {
            a[c-97]++;
        }
        int ans = 0;
        for(int i: a) {
            if(i % 2 != 0) {
                ans++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(solution("aaaa"));
    }
}
