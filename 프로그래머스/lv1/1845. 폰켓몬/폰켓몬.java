import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> monsterSet = new HashSet<>();
        for (int num : nums){
            monsterSet.add(num);
        }

        return monsterSet.size() > nums.length/2 ? nums.length/2 : monsterSet.size();
    }
}