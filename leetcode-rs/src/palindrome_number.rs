#![allow(dead_code)]

pub fn is_palindrome_string(x: i32) -> bool {
    let x = x.to_string();
    let forward = x.chars().into_iter();
    let reverse = x.chars().into_iter().rev();

    for (f, r) in forward.zip(reverse) {
        if f != r { return false; }
    }

    return true;
}

pub fn is_palindrome(x: i32) -> bool {
    if x < 0 { return false; }
    if x > 10 && x % 10 == 0 { return false; }
    if x < 10 && x >= 0 { return true; }

    // Creates a new variable and sets its value to the value of x
    let reverse_x = create_reverse_number(&x);
    let is_palindrome = check_palindrome(&x, &reverse_x);

    return is_palindrome;
}

fn create_reverse_number(x: &i32) -> i32 {
    let mut reverse_x = 0;
    let mut y = x.clone();

    while y > 0 {
        let last_digit = y % 10;

        reverse_x = reverse_x * 10;
        reverse_x += last_digit;

        y /= 10;
    }

    return reverse_x;
}

fn check_palindrome(x: &i32, reverse: &i32) -> bool {
    let mut copy_x = x.clone();
    let mut reverse_x = reverse.clone();

    while copy_x > 0 {
        let last_digit_copy_x = copy_x % 10;
        let last_digit_reverse_x = reverse_x % 10;

        if last_digit_copy_x != last_digit_reverse_x {
            return false;
        }

        copy_x /= 10;
        reverse_x /= 10;
    }

    return true;
}