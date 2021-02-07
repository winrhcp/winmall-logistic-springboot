package com.winmall.repositories;

import com.winmall.entities.H2Branches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface H2BranchRopository extends JpaRepository<H2Branches, Long> {
    @Override
    List<H2Branches> findAll();

    @Override
    <S extends H2Branches> S save(S s);

    @Override
    Optional<H2Branches> findById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Query(value = "select * from branch b where b.bname = ?1", nativeQuery = true)
    Optional<H2Branches> findByName(String bname);
}
