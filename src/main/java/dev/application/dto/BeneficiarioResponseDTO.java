package dev.application.dto;

import dev.application.model.Beneficiario;
import dev.application.model.Categoria;

public record BeneficiarioResponseDTO(
                Long id,
                String email,
                String senha,
                String imageName,
                Categoria categoria,
                String nome,
                String descricao,
                String pix) {

        public static BeneficiarioResponseDTO valueOf(Beneficiario beneficiario) {
                return new BeneficiarioResponseDTO(
                                beneficiario.getId(),
                                beneficiario.getEmail(),
                                beneficiario.getSenha(),
                                beneficiario.getImageName(),
                                beneficiario.getCategoria(),
                                beneficiario.getDescricao(),
                                beneficiario.getNome(),
                                beneficiario.getPix());
        }
}
