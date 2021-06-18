class WordDictionary {
    
    class Node {
        public int wordEnd;
        public Node[] list;
        
        public Node() {
            wordEnd = 0;
            list = new Node[26];
        }
        
        @Override
        public String toString() {
            return "wordEnd : " + wordEnd;
        }
    }
    
    Node root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node currNode = root;
        
        int len = word.length();
        for(int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            
            if (currNode.list[idx] == null) currNode.list[idx] = new Node();
            currNode = currNode.list[idx];
        }
        
        currNode.wordEnd++;
        // System.out.println(currNode);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return recSearch(root, word, 0);
        // return false;
    }
    
    private boolean recSearch(Node node, String word, int idx) {
        if (node == null) return false;
        
        char ch = word.charAt(idx);
        
        if (idx == word.length() - 1) {
            if (ch != '.') {
                if (node.list[ch - 'a'] != null && node.list[ch - 'a'].wordEnd > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                for(int i = 0; i < 26; i++) {
                    if (node.list[i] != null && node.list[i].wordEnd > 0) {
                        return true;
                    }
                }
                
                return false;
            }
        }
        
        if (ch != '.') {
            int index = ch - 'a';
            
            if (node.list[index] == null) return false;
            return recSearch(node.list[index], word, idx + 1);
        } else {
            boolean ans = false;
            
            for(int i = 0; i < 26; i++) {
                ans = ans || recSearch(node.list[i], word, idx + 1);
            }
            
            return ans;
        }
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
