package com.logic.DTO;

import com.logic.models.Cars;
import com.logic.models.Customer;
import com.logic.models.Employee;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {
    @NotNull
    @Pattern(regexp = "^[a-zA-Z_ ]*$",message = "Name should contain only letters and space!")
    private String customerName;
    @NotNull
    @Pattern(regexp = "[0-9]{9}",message = "Number format [0-9]")
    private String phoneNumber;
    @NotNull
    @Min(value = 1000)
    private int cardNumber;
    @NotNull
    @Min(value = 1)
    private String rendTime;
    @NotNull
    @Future(message = "Not past!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Employee employee;
    private Customer customer;

    private boolean send = false;
}
