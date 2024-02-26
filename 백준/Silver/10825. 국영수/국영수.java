import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Student[] students = new Student[n];
        for(int i=0; i<n; i++) {
            students[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(students);

        for(int i=0; i<students.length; i++) {
            System.out.println(students[i].name);
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int kor;
    int eng;
    int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student o) {
        if(kor == o.kor && eng == o.eng && math == o.math) {
            return name.compareTo(o.name);
        }
        if(kor == o.kor && eng == o.eng) {
            return o.math - math;
        }
        if(kor == o.kor) {
            return eng - o.eng;
        }
        return o.kor - kor;
    }
}