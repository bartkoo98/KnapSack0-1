package org.example;

public class Knapsack {

    static int max(int a, int b) {
        return Math.max(a, b);
    }

    static void knapSack(int W, int[] wt, int[] val, int n) {
        int i, w;
        int[][] M = new int[n + 1][W + 1];


        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    M[i][w] = 0;
                else if (wt[i - 1] <= w)
                    M[i][w] = max(val[i - 1] + M[i - 1][w - wt[i - 1]], M[i - 1][w]);
                else
                    M[i][w] = M[i - 1][w];
            }
        }
        System.out.println("Maximum Value:\t" + M[n][W]);

        System.out.println("Selected Packs: ");

        while (n != 0) {
            if (M[n][W] != M[n - 1][W]) {
                System.out.println("Pack " + n + " with {weight = " + wt[n - 1] + " and value = " + val[n - 1] + "}");

                W = W - wt[n - 1];
            }
            n--;
        }
    }

    public static void main(String[] args) {
        int[] value = new int[] { 2, 3, 5, 4, 6, 3};
        int[] weight = new int[] { 4, 2, 6, 7, 6, 5};
        int W = 10;
        int n = value.length;
        knapSack(W, weight, value, n);
    }
}

