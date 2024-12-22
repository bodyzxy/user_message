package me.pgthinker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import me.pgthinker.common.BaseResponse;
import me.pgthinker.common.ResultUtils;
import me.pgthinker.model.entity.UserDO;
import me.pgthinker.model.vo.AuthVO;
import me.pgthinker.model.vo.UserReq;
import me.pgthinker.model.vo.UserRes;
import me.pgthinker.service.AuthService;
import me.pgthinker.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "认证管理", description = "登录注册相关操作")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    @Operation(summary = "注册", description = "注册后默认是user角色")
    @PostMapping("/register")
    public BaseResponse<Long> register(@RequestBody AuthVO authVO) {
        return ResultUtils.success(authService.register(authVO));
    }

    @Operation(summary = "登录", description = "登录返回登录信息")
    @PostMapping("/login")
    public BaseResponse<UserRes> login(@RequestBody AuthVO authVO, HttpServletRequest request) {
        return ResultUtils.success(authService.login(authVO,request));
    }

    @Operation(summary = "获取登录用户的信息")
    @GetMapping("/info")
    public BaseResponse<UserDO> info(HttpServletRequest request) {
        return ResultUtils.success(userService.getLoginUser(request));
    }
}
