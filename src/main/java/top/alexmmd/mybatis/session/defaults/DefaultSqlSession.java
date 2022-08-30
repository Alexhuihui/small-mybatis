package top.alexmmd.mybatis.session.defaults;

import top.alexmmd.mybatis.binding.MapperRegistry;
import top.alexmmd.mybatis.mapping.MappedStatement;
import top.alexmmd.mybatis.session.Configuration;
import top.alexmmd.mybatis.session.SqlSession;

/**默认SqlSession实现类
 * @author wangyonghui
 * @date 2022年08月29日 19:07:00
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
