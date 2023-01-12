package searchSuggestionSystem1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystem {

    public static void main(String[] args) {
        //test case
        String[] products = new String[]{"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> result = suggestedProducts(products, searchWord);
        result.forEach(strings -> strings.forEach(System.out::println));

    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //create a trie for words.
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        // Add all words to trie.
        for (String w : products) {
            trie.insert(w);
        }
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            //add current character to prefix
            prefix += c;
            result.add(trie.getWordsStartingWith(prefix));
        }
        return result;
    }
}

class Trie {

    class Node {
     Boolean isWord = false;
     List<Node> children = Arrays.asList(new Node[26]);
    }

    Node root;
    Node current;
    List<String> resultBuffer;

    Trie() {
        root = new Node();
    }

    void dfsWithPrefix(Node current, String word) {
        if (resultBuffer.size()==3) {
            return;
        }
        if (current.isWord) {
            resultBuffer.add(word);
        }

        for (char c = 'a'; c<='z'; c++) {
            if (current.children.get(c-'a')!=null) {
                dfsWithPrefix(current.children.get(c-'a'), word+c);
            }
        }
    }

    void insert(String s) {
        current = root;
        for (char c : s.toCharArray()) {
            if (current.children.get(c - 'a')==null) {
                current.children.set(c - 'a', new Node());
            }
            current = current.children.get(c - 'a');
        }
        current.isWord = true;
    }

    List<String> getWordsStartingWith(String prefix) {
        current = root;
        resultBuffer = new ArrayList<>();
        for (char c : prefix.toCharArray()) {
            if (current.children.get(c - 'a') == null) {
                return resultBuffer;
            }
            current = current.children.get(c - 'a');
        }
        dfsWithPrefix(current, prefix);
        return resultBuffer;
    }
}