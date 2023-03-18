package com.cafe.order;
import java.util.ArrayList;
import java.util.List;
import com.cafe.order.*;
import com.cafe.menu.*;

public class Order {
    private Order del1;
    private Order dri1;
    private Order tak1;

    private String a;

    PickUpFactory pickUpFactory = new PickUpFactory();

    private Order.PickUp deli;
    private Order.PickUp drive;
    private Order.PickUp take;

    private final PickUpFactory.Delivery delivery = pickUpFactory.new Delivery(a);
    private final PickUpFactory.DriveThru driveThru = pickUpFactory.new DriveThru(a);
    private final PickUpFactory.TakeOut takeOut = pickUpFactory.new TakeOut();

    public List<OrderItem> items = new ArrayList<>();

    private static int orderCounter =1;
    private int orderNo;

    public void setPickUp(Order.PickUp pickUp){
        if(pickUp instanceof PickUpFactory.TakeOut){
            take = pickUp;
        }
        if(pickUp instanceof PickUpFactory.DriveThru){
            drive = pickUp;
        }
        if(pickUp instanceof PickUpFactory.Delivery){
            deli = pickUp;
        }
    }

    public void addItem(OrderItem orderItem){
        items.add(orderItem);
    }

    public void completed(){
        if(take instanceof PickUpFactory.TakeOut){
            takeOut.handle(tak1);
        }
        if(drive instanceof PickUpFactory.DriveThru){
            driveThru.handle(dri1);
        }
        if(deli instanceof PickUpFactory.Delivery){
            delivery.handle(del1);
        }
    }

    public static interface PickUp{
        public abstract void handle(Order o);
    }
}
