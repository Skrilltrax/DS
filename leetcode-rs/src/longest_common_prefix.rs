#![allow(dead_code)]

pub fn longest_common_prefix(strs: Vec<String>) -> String {
    if strs.len() == 0 { return "".to_string(); }

    let min_size_strs = strs.clone();
    let mut answer = String::from("");
    let mut min_size = i32::MAX;

    for str in min_size_strs {
        if (str.len() as i32) < min_size {
            min_size = str.len() as i32
        }
    }

    for index in 0..min_size {
        let char = &strs
            .first()
            .unwrap()
            .chars()
            .nth(index as usize)
            .unwrap();

        for str in &strs {
            if str.chars().nth(index as usize).unwrap() != *char {
                return answer;
            }
        }

        answer += &char.to_string();
    }

    return answer;
}