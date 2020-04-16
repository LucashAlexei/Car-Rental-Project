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
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empl_id;

    @Column(name = "empl_name")
    private String empl_name;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Orders> ordersList = new ArrayList<>();

    public Employee(String empl_name) {
        this.empl_name=empl_name;
    }

    public void addOrders(Orders orders) {
        orders.setEmployee(this);
        ordersList.add(orders);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empl_id=" + empl_id +
                ", empl_name='" + empl_name + '\'' +
                '}';
    }
}
