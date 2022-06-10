package org.malinowsky.appcodewars.text.align.justify.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class JustifyHistoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createAnother(Collection<JustifyHistory> collection) {
        collection.forEach(entityManager::persist);
    }

    public List<JustifyHistory> getByUuid(String uuid) {
        EntityManagerFactory postgres = Persistence.createEntityManagerFactory("postgres");
        EntityManager entityManager = postgres.createEntityManager();

        Query query = entityManager.createNamedQuery(JustifyHistory.FIND_BY_UUID);
        query.setParameter("id", uuid);
        return (List<JustifyHistory>) query.getResultList();
    }
}
