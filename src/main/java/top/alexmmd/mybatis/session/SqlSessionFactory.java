package top.alexmmd.mybatis.session;

/**
 * 工厂模式接口，构建SqlSession的工厂
 *
 * @author wangyonghui
 * @date 2022年08月29日 19:07:00
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     *
     * @return SqlSession
     */
    SqlSession openSession();

}
