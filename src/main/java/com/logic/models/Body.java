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
@Table(name = "body")
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int body_id;

    @Column(name = "BODY")
    private String body;

    @OneToMany(mappedBy = "body", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Cars> carsList = new ArrayList<>();
    public List<Cars> getCars(){
        return carsList;
    }

    public void addAuto(Cars cars) {
        cars.setBody(this);
        carsList.add(cars);
    }

    public void setCars(List<Cars> carList){
        this.carsList = carList;
    }

    public Body(String body) {
        this.body=body;
    }

    @Override
    public String toString() {
        return "Body{" +
                "body_id=" + body_id +
                ", body='" + body + '\'' +
                '}';
    }
}
