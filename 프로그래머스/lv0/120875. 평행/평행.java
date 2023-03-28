class Solution {
    public int solution(int[][] dots) {
        for (int i = 0; i < dots.length; i++) {
            double slope1 = getSlope(dots[i], dots[(i + 1) % 4]);
            double slope2 = getSlope(dots[(i + 2) % 4], dots[(i + 3) % 4]);

            if(slope1 == slope2) return 1;
        }

        return 0;
    }

    private static double getSlope(int[] a, int[] b) {
        double mo = a[0] - b[0];
        double ja = a[1] - b[1];

        return ja / mo;
    }
}