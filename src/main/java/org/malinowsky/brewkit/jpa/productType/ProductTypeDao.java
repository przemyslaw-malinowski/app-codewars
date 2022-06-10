package org.malinowsky.brewkit.jpa.productType;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;

@ApplicationScoped
public class ProductTypeDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addAll(Collection<ProductType> items) {
        items.forEach(entityManager::persist);
    }
}
