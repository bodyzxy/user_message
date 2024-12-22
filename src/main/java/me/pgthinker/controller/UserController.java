package me.pgthinker.controller;

import lombok.RequiredArgsConstructor;
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
    public List<Long> delete(@RequestBody BaseDelete baseDelete){
        return userService.delete(baseDelete);
    }

    @PostMapping("/update")
    public Long update(@RequestBody UserDO userDO){
        return userService.update(userDO);
    }

    @PostMapping("/getUser")
    public Pageable listOfPage(@RequestBody UserReq userReq){
        return userService.listOfPage((Pageable) userReq);
    }


}
