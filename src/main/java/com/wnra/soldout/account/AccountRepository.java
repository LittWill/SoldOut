package com.wnra.soldout.account;

import com.wnra.soldout.domain.Account;
import com.wnra.soldout.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}
