package com.example.demo.translator;

import com.example.demo.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class TranslatorFamilyDTOToFamilyDB {
    public FamilyDB toFamilyDB(FamilyExtendedDTO familyExtendedDTO){
        FamilyDB familyDB = toFamilyDBMap(familyExtendedDTO);
        familyDB.getHead().setFamilyId((familyDB));

        return familyDB;
    }

    public FamilyDB toFamilyDB(FamilyDTO familyDTO){
        FamilyDB familyDB = toFamilyDBMap(familyDTO);

        return familyDB;
    }

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "origin", source = "origin")
    })
    protected abstract FamilyDB toFamilyDBMap(FamilyDTO familyDTO);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "origin", source = "origin"),
            @Mapping(target = "head", expression = "java(toFamilyDBMap(familyDTO.getHead()))")
    })
    protected abstract FamilyDB toFamilyDBMap(FamilyExtendedDTO familyDTO);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "age", source = "age"),
            @Mapping(target = "gender", source = "gender"),
            @Mapping(target = "familyId", ignore = true)
    })
    protected abstract MembersDB toFamilyDBMap(MembersDTO membersDTO);
}
