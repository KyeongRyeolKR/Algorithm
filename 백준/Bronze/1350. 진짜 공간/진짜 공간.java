import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int countFiles = sc.nextInt();
        List<Integer> fileSizes = new ArrayList<>();
        for (int i = 0; i < countFiles; i++) {
            fileSizes.add(sc.nextInt());
        }
        long clusterSize = sc.nextInt();

        List<Long> results = new ArrayList<>();
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
        for (long x : results) {
            sum += x;
        }

        System.out.println(sum);
    }
}
