class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> list=new ArrayList<>();
        for(int[] item:items1)
            list.add(Arrays.asList(item[0],item[1]));
        for(int[] item:items2){
            boolean found=false;
            for(List<Integer> x:list){
                if(x.get(0)==item[0]){
                    x.set(1,x.get(1)+item[1]);
                    found=true;
                    break;
                }
            }
            if(!found)
                list.add(Arrays.asList(item[0],item[1]));
        }
        list.sort((a,b)->a.get(0)-b.get(0));
        return list;
    }
}