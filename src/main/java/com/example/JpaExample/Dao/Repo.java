package com.example.JpaExample.Dao;

import com.example.JpaExample.Model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Repo extends JpaRepository<Alien, Integer> {

   /* List<Alien> findByAname(String aname);

    @Query("from Alien where aname=?1 order by aid")
    List<Alien> findbyAnameSorted(String anmae);*/
}
