class Solution {
    boolean solution(String s) {
        boolean check = true;
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if(count < 0) return false;
        }

        if(count != 0) {
            check = false;
        }

        return check;
    }
}