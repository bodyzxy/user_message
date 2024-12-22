package me.pgthinker.model.vo;

import lombok.Data;

import java.util.Date;


@Data
public class UserRes {
    private String id;
    private String username;

    private String role;
    private String profilePicture;
    private Date createTime;

}
