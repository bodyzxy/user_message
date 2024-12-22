package me.pgthinker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.pgthinker.model.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
