package com.ybin.demo.repository.jpaRepository;

import com.ybin.demo.entity.jpaEntity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
