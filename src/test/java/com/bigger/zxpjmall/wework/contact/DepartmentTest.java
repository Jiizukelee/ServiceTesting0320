package com.bigger.zxpjmall.wework.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void list() {
        Department department = new Department();
        department.list("2")
                .then().statusCode(200)
                .body("errcode",equalTo(0),"department.name[1]",equalTo("空气猫"));
        department.list("6")
                .then().statusCode(200)
                .body("errcode",equalTo(0),"department.id",hasItem(6));
    }
}