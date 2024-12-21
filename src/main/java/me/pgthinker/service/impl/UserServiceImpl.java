package me.pgthinker.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import me.pgthinker.common.Constants;
import me.pgthinker.common.ErrorCode;
import me.pgthinker.exception.BusinessException;
import me.pgthinker.mapper.UserMapper;
import me.pgthinker.model.entity.UserDO;
import me.pgthinker.model.vo.BaseDelete;
import me.pgthinker.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
    public Long delete(BaseDelete baseDelete) {
        if(CollectionUtils.isEmpty(baseDelete.getIds())){
            return -1L;
        }
        userMapper.deleteBatchIds(baseDelete.getIds());
        return 0L;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long update() {
        return 0L;
    }

    @Override
    public Pageable listOfPage(Pageable pageable) {
        return null;
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
