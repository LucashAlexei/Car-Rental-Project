package com.logic.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;

    @Column(name = "car_model")
    private String car_model;
    @Column(name = "equipment")
    private String equipment;
    @Column(name = "price_per_day")
    private int pricePerDay;
    @Column(name = "YEAR")
    private int year;

    @OneToMany(mappedBy = "cars", cascade = CascadeType.ALL)
    private List<Orders> ordersList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GEAR_ID",referencedColumnName = "GEAR_ID")
    private GearBox gear;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BODY_ID",referencedColumnName = "BODY_ID")
    private Body body;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FUEL_ID",referencedColumnName = "FUEL_ID")
    private Fuel fuel;

    public void addOrder(Orders orders) {
        orders.setCars(this);
        ordersList.add(orders);
    }
}
