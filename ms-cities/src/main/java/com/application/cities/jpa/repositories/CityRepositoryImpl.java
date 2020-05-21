package com.application.cities.jpa.repositories;

import com.application.cities.jpa.entities.CityEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CityRepositoryImpl implements CityRepositoryCustom {

  private static final int LIMIT = 1;

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public CityEntity findLatestCityCreated() {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<CityEntity> query = builder.createQuery(CityEntity.class);

    Root<CityEntity> root = query.from(CityEntity.class);
    query.select(root).orderBy(builder.desc(root.get("creationTime")));

    TypedQuery<CityEntity> policyEntity = entityManager.createQuery(query).setMaxResults(LIMIT);

    return policyEntity.getSingleResult();
  }

  /**
   * To count using a where criteria use query.where()
   */
  @Override
  public boolean isEmpty() {
    CriteriaBuilder qb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Long> query = qb.createQuery(Long.class);
    query.select(qb.count(query.from(CityEntity.class)));
    return entityManager.createQuery(query).getSingleResult() == 0;
  }
}
