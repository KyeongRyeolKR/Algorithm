class Solution {
    public String solution(int a, int b) {
        int[] dayOfMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int sum = -1;
        for(int month=1; month<a; month++) {
            sum += dayOfMonth[month];
        }

        sum += b;

        return dayOfWeek[sum % 7];
    }
}