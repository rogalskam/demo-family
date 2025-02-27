package com.example.demo.translator;

import com.example.demo.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class TranslatorMemberDTOToMemberDB {
    public MembersDB toMembersDB(MembersExtendedDTO membersExtendedDTO) {
        MembersDB membersDB = toMembersDBMap(membersExtendedDTO);
        return membersDB;
    }

    public MembersDB toMembersDB(MembersDTO membersDTO){
        MembersDB membersDB = toMembersDBMap(membersDTO);

        return membersDB;
    }

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "age", source = "age"),
            @Mapping(target = "gender", source = "gender"),
            @Mapping(target = "familyId", ignore = true)
    })
    protected abstract MembersDB toMembersDBMap(MembersDTO membersDTO);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "age", source = "age"),
            @Mapping(target = "gender", source = "gender"),
            @Mapping(target = "familyId", expression = "java(toFamilyDBMap(membersExtendedDTO.getFamily()))")
    })
    protected abstract MembersDB toMembersDBMap(MembersExtendedDTO membersExtendedDTO);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "origin", source = "origin")
    })
    protected abstract FamilyDB toFamilyDBMap(FamilyDTO familyDTO);


}
