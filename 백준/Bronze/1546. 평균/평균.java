import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] score = new int[n];
        for(int i=0; i<score.length; i++){
            score[i] = scanner.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<score.length; i++){
            if(score[i] > max){
                max = score[i];
            }
        }

        double[] newScore = new double[n];
        for(int i=0; i<newScore.length; i++){
            newScore[i] = score[i] / (double)max * 100;
        }

        double sum = 0.0;
        double avg = 0.0;
        for(double x : newScore){
            sum += x;
        }
        avg = sum / n;
        System.out.println(avg);

    }
}