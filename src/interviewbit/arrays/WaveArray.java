package interviewbit.arrays;

import java.util.*;

public class WaveArray {

    public List<Integer> wave(List<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        for(int i = 0; i < n - 1; i += 2) {
            int temp = A.get(i);
            A.set(i, A.get(i + 1));
            A.set(i + 1, temp);
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(new WaveArray().wave(Arrays.asList(5, 1, 3, 2, 4)));
    }
}
