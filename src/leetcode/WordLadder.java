package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length(), ans = 0;
        Map<String, Set<String>> graph = new HashMap<>();
        for (String s1 : wordList) {
            graph.put(s1, new HashSet<>());
            for (String s2 : wordList) {
                int count = 0;
                for (int k = 0; k < len; k++)
                    if (s1.charAt(k) != s2.charAt(k)) {
                        count++;
                        if(count > 1) break;
                    }
                if (count == 1)
                    graph.get(s1).add(s2);
            }
        }
        Queue<String> q = new ArrayDeque<>();
        for (String s2 : wordList) {
            int count = 0;
            for (int k = 0; k < len; k++)
                if (beginWord.charAt(k) != s2.charAt(k))
                    count++;
            if (count == 1)
                q.add(s2);
        }
        Set<String> set = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            while(size-- > 0){
                String rem = q.remove();
                if(set.contains(rem)) continue;
                set.add(rem);
                if(rem.equals(endWord)) return ans + 1;
                for(String nbr : graph.get(rem))
                    if(!set.contains(nbr))
                        q.add(nbr);
            }
        }
        return 0;
    }

    Set<String> wordList;

    public int ladderLengthFaster(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        this.wordList = wordList.stream().filter(w -> !w.equals(beginWord)).collect(Collectors.toSet());
        Map<String, Boolean> visited = new HashMap<>();

        this.wordList.forEach( word -> visited.put(word, false));

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        queue.add(""); // marker for layer end
        visited.put(beginWord, true);

        Map<String, List<String>> parents = new HashMap<>();
        parents.put(beginWord, Collections.singletonList(""));

        int layerNumber = 1;
        List<List<String>> ans = new ArrayList<>();

        while(queue.size() > 1) {
            String word = queue.poll();
            if(word.isEmpty()) {
                queue.add(""); // else add layer break and increase layer count
                layerNumber++;
                continue;
            }

            if(word.equals(endWord)) return layerNumber;
            for(String neighbour: findNeighbours(word)) { // for all possible change from current word
                if(!visited.get(neighbour)) {
                    visited.put(neighbour, true);
                    queue.add(neighbour);
                }
            }

        }

        return 0;
    }

    List<String> findNeighbours(String s) {
        char[] chars = s.toCharArray();
        List<String> neighbours = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char oldChar = chars[i];
            for(char c = 'a'; c <= 'z'; ++c) {
                chars[i] = c;
                if(c != oldChar && wordList.contains(String.valueOf(chars))) neighbours.add(String.valueOf(chars));
            }
            chars[i] = oldChar;
        }
        return neighbours;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        System.out.println(
                wordLadder.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(
                wordLadder.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"))
        );
        System.out.println(
                wordLadder.ladderLengthFaster("hit", "cog", Arrays.asList("hot","dot","tog","cog"))
        );
        System.out.println(
                wordLadder.ladderLength("qa", "sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"))
        );
    }

}
