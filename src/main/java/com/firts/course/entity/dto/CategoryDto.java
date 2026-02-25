package com.firts.course.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {

    @NotBlank(message = "El nombre de la categoria no debe estar vacio")
    @Size(min = 3, message = "El nombre de la categoria debe tener minimo 3 caracteres")
    private String name;

    @NotBlank(message = "La descripción de la categoria no debe estar vacio")
    @Size(min = 10, message = "La descripción de la categoria debe tener minimo 10 caracteres")
    private String description;
}