package com.cafe.order;
import com.cafe.order.*;
import com.cafe.menu.*;

import java.sql.Driver;

public class PickUpFactory {

    class Delivery implements Order.PickUp{
        private final String address;

        public Delivery(String a){
            this.address = a;
        }

        @Override
        public void handle(Order order){
            System.out.println("---배달 관리 화면---");
            System.out.println("배달통으로 주문을 전달합니다!");
            System.out.println("배송주소: "+"Pusan National University");
        }
    }

    class DriveThru implements Order.PickUp{
        private final String vehicleNumber;

        public DriveThru(String a){
            this.vehicleNumber = a;
        }

        @Override
        public void handle(Order order){
            System.out.println("---드라이브 쓰루 화면---");
            System.out.println("차량번호: "+"001가0000");
            System.out.println("주문하신 음료가 준비 되었습니다!");
        }
    }

    class TakeOut implements Order.PickUp{
        private final int num;
        public TakeOut(){
            this.num = 3;
        }

        @Override
        public void handle(Order order){
            System.out.println("---테이크 아웃 화면---");
            System.out.println("주문번호: "+num);
            System.out.println("주문하신 음료가 준비 되었습니다!");
        }
    }

    public Order.PickUp makeTakeOut(){
        return new TakeOut();
    }

    public Order.PickUp makeDriveThru(String vehicleNumber){
        return new DriveThru(vehicleNumber);
    }

    public Order.PickUp makeDelivery(String address){
        return new Delivery(address);
    }
}
