import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }
        long sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : target) {
            sum += num;
            maxHeap.offer(num);
        }
        while (maxHeap.peek() > 1) {
            int max = maxHeap.poll();
            long restSum = sum - max;
            if (restSum == 1) return true;
            if (restSum == 0 || max <= restSum) return false;
            int prev = (int)(max % restSum);
            if (prev == 0) prev = (int)restSum;
            if (prev == max) return false;
            maxHeap.offer(prev);
            sum = restSum + prev;
        }
        return true;
    }
}   