package me.pgthinker.model.vo;

import lombok.Data;

import java.util.List;


@Data
public class BaseDelete {
    private List<Long> ids;
}
