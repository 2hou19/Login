package com.zhou.mybatis.mapper;

import com.zhou.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface EmpMapper {

    /**
     * 根据id查询员工信息
     */
    Map<String, Object> selectByDeptId(Integer deptId);

    /**
     * 查询所有员工信息
     * @return
     */
    List<Emp> selectAll();

    /**
     * 通过map集合接收所有员工信息
     */
    @MapKey("id")
    Map<String, Object> selectAllToMap();

    /**
     * 根据用户名进行模糊查询
     */
    List<Map<String, Object>> selectByLike(String EmpName);

    /**
     * 根据id批量删除员工信息
     */
    int deleteByIds(String ids);

    /**
     * 使用accociation处理多对一的映射关系
     */
    List<Emp> empAndDeptResultMapByAccociation(Integer id);

    /**
     * 分布查询
     */
    Emp getEmpAndDeptByStep(Integer id);

}
