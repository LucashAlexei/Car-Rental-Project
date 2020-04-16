package com.logic.DTO;

import com.logic.models.Body;
import com.logic.models.Fuel;
import com.logic.models.GearBox;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//DTO - Data to Object
public class AdminDTO {
    private String carModel;
    private String equipment;
    private int pricePerDay;
    private int year;
    private Body body;
    private GearBox gearBox;
    private Fuel fuel;
}
