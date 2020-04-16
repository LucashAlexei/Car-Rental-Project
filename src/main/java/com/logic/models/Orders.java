package com.logic.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Orders {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int order_id;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "car_id",referencedColumnName="car_id")
        private Cars cars;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "cus_id", referencedColumnName="cus_id")
        private Customer customer;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "empl_id", referencedColumnName="empl_id")
        private Employee employee;

        @Column(name = "arend_time")
        private String arend_time;

        public Orders(String arend_time){
                this.arend_time=arend_time;
        }

        @Override
        public String toString() {
                return "Orders{" +
                        "order_id=" + order_id +
                        ", cars=" + cars.getCar_model() +
                        ", customer=" + customer.getCus_name() +
                        ", employee=" + employee.getEmpl_name() +
                        ", arend_time='" + arend_time + '\'' +
                        '}';
        }
}
