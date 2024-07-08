class Solution {
    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        System.out.println("The winner is: " + findTheWinner(n, k));
        
        n = 6;
        k = 5;
        System.out.println("The winner is: " + findTheWinner(n, k));
    }

    public static int findTheWinner(int n, int k) {
        return findWinnerRecursive(n, k) + 1; // Convert zero-based index to one-based index
    }

    private static int findWinnerRecursive(int n, int k) {
        if (n == 1) {
            return 0; // Base case: only one person is left
        } else {
            return (findWinnerRecursive(n - 1, k) + k) % n; // Recursive step
        }
    }
}