mod two_sum;

fn main() {
    println!("Hello, world!");
    let answer = two_sum::two_sum(vec![2,7,11,15], 9);
    println!("{:?}", answer);
}
