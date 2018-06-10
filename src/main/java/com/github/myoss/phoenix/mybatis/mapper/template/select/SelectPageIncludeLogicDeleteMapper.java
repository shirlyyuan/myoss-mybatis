/*
 * Copyright 2018-2018 https://github.com/myoss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.myoss.phoenix.mybatis.mapper.template.select;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.github.myoss.phoenix.core.lang.dto.Order;
import com.github.myoss.phoenix.mybatis.mapper.annotation.RegisterMapper;
import com.github.myoss.phoenix.mybatis.mapper.template.select.impl.SelectIncludeLogicDeleteMapperTemplate;
import com.github.myoss.phoenix.mybatis.table.annotation.Column;

/**
 * 查询记录通用 Mapper 接口，不会过滤掉已经被标记为逻辑删除（{@link Column#logicDelete}）的数据
 *
 * @author Jerry.Chen
 * @since 2018年6月10日 下午11:58:16
 */
@RegisterMapper
public interface SelectPageIncludeLogicDeleteMapper<T> {
    /**
     * 根据条件分页查询匹配的实体对象，不会过滤掉已经被标记为逻辑删除（{@link Column#logicDelete}）的数据
     *
     * @param condition 匹配的条件
     * @param offset 记录行的偏移量（SELECT * FROM table LIMIT 0,10; // 检索记录行 1-10）
     * @param pageSize 分页的条数
     * @param orders 排序字段
     * @return 匹配的实体对象
     * @see SelectIncludeLogicDeleteMapperTemplate#selectPageIncludeLogicDelete
     */
    @SelectProvider(type = SelectIncludeLogicDeleteMapperTemplate.class, method = "dynamicSql")
    List<T> selectPageIncludeLogicDelete(@Param("condition") T condition, @Param("offset") int offset,
                                         @Param("pageSize") int pageSize, @Param("orders") List<Order> orders);

    /**
     * 根据条件分页查询匹配的实体对象，不会过滤掉已经被标记为逻辑删除（{@link Column#logicDelete}）的数据
     *
     * @param condition 匹配的条件
     * @param extraCondition 扩展查询条件，需要自定义
     * @param offset 记录行的偏移量（SELECT * FROM table LIMIT 0,10; // 检索记录行 1-10）
     * @param pageSize 分页的条数
     * @param orders 排序字段
     * @return 匹配的实体对象
     * @see SelectIncludeLogicDeleteMapperTemplate#selectPageIncludeLogicDelete2
     */
    @SelectProvider(type = SelectIncludeLogicDeleteMapperTemplate.class, method = "dynamicSql")
    List<T> selectPageIncludeLogicDelete2(@Param("condition") T condition,
                                          @Param("extraCondition") Map<String, Object> extraCondition,
                                          @Param("offset") int offset, @Param("pageSize") int pageSize,
                                          @Param("orders") List<Order> orders);
}