package com.ybc.controller.admin;

import com.ybc.dto.CategoryDTO;
import com.ybc.dto.CategoryPageQueryDTO;
import com.ybc.entity.Category;
import com.ybc.result.PageResult;
import com.ybc.result.Result;
import com.ybc.service.CategoryService;
import com.ybc.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/admin/category")
@Api(tags = "分类相关接口")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ApiOperation("新增分类")
    public Result<String> save(@RequestBody CategoryDTO categoryDTO){
        log.info("新增分类：{}", categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }


    /**
     * 删除分类
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("删除分类")
    public Result delete(Long id) {
        categoryService.deleteById(id);
        return Result.success();
    }

    /**
     * 修改分类
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改分类")
    public Result update(@RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryDTO);
        return Result.success();
    }

    /**
     * 启用禁用分类
     * @param status
     * @return
     */
    @PostMapping("status/{status}")
    @ApiOperation("启用禁用分类")
    public Result startOrStop(@PathVariable Integer status,Long id) {
        categoryService.startOrStop(status,id);
        return Result.success();
    }

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list (Integer type ) {
        List<Category> categorys = categoryService.selectByType(type);
        return Result.success(categorys);
    }
}
