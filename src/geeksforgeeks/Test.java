package geeksforgeeks;

import java.util.*;

public class Test {
    int index;
    public String countOfAtoms(String formula) {
        index = 0;
        Map<String, Integer> mp = countPart(formula);
        List<String> keys = new LinkedList<>(mp.keySet());

        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for(String c : keys) {
            sb.append(c);
            if(mp.get(c) != 1) sb.append(mp.get(c));
        }
        return sb.toString();
    }

    private Map<String, Integer> countPart(String formula) {
        Map<String, Integer> mp = new HashMap<>();
        while(index < formula.length()) {
            char ch = formula.charAt(index);
            if(ch == '(') {
                index++;
                Map<String, Integer> m = countPart(formula);
                for(String key : m.keySet()) {
                    mp.put(key, mp.getOrDefault(key, 0) + m.get(key));
                }
            }
            else if(ch == ')') {
                index++;
                int num = 0;
                if(index < formula.length()) {
                    char x = formula.charAt(index);
                    while (x >= '0' && x <= '9') {
                        num = num * 10 + (x - '0');
                        index++;
                        if(index >= formula.length()) break;
                        x = formula.charAt(index);
                    }
                }
                if (num == 0) num = 1;
                for (String key : mp.keySet()) {
                    mp.put(key, mp.get(key) * num);
                }
                return mp;
            }
            else if((ch >= 'A' && ch <= 'Z')) {
                char c = formula.charAt(index);
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                index++;
                if(index < formula.length()) {
                    c = formula.charAt(index);
                    while(c >= 'a' && c <= 'z') {
                        sb.append(c);
                        index++;
                        if(index >= formula.length()) break;
                        c = formula.charAt(index);
                    }
                }
                int count = 0;
                while(c >= '0' && c <= '9') {
                    count = count * 10 + ( c- '0');
                    index++;
                    if(index >= formula.length()) break;
                    c = formula.charAt(index);
                }
                if(count == 0) count = 1;
                String elem = sb.toString();
                mp.put(elem, mp.getOrDefault(elem, 0) + count);
            }
        }
        return mp;
    }
}