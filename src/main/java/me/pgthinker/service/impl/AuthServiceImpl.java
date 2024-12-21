package me.pgthinker.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import me.pgthinker.model.vo.AuthVO;
import me.pgthinker.service.AuthService;
import org.springframework.stereotype.Service;

/**
 * @Project: me.pgthinker.service.impl
 * @Author: NingNing0111
 * @Github: https://github.com/ningning0111
 * @Date: 2024/12/21 10:48
 * @Description:
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public Long login(AuthVO authVO, HttpServletRequest request) {
        return 0L;
    }

    @Override
    public Long register(AuthVO authVO) {
        return 0L;
    }
}
