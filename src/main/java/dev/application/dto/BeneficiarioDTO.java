package dev.application.dto;

public record BeneficiarioDTO(
        String email,
        String senha,
        String imageName,
        Integer idCategoria,
        String nome,
        String descricao,
        String pix) {
}