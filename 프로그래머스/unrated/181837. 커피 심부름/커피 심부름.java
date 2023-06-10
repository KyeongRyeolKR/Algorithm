class Solution {
    public int solution(String[] order) {
        int total = 0;
        for (String o : order) {
            if(o.contains("latte")) total += 5000;
            else total += 4500;
        }
        return total;
    }
}