package com.example.telproject.mapper;

import com.example.telproject.dto.ManagerDTO;
import com.example.telproject.entity.Manager;
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
    date = "2023-05-09T12:39:28+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class ManagerMapperImpl implements ManagerMapper {

    private final DatatypeFactory datatypeFactory;

    public ManagerMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public ManagerDTO toDto(Manager manager) {
        if ( manager == null ) {
            return null;
        }

        String first_name = null;
        String last_name = null;
        String status = null;
        String email = null;
        String phone_number = null;
        LocalDateTime birth_date = null;
        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;

        first_name = manager.getFirst_name();
        last_name = manager.getLast_name();
        if ( manager.getStatus() != null ) {
            status = manager.getStatus().name();
        }
        email = manager.getEmail();
        phone_number = manager.getPhone_number();
        birth_date = xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( manager.getBirth_date() ) );
        created_at = xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( manager.getCreated_at() ) );
        updated_at = xmlGregorianCalendarToLocalDateTime( dateToXmlGregorianCalendar( manager.getUpdated_at() ) );

        ManagerDTO managerDTO = new ManagerDTO( first_name, last_name, status, email, phone_number, birth_date, created_at, updated_at );

        return managerDTO;
    }

    @Override
    public List<ManagerDTO> listToDTO(List<Manager> managers) {
        if ( managers == null ) {
            return null;
        }

        List<ManagerDTO> list = new ArrayList<ManagerDTO>( managers.size() );
        for ( Manager manager : managers ) {
            list.add( toDto( manager ) );
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
