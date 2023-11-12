package dev.application.converter;

import dev.application.model.Categoria;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoriaConverter implements AttributeConverter<Categoria, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Categoria categoria) {
        return categoria == null ? null : categoria.getId();
    }

    @Override
    public Categoria convertToEntityAttribute(Integer id) {
        return Categoria.valueOf(id);
    }
}