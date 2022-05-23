#![allow(dead_code)]

mod two_sum;
mod palindrome_number;
mod longest_common_prefix;
mod roman_to_int;
mod valid_parentheses;
mod merge_two_sorted_lists;
mod arrays;

fn main() {
    let answer = arrays::pascal_triangle::generate(5);
    println!("{:?}", answer);
}
