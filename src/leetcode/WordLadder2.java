package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadder2 {

    Set<String> wordList;
    Map<String, List<List<String>>> layer;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return new ArrayList<>();
        this.wordList = wordList.stream().filter(w -> !w.equals(beginWord)).collect(Collectors.toSet());
        this.layer = new HashMap<>();
        layer.put(beginWord, Collections.singletonList(Collections.singletonList(beginWord)));

        while (!layer.isEmpty()) {
            if(layer.containsKey(endWord)) return layer.get(endWord); // if final layer already built return it
            Map<String, List<List<String>>> nextLayer = new HashMap<>(); // building the possible sequences in next layer
            for(Map.Entry<String, List<List<String>>> entry : layer.entrySet()) { // for all seq in current layer
                String word = entry.getKey();
                List<List<String>> paths = entry.getValue();
                System.out.print(word + " -> ");
                System.out.println(findNeighbours(word));
                for(String neighbour: findNeighbours(word)) { // get all neighbours of the current word
                    for(List<String> path: paths) { // get all possible paths for the current word and add it to next layer with neighbour as last element
                        if(!nextLayer.containsKey(neighbour)) nextLayer.put(neighbour, new ArrayList<>());
                        List<List<String>> n = nextLayer.get(neighbour);
                        n.add(new ArrayList<>(path));
                        n.get(n.size() - 1).add(neighbour);
                    }
                }
            }
            nextLayer.keySet().forEach(i ->this.wordList.remove(i)); // remove used words from set to avoid loops
            layer = nextLayer; // move to next layer
        }
        return new ArrayList<>();
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
        WordLadder2 wordLadder2 = new WordLadder2();
        System.out.println(
                wordLadder2.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(
                wordLadder2.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"))
        );

        System.out.println(
                wordLadder2.findLadders("qa", "sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"))
        );
    }
}
