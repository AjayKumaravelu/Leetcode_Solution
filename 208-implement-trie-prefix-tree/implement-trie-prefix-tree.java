class Trie {
    static class Node{
        Node link[] = new Node[26];
        boolean flag = false;

        public Node(){

        }

        public boolean isContainsKey(char ch){
            return (link[ch - 'a'] != null);
        }

        public void put(char ch, Node node){
            link[ch - 'a'] = node;
        }

        public Node get(char ch){
            return (link[ch - 'a']);
        }

        public void setEnd(){
            flag = true;
        }

        public boolean isEnd(){
            return flag;
        }

    }

    private static Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.isContainsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.isContainsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0; i < prefix.length(); i++){
            if(!node.isContainsKey(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */