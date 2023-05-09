package com.example.telproject.mapper;

import com.example.telproject.dto.ConfirmationTokenDTO;
import com.example.telproject.entity.ConfirmationToken;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T12:39:28+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class ConfirmationTokenMapperImpl implements ConfirmationTokenMapper {

    @Override
    public ConfirmationTokenDTO toDto(ConfirmationToken token) {
        if ( token == null ) {
            return null;
        }

        String token1 = null;
        LocalDateTime created_at = null;
        LocalDateTime expired_at = null;
        LocalDateTime confirmed_at = null;
        String client = null;

        token1 = token.getToken();
        created_at = token.getCreated_at();
        expired_at = token.getExpired_at();
        confirmed_at = token.getConfirmed_at();
        client = map( token.getClient() );

        ConfirmationTokenDTO confirmationTokenDTO = new ConfirmationTokenDTO( token1, created_at, expired_at, confirmed_at, client );

        return confirmationTokenDTO;
    }
}
