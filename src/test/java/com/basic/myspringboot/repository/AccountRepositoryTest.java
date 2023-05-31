package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    @Rollback(value = false)
    void crud() {
        //1.insert
        Account account = new Account();
        account.setUsername("spring");
        account.setPassword("test12");
        Account savedAccount = accountRepository.save(account);
        System.out.println("Account username = " + savedAccount.getUsername());

        //2. select => update ( dirty checking 기능을 사용한 업데이트 )
        Optional<Account> optionalAccount = accountRepository.findByUsername(savedAccount.getUsername());
        if(optionalAccount.isPresent()){
            Account existAccount = optionalAccount.get();
            existAccount.setPassword("test1234");
        }

        Optional<Account> optional = accountRepository.findById(1L);
        //orElseThrow(Supplier) Supplier의 추상메서드 T get()
        Account account10 = optional.orElseThrow(() -> new RuntimeException("Account Not Found"));
        System.out.println(account10.getUsername());
    }
}