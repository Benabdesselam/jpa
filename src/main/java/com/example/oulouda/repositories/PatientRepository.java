package com.example.oulouda.repositories;

import com.example.oulouda.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    List<Patient> findByMalade(boolean m);
    Page<Patient> findByMalade(boolean m,Pageable pageable);
    //List<Patient> findByMaladeLessThan(boolean m,int n);
    //List<Patient> findByMaladeIsstrueAndscoreLessthan(int n);
    //List<Patient> findByDateNaissanceBetweenAAndMaladeIsTrueOrNomLike(Date d1, Date d2,String mc);
    //@Query(value = "select p from Patient p where p.dateNaissance BETWEEN  :x and :y or p.nom like :z",nativeQuery = true)
   // List<Patient> chercherPatient(@Param("x") Date d1,@Param("y") Date d2,@Param("z") String nom);
    @Query(value = "select * from PATIENT   where NOM like :x and SCORE < :y",nativeQuery = true )
    List<Patient> chercherPatient(@Param("x") String x, @Param("y")int y);

}
