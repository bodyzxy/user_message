package me.pgthinker.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Project: me.pgthinker.model.entity
 * @Author: NingNing0111
 * @Github: https://github.com/ningning0111
 * @Date: 2024/12/21 09:52
 * @Description:
 */
@TableName("user_info")
@Data
public class UserDO implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String profilePicture;
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
