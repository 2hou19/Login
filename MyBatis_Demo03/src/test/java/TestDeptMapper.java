import FactoryUtils.FactoryUtil;
import com.zhou.mybatis.mapper.DeptMapper;
import com.zhou.mybatis.pojo.Dept;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestDeptMapper {

    @Test
    public void testDeptSelect() throws IOException {

        SqlSession sqlSession = FactoryUtil.factoryMybatis();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept empAndDeptByStep = mapper.getEmpAndDeptByStep(20);
        System.out.println(empAndDeptByStep);

    }

    @Test
    public void testGetDeptAndEmpByCollection() throws IOException {

        SqlSession sqlSession = FactoryUtil.factoryMybatis();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByCollection(10);
        //depts.forEach(System.out::println);
        System.out.println(dept);

    }

    @Test
    public void getEmpAndDeptByStepTwo() throws IOException {

        SqlSession sqlSession = FactoryUtil.factoryMybatis();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> depts = mapper.getEmpAndDeptByStepTwo(20);
        //depts.forEach(System.out::println);
        depts.forEach(dept -> System.out.println(dept.getDeptName()));

        /**
         * DEBUG 07-11 08:33:49,841 ==>  Preparing: select * from dept where id = 20 (BaseJdbcLogger.java:137)
         * DEBUG 07-11 08:33:49,889 ==> Parameters:  (BaseJdbcLogger.java:137)
         * DEBUG 07-11 08:33:49,987 <==      Total: 1 (BaseJdbcLogger.java:137)
         * 学工部
         */

    }


    @Test
    public void testGetEmpByCondition() throws IOException {

        SqlSession sqlSession = FactoryUtil.factoryMybatis();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        List<Map<String, Object>> depts = mapper.getDeptByCondition(10, "教研部", "北京");
        depts.forEach(System.out::println);
        //System.out.println(depts);

    }

    @Test
    public void testGetDeptByTrim() throws IOException {

        SqlSession sqlSession = FactoryUtil.factoryMybatis();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(20, "学工部", "上海", null);
        List<Map<String, Object>> deptByTrim = mapper.getDeptByTrim(dept);
        deptByTrim.forEach(System.out::println);

    }
}
