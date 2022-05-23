pub fn max_sub_array(nums: Vec<i32>) -> i32 {
    let mut max_so_far = i32::MIN;
    let mut max_ending_here = 0;

    for i in 0..nums.len() {
        let current_num = nums[i];
        max_ending_here += current_num;

        if max_ending_here > max_so_far {
            max_so_far = max_ending_here;
        }

        if max_ending_here < 0 {
            max_ending_here = 0;
        }
    }

    return max_so_far;
}