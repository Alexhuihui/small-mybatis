package top.alexmmd.mybatis.session.defaults;

import top.alexmmd.mybatis.binding.MapperRegistry;
import top.alexmmd.mybatis.session.Configuration;
import top.alexmmd.mybatis.session.SqlSession;
import top.alexmmd.mybatis.session.SqlSessionFactory;

/**
 * 默认的 DefaultSqlSessionFactory
 *
 * @author wangyonghui
 * @date 2022年08月29日 19:07:00
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}
