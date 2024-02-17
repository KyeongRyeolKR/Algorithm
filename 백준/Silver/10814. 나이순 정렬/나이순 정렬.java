import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Member[] members = new Member[n];

        for(int i=0; i<n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            members[i] = new Member(i, age, name);
        }

        Arrays.sort(members);

        for(Member member : members) {
            System.out.println(member);
        }
    }
}

class Member implements Comparable<Member> {
    int id;
    int age;
    String name;

    public Member(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member o) {
        if(this.age == o.age) {
            return this.id - o.id;
        }
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}