package top.alexmmd.mybatis;


import java.io.IOException;
import java.io.Reader;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.alexmmd.mybatis.dao.IUserDao;
import top.alexmmd.mybatis.io.Resources;
import top.alexmmd.mybatis.session.SqlSession;
import top.alexmmd.mybatis.session.SqlSessionFactory;
import top.alexmmd.mybatis.session.SqlSessionFactoryBuilder;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}", res);
    }
}
