class Solution {
    public String solution(String my_string) {
        String[] removes = {"a", "e", "i", "o", "u"};

        for (String remove : removes) {
            if (my_string.contains(remove)) {
                my_string = my_string.replaceAll(remove, "");
            }
        }
        
        return my_string;
    }
}