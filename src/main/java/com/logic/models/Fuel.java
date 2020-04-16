package com.logic.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "fuel")
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fuel_id;

    @Column(name = "FUEL")
    private String fuel;

    @OneToMany(mappedBy = "fuel", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Cars> carsList = new ArrayList<>();

    public Fuel(String fuel) {
        this.fuel=fuel;
    }

    public void addAuto(Cars cars) {
        cars.setFuel(this);
        carsList.add(cars);
    }

    @Override
    public String toString() {
        return "Fuel{" +
                "fuel_id=" + fuel_id +
                ", fuel='" + fuel + '\'' +
                '}';
    }
}
