package leetcode;

public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for(char c : text.toCharArray()) count[c - 'a']++;
        count['l' - 'a'] /= 2;
        count['o' - 'a'] /= 2;
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < 26; ++i) {
            char c = (char)(i + 'a');
            if ((c == 'b' ||
                    c == 'a' ||
                    c == 'l' ||
                    c == 'o' ||
                    c == 'n') &&
                    count[i] < minCount) minCount = count[i];
        }
        return minCount;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfBalloons().maxNumberOfBalloons("leetcode"));
    }
}
