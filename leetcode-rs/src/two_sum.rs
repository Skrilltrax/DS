use std::collections::HashMap;

#[allow(dead_code)]
pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let mut map: HashMap<i32, i32> = HashMap::new();

    for (i, num) in nums.iter().enumerate() {
        let index = i as i32;
        let inverse = target - num;

        if map.contains_key(&inverse) {
            let inverse_index = map.get(&inverse).unwrap();
            return vec![index, *inverse_index];
        } else {
            map.insert(*num, index);
        }
    }

    return vec![-1, -1];
}