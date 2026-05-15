class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = 0;
        int empty = 0;
        
        while (numBottles > 0) {
            sum += numBottles;  // drink all bottles
            empty += numBottles; // now we have empty bottles
            numBottles = empty / numExchange; // exchange for new
            empty = empty % numExchange; // leftover empties
        }
        return sum;
    }
}