package com.steven.banking.service.impl;

import com.steven.banking.dto.AccountDto;
import com.steven.banking.entity.Account;
import com.steven.banking.mapper.AccountMapper;
import com.steven.banking.repository.AccountRepository;
import com.steven.banking.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        // convert accountDTO to account
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccount(Long id) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));

        AccountDto accountDto = AccountMapper.mapToAccountDto(account);

        return accountDto;
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        // get account
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account is not exist"));

        // update balance
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        AccountDto accountDto = AccountMapper.mapToAccountDto(account);

        return accountDto;
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        // get account
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account is not exist"));

        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient amount");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        AccountDto accountDto = AccountMapper.mapToAccountDto(account);

        return accountDto;
    }

    @Override
    public List<AccountDto> getAllAccounts(){

        List<Account> listAccounts= accountRepository.findAll();

        List<AccountDto> listAccountsDto= listAccounts.stream()
                .map(account -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());

        return listAccountsDto;
    }

    @Override
    public void delete(Long id) {
        // get account
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account is not exist"));
        accountRepository.deleteById(id);
    }
}
