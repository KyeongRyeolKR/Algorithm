import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        String str = sc.nextLine();
        int[] arr = main.checkAlphabetIndex(str);
        main.printArray(arr);
    }

    private int[] checkAlphabetIndex(String str){
        int[] result = initializeArray();
        str = str.toUpperCase();
        for(int i=0; i<str.length(); i++) {
            result[(str.charAt(i) - 65)] = str.indexOf(str.charAt(i));
        }

        return result;
    }

    private int[] initializeArray(){
        int[] array = new int[26];
        for(int i=0; i<26; i++){
            array[i] = -1;
        }
        return array;
    }

    private void printArray(int[] result){
        for(int x : result){
            System.out.print(x + " ");
        }
    }
}
