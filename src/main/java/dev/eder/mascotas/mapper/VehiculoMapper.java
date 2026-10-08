package dev.eder.mascotas.mapper;

import dev.eder.mascotas.dto.MascotaRequest;
import dev.eder.mascotas.dto.MascotaResponse;
import dev.eder.mascotas.entity.Mascota;

public final class VehiculoMapper {

    public VehiculoMapper(){
    }

    // Request → entidad NUEVA
    public static Mascota toEntity(MascotaRequest request){
        Mascota mascota = new Mascota();
        actualizarEntity(request,mascota);
        return mascota;
    }

    // Copia el request sobre una entidad que YA EXISTE

    public static void actualizarEntity(MascotaRequest request, Mascota mascota){
        mascota.setMicrochip(request.microchip().trim());
        mascota.setNombre(request.nombre().trim());
        mascota.setEspecie(request.especie().trim());
        mascota.setRaza(request.raza().trim());
        mascota.setEdad(request.edad());
        mascota.setNombreDueno(request.nombreDueno().trim());
    }

    // Entidad → response con BUILDER
    public static MascotaResponse toResponse (Mascota mascota){
        return MascotaResponse.builder()
        .id(mascota.getId())
        .microchip(mascota.getMicrochip())
        .edad(mascota.getEdad())
        .nombreDueno(mascota.getNombreDueno())
        .descripcion(mascota.getNombre() + "(" + mascota.getEspecie() + mascota.getRaza() + ")")
        .fechaRegistro(mascota.getFechaRegistro())
        .build();
    }
}
