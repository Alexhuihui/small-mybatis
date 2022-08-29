package top.alexmmd.mybatis;


import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.alexmmd.mybatis.binding.MapperProxyFactory;
import top.alexmmd.mybatis.dao.IUserDao;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);

        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("top.alexmmd.mybatis.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("top.alexmmd.mybatis.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        IUserDao userDao = factory.newInstance(sqlSession);

        String toString = userDao.toString();
        System.out.println("toString = " + toString);

        String res = userDao.queryUserName("www");
        logger.info("测试结果：{}", res);
    }

}
