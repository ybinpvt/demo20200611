package com.ybin.demo.entity.jpaEntity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author ybin
 * @version 1.0
 * @date 2020/6/12 8:44
 */

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
