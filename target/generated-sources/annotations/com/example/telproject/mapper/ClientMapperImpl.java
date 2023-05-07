package com.example.telproject.mapper;

import com.example.telproject.dto.ClientDTO;
import com.example.telproject.entity.Client;
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
public class ClientMapperImpl implements ClientMapper {

    private final DatatypeFactory datatypeFactory;

    public ClientMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public ClientDTO toDto(Client client) {
        if ( client == null ) {
            return null;
        }

        String id = null;
        String manager = null;
        String status = null;
        String first_name = null;
        String last_name = null;
        String email = null;
        String address = null;
        String phone = null;
        LocalDateTime birth_date = null;
        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;

        if ( client.getId() != null ) {
            id = String.valueOf( client.getId() );
        }
        manager = map( client.getManager() );
        if ( client.getStatus() != null ) {
            status = client.getStatus().name();
        }
        first_name = client.getFirst_name();
        last_name = client.getLast_name();
        email = client.getEmail();
        address = client.getAddress();
        phone = client.getPhone();
        birth_date = xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( client.getBirth_date() ) );
        created_at = xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( client.getCreated_at() ) );
        updated_at = xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( client.getUpdated_at() ) );

        String tax_code = null;

        ClientDTO clientDTO = new ClientDTO( id, manager, status, tax_code, first_name, last_name, email, address, phone, birth_date, created_at, updated_at );

        return clientDTO;
    }

    @Override
    public List<ClientDTO> listToDTO(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientDTO> list = new ArrayList<ClientDTO>( clients.size() );
        for ( Client client : clients ) {
            list.add( toDto( client ) );
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
