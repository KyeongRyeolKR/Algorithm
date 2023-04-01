import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        sc.nextLine();

        Set<String> set = new HashSet<>();
        for(int i=0; i<size; i++) {
            set.add(sc.nextLine());
        }

        set.stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(e -> e))
                .forEach(System.out::println);
    }
}