class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int continued = 0;
        int attackIndex = 0;
        int max = health;
        for(int i=1; i<=attacks[attacks.length-1][0]; i++) {
            if(attacks[attackIndex][0] == i) {
                continued = 0;
                health -= attacks[attackIndex][1];
                if(health < 1) {
                    return -1;
                }
                attackIndex++;
                continue;
            }

            if(health + bandage[1] > max) {
                health = max;
            } else {
                health += bandage[1];
            }
            continued++;
            if(continued == bandage[0]) {
                if(health + bandage[1] > max) {
                    health = max;
                } else {
                    health += bandage[2];
                }
                continued = 0;
            }
        }

        return health;
    }
}