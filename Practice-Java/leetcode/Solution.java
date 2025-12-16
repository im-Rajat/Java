package leetcode;

import java.util.Random;

class Solution {
    public static void main(String[] args) {

        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            int temp = rand.nextInt(100);
            System.out.print(temp + " ");
        }

        System.out.println(2 % 10);
    }
}