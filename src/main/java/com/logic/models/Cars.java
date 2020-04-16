package com.logic.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int car_id;

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

    public Cars(String car_model, String equipment, int pricePerDay, int year) {
        this.car_model = car_model;
        this.equipment = equipment;
        this.pricePerDay = pricePerDay;
        this.year = year;
    }

    public void addOrder(Orders orders) {
        orders.setCars(this);
        ordersList.add(orders);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "car_id=" + car_id +
                ", car_model='" + car_model + '\'' +
                ", equipment='" + equipment + '\'' +
                ", price_per_month=" + pricePerDay +
                ", year=" + year +
                ", gear=" + gear.getGearBox() +
                ", body=" + body.getBody() +
                ", fuel=" + fuel.getFuel() +
                '}';
    }
}
