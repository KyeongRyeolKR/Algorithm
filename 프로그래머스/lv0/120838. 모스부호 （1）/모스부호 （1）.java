import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String letter) {
        String morse = "'.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f','--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l','--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r','...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x','-.--':'y','--..':'z'";
        String[] arr = morse.split(",");

        Map<String, String> map = new HashMap<>();

        for(String x : arr) {
            String[] subArr = x.replaceAll("'", "").split(":");
            map.put(subArr[0], subArr[1]);
        }

        String[] letters = letter.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String x : letters) {
            sb.append(map.get(x));
        }

        return sb.toString();
    }
}