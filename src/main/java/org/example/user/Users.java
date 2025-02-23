package org.example.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.UUID;

@Data
public class Users {


    private UUID uuid;

    private String name;

    private String soname;

    private int role_id;

    private String status;



}
