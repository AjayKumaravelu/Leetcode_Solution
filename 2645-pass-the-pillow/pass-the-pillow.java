class Solution {
    public int passThePillow(int n, int time) {
        int direction = 1;
        // Current position of the pillow
        int position = 1;

        for (int i = 0; i < time; i++) {
            position += direction;
            if (position == n || position == 1) {
                direction *= -1; // Change direction at the ends
            }
        }

        return position;
    }
}