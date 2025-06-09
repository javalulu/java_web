package com.americano.mapper;

import com.americano.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper // mybatis注解， 自动创建实现类对象（代理对象），并自动将该实现类对象存入IOC容器（bean)
public interface UserMapper {

    // @Select("select * from user") // 执行查询sql, (Insert, Update. Delete)
    public List<User> findAll();

//    @Delete("delete from user where id = #{id}") // #{id}: ?占位符->行参->预编译SQL; ${...}拼接符，直接将参数拼接，用于动态调整表名和字段名，不安全性能低，少用
//    public void deleteById(Integer id);

    @Delete("delete from user where id = #{id}") // 带Integer返回值，记录受影响的行数
    public Integer deleteById(Integer id);

    @Insert("insert into user(username,password,name,age) values(#{username}, #{password}, #{name}, #{age})") // 传入封装对象的属性名
    public Integer insert(User user); // 直接传入封装对象

    @Update("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id}")
    public Integer update(User user);

    @Select("select * from user where username=#{username} and password=#{password}")
    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password); // 需要加@Param因为有多个行参，编译后需要Sql语句需要知道哪个行参对应哪个占位符
//    如果是基于官方springboot骨架创建的项目，可以省略@Param，因为启用了maven compiler中的parameters，编译后的字节码文件会保留行参名称

}
