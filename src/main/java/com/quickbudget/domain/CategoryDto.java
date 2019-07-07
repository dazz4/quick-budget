package com.quickbudget.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CategoryDto {
    private Long id;
    private String name;
    @JsonIgnore
    private Transaction transaction;
}
