package com.nepalaya.studentmgmt.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@FunctionalInterface
public interface Conditional<T> {
    void add(CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery, Root<T> root);
}
