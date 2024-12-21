package me.pgthinker.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import me.pgthinker.common.ErrorCode;
import me.pgthinker.exception.BusinessException;
import me.pgthinker.mapper.UserMapper;
import me.pgthinker.mapper.UserRoleMapper;
import me.pgthinker.model.entity.RoleDO;
import me.pgthinker.model.entity.UserDO;
import me.pgthinker.model.entity.UserRoleDO;
import me.pgthinker.model.vo.AuthVO;
import me.pgthinker.model.vo.UserRes;
import me.pgthinker.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StreamUtils;

/**
 * @Project: me.pgthinker.service.impl
 * @Author: NingNing0111
 * @Github: https://github.com/ningning0111
 * @Date: 2024/12/21 10:48
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;


    @Override
    public UserRes login(AuthVO authVO, HttpServletRequest request) {
        String password = authVO.getPassword();
        String username = authVO.getUsername();
        if(StringUtils.isAnyEmpty(password, username)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        LambdaQueryWrapper<UserDO> qw = new LambdaQueryWrapper<>();
        qw.eq(UserDO::getUsername, username);
        UserDO userDO = userMapper.selectOne(qw);
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!md5Password.equals(userDO.getPassword())) {
            throw new BusinessException(ErrorCode.USER_ACCOUNT_ERROR);
        }
        UserRes userRes = new UserRes();
        BeanUtils.copyProperties(userDO, userRes);
        return userRes;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long register(AuthVO authVO) {
        String username = authVO.getUsername();
        String password = authVO.getPassword();
        if(StringUtils.isAnyEmpty(username, password)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        LambdaUpdateWrapper<UserDO> qw = new LambdaUpdateWrapper<>();
        qw.eq(UserDO::getUsername, username);
        UserDO storeUser = userMapper.selectOne(qw);
        if(storeUser != null) {
            throw new BusinessException(ErrorCode.USER_EXIST);
        }
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        UserDO userDO = new UserDO();
        userDO.setUsername(username);
        userDO.setPassword(md5Password);
        userMapper.insert(userDO);

        UserRoleDO userRoleDO = new UserRoleDO();
        userRoleDO.setUserId(userDO.getId());
        userRoleDO.setRoleId(2L);
        userRoleMapper.insert(userRoleDO);
        return userDO.getId();
    }
}
