package leetcode;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        for(String s : path.split("/")) {
            if(s.equals("") || s.equals(".")) continue;
            if(s.equals("..")) {
                if(stack.isEmpty()) continue;
                stack.pop();
            }
            else stack.push(s);
        }
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath ob = new SimplifyPath();
        System.out.println(ob.simplifyPath("/home/"));
    }
}
