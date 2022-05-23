#![allow(dead_code)]

use std::collections::HashSet;

pub fn set_zeroes(matrix: &mut Vec<Vec<i32>>) {
    let mut row_set = HashSet::new();
    let mut col_set = HashSet::new();

    let row_len: usize = matrix.len();
    if row_len == 0 { return; }

    let col_len: usize = matrix.get(0).unwrap().len();

    for i in 0..row_len {
        for j in 0..col_len {
            if matrix[i][j] == 0 {
                row_set.insert(i);
                col_set.insert(j);
            }
        }
    }

    for i in 0..row_len {
        for j in 0..col_len {
            let row_zero = row_set.contains(&i);
            let col_zero = col_set.contains(&j);

            if row_zero || col_zero {
                matrix[i][j] = 0
            }
        }
    }
}
