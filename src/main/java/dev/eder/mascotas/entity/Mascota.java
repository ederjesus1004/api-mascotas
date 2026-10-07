package dev.eder.mascotas.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mascotas")
@Data
@NoArgsConstructor
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 15)
    private String microchip;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String especie;

    @Column(nullable = false, length = 50)
    private String raza;

    @Column(nullable = false)
    private Integer edad;

    @Column(nullable = false, length = 100)
    private String nombreDueno;

    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    void alCrear(){
        this.fechaRegistro=LocalDateTime.now();
    }

}
