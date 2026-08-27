class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];

        for(char c:s.toCharArray()){
            count[c-'a']++;
        }

        int[] bestCount = null;
        int bestIndex = -1;
        char bestChar = 0;

        StringBuilder prefix = new StringBuilder();

        for(int i=0;i<s.length();i++){
            int targetChar = target.charAt(i)-'a';

            // Save the smallest possible character greater than target[i]
            for(int j=targetChar+1;j<26;j++){
                if(count[j]>0){
                    bestIndex = i;
                    bestChar = (char)('a'+j);
                    bestCount = count.clone();
                    bestCount[j]--;
                    break;
                }
            }

            // Try to match target[i]
            if(count[targetChar]==0){
                break;
            }

            prefix.append(target.charAt(i));
            count[targetChar]--;
        }

        if(bestIndex==-1){
            return "";
        }

        // Keep only prefix before the greater character
        StringBuilder ans = new StringBuilder(
            prefix.substring(0, bestIndex)
        );

        ans.append(bestChar);

        // Add remaining characters in sorted order
        for(int i=0;i<26;i++){
            while(bestCount[i]>0){
                ans.append((char)('a'+i));
                bestCount[i]--;
            }
        }

        return ans.toString();
    }
}