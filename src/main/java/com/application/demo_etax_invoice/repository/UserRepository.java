package com.application.demo_etax_invoice.repository;

import com.application.demo_etax_invoice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
