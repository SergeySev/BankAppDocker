package com.example.telproject.mapper;

import com.example.telproject.dto.ClientDocumentDTO;
import com.example.telproject.entity.ClientDocument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T12:39:28+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class ClientDocumentMapperImpl implements ClientDocumentMapper {

    @Override
    public ClientDocumentDTO toDTO(ClientDocument clientDocument) {
        if ( clientDocument == null ) {
            return null;
        }

        byte[] document = null;
        String type = null;

        byte[] document1 = clientDocument.getDocument();
        if ( document1 != null ) {
            document = Arrays.copyOf( document1, document1.length );
        }
        type = clientDocument.getType();

        ClientDocumentDTO clientDocumentDTO = new ClientDocumentDTO( document, type );

        return clientDocumentDTO;
    }

    @Override
    public List<ClientDocumentDTO> toDTOList(List<ClientDocument> clientDocument) {
        if ( clientDocument == null ) {
            return null;
        }

        List<ClientDocumentDTO> list = new ArrayList<ClientDocumentDTO>( clientDocument.size() );
        for ( ClientDocument clientDocument1 : clientDocument ) {
            list.add( toDTO( clientDocument1 ) );
        }

        return list;
    }
}
