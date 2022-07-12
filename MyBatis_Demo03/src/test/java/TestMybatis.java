import FactoryUtils.FactoryUtil;
import com.zhou.mybatis.mapper.DeptMapper;
import com.zhou.mybatis.mapper.EmpMapper;
import com.zhou.mybatis.pojo.Dept;
import com.zhou.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class TestMybatis {

    @Test
    public void testSelectAllEmp() throws IOException {

        SqlSession sqlSession = FactoryUtil.factoryMybatis();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.selectAll();
        emps.forEach(emp -> System.out.println(emp));

    }

    @Test
    public void testselectAllToMap() throws IOException {

        SqlSession sqlSession = FactoryUtil.factoryMybatis();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Map<String, Object> map = mapper.selectAllToMap();
        System.out.println(map);

    }

    @Test
    public void testselectByLike() throws IOException {

        SqlSession sqlSession = FactoryUtil.factoryMybatis();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Map<String, Object>> maps = mapper.selectByLike("悟空");
        maps.forEach(System.out::println);

    }

    @Test
    public void testdeleteByIds() throws IOException {

        SqlSession sqlSession = FactoryUtil.factoryMybatis();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        int i = mapper.deleteByIds("1001, 1003, 1005");
        System.out.println(i);

    }

    @Test
    public void testempAndDeptResultMapByAccociation() throws IOException {

        SqlSession sqlSession = FactoryUtil.factoryMybatis();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.empAndDeptResultMapByAccociation(1002);
        emps.forEach(System.out::println);

    }

    @Test
    public void testgetEmpAndDeptByStep() throws IOException {

        SqlSession sqlSession = FactoryUtil.factoryMybatis();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStep(1002);
        System.out.println(emp);
    }

    /**
     * 测试MyBatis的一级缓存
     */
    @Test
    public void testCacheOne() throws IOException {

        SqlSession sqlSession = FactoryUtil.factoryMybatis();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.selectAll();
        emps.forEach(System.out::println);
        System.out.println("=============");

        /**
         * 1. 不同的SqlSession对应不同的一级缓存
         * 2. 同一个SqlSession但是查询条件不同
         * 3. 同一个SqlSession两次查询期间执行了任何一次增删改操作
         * 4. 同一个SqlSession两次查询期间手动清空了缓存
         */

        //手动清空缓存
        //sqlSession.clearCache();


        //SqlSession sqlSession1 = FactoryUtil.factoryMybatis();
        /**
         * System.out.println(sqlSession1);
         * System.out.println(sqlSession);
         * org.apache.ibatis.session.defaults.DefaultSqlSession@2eae8e6e
         * org.apache.ibatis.session.defaults.DefaultSqlSession@2eae8e6e
         */
        
        //EmpMapper mapper1 = sqlSession.getMapper(EmpMapper.class);
        /*InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(resource);
        SqlSession sqlSession1 = build.openSession(true);
        EmpMapper mapper1 = sqlSession1.getMapper(EmpMapper.class);*/
        List<Emp> emps1 = mapper.selectAll();
        emps1.forEach(System.out::println);

    }


    /**
     * 测试MyBatis的二级缓存
     */
    @Test
    public void testCacheTwo() throws IOException {

        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(resource);
        SqlSession sqlSession = build.openSession(true);
        SqlSession sqlSession1 = build.openSession(true);

        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.selectAll();
        emps.forEach(System.out::println);
        sqlSession.close();
        System.out.println("==========");
        EmpMapper mapper1 = sqlSession1.getMapper(EmpMapper.class);
        mapper1.selectAll();
        emps.forEach(System.out::println);

    }
}
