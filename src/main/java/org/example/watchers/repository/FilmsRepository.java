package org.example.watchers.repository;

import org.example.watchers.entity.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmsRepository extends JpaRepository<Films, Integer> {

    List<Films> findAllByOrderByNameAsc();
}

