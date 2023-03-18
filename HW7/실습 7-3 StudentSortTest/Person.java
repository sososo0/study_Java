public class Person implements MyMovable{
    private String movable;

    public Person(String movable){
        this.movable = movable;
    }

    @Override
    public String moveBy(){
        return "나는 "+movable+"로 출근한다.";
    }
}
