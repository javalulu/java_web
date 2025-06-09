package com.americano;

import com.americano.mapper.UserMapper;
import com.americano.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // SpringBoot单元测试注解 - 当前测试类中的测试方法运行时，会启动springboot项目 -> 创建IOC容器
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void testDeleteById(){
        Integer i = userMapper.deleteById(4);
        System.out.println("执行完毕，影响的记录数： " + i);
    }

    @Test
    public void testInsert() {
        User user = new User(null, "gaoyuanyuan", "666888", "高圆圆",18);
        Integer i = userMapper.insert(user);
    }

    @Test
    public void testUpdate() {
        User user = new User(1, "zhouyu", "666888", "周瑜",25);
        Integer i = userMapper.update(user);
    }

    @Test
    public void testFindByUsernameAndPassword() {
        User user = userMapper.findByUsernameAndPassword("zhouyu", "666888");
        System.out.println(user);
    }


}
