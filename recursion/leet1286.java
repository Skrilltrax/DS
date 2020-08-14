class CombinationIterator {

    ArrayList<String> list;
    int idx;
    
    public CombinationIterator(String characters, int combinationLength) {
        list = new ArrayList<>();
        idx = 0;
        createCombinations(characters, 0, "", combinationLength);
        System.out.println(list);
    }
    
    public String next() {
        return list.get(idx++);    
    }
    
    public boolean hasNext() {
        return idx != list.size();
    }
    
    private void createCombinations(String str, int idx, String ans, int comLen) {
        // System.out.println(ans + comLen);
        if (comLen == ans.length()) {
            // System.out.println(ans);
            list.add(ans);
            return;
        }
        
        if (idx == str.length()) return;
        
        for(int i = idx; i < str.length(); i++) {
            createCombinations(str, i + 1, ans + str.charAt(i), comLen);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
