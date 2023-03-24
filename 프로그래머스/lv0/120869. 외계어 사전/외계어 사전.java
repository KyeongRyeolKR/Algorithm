import java.util.Arrays;

class Solution {
    public int solution(String[] spell, String[] dic) {
        for(int i=0; i<dic.length; i++) {
            if(dic[i].length() < spell.length) continue;
            for (int j=0; j<spell.length; j++) {
                dic[i] = dic[i].replaceFirst(spell[j], "");
            }
        }

        return (int) Arrays.stream(dic)
                .filter(e -> e.equals(""))
                .count() > 0 ? 1 : 2;
    }
}