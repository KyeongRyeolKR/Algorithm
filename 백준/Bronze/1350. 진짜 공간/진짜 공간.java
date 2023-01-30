import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int countFiles = sc.nextInt();
        List<Integer> fileSizes = new ArrayList<>();
        for (int i = 0; i < countFiles; i++) {
            fileSizes.add(sc.nextInt());
        }
        int clusterSize = sc.nextInt();

        List<Integer> results = new ArrayList<>();
        for (int x : fileSizes) {
            if (x == 0) {
                continue;
            } else if (x % clusterSize != 0) {
                results.add(clusterSize + (x / clusterSize) * clusterSize);
            } else {
                results.add(x / clusterSize * clusterSize);
            }
        }

        long sum = 0;
        for (int x : results) {
            sum += x;
        }

        System.out.println(sum);
    }
}
