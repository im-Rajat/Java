package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> nums_map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            int temp = target - nums[i];
            if(nums_map.containsKey(temp))
            {
                return new int[] {nums_map.get(temp), i};
            }
            nums_map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No match found!");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        System.out.println(a);

    }
}
