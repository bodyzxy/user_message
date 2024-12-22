package me.pgthinker.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import me.pgthinker.common.BaseResponse;
import me.pgthinker.common.Constants;
import me.pgthinker.common.ErrorCode;
import me.pgthinker.common.ResultUtils;
import me.pgthinker.exception.BusinessException;
import me.pgthinker.mapper.RoleMapper;
import me.pgthinker.mapper.UserMapper;
import me.pgthinker.mapper.UserRoleMapper;
import me.pgthinker.model.entity.RoleDO;
import me.pgthinker.model.entity.UserDO;
import me.pgthinker.model.entity.UserRoleDO;
import me.pgthinker.model.enums.UserRoleEnum;
import me.pgthinker.model.vo.BaseDelete;
import me.pgthinker.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;
    private final RoleMapper roleMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Long> delete(BaseDelete baseDelete) {
        if(CollectionUtils.isEmpty(baseDelete.getIds())){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        userMapper.deleteBatchIds(baseDelete.getIds());
        return baseDelete.getIds();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long update(UserDO userDO) {
        if (userDO.getId() == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        UserDO user = userMapper.selectById(userDO.getId());
        if (user == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        user.setUsername(userDO.getUsername());
        user.setPassword(userDO.getPassword());
        user.setProfilePicture(userDO.getProfilePicture());
        userMapper.updateById(user);
        return userDO.getId();
    }

    @Override
    public Pageable listOfPage(Pageable pageable) {
        Page<UserDO> page = new Page<>(pageable.getPageNumber(),pageable.getPageSize());

        return (Pageable) userMapper.selectPage(page,null);
    }

    @Override
    public List<UserRoleEnum> userRoles(Long userId) {
        LambdaQueryWrapper<UserRoleDO> userRoleQW = new LambdaQueryWrapper<>();
        userRoleQW.eq(UserRoleDO::getUserId, userId);
        List<UserRoleDO> userRoleDOS = userRoleMapper.selectList(userRoleQW);
        if(CollectionUtils.isEmpty(userRoleDOS)){
            return Collections.emptyList();
        }
        List<Long> roleIds = userRoleDOS.stream().map(UserRoleDO::getRoleId).toList();
        LambdaQueryWrapper<RoleDO> roleQW = new LambdaQueryWrapper<>();
        roleQW.in(RoleDO::getId, roleIds);
        List<RoleDO> roleDOS = roleMapper.selectList(roleQW);
        if(CollectionUtils.isEmpty(roleDOS)){
            return Collections.emptyList();
        }

        return roleDOS.stream().map(role -> UserRoleEnum.getEnumByValue(role.getName())).toList();
    }


    @Override
    public UserDO getLoginUser(HttpServletRequest request) {
        Object user = request.getSession().getAttribute(Constants.USER_Attribute);
        UserDO userDO = (UserDO) user;
        if(userDO == null || userDO.getId() == null){
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        userDO = userMapper.selectById(userDO.getId());

        return userDO;
    }


}
