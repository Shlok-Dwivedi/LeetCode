class Solution {
    public boolean isRobotBounded(String instructions) {
        int deg=0;
        int [] pos={0,0};
        for(int i=0;i<instructions.length();i++){
            if(instructions.charAt(i)=='G'){
                if (deg==0){
                    pos[0]=pos[0]+1;
                }
                else if (deg==90){
                    pos[1]=pos[1]-1;
                }
                else if (deg==180){
                    pos[0]=pos[0]-1;
                }
                else{
                    pos[1]=pos[1]+1;
                }
            }
            else if(instructions.charAt(i)=='L'){
                deg=(deg+90)%360;
            }
            else if(instructions.charAt(i)=='R'){
                deg=(deg+270)%360;
            }
        }
        if(pos[0]==0 && pos[1]==0 || deg!=0){
            return true;
        }
        return false;
    }
}