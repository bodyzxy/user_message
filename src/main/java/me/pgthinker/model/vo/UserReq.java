package me.pgthinker.model.vo;

import lombok.Data;

/**
 * @Project: me.pgthinker.model.vo
 * @Author: NingNing0111
 * @Github: https://github.com/ningning0111
 * @Date: 2024/12/21 10:54
 * @Description:
 */
@Data
public class UserReq {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String username;
    private String role;
}
