package me.pgthinker.service;

import jakarta.servlet.http.HttpServletRequest;
import me.pgthinker.model.vo.AuthVO;
import me.pgthinker.model.vo.UserRes;


public interface AuthService {
    /**
     * 登录
     * @param authVO
     * @return
     */
    UserRes login(AuthVO authVO, HttpServletRequest request);

    /**
     * 注册
     * @param authVO
     * @return
     */
    Long register(AuthVO authVO);
}
