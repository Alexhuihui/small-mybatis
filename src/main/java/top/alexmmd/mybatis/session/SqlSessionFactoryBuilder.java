package top.alexmmd.mybatis.session;

import java.io.Reader;
import top.alexmmd.mybatis.builder.xml.XMLConfigBuilder;
import top.alexmmd.mybatis.session.defaults.DefaultSqlSessionFactory;

/**
 * 作为整个mybatis的入口 构建SqlSessionFactory的工厂
 *
 * @author wangyonghui
 * @date 2022年08月30日 09:07:00
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
