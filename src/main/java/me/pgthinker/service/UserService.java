package me.pgthinker.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.servlet.http.HttpServletRequest;
import me.pgthinker.common.BaseResponse;
import me.pgthinker.model.entity.UserDO;
import me.pgthinker.model.enums.UserRoleEnum;
import me.pgthinker.model.vo.BaseDelete;
import me.pgthinker.model.vo.UserReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserService {

    List<Long> delete(BaseDelete baseDelete);

    Long update(UserDO userDO);

    UserDO getLoginUser(HttpServletRequest request);

    IPage<UserDO> listOfPage(UserReq userReq);

    List<UserRoleEnum> userRoles(Long userId);
}
