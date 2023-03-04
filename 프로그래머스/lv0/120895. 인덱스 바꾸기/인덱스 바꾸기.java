class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] arr = my_string.toCharArray();

        char[] subArr = my_string.toCharArray();
        subArr[num1] = arr[num2];
        subArr[num2] = arr[num1];
        
        return String.valueOf(subArr);
    }
}