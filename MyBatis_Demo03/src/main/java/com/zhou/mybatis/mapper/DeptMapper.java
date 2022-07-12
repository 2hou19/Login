package com.zhou.mybatis.mapper;

import com.zhou.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeptMapper {
    /**
     * 分布查询多对一
     * @param id
     * @return
     */
    Dept getEmpAndDeptByStep(Integer id);

    /**
     * 一对多映射处理collection
     */
    Dept getDeptAndEmpByCollection(Integer id);

    /**
     * 分布查询一对多
     */
    List<Dept> getEmpAndDeptByStepTwo(Integer id);

    /**
     * 动态SQL（if and where）
     */
    @MapKey("")
    List<Map<String, Object>> getDeptByCondition(@Param("id") Integer id, @Param("deptName")String deptName, @Param("loc")String loc);

    /**
     * 动态SQL（trim）
     */
    List<Map<String, Object>> getDeptByTrim(@Param("dept") Dept dept);
}
