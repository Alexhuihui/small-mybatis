package top.alexmmd.mybatis.builder;

import top.alexmmd.mybatis.session.Configuration;

/**
 * @author wangyonghui
 * @date 2022年08月30日 09:04:00
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
