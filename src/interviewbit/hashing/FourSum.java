package interviewbit.hashing;

import java.util.*;

public class FourSum {

    private boolean allDistinct(int a, int b, int c, int d) {
        return (a != b && a != c && a != d && b != c && b != d && c != d);
    }
    public ArrayList<ArrayList<Integer>> fourSum(List<Integer> A, int B) {
        Collections.sort(A);

        HashMap<Integer, Set<List<Integer>>> map = new HashMap<>();
        Set<ArrayList<Integer>> ans = new HashSet<>();

        for(int i = 0; i < A.size() - 1; ++i) {
            if(i != 0 && Objects.equals(A.get(i), A.get(i - 1))) continue;
            for(int j = i + 1; j < A.size(); ++j) {
                int sum = A.get(i) + A.get(j);
                if(map.containsKey(B - sum)) {
                    for(List<Integer> x : map.get(B - sum)) {
                        if(allDistinct(x.get(0), x.get(1), i, j)) {
                            ArrayList<Integer> subList = new ArrayList<>();
                            subList.add(A.get(x.get(0)));
                            subList.add(A.get(x.get(1)));
                            subList.add(A.get(i));
                            subList.add(A.get(j));
                            Collections.sort(subList);
                            ans.add(subList);
                        }
                    }
                }
                Set<List<Integer>> s = map.getOrDefault(sum, new HashSet<>());
                s.add(Arrays.asList(i, j));
                map.put(sum, s);
            }
        }
//        System.out.println(map);
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {

        System.out.println(
            new FourSum().fourSum(
                    Arrays.asList(9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2),
                    0)
            );
    }
}
