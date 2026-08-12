class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            int count=0;
            if(map.containsKey(num)){
                count=map.get(num);
            }
            count++;
            map.put(num,count);
            if(count>nums.length/2)
                return num;
        }
        return -1;
    }
}