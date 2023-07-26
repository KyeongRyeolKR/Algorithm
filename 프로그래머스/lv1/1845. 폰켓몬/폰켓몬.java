package 프로그래머스.lv1.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] nums) {
        int choice = nums.length/2;
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        return Math.min(set.size(), choice);
    }
}