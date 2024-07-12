package com.tap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tap.Entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long>{

}
