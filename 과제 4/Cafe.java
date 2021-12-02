import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class Cafe {
    private String name;
    private HashMap<String,Beverage> menus = new HashMap<>();

    public String toString(){
        String msg = " Cafe Name: "+name+" Beverage Count: "+menus.size()+"\n";
        Iterator<Beverage> values = menus.values().iterator();
        while(values.hasNext()){
            msg += "\t" + values.next()+"\n";
        }
        return msg;
    }
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o instanceof String){
            return true;
        }else return false;
    }
    public int hashCode(){
        return Objects.hash();
    }
    public Cafe(String a){
        this.name = a;
    }
    public Beverage findBeverage(String a, String b){
        if(menus.get(a) != null){
            if(menus.get(a).getBeverageName().equals(a)&&menus.get(a).getBeverageType().equals(b)){
                return menus.get(a);
            }
        }
        return null;
    }
    public HashMap addBeverage(Beverage a){
        menus.put(a.getBeverageName(),a);
        return menus;
    }
    public HashMap removeAllBeverage(){
        menus.clear();
        return menus;
    }
}
