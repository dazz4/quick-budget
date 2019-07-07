package com.quickbudget.mapper;

import com.quickbudget.domain.Category;
import com.quickbudget.domain.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    public Category mapToCategory(final CategoryDto categoryDto) {
        return new Category(
                categoryDto.getId(),
                categoryDto.getName(),
                categoryDto.getTransaction());
    }

    public CategoryDto mapToCategoryDto(final Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getTransaction());
    }

    public List<CategoryDto> mapToCategoryDtoList(final List<Category> categories) {
        return categories.stream()
                .map(b -> new CategoryDto(b.getId(), b.getName(), b.getTransaction()))
                .collect(Collectors.toList());
    }
}
