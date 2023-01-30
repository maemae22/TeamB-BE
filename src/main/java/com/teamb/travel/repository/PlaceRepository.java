package com.teamb.travel.repository;

import com.teamb.travel.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    @Query(value = "select p.contentid from place p",
    nativeQuery = true)
    public List<String> findByAllContentid();
}