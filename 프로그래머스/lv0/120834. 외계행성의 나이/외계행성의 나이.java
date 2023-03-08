class Solution {
    public String solution(int age) {
        String age_ = String.valueOf(age);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<age_.length(); i++) {
            if(age_.charAt(i) == '0') {
                sb.append("a");
            } else if(age_.charAt(i) == '1') {
                sb.append("b");
            } else if(age_.charAt(i) == '2') {
                sb.append("c");
            } else if(age_.charAt(i) == '3') {
                sb.append("d");
            } else if(age_.charAt(i) == '4') {
                sb.append("e");
            } else if(age_.charAt(i) == '5') {
                sb.append("f");
            } else if(age_.charAt(i) == '6') {
                sb.append("g");
            } else if(age_.charAt(i) == '7') {
                sb.append("h");
            } else if(age_.charAt(i) == '8') {
                sb.append("i");
            } else if(age_.charAt(i) == '9') {
                sb.append("j");
            }
        }
        return sb.toString();
    }
}