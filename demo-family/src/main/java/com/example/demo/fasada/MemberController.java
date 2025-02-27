package com.example.demo.fasada;

import com.example.demo.mediator.MediatorFamily;
import com.example.demo.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    public final MediatorFamily mediatorFamily;

//    public MemberController(MediatorFamily mediatorFamily) {
//        this.mediatorFamily = mediatorFamily;
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveMember")
    public void saveMember(@RequestBody MembersDTO membersDTO){
        mediatorFamily.saveMember(membersDTO);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllMembers")
    public List<MembersExtendedDTO> getAll(){
        return mediatorFamily.getAllMembers();
    }
}
