package com.example.demo.translator;

import com.example.demo.model.FamilyDB;
import com.example.demo.model.FamilyDTO;
import com.example.demo.model.FamilyExtendedDTO;
import com.example.demo.model.MembersDB;
import com.example.demo.model.MembersDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-27T10:03:38+0100",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class TranslatorFamilyDBtoFamilyDTOImpl extends TranslatorFamilyDBtoFamilyDTO {

    @Override
    protected FamilyDTO toFamilyDTO(FamilyDB familyDB) {
        if ( familyDB == null ) {
            return null;
        }

        FamilyDTO familyDTO = new FamilyDTO();

        familyDTO.setName( familyDB.getName() );
        familyDTO.setOrigin( familyDB.getOrigin() );

        return familyDTO;
    }

    @Override
    protected FamilyExtendedDTO toFamilyExDTO(FamilyDB familyDB) {
        if ( familyDB == null ) {
            return null;
        }

        FamilyExtendedDTO familyExtendedDTO = new FamilyExtendedDTO();

        familyExtendedDTO.setName( familyDB.getName() );
        familyExtendedDTO.setOrigin( familyDB.getOrigin() );

        familyExtendedDTO.setHead( toMemberDTO(familyDB.getHead()) );

        return familyExtendedDTO;
    }

    @Override
    protected MembersDTO toMemberDTO(MembersDB membersDB) {
        if ( membersDB == null ) {
            return null;
        }

        MembersDTO membersDTO = new MembersDTO();

        membersDTO.setName( membersDB.getName() );
        membersDTO.setAge( membersDB.getAge() );
        membersDTO.setGender( membersDB.getGender() );

        return membersDTO;
    }
}
