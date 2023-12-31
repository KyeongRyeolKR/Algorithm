import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Subject> list = new ArrayList<>();
        for(int i=0; i<20; i++) {
            String[] split = sc.nextLine().split(" ");

            String name = split[0];
            double credit = Double.parseDouble(split[1]);
            String grade = split[2];

            if(grade.equals("P")) {
                continue;
            }

            Subject subject = new Subject(name, credit, grade);
            list.add(subject);
        }

        double totalScore = list.stream()
                .mapToDouble(Subject::getScore)
                .sum();

        int totalCredit = list.stream()
                .mapToInt(Subject::getCredit)
                .sum();

        double avg = totalScore / totalCredit;

        System.out.println(Math.round(avg * 1e6) / 1e6);
    }
}

class Subject {
    String name;
    int credit;
    String grade;

    public Subject(String name, double credit, String grade) {
        this.name = name;
        this.credit = (int) credit;
        this.grade = grade;
    }

    public double getScore() {
        return credit * getGradePoint();
    }

    public int getCredit() {
        return credit;
    }

    public double getGradePoint() {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            default:
                return 0.0;
        }
    }
}