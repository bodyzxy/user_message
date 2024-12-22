package me.pgthinker.controller;

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

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/delete")
    public BaseResponse<List<Long>> delete(@RequestBody BaseDelete baseDelete){
        return ResultUtils.success(userService.delete(baseDelete));
    }

    @PostMapping("/update")
    public BaseResponse<Long> update(@RequestBody UserDO userDO){
        return ResultUtils.success(userService.update(userDO));
    }

    @PostMapping("/getUser")
    public BaseResponse<Pageable> listOfPage(@RequestBody UserReq userReq){
        return ResultUtils.success(userService.listOfPage((Pageable) userReq));
    }


}
