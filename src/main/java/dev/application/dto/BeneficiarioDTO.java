package dev.application.dto;

import java.util.List;

public record BeneficiarioDTO(
        String email,
        String senha,
        List<String> images,
        Integer idCategoria,
        String nome,
        String descricao,
        String pix) {
}