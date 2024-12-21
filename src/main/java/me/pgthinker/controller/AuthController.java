package me.pgthinker.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import me.pgthinker.common.BaseResponse;
import me.pgthinker.common.ResultUtils;
import me.pgthinker.model.vo.AuthVO;
import me.pgthinker.model.vo.UserReq;
import me.pgthinker.model.vo.UserRes;
import me.pgthinker.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: me.pgthinker.controller
 * @Author: NingNing0111
 * @Github: https://github.com/ningning0111
 * @Date: 2024/12/21 18:49
 * @Description:
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;


    @PostMapping("/register")
    public BaseResponse<Long> register(@RequestBody AuthVO authVO) {
        return ResultUtils.success(authService.register(authVO));
    }

    @PostMapping("/login")
    public BaseResponse<UserRes> login(@RequestBody AuthVO authVO, HttpServletRequest request) {
        return ResultUtils.success(authService.login(authVO,request));
    }
}
