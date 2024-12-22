package me.pgthinker.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import me.pgthinker.model.entity.RoleDO;
import org.springdoc.core.converters.models.Pageable;

public interface RoleService {
    Long addRole(RoleDO roleDO);

    Long delete(Long roleId);

    Long update(RoleDO roleDO);

    IPage<RoleDO> listPage(Pageable pageable);
}
