package top.squawk.backend.service.impl.order.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


public class Order {
    private String username ;
    private Integer orderId ;
    private String product ;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date submittime ;
    private String address ;
    private Integer status ;
    private String payway ;

    public Order() {
    }

    public Order(String username, Integer orderId, String product, Date submittime, String address, Integer status, String payway) {
        this.username = username;
        this.orderId = orderId;
        this.product = product;
        this.submittime = submittime;
        this.address = address;
        this.status = status;
        this.payway = payway;
    }

    public String getUsername() {
        return username;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    public Date getSubmittime() {
        return submittime;
    }

    public String getAddress() {
        return address;
    }

    public Integer getStatus() {
        return status;
    }

    public String getPayway() {
        return payway;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    @Override
    public String toString() {
        return "Order{" +
                "username='" + username + '\'' +
                ", orderId=" + orderId +
                ", product='" + product + '\'' +
                ", submittime=" + submittime +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", payway='" + payway + '\'' +
                '}';
    }
}
