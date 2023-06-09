class Solution {
    public int solution(String myString, String pat) {
        int count = 0;
        for(int i=0; i<myString.length()-pat.length()+1; i++) {
            String temp = "";
            for(int j=i; j<i+pat.length(); j++) {
                temp += myString.charAt(j);
            }
            if(temp.equals(pat)) {
                count++;
            }
        }

        return count;
    }
}