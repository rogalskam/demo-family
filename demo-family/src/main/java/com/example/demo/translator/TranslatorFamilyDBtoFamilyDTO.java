package com.example.demo.translator;


import com.example.demo.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class TranslatorFamilyDBtoFamilyDTO {

    public FamilyExtendedDTO toFamilyExtendedDTO(FamilyDB familyDB){
        FamilyExtendedDTO familyExtendedDTO = toFamilyExDTO(familyDB);
        return familyExtendedDTO;
    }
    public FamilyDTO toFamily(FamilyDB familyDB){
        FamilyDTO familyDTO = toFamilyDTO(familyDB);
        return familyDTO;
    }

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "origin", target = "origin"),
    })
    protected abstract FamilyDTO toFamilyDTO(FamilyDB familyDB);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "origin", target = "origin"),
            @Mapping(expression = "java(toMemberDTO(familyDB.getHead()))", target = "head"),
    })
    protected abstract FamilyExtendedDTO toFamilyExDTO(FamilyDB familyDB);


    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "age", target = "age"),
            @Mapping(source = "gender", target = "gender"),
    })
    protected abstract MembersDTO toMemberDTO(MembersDB membersDB);

}
