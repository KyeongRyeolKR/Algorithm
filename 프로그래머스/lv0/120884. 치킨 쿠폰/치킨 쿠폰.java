class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int service = 0;

        while(true) {
            service = chicken / 10;
            chicken = chicken % 10 + service;
            answer += service;
            if(chicken < 10) {
                break;
            }
        }
        return answer;
    }
}