package edu.pnu.admin;
import edu.pnu.admin.*;
import java.util.Objects;

    public class Beverage {
        private String type;
        private String name;

        public String getBeverageName(){
            return name;
        }
        public String getBeverageType(){
            return type;
        }
        public String toString(){
            return "["+this.name+", "+this.type+"]";
        }
        public int hashCode(){
            return Objects.hash();
        }
        public Beverage(String a, String b){
            this.name = a;
            this.type = b;
        }
    }

