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
        department.list(2)
                .then().statusCode(200)
                .body("errcode",equalTo(0),"department.name[1]",equalTo("空气猫"));
        department.list(6)
                .then().statusCode(200)
                .body("errcode",equalTo(0),"department[0].id",equalTo(6));
    }

    @Test
    void create() {
        department.create("Jiizuketest_03212", 5).then().body("errcode", equalTo(0));
        department.create("Jiizuketest_03213", 5).then().body("errcode", equalTo(0));
    }

    @Test
    void update() {
        department.update(8, "songjiangyanfa05").then().body("errcode", equalTo(0));
        department.update(8, 6).then().body("errcode", equalTo(0));
        department.update(100, "keji01", 3).then().body("errcode", equalTo(0));
    }

    @Test
    void delete() {
        department.delete(8).then().body("errcode",equalTo(0));
    }

    @Test
    void createUpdateDelete(){
        department.create("Testapi0001",12).then().body("errcode", equalTo(0));
        Integer id = department.list(12)
                .path("department.find{department -> department.name == \"Testapi0001\"}.id");
        department.update(id,"Testapi1001",12).then().body("errcode", equalTo(0));
//        department.delete(id).then().body("errcode", equalTo(0));
//        System.out.println(id.getClass());
//        System.out.println(id);
    }
}