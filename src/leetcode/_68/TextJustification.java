package leetcode._68;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            List<String> currLine = getWords(i, words, maxWidth);
            i+= currLine.size();
            ans.add(createLine(currLine, i, words, maxWidth));
        }
        return ans;
    }



    private List<String> getWords(int i, String[] words, int maxWidth) {
        List<String> curLine = new ArrayList<>();
        int curLength =  0;
        while (i < words.length && curLength + words[i].length() <= maxWidth) {
            curLine.add(words[i]);
            curLength += words[i].length() + 1;
            i++;
        }
        return curLine;
    }

    private String createLine(List<String> line, int i, String[] words, int maxWidth) {
        int baseLength = -1;
        for (String word : line) {
            baseLength += word.length() + 1;
        }

        int extraSpaces = maxWidth - baseLength;
        if(line.size() == 1 || i == words.length){
            return String.join(" ", line) + " ".repeat(extraSpaces);
        }

        int wordCount = line.size() - 1;
        int spacesPerWord = extraSpaces / wordCount;
        int needsExtraSpace = extraSpaces % wordCount;

        for (int j = 0; j < needsExtraSpace; j++) {
            line.set(j, line.get(j)+ " ");
        }

        for (int j = 0; j < wordCount; j++) {
            line.set(j, line.get(j)+ " ".repeat(spacesPerWord));
        }
        return String.join(" ", line);
    }

    public static void main(String[] args) {
        var t = new TextJustification();
        System.out.println(t.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(t.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));//
        System.out.println(t.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"},
                20));
    }
}
