package com.example.demo.fasada;

import com.example.demo.mediator.MediatorFamily;
import com.example.demo.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FamilyController {
    public final MediatorFamily mediatorFamily;

//    public FamilyController(MediatorFamily mediatorFamily) {
//        this.mediatorFamily = mediatorFamily;
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public void saveFamily(@RequestBody FamilyDTO familyDTO){
        mediatorFamily.saveFamily(familyDTO);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getByName")
    public List<FamilyExtendedDTO> getFamilyByParam(@RequestParam String name){
        return mediatorFamily.getByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public List<FamilyExtendedDTO> getAllFamily(){
        return mediatorFamily.getAll();
    }
}
