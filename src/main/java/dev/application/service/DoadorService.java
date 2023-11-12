package dev.application.service;

import java.util.List;

import dev.application.dto.DoadorDTO;
import dev.application.dto.DoadorResponseDTO;

public interface DoadorService {
    
    DoadorResponseDTO create(DoadorDTO doadorDTO);

    DoadorResponseDTO update(Long id, DoadorDTO doadorDTO);

    void delete(Long id);

    List<DoadorResponseDTO> getAll();
}