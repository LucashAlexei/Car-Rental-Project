package com.logic.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cus_id;

    @Column(name = "cus_name")
    private String cus_name;

    @Column(name = "card_num")
    private int card_num;

    @Column(name = "phone_num")
    private String phone_number;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Orders> orderList = new ArrayList<>();

    public Customer(String cus_name, int card_num, String phone_number) {
        this.cus_name=cus_name;
        this.card_num=card_num;
        this.phone_number=phone_number;
    }

    public void addOrders(Orders orders) {
        orders.setCustomer(this);
        orderList.add(orders);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cus_id=" + cus_id +
                ", cus_name='" + cus_name + '\'' +
                ", card_num=" + card_num +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
