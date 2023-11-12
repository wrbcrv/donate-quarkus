package dev.application.service;

import java.util.List;

import dev.application.dto.BeneficiarioDTO;
import dev.application.dto.BeneficiarioResponseDTO;

public interface BeneficiarioService {
    
    BeneficiarioResponseDTO create(BeneficiarioDTO beneficiarioDTO);

    BeneficiarioResponseDTO update(Long id, BeneficiarioDTO beneficiarioDTO);

    void delete(Long id);

    List<BeneficiarioResponseDTO> getAll();
}