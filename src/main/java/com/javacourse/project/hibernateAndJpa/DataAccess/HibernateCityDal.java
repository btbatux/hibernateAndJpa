package com.javacourse.project.hibernateAndJpa.DataAccess;

import com.javacourse.project.hibernateAndJpa.Entities.City;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class HibernateCityDal implements ICityDal {

    private EntityManager entityManager;


    @Autowired
    private HibernateCityDal(EntityManager entityManager) {
        // Spring tarafından otomatik olarak çağrılacak ve EntityManager türünde bir nesne enjekte edilecek.
        this.entityManager = entityManager;
    }

    public HibernateCityDal() {
    }

    @Override
    @Transactional //Transaction başlatır sorgu için. AOP - Aspect oriented programming.
    public List<City> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<City> cities = session.createQuery("from City").getResultList();
        return cities;
    }


    @Override
    public void add(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }


    @Override
    public void update(City city) {

        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }


    @Override
    public void delete(City city) {
        Session session = entityManager.unwrap(Session.class);
        City cityToDelete = session.get(City.class,city.getId());
        session.delete(cityToDelete);
    }

    @Override
    public City getById(int id) {
        Session session = entityManager.unwrap(Session.class);

        City city = session.get(City.class, id);

        return city;
    }
}
