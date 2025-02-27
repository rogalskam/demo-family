package com.example.demo.translator;

import com.example.demo.model.FamilyDB;
import com.example.demo.model.FamilyDTO;
import com.example.demo.model.FamilyExtendedDTO;
import com.example.demo.model.Gender;
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
public class TranslatorFamilyDTOToFamilyDBImpl extends TranslatorFamilyDTOToFamilyDB {

    @Override
    protected FamilyDB toFamilyDBMap(FamilyDTO familyDTO) {
        if ( familyDTO == null ) {
            return null;
        }

        FamilyDB familyDB = new FamilyDB();

        familyDB.setName( familyDTO.getName() );
        familyDB.setOrigin( familyDTO.getOrigin() );

        return familyDB;
    }

    @Override
    protected FamilyDB toFamilyDBMap(FamilyExtendedDTO familyDTO) {
        if ( familyDTO == null ) {
            return null;
        }

        FamilyDB familyDB = new FamilyDB();

        familyDB.setName( familyDTO.getName() );
        familyDB.setOrigin( familyDTO.getOrigin() );

        familyDB.setHead( toFamilyDBMap(familyDTO.getHead()) );

        return familyDB;
    }

    @Override
    protected MembersDB toFamilyDBMap(MembersDTO membersDTO) {
        if ( membersDTO == null ) {
            return null;
        }

        String name = null;
        int age = 0;
        Gender gender = null;

        name = membersDTO.getName();
        age = membersDTO.getAge();
        gender = membersDTO.getGender();

        long id = 0L;
        FamilyDB familyId = null;

        MembersDB membersDB = new MembersDB( id, name, age, gender, familyId );

        return membersDB;
    }
}
