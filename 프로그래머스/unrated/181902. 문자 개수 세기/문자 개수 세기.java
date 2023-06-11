class Solution {
    public int[] solution(String my_string) {
        int[] arr = new int[52];
        for(int i=0; i<my_string.length(); i++) {
            if(Character.isUpperCase(my_string.charAt(i))) {
                arr[my_string.charAt(i) - 'A']++;
            } else {
                arr[my_string.charAt(i) - 'a' + 26]++;
            }
        }

        return arr;
    }
}