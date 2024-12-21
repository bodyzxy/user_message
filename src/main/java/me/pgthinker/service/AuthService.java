package me.pgthinker.service;

import jakarta.servlet.http.HttpServletRequest;
import me.pgthinker.model.vo.AuthVO;

/**
 * @Project: me.pgthinker.service
 * @Author: NingNing0111
 * @Github: https://github.com/ningning0111
 * @Date: 2024/12/21 09:57
 * @Description:
 */
public interface AuthService {
    /**
     * 登录
     * @param authVO
     * @return
     */
    Long login(AuthVO authVO, HttpServletRequest request);

    /**
     * 注册
     * @param authVO
     * @return
     */
    Long register(AuthVO authVO);
}
