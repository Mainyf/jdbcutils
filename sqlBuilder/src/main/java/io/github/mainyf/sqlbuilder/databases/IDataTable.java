package io.github.mainyf.sqlbuilder.databases;

import io.github.mainyf.sqlbuilder.where.Where;

import java.util.Set;

public interface IDataTable<T> {

    void createTable();

    int insert(T entity);

    int insertList(T entity);

    int update(T entity, Where where);

    T find(Where where);

    Set<T> findList(Where where);

    int delete(Where where);

}
