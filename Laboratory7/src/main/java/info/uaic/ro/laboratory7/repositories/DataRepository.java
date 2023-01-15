package info.uaic.ro.laboratory7.repositories;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class DataRepository<T> implements Serializable {
    protected Class<T> entityClass;

    @PersistenceContext(name = "DPU")
    private EntityManager entityManager;

    protected DataRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void persist(T entity) {
        entityManager.persist(entity);
    }

    @PostConstruct
    public void init() {}

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void remove(T entity) {
        if(!entityManager.contains(entity)) {
            entityManager.merge(entity);
        }
        entityManager.remove(entity);
    }

    public T findById(int id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {
       return getResultList(entityClass.getSimpleName() + ".findAll");
    }

    public List<T> getResultList(String namedQuery) {
        return entityManager.createNamedQuery(namedQuery, entityClass).getResultList();
    }
}
