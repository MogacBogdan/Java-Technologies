package com.example.laboratory3.beans;

import com.example.laboratory3.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

public class DataViewBean<T extends AbstractEntity<ID>, ID> implements Serializable {
    @Getter @Setter protected T selectedEntity;
    @Getter protected List<T> entities;
}
