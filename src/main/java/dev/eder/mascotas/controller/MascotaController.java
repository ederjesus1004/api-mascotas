package dev.eder.mascotas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.eder.mascotas.dto.MascotaRequest;
import dev.eder.mascotas.dto.MascotaResponse;
import dev.eder.mascotas.service.MascotaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor
public class MascotaController {

     // Pide la INTERFACE. Spring le entrega VehiculoServiceImpl.
    private final MascotaService mascotaService;

    @GetMapping
    public List<MascotaResponse> listar(){
        return mascotaService.listar();
    }

    @GetMapping("/{id}")
    public MascotaResponse obtenerPorId(@PathVariable  Long id){
        return mascotaService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MascotaResponse crear(@Valid @RequestBody MascotaRequest request){
        return mascotaService.crear(request);
    }

    @PutMapping("/{id}")
    public MascotaResponse actualizar(@PathVariable Long id, @Valid @RequestBody MascotaRequest request ){
        return mascotaService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        mascotaService.eliminar(id);
    }
}
