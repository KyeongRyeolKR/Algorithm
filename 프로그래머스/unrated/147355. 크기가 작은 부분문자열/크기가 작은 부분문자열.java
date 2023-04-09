class Solution {
    public int solution(String t, String p) {
        int count = 0;

        String s = t.substring(0, p.length());
        if(Long.parseLong(s) <= Long.parseLong(p)) count++;

        for(int i=p.length(); i<t.length(); i++) {
            s += t.charAt(i);
            s = s.substring(1);
            if(Long.parseLong(s) <= Long.parseLong(p)) count++;
        }

        return count;
    }
}