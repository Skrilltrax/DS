pub fn max_profit(prices: Vec<i32>) -> i32 {
    let mut max_profit = 0;
    let mut price_stack = Vec::new();

    // Push the initial price since we must buy on that day
    price_stack.push(prices[0]);

    for i in 1..prices.len() {
        let current_price = prices[i];
        let previous_price = prices[i - 1];

        if current_price > previous_price {
            price_stack.push(current_price);
            continue;
        }

        // Check if max profit is greater than the current max profit
        max_profit = max_profit.max(current_price - price_stack[0]);

        while !price_stack.is_empty() && current_price < *price_stack.last().unwrap() {
            price_stack.pop();
        }

        price_stack.push(current_price);
    }

    if price_stack.len() > 2 {
        let buy_price = price_stack.first().unwrap();
        let sell_price = price_stack.last().unwrap();
        let profit = *sell_price - *buy_price;

        max_profit = max_profit.max(profit);
    }

    return max_profit;
}
