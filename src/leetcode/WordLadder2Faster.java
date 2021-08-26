package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadder2Faster {

    Set<String> wordList;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return new ArrayList<>();
        this.wordList = wordList.stream().filter(w -> !w.equals(beginWord)).collect(Collectors.toSet());
        Map<String, Integer> wordLayerMap = new HashMap<>();

        this.wordList.forEach( word -> wordLayerMap.put(word, -1));
        wordLayerMap.put(beginWord, 0);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        queue.add(""); // marker for layer end

        Map<String, List<String>> parents = new HashMap<>();
        parents.put(beginWord, Collections.singletonList(""));

        int layerNumber = 0;
        boolean endFound = false;
         List<List<String>> ans = new ArrayList<>();

         while(queue.size() > 1) {
             System.out.println(queue);
             String word = queue.poll();
             if(word.isEmpty()) {
                 if(endFound) break; // if end found then break
                 queue.add(""); // else add layer break and increase layer count
                 layerNumber++;
                 continue;
             }

             if(word.equals(endWord)) endFound = true;
             System.out.println(word + " -> " + findNeighbours(word));
             for(String neighbour: findNeighbours(word)) { // for all possible change from current word
                 if(wordLayerMap.get(neighbour) == layerNumber) { // if used in current layer then add current word also as parent
                     parents.get(neighbour).add(word);
                 } else if(wordLayerMap.get(neighbour) == -1) { // if never used create a new list and add current word as parent and change layer number
                     wordLayerMap.put(neighbour, layerNumber);
                     queue.add(neighbour); // adding the word as next layer element
                     parents.computeIfAbsent(neighbour, p -> new ArrayList<>()).add(word);
                 }
             }

         }
        System.out.println(parents);
         if(endFound) {
            answerMaker(ans, new LinkedList<>(), parents, endWord);
         }

        return ans;
    }

    private void answerMaker(List<List<String>> ans, LinkedList<String> temp, Map<String , List<String>> parents, String current) {
        if(current.isEmpty()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.addFirst(current);
        for(String s : parents.get(current)) answerMaker(ans, temp, parents, s);
        temp.removeFirst();
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
        WordLadder2Faster wordLadder2 = new WordLadder2Faster();
        System.out.println(
                wordLadder2.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(
                wordLadder2.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"))
        );
        System.out.println(
                wordLadder2.findLadders("hit", "cog", Arrays.asList("hot","dot","tog","cog"))
        );
        System.out.println(
                wordLadder2.findLadders("qa", "sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"))
        );
    }
}
