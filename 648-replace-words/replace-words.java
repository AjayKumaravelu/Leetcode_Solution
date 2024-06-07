class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public void insert(String word, TrieNode root) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        // Build the Trie
        for (String word : dictionary) {
            insert(word, root);
        }

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");

        // Replace words in the sentence
        for (String word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }
            TrieNode node = root;
            String replacement = null;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null || node.word != null) {
                    break;
                }
                node = node.children[c - 'a'];
            }
            if (node.word != null) {
                replacement = node.word;
            }
            result.append(replacement != null ? replacement : word);
        }

        return result.toString();
        
    }
}