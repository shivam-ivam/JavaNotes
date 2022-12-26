package GreedyAlgorithm;

import java.util.ArrayList;

// we are given an infinite supply of denominations [1, 2, 5, 10, 20, 50, 100, 500, 2000].
// find min no. of coins/notes to make change for a value V.
public class IndianCoins {
    public static void main(String[] args) {
        int coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                ans.add(coins[i]);
            }
        }
        System.out.println(ans.size());
        System.out.println(ans);
    }
}
