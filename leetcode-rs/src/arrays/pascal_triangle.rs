pub fn generate(num_rows: i32) -> Vec<Vec<i32>> {
    let mut pascal_list = Vec::new();

    for i in 0..num_rows {
        let new_row = if i == 0 {
            create_row(&i, &Vec::new())
        } else {
            let prev_row_number = (i as usize) - 1;
            create_row(&i, &pascal_list[prev_row_number])
        };
        pascal_list.push(new_row);
    }

    return pascal_list;
}

pub fn create_row(row_number: &i32, previous_row: &Vec<i32>) -> Vec<i32> {
    if *row_number == 0 {
        return vec![1];
    }

    let mut new_row = Vec::new();

    // Push the initial 1
    new_row.push(1);

    for i in 0..(previous_row.len() - 1) {
        let first_num = previous_row[i];
        let second_num = previous_row[i + 1];

        new_row.push(first_num + second_num);
    }

    // Push the last 1
    new_row.push(1);

    return new_row;
}