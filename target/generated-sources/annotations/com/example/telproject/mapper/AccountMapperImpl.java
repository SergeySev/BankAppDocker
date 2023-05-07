package com.example.telproject.mapper;

import com.example.telproject.dto.AccountDTO;
import com.example.telproject.entity.Account;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-05T15:43:14+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDTO toDto(Account account) {
        if ( account == null ) {
            return null;
        }

        String card_number = null;
        String csv = null;
        String type = null;
        String status = null;
        String balance = null;
        String currency_code = null;

        card_number = account.getCard_number();
        csv = account.getCsv();
        if ( account.getType() != null ) {
            type = account.getType().name();
        }
        if ( account.getStatus() != null ) {
            status = account.getStatus().name();
        }
        if ( account.getBalance() != null ) {
            balance = account.getBalance().toString();
        }
        if ( account.getCurrency_code() != null ) {
            currency_code = account.getCurrency_code().name();
        }

        AccountDTO accountDTO = new AccountDTO( card_number, csv, type, status, balance, currency_code );

        return accountDTO;
    }

    @Override
    public List<AccountDTO> toDtoList(List<Account> accounts) {
        if ( accounts == null ) {
            return null;
        }

        List<AccountDTO> list = new ArrayList<AccountDTO>( accounts.size() );
        for ( Account account : accounts ) {
            list.add( toDto( account ) );
        }

        return list;
    }
}
