package dev.eder.mascotas.dto;

import java.time.LocalDateTime;

import lombok.Builder;

// "descripcion" no existe en la tabla: la arma el mapper.
@Builder
public record MascotaResponse(
    Long id,
    String microchip,
    Integer edad,
    String nombreDueno,
    String descripcion,
    LocalDateTime fechaRegistro

) {

}
