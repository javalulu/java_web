package com.americano;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void testGetGender_Male() {
        String gender = userService.getGender("110101199003071234");
        Assertions.assertEquals("男", gender);
    }

    @Test
    void testGetGender_Female() {
        String gender = userService.getGender("110101199003074321");
        Assertions.assertEquals("女", gender);
    }

    @Test
    void testGetGender_NullInput() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> userService.getGender(null));
    }

    @Test
    void testGetGender_InvalidLength() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> userService.getGender("1234567890"));
    }

    @Test
    public void testGetAge() {
        UserService userService = new UserService();
        Integer age = userService.getAge("210106200401011819");
        System.out.println(age);
    }

    @Test
    public void testGetGender() {
        UserService userService = new UserService();
        String gender = userService.getGender("210106200401011819");
        System.out.println(gender);
    }

    @Test
    public void testGetGenderWithAssert() {
        UserService userService = new UserService();
        String gender = userService.getGender("210106200401011819");
        Assertions.assertEquals("男", gender, "性别获取逻辑有问题");
    }

    @Test
    public void testGetGenderWithAssert2() {
        UserService userService = new UserService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender(null));
    }

}
