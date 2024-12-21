package me.pgthinker.service;

import jakarta.servlet.http.HttpServletRequest;
import me.pgthinker.common.BaseResponse;
import me.pgthinker.model.entity.UserDO;
import me.pgthinker.model.enums.UserRoleEnum;
import me.pgthinker.model.vo.BaseDelete;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Project: me.pgthinker.service
 * @Author: NingNing0111
 * @Github: https://github.com/ningning0111
 * @Date: 2024/12/21 10:00
 * @Description:
 */
public interface UserService {

    List<Long> delete(BaseDelete baseDelete);
    Long update(UserDO userDO);

    UserDO getLoginUser(HttpServletRequest request);

    Pageable listOfPage(Pageable pageable);

    List<UserRoleEnum> userRoles(Long userId);
}
