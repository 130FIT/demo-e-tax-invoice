package com.application.demo_etax_invoice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(
        name = "users"
)
public class User  extends BaseEntity{
    @Id
    @Column(
            name = "email",
            nullable = false,
            unique = true,
            columnDefinition = "VARCHAR(100)"
    )
    private String email;
}
