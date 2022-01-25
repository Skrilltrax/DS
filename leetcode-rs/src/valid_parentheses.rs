#![allow(dead_code)]

pub fn is_valid(s: String) -> bool {
    if s.len() == 0 { return true; }

    let mut stack: Vec<char> = Vec::new();

    for ch in s.chars() {
        match ch {
            '(' | '{' | '[' => { stack.push(ch) }
            ')' => {
                if stack.last().is_none() { return false; }
                if *stack.last().unwrap() != '(' { return false }
                stack.pop();
            }
            '}' => {
                if stack.last().is_none() { return false; }
                if *stack.last().unwrap() != '{' { return false }
                stack.pop();
            }
            ']' => {
                if stack.last().is_none() { return false; }
                if *stack.last().unwrap() != '[' { return false }
                stack.pop();
            }
            _ => { panic!("Unknown character {}", ch) }
        }
    }

    return stack.is_empty();
}
