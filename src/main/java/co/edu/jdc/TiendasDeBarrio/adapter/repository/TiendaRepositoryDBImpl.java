/*package co.edu.jdc.TiendasDeBarrio.adapter.repository;


import co.edu.jdc.TiendasDeBarrio.domain.entities.Tienda;
import co.edu.jdc.TiendasDeBarrio.adapter.repository.TiendaRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

public class TiendaRepositoryDBImpl implements TiendaRepository {

    private EntityManager entityManager;
    public TiendaRepositoryDBImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public void save(Tienda tienda) {
        this. entityManager.persist(tienda);

    }
    @Transactional
    @Override
    public void update(Tienda tienda) {
        this.entityManager.merge(tienda);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        this.entityManager.remove(this.findById(id));
    }

    @Override
    public Tienda findById(Long id) {
        return this.entityManager.find(Tienda.class, id);
    }

    @Override
    public List<Tienda> findAll() {
        return this.entityManager.createQuery("SELECT u FROM Tienda u", Tienda.class).getResultList();
    }

    @Override
    public boolean existsTienda(String name) {
        return this.entityManager.createQuery("SELECT COUNT (u) FROM Tienda u WHERE u.name =: name", Long.class)
                .setParameter("name", name)
                .getSingleResult() > 0;
    }

    @Override
    public boolean existTienda(Long id) {
        return this.entityManager.createQuery("SELECT COUNT (u) FROM Tienda u WHERE u.id = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult() > 0;
    }

}
*/
