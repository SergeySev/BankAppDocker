package com.example.telproject.mapper;

import com.example.telproject.dto.TransactionDTO;
import com.example.telproject.entity.Transaction;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-05T15:43:14+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    private final DatatypeFactory datatypeFactory;

    public TransactionMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public TransactionDTO toDto(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        String from_account_id = null;
        String description = null;
        String amount = null;
        LocalDateTime created_at = null;

        from_account_id = map( transaction.getFrom_account_id() );
        description = transaction.getDescription();
        if ( transaction.getAmount() != null ) {
            amount = transaction.getAmount().toString();
        }
        created_at = xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( transaction.getCreated_at() ) );

        TransactionDTO transactionDTO = new TransactionDTO( from_account_id, description, amount, created_at );

        return transactionDTO;
    }

    @Override
    public List<TransactionDTO> listToDTO(List<TransactionDTO> transactionDTO) {
        if ( transactionDTO == null ) {
            return null;
        }

        List<TransactionDTO> list = new ArrayList<TransactionDTO>( transactionDTO.size() );
        for ( TransactionDTO transactionDTO1 : transactionDTO ) {
            list.add( transactionDTO1 );
        }

        return list;
    }

    private XMLGregorianCalendar dateToXmlGregorianCalendar( Date date ) {
        if ( date == null ) {
            return null;
        }

        GregorianCalendar c = new GregorianCalendar();
        c.setTime( date );
        return datatypeFactory.newXMLGregorianCalendar( c );
    }

    private static LocalDateTime xmlGregorianCalendarToLocalDateTime( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        if ( xcal.getYear() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMonth() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getDay() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getHour() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMinute() != DatatypeConstants.FIELD_UNDEFINED
        ) {
            if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED
                && xcal.getMillisecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond(),
                    Duration.ofMillis( xcal.getMillisecond() ).getNano()
                );
            }
            else if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond()
                );
            }
            else {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute()
                );
            }
        }
        return null;
    }
}
