package me.pgthinker.service;

import jakarta.servlet.http.HttpServletRequest;
import me.pgthinker.common.BaseResponse;
import me.pgthinker.model.entity.UserDO;
import me.pgthinker.model.vo.BaseDelete;
import org.springframework.data.domain.Pageable;

/**
 * @Project: me.pgthinker.service
 * @Author: NingNing0111
 * @Github: https://github.com/ningning0111
 * @Date: 2024/12/21 10:00
 * @Description:
 */
public interface UserService {

    BaseResponse delete(BaseDelete baseDelete);
    BaseResponse update(UserDO userDO);

    UserDO getLoginUser(HttpServletRequest request);

    Pageable listOfPage(Pageable pageable);
}
