package com.firts.course.entity.dto;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

    @NotBlank(message = "El nombre no debe estar vacio")
    @Size(min = 3, message = "El nombre debe de tener más de dos caracteres")
    private String name;

    @NotNull(message = "La cantidad no debe ser nula")
    @Min(value = 0, message = "La cantidad no debe ser menor a 0")
    private int quantity;

    @NotNull(message = "El precio no debe ser nulo")
    @Min(value = 0, message = "El precio no debe ser menor a 0")
    private double price;

    @NotNull(message = "La disponibilidad no debe ser nula")
    private boolean available;
}