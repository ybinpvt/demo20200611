package com.ybin.demo.repository.jpaRepository;

import com.ybin.demo.entity.jpaEntity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
