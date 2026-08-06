class Solution {
    public boolean judgeCircle(String moves) {
        int vertical_magnitude=0;
        int horizontal_magnitude=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L'){
                horizontal_magnitude--;
            }
            else if(moves.charAt(i)=='R'){
                horizontal_magnitude++;
            }
            else if(moves.charAt(i)=='D'){
                vertical_magnitude--;
            }
            else {
                vertical_magnitude++;
            }
        }
        if(horizontal_magnitude==0 && vertical_magnitude==0){
            return true;
        }
        return false;
    }
}