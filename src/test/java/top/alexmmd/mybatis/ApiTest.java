package top.alexmmd.mybatis;


import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.alexmmd.mybatis.binding.MapperProxyFactory;
import top.alexmmd.mybatis.binding.MapperRegistry;
import top.alexmmd.mybatis.dao.IUserDao;
import top.alexmmd.mybatis.session.SqlSession;
import top.alexmmd.mybatis.session.SqlSessionFactory;
import top.alexmmd.mybatis.session.defaults.DefaultSqlSessionFactory;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("top.alexmmd.mybatis.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("1");
        logger.info("测试结果：{}", res);
    }

}
