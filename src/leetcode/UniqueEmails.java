package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


public class UniqueEmails {

    public int numUniqueEmails(String[] emails) {
        return Arrays.stream(emails).map(email -> {
            String[] subParts = email.split("@");
            return subParts[0].replace(".", "").split("\\+")[0] + "@" + subParts[1];
        }).collect(Collectors.toSet()).size();

    }

    public static void main(String[] args) {
        System.out.println(new UniqueEmails().numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }
}
