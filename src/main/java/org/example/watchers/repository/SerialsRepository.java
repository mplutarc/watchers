package org.example.watchers.repository;

import org.example.watchers.entity.Serials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface SerialsRepository extends JpaRepository<Serials, Integer> {

    List<Serials> findAllByOrderByNameAsc();
}
