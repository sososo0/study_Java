public class Professor extends Person {
    private String major;
    private String schoolName;

    public Professor(String name,int age, String address, String schoolName1, String major){
        super(name, age, address);
        this.schoolName = schoolName1;
        this.major = major;

    }

    public String getSchoolName(){
        return schoolName;
    }
    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    public String getMajor(){
        return major;
    }

    public void setMajor(String major){
        this.major = major;
    }

    @Override
    public String toString(){
        return String.format("%S, %d, %s, %s, %s",
                getName(),getAge(),getAddress(),schoolName,major);
    }
}
