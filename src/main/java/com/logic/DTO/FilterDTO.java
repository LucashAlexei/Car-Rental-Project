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
public class FilterDTO {
    private String sortingOrder;
    private String sortingBody;
    private String sortingGear;
    private String sortingFuel;
    private String sortingEquipment;

    private String body;
    private String gearBox;
    private String fuel;
}
