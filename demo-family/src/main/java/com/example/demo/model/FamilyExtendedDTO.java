package com.example.demo.model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FamilyExtendedDTO extends FamilyDTO {
    private MembersDTO head;
}
