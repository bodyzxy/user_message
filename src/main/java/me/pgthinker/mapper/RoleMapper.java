package me.pgthinker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.pgthinker.model.entity.RoleDO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RoleMapper extends BaseMapper<RoleDO> {
}
