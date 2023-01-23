import java.util.*;
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        List<Triangle> triangles = main.getTriangles();
        for(Triangle t : triangles){
            System.out.println(main.isRightAngle(t));
        }
    }

    private List<Triangle> getTriangles(){
        List<Triangle> triangles = new ArrayList<>();
        while(true){
            List<Integer> list = new ArrayList<>();
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int c = sc.nextInt();
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            Collections.sort(list);
            if(list.get(0)==list.get(1) && list.get(1)==list.get(2) && list.get(2)==0) break;
            triangles.add(new Triangle(list.get(0),list.get(1),list.get(2)));
        }
        return triangles;
    }

    private String isRightAngle(Triangle triangle){
        if((Math.pow(triangle.getA(),2) + Math.pow(triangle.getB(),2)) == Math.pow(triangle.getC(),2)){
            return "right";
        }
        return "wrong";
    }
}

class Triangle{
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}