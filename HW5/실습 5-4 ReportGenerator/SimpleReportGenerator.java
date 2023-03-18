package org.report;
import org.report.*;

import java.util.List;

public class SimpleReportGenerator extends AbstractReportGenerator{
    @Override
    protected boolean customerReportCondition(Customer customer){
        if(customer.getPoint() > 0)
            return true;
        else return false;
    }
    @Override
    protected String getReportHeader(List<Customer>customers){
        return "\n고객의 수: "+customers.size()+" 명\n";
    }
    @Override
    protected String getReportForCustomer(Customer customer){
        return customer.getName()+": "+customer.getPoint()+"\n";
    }
    @Override
    protected String getReportFooter(List<Customer>customers){
        for(Customer customer:customers){
            getReportForCustomer(customer);
        }
        return "";
    }
}
