package com.bigger.zxpjmall.wework.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    Department department;

    @BeforeEach
    void setUp() {
        if (department == null){
            department = new Department();
        }
    }

    @Test
    void list() {
        department.list("2")
                .then().statusCode(200)
                .body("errcode",equalTo(0),"department.name[1]",equalTo("空气猫"));
        department.list("6")
                .then().statusCode(200)
                .body("errcode",equalTo(0),"department[0].id",equalTo(6));
    }

    @Test
    void create() {
        department.create("Jiizuketest_03212", 5).then().body("errcode", equalTo(0));
        department.create("Jiizuketest_03213", 5).then().body("errcode", equalTo(0));
    }
}