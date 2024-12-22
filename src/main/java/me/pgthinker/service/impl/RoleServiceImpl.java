package me.pgthinker.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import me.pgthinker.mapper.RoleMapper;
import me.pgthinker.model.entity.RoleDO;
import me.pgthinker.service.RoleService;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    @Transactional(rollbackFor = Exception.class)
    @PostConstruct
    public void initBaseRole() {
        RoleDO adminRole = new RoleDO();
        adminRole.setName("admin");
        adminRole.setDescription("管理员");

        RoleDO userRole = new RoleDO();
        userRole.setName("user");
        userRole.setDescription("用户");

        LambdaQueryWrapper<RoleDO> roleQW = new LambdaQueryWrapper<>();
        roleQW.eq(RoleDO::getName, adminRole.getName());
        if(!roleMapper.exists(roleQW)) {
            roleMapper.insert(adminRole);
        }

        roleQW = new LambdaQueryWrapper<>();
        roleQW.eq(RoleDO::getName, userRole.getName());
        if(!roleMapper.exists(roleQW)) {
            roleMapper.insert(userRole);
        }


    }

    @Override
    public Long addRole(RoleDO roleDO) {
        roleMapper.insert(roleDO);
        return roleDO.getId();
    }

    @Override
    public Long delete(Long roleId) {
        roleMapper.deleteById(roleId);
        return roleId;
    }

    @Override
    public Long update(RoleDO roleDO) {
        roleMapper.updateById(roleDO);
        return roleDO.getId();
    }

    @Override
    public IPage<RoleDO> listPage(Pageable pageable) {
        Page<RoleDO> roleDOPage = new Page<>(pageable.getPage(), pageable.getSize());
        return roleMapper.selectPage(roleDOPage,null);
    }
}
