package edu.pnu.admin;
import edu.pnu.admin.*;
import edu.pnu.collection.GenericList;
import java.util.Objects;

public class Cafe {
    private String name;
    private GenericList<Beverage> students = new GenericList<Beverage>();

    public String toString(){
        String msg = "Cafe Name: "+name+" Beverage Count: "+students.size()+"\n";
        for(int i=0;i<students.size();i++){
            msg += "\t" + students.get(i) +"\n";
        }
        return msg;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof String) return true;
        else return false;
    }

    public int hashCode() {
        return Objects.hash();
    }

    public Cafe (String a){
        this.name = a;
    }

    public Beverage findBeverage(String a, String b){

        for(int i=0;i<students.size();i++){
            if(students.get(i).getBeverageName().equals(a) && students.get(i).getBeverageType().equals(b))
                return students.get(i);
        }
        return null;
    }

    public GenericList addBeverage(Beverage a){
        students.add(a);
        return students;
    }

    public GenericList removeAllBeverage(){
        students.clear();
        return students;
    }
}
