package com.javalearning.Banking_app.repository;

import com.javalearning.Banking_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
