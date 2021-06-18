class Solution {
public:
    int strStr(string haystack, string needle) {
        if (needle == "")
            return 0;
        
        int tmpIndex = -1;
        int permIndex = -1;
        int needleIndex = 0;
        
        for (int i = 0; i < haystack.size(); i++) {
            // Check if our needle char matches the haystack char
            if (haystack[i] == needle[needleIndex]) {
                // set tmp index as possible soln
                if (tmpIndex == -1) {
                    tmpIndex = i;
                }
                // update needle index
                needleIndex++;
            } else {
                needleIndex = 0;
                // if a char does not matches go back to tmp index
                // loop will automatically increment us to next of curr char
                if (tmpIndex != -1) {
                    i = tmpIndex;
                }
                tmpIndex = -1;
            }
            // if the whole word is complete exit the loop
            if (needleIndex == needle.size()) {
                permIndex = tmpIndex;
                break;
            }
        }
        
        return permIndex;
    }
};
