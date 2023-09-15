package com.albert.demotest.entity;

import com.albert.demotest.enums.Grade;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Accessors(chain = true)
@Entity
public class MsEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
    private Instant deletedAt;

    private String name;
    private Long salary;
    @Enumerated(EnumType.STRING)
    private Grade grade;
}
