package dev.application.dto;

import dev.application.model.Doador;

public record DoadorResponseDTO(
        Long id,
        String email,
        String senha) {

    public static DoadorResponseDTO valueOf(Doador doador) {
        return new DoadorResponseDTO(
                doador.getId(),
                doador.getEmail(),
                doador.getSenha());
    }
}