import java.util.Scanner;

class Triangle{
    private final int base;
    private final int height;

    public Triangle(int base, int height){
        this.base =base;
        this.height = height;
    }
    public Double getArea(int base,int height){
        Double area = Double.valueOf(base)*height/2;
        return area;
    }
    public String toString(){
        return String.format("Triangle [base=%d, height=%d, area=%.2f]"
                ,base,height,getArea(base,height));
    }
}
public class TriangleTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        Triangle[] triangles = new Triangle[N];

        for(int i=0;i< triangles.length;i++){
            int base = scanner.nextInt();
            int height = scanner.nextInt();
            triangles[i] = new Triangle(base,height);
            System.out.println(triangles[i]);
        }
    }
}
