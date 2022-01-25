pub fn roman_to_int(s: String) -> i32 {
    let str_len = s.len();
    let mut answer = 0;
    let mut skip_loop = false;

    for index in 0..str_len {
        // It is not the last element
        if skip_loop {
            skip_loop = false;
            continue;
        }

        if index < str_len - 1 {
            let first = &s.chars().nth(index).unwrap();
            let second = &s.chars().nth(index + 1).unwrap();
            let first_roman = map_roman(first) as i32;
            let second_roman = map_roman(second) as i32;

            if first_roman < second_roman {
                answer += second_roman - first_roman;
                skip_loop = true;
            } else {
                answer += first_roman;
            }
        } else {
            let char = &s.chars().nth(index).unwrap();
            let roman = map_roman(char) as i32;
            answer += roman;
        }
    }

    return answer;
}

fn map_roman(ch: &char) -> Roman {
    return match *ch {
        'I' => Roman::I,
        'V' => Roman::V,
        'X' => Roman::X,
        'L' => Roman::L,
        'C' => Roman::C,
        'D' => Roman::D,
        'M' => Roman::M,
        // We will never reach this case
        _ => { Roman::I }
    }
}

enum Roman {
    I = 1,
    V = 5,
    X = 10,
    L = 50,
    C = 100,
    D = 500,
    M = 1000,
}