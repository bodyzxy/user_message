package me.pgthinker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.pgthinker.model.entity.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserRoleMapper extends BaseMapper<UserRoleDO> {
}
