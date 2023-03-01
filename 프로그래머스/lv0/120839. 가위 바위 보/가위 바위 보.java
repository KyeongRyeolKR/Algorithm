class Solution {
    public String solution(String rsp) {
        String[] rspArr = rsp.split("");
        
        StringBuilder builder = new StringBuilder();
        for(String s : rspArr) {
            if(s.equals("2")) builder.append("0");
            if(s.equals("0")) builder.append("5");
            if(s.equals("5")) builder.append("2");
        }
        return builder.toString();
    }
}