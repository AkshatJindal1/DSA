package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher {

    public static void main(String[] args) {
        String name = "grp-21_hbjb-hjvk78jhg-jh_gfcjghfjhf";

        Pattern p = Pattern.compile("([^_]+)_([^_]+)_([^_]+)");
        Matcher m = p.matcher(name);
        if (m.matches()) {
            System.out.println(m.groupCount());
            System.out.println(m.group(3));

        } else {
            System.out.println("not found");
        }
    }
}
