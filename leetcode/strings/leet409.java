class Solution {
    public int longestPalindrome(String s) {
        int[] freqMap = new int[52];
        
        for(int i = 0;  i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (isCapital(ch)) {
                freqMap[26 + (ch - 'A')]++;
            } else {
                freqMap[0 + (ch - 'a')]++;
            }
        }
        
        int evenCount = 0;
        int oddCount = 0;
        boolean containsOdd = false;
        
        for(int i = 0; i < freqMap.length; i++) {
            if (freqMap[i] % 2 == 0) {
                evenCount += freqMap[i];
            } else {
                containsOdd = true;
                oddCount += freqMap[i] - 1;
            }
        }
                
        return evenCount + oddCount + (containsOdd == true ? 1 : 0);
    }
    
    private boolean isCapital(char ch) {
        if (ch >= 'A'&& ch <= 'Z') return true;
        return false;
    }
}
