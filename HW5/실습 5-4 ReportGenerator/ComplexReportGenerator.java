package org.report;
import org.report.*;

import java.util.List;

public class ComplexReportGenerator extends AbstractReportGenerator{
    int a =0;
    @Override
    protected boolean customerReportCondition(Customer customer){
        if(customer.getPoint()>50)
            return true;
        else return false;
    }
    @Override
    protected String getReportHeader(List<Customer>customers){
        return "고객의 수: "+customers.size()+" 명 입니다\n";
    }
    @Override
    protected String getReportForCustomer(Customer customer){
        return customer.getPoint()+": "+customer.getName()+"\n";
    }
    @Override
    protected String getReportFooter(List<Customer>customers){
        for (Customer customer:customers){
            a = a+customer.getPoint();
        }
        return "점수 합계: "+a;
    }
}