package com.quickbudget.controller;

import com.quickbudget.domain.CategoryDto;
import com.quickbudget.mapper.CategoryMapper;
import com.quickbudget.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/budget/account/transaction/category")
public class CategoryController {
    @Autowired
    private DBService dbService;
    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getCategories")
    public List<CategoryDto> getCategories() {
        return categoryMapper.mapToCategoryDtoList(dbService.getAllCategories());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCategory")
    public CategoryDto getCategory(@RequestParam Long categoryId) throws CategoryNotFoundException {
        return categoryMapper.mapToCategoryDto(
                dbService.getCategory(categoryId).orElseThrow(CategoryNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCategory", consumes = APPLICATION_JSON_VALUE)
    public void createCategory(@RequestBody CategoryDto categoryDto) {
        dbService.saveCategory(categoryMapper.mapToCategory(categoryDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCategory")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto) {
        return categoryMapper.mapToCategoryDto(
                dbService.saveCategory(categoryMapper.mapToCategory(categoryDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCategory")
    public void deleteCategory(Long categoryId) {
        dbService.deleteCategory(categoryId);
    }
}
