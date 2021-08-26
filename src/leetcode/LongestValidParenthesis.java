package leetcode;

import java.util.Stack;

public class LongestValidParenthesis {

    public static int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        st.push(-1);
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') st.push(i);
            else {
                st.pop();
                if(st.isEmpty()) {
                    st.push(i);
                } else {
                    ans = Math.max(ans, i - st.peek());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(
                longestValidParentheses("(()") == 2 &&
                longestValidParentheses(")()())") == 4 &&
                longestValidParentheses("") == 0 &&
                longestValidParentheses("()(()") == 2
                );
    }
}
