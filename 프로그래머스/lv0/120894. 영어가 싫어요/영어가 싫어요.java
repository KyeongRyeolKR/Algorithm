class Solution {
    public long solution(String numbers) {
        String[] numberName = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<numberName.length; i++) {
            if (numbers.contains(numberName[i])) {
                numbers = numbers.replaceAll(numberName[i], String.valueOf(i));
            }
        }

        return Long.parseLong(numbers);
    }
}