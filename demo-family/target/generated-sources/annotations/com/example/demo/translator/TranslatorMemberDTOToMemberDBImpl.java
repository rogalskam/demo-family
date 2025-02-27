package com.example.demo.translator;

import com.example.demo.model.FamilyDB;
import com.example.demo.model.FamilyDTO;
import com.example.demo.model.Gender;
import com.example.demo.model.MembersDB;
import com.example.demo.model.MembersDTO;
import com.example.demo.model.MembersExtendedDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-27T10:04:39+0100",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class TranslatorMemberDTOToMemberDBImpl extends TranslatorMemberDTOToMemberDB {

    @Override
    protected MembersDB toMembersDBMap(MembersDTO membersDTO) {
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

    @Override
    protected MembersDB toMembersDBMap(MembersExtendedDTO membersExtendedDTO) {
        if ( membersExtendedDTO == null ) {
            return null;
        }

        String name = null;
        int age = 0;
        Gender gender = null;

        name = membersExtendedDTO.getName();
        age = membersExtendedDTO.getAge();
        gender = membersExtendedDTO.getGender();

        long id = 0L;
        FamilyDB familyId = toFamilyDBMap(membersExtendedDTO.getFamily());

        MembersDB membersDB = new MembersDB( id, name, age, gender, familyId );

        return membersDB;
    }

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
}
