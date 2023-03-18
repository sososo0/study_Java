package com.cafe.order;
import com.cafe.order.*;
import com.cafe.menu.*;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderRepository implements Iterator<Order>{

    List<Order> orders = new ArrayList<>();

    int nextIndex = 0;
    int num0=0;
    int num =0;

    public void add(Order order){
        orders.add(order);
        num++;
    }

    public boolean hasNext(){
        return nextIndex < orders.size();
    }

    public Order next(){
        return orders.get(nextIndex++);
    }

    public String toString(){
        printMethod();
        return "";
    }

    public void printMethod(){
        System.out.println("\n---주문 관리자 화면---");
        System.out.println("현재 주문수는 총 "+num+" 입니다.");
        System.out.println(" ");
        System.out.println("< 주문 내역 >");
        for(int i=num0;i<orders.size();i++){
            System.out.println("주문번호: "+(i+1)+" - "+orders.get(i).items);
        }
        num--;
        num0++;
    }
}