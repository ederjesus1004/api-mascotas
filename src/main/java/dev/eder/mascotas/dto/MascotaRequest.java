package dev.eder.mascotas.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record MascotaRequest(
    
    @NotBlank(message = "EL microchip es obligatorio")
    @Pattern(regexp = "^9\\d{14}$", message = "El microchip debe de tener el formato 912345678912345")
    String microchip,

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre tiene que tener maximo 50 caracteres")
    String nombre,

    @NotBlank(message = "La especie es obligatoria")
    @Size(max = 30, message = "La especie no puede tener maximo de 30")
    String especie,

    @NotBlank(message = "La raza es obligatoria")
    @Size(max = 50, message = "La raza tiene que ser maximo de 50 caracteres")
    String raza,

    @NotNull(message = "La edad es obligatorio")
    @Min(value = 0, message = "EL año minimo es de 0")
    @Max(value = 10, message = "El año maximo es de 10")
    Integer edad,
    
    @NotBlank(message = "El nombre del dueño es obligatorio")
    @Size(max = 100, message = "El nombre del dueño es maximo de 100 caracteres")
    String nombreDueno

) {

}
