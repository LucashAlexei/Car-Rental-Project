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
@Table(name = "gearbox")
public class GearBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gear_id;

    @Column(name = "GEAR_BOX")
    private String gearBox;

    @OneToMany(mappedBy = "gear", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Cars> carsList = new ArrayList<>();

    public GearBox(String gearBox) {
        this.gearBox=gearBox;
    }
    public void addAuto(Cars cars) {
        cars.setGear(this);
        carsList.add(cars);
    }

    @Override
    public String toString() {
        return "GearBox{" +
                "gear_id=" + gear_id +
                ", gearBox='" + gearBox + '\'' +
                '}';
    }
}

