class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            int number = -1;
            if (nums[i] < 0) {
                number = nums[i] * -1;
            } else {
                number = nums[i];
            }
            
            if (nums[number - 1] < 0) {
                list.add(number);
            } else {
                nums[number - 1] *= -1;
            }
        }
        
        return list;
    }
}
