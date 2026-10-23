class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            int landFinish = landStartTime[i] + landDuration[i];

            for (int j = 0; j < waterStartTime.length; j++) {
                int finish = Math.max(landFinish, waterStartTime[j]) + waterDuration[j];
                ans = Math.min(ans, finish);
            }
        }

        for (int j = 0; j < waterStartTime.length; j++) {
            int waterFinish = waterStartTime[j] + waterDuration[j];

            for (int i = 0; i < landStartTime.length; i++) {
                int finish = Math.max(waterFinish, landStartTime[i]) + landDuration[i];
                ans = Math.min(ans, finish);
            }
        }

        return ans;
    }

}