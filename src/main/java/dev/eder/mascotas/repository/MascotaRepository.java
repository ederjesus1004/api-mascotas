package dev.eder.mascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.eder.mascotas.entity.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long>{

    // Alguna mascota tiene microchip -> al CREAR
    boolean existsByMicrochip(String microchip);

    //¿OTRA mascota tiene este microchip? -> al EDITAR
    boolean existsByMicrochipAndIdNot(String microchip, Long id);
}
