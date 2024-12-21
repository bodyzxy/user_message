package me.pgthinker.service.impl;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import me.pgthinker.common.BaseResponse;
import me.pgthinker.common.Constants;
import me.pgthinker.common.ErrorCode;
import me.pgthinker.common.ResultUtils;
import me.pgthinker.exception.BusinessException;
import me.pgthinker.mapper.UserMapper;
import me.pgthinker.model.entity.UserDO;
import me.pgthinker.model.vo.BaseDelete;
import me.pgthinker.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;

/**
 * @Project: me.pgthinker.service.impl
 * @Author: NingNing0111
 * @Github: https://github.com/ningning0111
 * @Date: 2024/12/21 10:48
 * @Description:
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BaseResponse delete(BaseDelete baseDelete) {
        if(CollectionUtils.isEmpty(baseDelete.getIds())){
            return ResultUtils.error(ErrorCode.NOT_FOUND_ERROR);
        }
        userMapper.deleteBatchIds(baseDelete.getIds());
        return ResultUtils.success("删除成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BaseResponse update(UserDO userDO) {
        if (userDO.getId() == null) {
            return ResultUtils.error(ErrorCode.NOT_FOUND_ERROR);
        }
        UserDO user = userMapper.selectById(userDO.getId());
        if (user == null) {
            return ResultUtils.error(ErrorCode.NOT_FOUND_ERROR);
        }
        user.setUsername(userDO.getUsername());
        user.setPassword(userDO.getPassword());
        user.setProfilePicture(userDO.getProfilePicture());
        userMapper.updateById(user);
        return ResultUtils.success("修改成功");
    }

    @Override
    public Pageable listOfPage(Pageable pageable) {
        Page<UserDO> page = new Page<>(pageable.getPageNumber(),pageable.getPageSize());

        return (Pageable) userMapper.selectPage(page,null);
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
