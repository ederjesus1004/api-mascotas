package dev.eder.mascotas.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.eder.mascotas.dto.MascotaRequest;
import dev.eder.mascotas.dto.MascotaResponse;
import dev.eder.mascotas.entity.Mascota;
import dev.eder.mascotas.exception.RecursoDuplicadoException;
import dev.eder.mascotas.exception.RecursoNoEncontradoException;
import dev.eder.mascotas.mapper.MascotaMapper;
import dev.eder.mascotas.repository.MascotaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService{

    private final MascotaRepository mascotaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MascotaResponse> listar(){
        return mascotaRepository.findAll()
        .stream()
        .map(MascotaMapper::toResponse)
        .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public MascotaResponse obtenerPorId(Long id){
        return MascotaMapper.toResponse(buscarMascota(id));
    }


    @Override
    @Transactional
    public MascotaResponse crear (MascotaRequest request){
        if (mascotaRepository.existsByMicrochip(request.microchip())) {
            throw new RecursoDuplicadoException("ya existe una mascota con este microchip" + request.microchip());
        }

        Mascota mascota = MascotaMapper.toEntity(request);
        return MascotaMapper.toResponse(mascotaRepository.save(mascota));
    }

    @Override
    @Transactional
    public MascotaResponse actualizar(Long id, MascotaRequest request){
        Mascota mascota = buscarMascota(id);
        if (mascotaRepository.existsByMicrochipAndIdNot(request.microchip(), id)) {
            throw new RecursoDuplicadoException("Ya existe una mascota con este microchip" + request.microchip());
        }
        MascotaMapper.actualizarEntity(request, mascota);
        return MascotaMapper.toResponse(mascotaRepository.save(mascota));
    }

    @Override
    @Transactional
    public void eliminar(Long id){
        Mascota mascota = buscarMascota(id);
        mascotaRepository.delete(mascota);
    }

    private Mascota buscarMascota(Long id){
        return mascotaRepository.findById(id)
        .orElseThrow(()-> new RecursoNoEncontradoException("No existe la mascota con id " + id));
    }
}
