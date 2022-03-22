package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GeneSimilarity {

    static class Gene {
        char type;
        int count;

        public Gene(char type, int count) {
            this.type = type;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Gene{" +
                    "type=" + type +
                    ", count=" + count +
                    '}';
        }
    }

    private static List<Gene> convertStringToGeneList(String gene) {
        List<Gene> geneList = new ArrayList<>();
        int l1 = gene.length();
        int i = 0;
        int num = 0;
        char c = '0';
        while(i < l1) {
            if(gene.charAt(i) == 'A' || gene.charAt(i) == 'C' || gene.charAt(i) == 'G' || gene.charAt(i) == 'T') {
                geneList.add(new Gene(gene.charAt(i), num));
                num = 0;
            } else {
                num = num * 10 + gene.charAt(i) - '0';
            }
            ++i;
        }
        return geneList;
    }

    /**
     * @param Gene1: a string
     * @param Gene2: a string
     * @return: return the similarity of two gene fragments
     */
    public static String geneSimilarity(String Gene1, String Gene2) {
        // write your code here
        List<Gene> gene1 = convertStringToGeneList(Gene1);
        List<Gene> gene2 = convertStringToGeneList(Gene2);

        int seqLength = 0;
       for(Gene g : gene1) seqLength += g.count;
       int max1 = gene1.get(0).count;
       int max2 = gene2.get(0).count;

       int min1 = 1;
       int min2 = 1;
       int match = 0;
       int i = 0; int j = 0;
       if(gene1.get(i).type == gene2.get(j).type) {
           match += Math.min(max1, max2);
       }

       while(max1 < seqLength || max2 < seqLength) {
           if(max1 <= max2) {
               min1 = max1 + 1;
               max1 += gene1.get(++i).count;
           } else {
               min2 = max2 + 1;
               max2 += gene2.get(++j).count;
           }
           if(gene1.get(i).type == gene2.get(j).type)
               match += Math.min(max1, max2) - Math.max(min1, min2) + 1;
       }
       return match + "/" + seqLength;
    }

    public static void main(String[] args) {
        System.out.println(geneSimilarity("3T2G4A1C", "6T1A2C1G"));
    }
}
