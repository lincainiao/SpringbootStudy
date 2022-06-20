package com.lin.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
// 如果不配置，直接使用这个注解，会报红。
// 参数表示和yaml中的person绑定起来
@ConfigurationProperties(prefix = "person")

// 绑定目标配置文件
//@PropertySource(value = "classpath:application.properties")

// 数据校验
@Validated
public class Person {

    // SPEL表达式
//    @Value("${name}")

//    @Email()
    private String name;
    private int age;
    private Boolean like;
    private Date birth;
    private Map<String,Object> map;
    private List<Object> list;
    private Girl girl;

    public Person() {
    }

    public Person(String name, int age, Boolean like, Date birth, Map<String, Object> map, List<Object> list, Girl girl) {
        this.name = name;
        this.age = age;
        this.like = like;
        this.birth = birth;
        this.map = map;
        this.list = list;
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", like=" + like +
                ", birth=" + birth +
                ", map=" + map +
                ", list=" + list +
                ", girl=" + girl +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }
}
