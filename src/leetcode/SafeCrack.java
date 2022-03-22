package leetcode;

import java.util.*;

public class SafeCrack {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<n;i++) {
            sb.append("0");
        }
        int total = (int)Math.pow(k,n);
        HashSet<String> visited = new HashSet<>();
        visited.add(sb.toString());
        if(crackTheSafe(sb, n, k, visited, total)) {
            return sb.toString();
        }
        return "-1";
    }

    public boolean crackTheSafe(StringBuilder sb, int n, int k, HashSet<String> visited, int total) {
        System.out.println(sb.toString() + " " + visited);
        if(total == visited.size())
            return true;
        String lastDigits = sb.substring(sb.length() - (n-1));
        for(int i=0;i<k;i++) {
            Character ch = (char)(i+'0');
            String newStr = lastDigits + ch;
            if(!visited.contains(newStr)) {
                visited.add(newStr);
                sb.append(ch);
                if(crackTheSafe(sb, n, k, visited, total)) {
                    return true;
                }
                visited.remove(newStr);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SafeCrack ob = new SafeCrack();
        System.out.println(ob.crackSafe(3, 2));
    }
}
