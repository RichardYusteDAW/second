package com.fpmislata.demo.c_domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ListWithCount<T> {
    private List<T> list;
    private Integer count;
}