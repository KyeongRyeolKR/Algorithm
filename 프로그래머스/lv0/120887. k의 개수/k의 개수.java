class Solution {
    public int solution(int i, int j, int k) {
        StringBuilder sb = new StringBuilder();
        for(int a=i; a<=j; a++){
            sb.append(a);
        }

        int cnt = 0;
        for(String x : sb.toString().split("")) {
            if(x.equals(String.valueOf(k))) cnt++;
        }

        return cnt;
    }
}