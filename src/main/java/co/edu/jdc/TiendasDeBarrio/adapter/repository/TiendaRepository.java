package co.edu.jdc.TiendasDeBarrio.adapter.repository;

import co.edu.jdc.TiendasDeBarrio.domain.entities.Tienda;
import co.edu.jdc.TiendasDeBarrio.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Long> {

    @Query(value = "SELECT t FROM Tienda t")
    List<Tienda> findAll();
    @Query(value = "SELECT COUNT (t) FROM Tienda t WHERE t.name = :name")
    Long existsTienda(String name);

    @Query(value = "SELECT COUNT (t) FROM Tienda t WHERE t.id = :id")
    Long existTienda(Long id);
}
