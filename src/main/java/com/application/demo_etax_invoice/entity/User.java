package com.application.demo_etax_invoice.entity;

import jakarta.persistence.*;
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

    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private UserVerify userVerify;
}
