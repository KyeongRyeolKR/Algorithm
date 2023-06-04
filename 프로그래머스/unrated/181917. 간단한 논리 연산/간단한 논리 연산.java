class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean r1 = x1 || x2;
        boolean r2 = x3 || x4;
        return r1 && r2;
    }
}