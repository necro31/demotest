package com.albert.demotest.repository;

import com.albert.demotest.entity.MsEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MsEmployeeRepository extends JpaRepository<MsEmployee, Long> {
    Optional<MsEmployee> findByDeletedAtIsNullAndId(Long id);

    List<MsEmployee> findAllByDeletedAtIsNull();
}
