package dev.application.repository;

import dev.application.model.Doador;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DoadorRepository implements PanacheRepository<Doador> {
    
    public PanacheQuery<Doador> findByEmail(String email) {
        return find("UPPER(email) LIKE UPPER(?1) ", "%" + email + "%");
    }
}