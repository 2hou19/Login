package Mapper;

import Pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from username_pwd where username = #{userName} and password = #{passWord}")
    User selectUser(@Param("userName") String username, @Param("passWord") String password);

    @Select("select * from username_pwd where username = #{userName}")
    User selectByUn(@Param("userName") String username);

    @Insert("insert into username_pwd(username, password) value (#{userName}, #{passWord})")
    void insert(@Param("userName") String username, @Param("passWord") String password);

}
