package com.application.demo_etax_invoice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserVerify {
    @OneToOne
    @Id
    private User user;
    private String verifyCode;
    private boolean isVerified;
    private LocalDateTime verifiedAt;
}
