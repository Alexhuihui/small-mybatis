package top.alexmmd.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;
import top.alexmmd.mybatis.session.SqlSession;

/**
 * @author wangyonghui
 * @date 2022年08月29日 16:17:00
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
