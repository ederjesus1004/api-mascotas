package dev.eder.mascotas.service;

import java.util.List;

import dev.eder.mascotas.dto.MascotaRequest;
import dev.eder.mascotas.dto.MascotaResponse;

public interface MascotaService {

    List<MascotaResponse> listar();

    MascotaResponse obtenerPorId(Long id);

    MascotaResponse crear(MascotaRequest request);

    MascotaResponse actualizar(Long id, MascotaRequest request);

    void eliminar(Long id);
}
