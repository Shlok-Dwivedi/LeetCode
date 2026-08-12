class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            int reach=0;
            if(map.containsKey(num)){
                reach=map.get(num);
            }
            reach++;
            map.put(num,reach);
            if(reach>nums.length/3 && !l.contains(num))
                l.add(num);
        }
        return l;
    }
}