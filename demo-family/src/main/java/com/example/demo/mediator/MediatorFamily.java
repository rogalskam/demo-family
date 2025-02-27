package com.example.demo.mediator;

import com.example.demo.model.*;
import com.example.demo.services.FamilyService;
import com.example.demo.services.MemberService;
import com.example.demo.translator.TranslatorFamilyDBtoFamilyDTO;
import com.example.demo.translator.TranslatorFamilyDTOToFamilyDB;
import com.example.demo.translator.TranslatorMemberDBToMemberDTO;
import com.example.demo.translator.TranslatorMemberDTOToMemberDB;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MediatorFamily {
    TranslatorFamilyDBtoFamilyDTO translatorFamilyDBtoFamilyDTO;
    TranslatorMemberDBToMemberDTO memberDBToMemberDTO;
    TranslatorFamilyDTOToFamilyDB translatorFamilyDTOToFamilyDB;
    TranslatorMemberDTOToMemberDB translatorMemberDTOToMemberDB;
    FamilyService familyService;
    MemberService memberService;

    public MediatorFamily(
            TranslatorFamilyDBtoFamilyDTO translatorFamilyDBtoFamilyDTO,
            TranslatorMemberDBToMemberDTO memberDBToMemberDTO,
            TranslatorFamilyDTOToFamilyDB translatorFamilyDTOToFamilyDB,
            TranslatorMemberDTOToMemberDB translatorMemberDTOToMemberDB,
            FamilyService familyService,
            MemberService memberService
            ) {
        this.translatorFamilyDBtoFamilyDTO = translatorFamilyDBtoFamilyDTO;
        this.memberDBToMemberDTO = memberDBToMemberDTO;
        this.translatorFamilyDTOToFamilyDB = translatorFamilyDTOToFamilyDB;
        this.translatorMemberDTOToMemberDB = translatorMemberDTOToMemberDB;
        this.familyService = familyService;
        this.memberService = memberService;
    }

    public void saveFamily(FamilyDTO familyDTO) {
        FamilyDB familyDB = translatorFamilyDTOToFamilyDB.toFamilyDB(familyDTO);
        familyService.save(familyDB);
    }

    public void updateFamily(FamilyExtendedDTO familyDTO) {
        FamilyDB familyDB = translatorFamilyDTOToFamilyDB.toFamilyDB(familyDTO);
        familyService.save(familyDB);
    }

    public void saveMember(MembersDTO membersDTO) {
        MembersDB membersDB = translatorMemberDTOToMemberDB.toMembersDB(membersDTO);
        memberService.save(membersDB);
    }

    public void updateMember(MembersExtendedDTO membersExtendedDTO) {
      MembersDB membersDB = translatorMemberDTOToMemberDB.toMembersDB(membersExtendedDTO);
      memberService.save(membersDB);
    }

    public List<FamilyExtendedDTO> getByName(String name) {
        List<FamilyDB> list = familyService.findByName(name);
        List<FamilyExtendedDTO> extendedDTOSList = new ArrayList<>();
        for(FamilyDB familyDB: list) {
            extendedDTOSList.add(translatorFamilyDBtoFamilyDTO.toFamilyExtendedDTO(familyDB));
        }
        return extendedDTOSList;
    }

    public List<FamilyExtendedDTO> getAll() {
        List<FamilyDB> list = familyService.getAll();
        List<FamilyExtendedDTO> extendedDTOSList = new ArrayList<>();
        for(FamilyDB familyDB: list) {
            extendedDTOSList.add(translatorFamilyDBtoFamilyDTO.toFamilyExtendedDTO(familyDB));
        }
        return extendedDTOSList;
    }

    public List<MembersExtendedDTO> getAllMembers() {
        List<MembersDB> list = memberService.getAll();
        List<MembersExtendedDTO> extendedDTOSList = new ArrayList<>();
        for(MembersDB membersDB: list) {
            extendedDTOSList.add(memberDBToMemberDTO.toMemberExtendedDTO(membersDB));
        }
        return extendedDTOSList;
    }

}
