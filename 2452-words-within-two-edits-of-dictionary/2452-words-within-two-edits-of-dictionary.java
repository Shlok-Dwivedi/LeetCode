class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> str1=new ArrayList<>();

        for(int j=0;j<queries.length;j++){
            for(int i=0;i<dictionary.length;i++){
                int check=0;

                if(dictionary[i].length()==queries[j].length()){
                    for(int k=0;k<dictionary[i].length();k++){
                        if(dictionary[i].charAt(k) != queries[j].charAt(k)){
                            check++;
                        }
                    }

                    if(check<3){
                        str1.add(queries[j]);
                        break;
                    }
                }
            }
        }

        return str1;
    }
}