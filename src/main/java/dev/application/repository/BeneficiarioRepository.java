package dev.application.repository;

import dev.application.model.Beneficiario;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BeneficiarioRepository implements PanacheRepository<Beneficiario> {
    
    public PanacheQuery<Beneficiario> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome + "%");
    }
}