package me.pgthinker.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Project: me.pgthinker.model.entity
 * @Author: NingNing0111
 * @Github: https://github.com/ningning0111
 * @Date: 2024/12/21 23:28
 * @Description:
 */
@Data
@TableName("user_role_con")
public class UserRoleDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long roleId;
}
