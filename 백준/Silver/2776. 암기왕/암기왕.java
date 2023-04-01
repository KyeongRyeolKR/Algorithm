import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i<T; i++) {
            hashSet.clear();
            
            int size1 = sc.nextInt();

            for(int j=0; j<size1; j++) {
                hashSet.add(sc.nextInt());
            }

            int size2 = sc.nextInt();
            for(int j=0; j<size2; j++) {
                int temp = sc.nextInt();
                if(hashSet.contains(temp)) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}