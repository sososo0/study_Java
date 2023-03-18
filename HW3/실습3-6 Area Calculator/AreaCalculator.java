import java.util.Scanner;

enum Shape{
    TRIANGLE,RECTANGLE,CIRCLE,QUIT,INVALID
}
public class AreaCalculator {
    public static void main(String[] args){
        final Scanner scanner = new Scanner(System.in);

        while(true){

            String total = scanner.nextLine();
            String[] tots = total.split("\\s");

            if(tots.length==1){
                String s1 = total;
                String S1 = s1.toUpperCase();
                final Shape shape = getShape(S1);

                if(shape==Shape.QUIT){
                    System.out.println("BYE");
                    break;
                }else if(shape==Shape.INVALID){
                    System.out.println("INVALID");
                }
            }else if(tots.length==2){
                String s2_1 = tots[0];
                String s2_2 = tots[1];
                String S2 = s2_1.toUpperCase();
                double radius = Double.parseDouble(s2_2);
                final Shape shape = getShape(S2);
                getArea(shape,radius,radius);
            }else{
                String s3_1 = tots[0];
                String s3_2 = tots[1];
                String s3_3 = tots[2];
                String S3 = s3_1.toUpperCase();
                double a = Double.parseDouble(s3_2);
                double b = Double.parseDouble(s3_3);
                final Shape shape = getShape(S3);

                switch (shape){
                    case TRIANGLE:{
                        getArea(shape,a,b);
                        break;
                    }
                    case RECTANGLE:{
                        getArea(shape,a,b);
                        break;
                    }
                    default:
                        break;
            }
            }
        }
        scanner.close();
    }
    private static Shape getShape(String ans){
        if(ans.equals(Shape.TRIANGLE.name())){
            return Shape.TRIANGLE;
        }else if(ans.equals(Shape.RECTANGLE.name())){
            return Shape.RECTANGLE;
        }else if(ans.equals(Shape.CIRCLE.name())){
            return Shape.CIRCLE;
        }else if(ans.equals(Shape.QUIT.name())){
            return Shape.QUIT;
        }else return Shape.INVALID;
    }
    private static void getArea(Shape shape,double a,double b){
        switch (shape){
            case TRIANGLE:{
                double area = a*b/2;
                System.out.printf("Area of Triangle: %.2f%n",area);
                break;
            }
            case RECTANGLE:{
                double area = a*b;
                System.out.printf("Area of Rectangle: %.2f%n",area);
                break;
            }
            case CIRCLE:{
                double area = a*b*Math.PI;
                System.out.printf("Area of Circle: %.2f%n",area);
                break;
            }
        }
    }
}