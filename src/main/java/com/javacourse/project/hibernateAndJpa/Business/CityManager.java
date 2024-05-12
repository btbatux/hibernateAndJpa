package com.javacourse.project.hibernateAndJpa.Business;

import com.javacourse.project.hibernateAndJpa.DataAccess.ICityDal;
import com.javacourse.project.hibernateAndJpa.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityManager implements ICityService {
    private ICityDal iCityDal;


    @Autowired //Buraya uygun olan nesneyi enjekte et.
    public CityManager(ICityDal iCityDal) {
        this.iCityDal = iCityDal;
    }


    @Override
    @Transactional
    public List<City> getAll() {
        return this.iCityDal.getAll();
    }


    @Override
    @Transactional
    public void add(City city) {
        //İş kuralları
        this.iCityDal.add(city);
    }


    @Override
    @Transactional
    public void update(City city) {
        this.iCityDal.update(city);
    }


    @Override
    @Transactional
    public void delete(City city) {
        this.iCityDal.delete(city);
    }

    @Override
    @Transactional
    public City getById(int id) {

        return iCityDal.getById(id);
    }


}
