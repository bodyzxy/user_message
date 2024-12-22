package me.pgthinker.model.vo;

import lombok.Data;


@Data
public class UserReq {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String username;
    private String role;
}
