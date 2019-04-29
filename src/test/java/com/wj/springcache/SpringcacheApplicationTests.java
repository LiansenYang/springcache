package com.wj.springcache;

import com.wj.springcache.bean.Employee;
import com.wj.springcache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        Employee employee = employeeMapper.getEmpById(1);

        System.out.println(employee);

    }

    @Test
    public void test01(){
//        stringRedisTemplate.opsForValue().append("msg","hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//
//        System.out.println(msg);

        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");
    }

    @Test
    public void test02(){
        Employee empById = new Employee();

        redisTemplate.opsForValue().set("emp-01", empById);
    }
}
