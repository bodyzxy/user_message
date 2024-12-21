package me.pgthinker.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Project: me.pgthinker.model.vo
 * @Author: NingNing0111
 * @Github: https://github.com/ningning0111
 * @Date: 2024/12/21 10:01
 * @Description:
 */
@Data
public class UserRes {
    private String id;
    private String username;

    private String role;
    private String profilePicture;
    private Date createTime;

}
