import java.util.Objects;

public class Employee {

    private final String name;
    private final Double salary;

    public Employee(String name, Double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public Double getSalary(){
        return salary;
    }

    @Override
    public String toString(){
        return getName()+" "+getSalary();
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Employee)){
            return false;
        }
        Employee _o = (Employee) o;
        return salary.equals(_o.getSalary()) && name.equals(_o.getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,salary);
    }
}






