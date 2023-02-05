import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // 비교할 사람이 몇명인지 입력
        int personNum = sc.nextInt();

        // 인원수만큼 키, 몸무게를 입력받아 리스트로 반환
        List<Person> personList = getPersonList(personNum);

        // 키, 몸무게로 순위를 매겨줌
        ranking(personList);

        for(Person p : personList){
            System.out.println(p.getRank());
        }
    }

    private static List<Person> getPersonList(int personNum) {
        List<Person> personList = new ArrayList<>();
        for(int i=0; i<personNum; i++){
            personList.add(new Person(sc.nextInt(), sc.nextInt()));
        }
        return personList;
    }

    private static void ranking(List<Person> p) {
        for(int i=0; i<p.size(); i++){
            int count = 0;
            for(int j=0; j<p.size(); j++){
                if(i == j) continue;
                if(p.get(i).getWeight() < p.get(j).getWeight() && p.get(i).getHeight() < p.get(j).getHeight()){
                    count++;
                }
            }
            p.get(i).setRank(count+1);
        }
    }
}

/**
 * 사람의 키, 몸무게 정보를 담는 엔티티
 */
class Person {
    private int weight;
    private int height;
    private int rank;

    public Person(int weight, int height){
        this.weight = weight;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}