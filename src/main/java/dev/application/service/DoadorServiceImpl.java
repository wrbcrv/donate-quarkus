package dev.application.service;

import java.util.List;

import dev.application.dto.DoadorDTO;
import dev.application.dto.DoadorResponseDTO;
import dev.application.model.Doador;
import dev.application.repository.DoadorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;

@ApplicationScoped
public class DoadorServiceImpl implements DoadorService {

    @Inject
    DoadorRepository doadorRepository;

    @Override
    @Transactional
    public DoadorResponseDTO create(DoadorDTO doadorDTO) throws ConstraintViolationException {
        Doador entity = new Doador();

        entity.setEmail(doadorDTO.email());
        entity.setSenha(doadorDTO.senha());

        doadorRepository.persist(entity);

        return DoadorResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public DoadorResponseDTO update(Long id, DoadorDTO doadorDTO) throws ConstraintViolationException {
        Doador entity = doadorRepository.findById(id);

        entity.setEmail(doadorDTO.email());
        entity.setSenha(doadorDTO.senha());

        return DoadorResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        doadorRepository.deleteById(id);
    }

    @Override
    public List<DoadorResponseDTO> getAll() {
        return doadorRepository.listAll().stream().map(e -> DoadorResponseDTO.valueOf(e)).toList();
    }
}