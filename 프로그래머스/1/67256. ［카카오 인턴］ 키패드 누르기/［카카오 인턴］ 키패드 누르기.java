class Solution {

    Point left;
    Point right;
    Point numPoint;

    public String solution(int[] numbers, String hand) {
        String answer = "";

        left = new Point(3, 0);
        right = new Point(3, 2);

        for(int number : numbers) {
            numPoint = new Point((number-1)/3, (number-1)%3);

            if(number == 0) {
                numPoint = new Point(3, 1);
            }

            String finger = numPoint.getFinger(hand);

            answer += finger;

            if(finger.equals("L")) {
                left = numPoint;
            } else {
                right = numPoint;
            }
        }

        return answer;
    }

    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String getFinger(String hand) {
            String finger = hand.equals("right") ? "R" : "L";

            if(this.col == 0) {
                finger = "L";
            } else if(this.col == 2) {
                finger = "R";
            } else {
                int leftDist = left.getDistance(this);
                int rightDist = right.getDistance(this);

                if(leftDist < rightDist) {
                    finger = "L";
                } else if(rightDist < leftDist) {
                    finger = "R";
                }
            }
            return finger;
        }

        public int getDistance(Point p) {
            return Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
        }
    }
}

