package me.pgthinker.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import me.pgthinker.common.BaseResponse;
import me.pgthinker.common.ResultUtils;
import me.pgthinker.model.entity.RoleDO;
import me.pgthinker.service.RoleService;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @Project: me.pgthinker.controller
 * @Author: NingNing0111
 * @Github: https://github.com/ningning0111
 * @Date: 2024/12/22 16:07
 * @Description:
 */
@Tag(name = "角色管理", description = "用户角色相关操作")
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @Operation(summary = "添加角色", description = "添加一条角色信息")
    @PostMapping("/add")
    public BaseResponse<Long> add(@RequestBody RoleDO role) {
        Long l = roleService.addRole(role);
        return ResultUtils.success(l);
    }

    @Operation(summary = "删除角色", description = "删除一条角色信息")
    @PostMapping("/delete")
    public BaseResponse<Long> delete(@RequestBody RoleDO role) {
        Long delete = roleService.delete(role.getId());
        return ResultUtils.success(delete);
    }

    @Operation(summary = "更新角色", description = "更新一条角色信息")
    @PostMapping("/update")
    public BaseResponse<Long> update(@RequestBody RoleDO role) {
        Long update = roleService.update(role);
        return ResultUtils.success(update);
    }

    @Operation(summary = "查询角色", description = "分页查询角色信息")
    @GetMapping("/list")
    public BaseResponse<IPage<RoleDO>> list(@RequestBody Pageable pageable) {
        IPage<RoleDO> roleDOIPage = roleService.listPage(pageable);
        return ResultUtils.success(roleDOIPage);
    }
}
