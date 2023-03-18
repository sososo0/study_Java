import java.util.Objects;

public class Professor extends Person{
    private String major;
    private String schoolName;

    public Professor(String name, int age, String address, String schoolName,String major){
        super(name, age, address);
        this.schoolName = schoolName;
        this.major = major;
    }
    public String getSchoolName(){
        return schoolName;
    }
    public String getMajor(){
        return major;
    }
    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }
    public void setMajor(String major){
        this.major = major;
    }
    @Override
    public String toString(){
        return String.format("%s, %d, %s, %s, %s",
                getName(),getAge(),getAddress(),schoolName,major);
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Professor)
            return true;
        else return false;
    }
    @Override
    public int hashCode(){
        return Objects.hash();
    }
}
