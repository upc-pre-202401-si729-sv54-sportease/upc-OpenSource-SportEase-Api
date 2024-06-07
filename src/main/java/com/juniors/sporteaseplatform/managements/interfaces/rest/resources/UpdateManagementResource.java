package com.juniors.sporteaseplatform.managements.interfaces.rest.resources;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateManagementResource {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String type;
    private String nameClub;


}
