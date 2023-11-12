package dev.application.service;

import java.util.List;

import dev.application.dto.BeneficiarioDTO;
import dev.application.dto.BeneficiarioResponseDTO;
import dev.application.model.Beneficiario;
import dev.application.model.Categoria;
import dev.application.repository.BeneficiarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;

@ApplicationScoped
public class BeneficiarioServiceImpl implements BeneficiarioService {

    @Inject
    BeneficiarioRepository beneficiarioRepository;

    @Override
    @Transactional
    public BeneficiarioResponseDTO create(BeneficiarioDTO beneficiarioDTO) throws ConstraintViolationException {
        Beneficiario entity = new Beneficiario();

        entity.setEmail(beneficiarioDTO.email());
        entity.setSenha(beneficiarioDTO.senha());
        entity.setImageName(beneficiarioDTO.imageName());
        entity.setCategoria(Categoria.valueOf(beneficiarioDTO.idCategoria()));
        entity.setNome(beneficiarioDTO.nome());
        entity.setDescricao(beneficiarioDTO.descricao());
        entity.setPix(beneficiarioDTO.pix());

        beneficiarioRepository.persist(entity);

        return BeneficiarioResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public BeneficiarioResponseDTO update(Long id, BeneficiarioDTO beneficiarioDTO) throws ConstraintViolationException {
        Beneficiario entity = beneficiarioRepository.findById(id);

        entity.setEmail(beneficiarioDTO.email());
        entity.setSenha(beneficiarioDTO.senha());
        entity.setImageName(beneficiarioDTO.imageName());
        entity.setCategoria(Categoria.valueOf(beneficiarioDTO.idCategoria()));
        entity.setNome(beneficiarioDTO.nome());
        entity.setDescricao(beneficiarioDTO.descricao());
        entity.setPix(beneficiarioDTO.pix());

        return BeneficiarioResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        beneficiarioRepository.deleteById(id);
    }

    @Override
    public List<BeneficiarioResponseDTO> getAll() {
        return beneficiarioRepository.listAll().stream().map(e -> BeneficiarioResponseDTO.valueOf(e)).toList();
    }
}