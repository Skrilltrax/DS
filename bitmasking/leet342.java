class Solution {
    public boolean isPowerOfFour(int num) {
        for(int i = 0; i < 32; i += 2) {
            int mask = (1 << i);
            if (((num & mask) != 0) && ((num & (~mask)) == 0)) {
                return true;
            }
        }
        
        return false;
    }
}
