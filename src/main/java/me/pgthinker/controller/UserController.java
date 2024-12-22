package me.pgthinker.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.pgthinker.common.BaseResponse;
import me.pgthinker.common.ResultUtils;
import me.pgthinker.model.entity.UserDO;
import me.pgthinker.model.vo.BaseDelete;
import me.pgthinker.model.vo.UserReq;
import me.pgthinker.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "用户管理", description = "系统用户信息相关操作")
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "删除用户信息", description = "删除一条用户的信息")
    @PostMapping("/delete")
    public BaseResponse<List<Long>> delete(@RequestBody BaseDelete baseDelete){
        return ResultUtils.success(userService.delete(baseDelete));
    }

    @Operation(summary = "修改用户信息", description = "修改一条用户的信息")
    @PostMapping("/update")
    public BaseResponse<Long> update(@RequestBody UserDO userDO){
        return ResultUtils.success(userService.update(userDO));
    }

    @Operation(summary = "查询用户信息", description = "分页查询角色信息")
    @GetMapping("/getUser")
    public BaseResponse<IPage<UserDO>> listOfPage(UserReq userReq){
        return ResultUtils.success(userService.listOfPage(userReq));
    }


}
