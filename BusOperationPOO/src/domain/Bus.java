package domain;

import java.time.LocalTime;

/**
 * @author Fellipe Toledo
 * @created 10/12/2021
 */
public class Bus {

    private String consortium;
    private String company;
    private String orderNumber;
    private LocalTime operationStartTime;
    private LocalTime operationEndTime;

    public Bus() {
    }

    public String getConsortium() {
        return this.consortium;
    }

    public void setConsortium(String consortium) {
        this.consortium = consortium;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalTime getOperationStartTime() {
        return this.operationStartTime;
    }

    public void setOperationStartTime(LocalTime operationStartTime) {
        this.operationStartTime = operationStartTime;
    }

    public LocalTime getOperationEndTime() {
        return this.operationEndTime;
    }

    public void setOperationEndTime(LocalTime operationEndTime) {
        this.operationEndTime = operationEndTime;
    }


}
