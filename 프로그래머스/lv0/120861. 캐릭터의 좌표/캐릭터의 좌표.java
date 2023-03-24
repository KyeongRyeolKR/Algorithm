class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] result = new int[2];
        int maxSizeX = board[0]/2;
        int maxSizeY = board[1]/2;

        for(int i=0; i<keyinput.length; i++) {
            if(keyinput[i].equals("left")) {
                result[0]--;
                if(result[0] < -maxSizeX){
                    result[0] = -maxSizeX;
                }
            }
            if(keyinput[i].equals("right")) {
                result[0]++;
                if(result[0] > maxSizeX){
                    result[0] = maxSizeX;
                }
            }
            if(keyinput[i].equals("up")) {
                result[1]++;
                if(result[1] > maxSizeY){
                    result[1] = maxSizeY;
                }
            }
            if(keyinput[i].equals("down")) {
                result[1]--;
                if(result[1] < -maxSizeY){
                    result[1] = -maxSizeY;
                }
            }
        }

        return result;
    }
}