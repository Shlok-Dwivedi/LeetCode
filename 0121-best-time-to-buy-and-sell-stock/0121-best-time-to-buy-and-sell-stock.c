int maxProfit(int* prices, int pricesSize) {
    if (pricesSize <= 1) return 0;

    int min_price = prices[0];
    int max_profit = 0;

    for (int i = 1; i < pricesSize; i++) {
        if (prices[i] < min_price) {
            min_price = prices[i];  // better buying price
        } else {
            int profit = prices[i] - min_price; 
            if (profit > max_profit) {
                max_profit = profit;  // better selling profit
            }
        }
    }

    return max_profit;
}
