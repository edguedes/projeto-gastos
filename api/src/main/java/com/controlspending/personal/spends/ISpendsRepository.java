package com.controlspending.personal.spends;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISpendsRepository extends JpaRepository<Spends, Long> {

    // @Query(value = "SELECT * FROM Spends S "
    // + "WHERE S.pessoa_id=:pessoa_id", nativeQuery=true)
    // Page<Spends> findTokenAll(@Param("id_spends") Long pessoa_id, Pageable
    // pageable);

    @Query("SELECT s FROM Spends s WHERE s.pessoa.id = ?1 ")
    Page<Spends> findByPessoaId(Long id, Pageable pageable);
}
