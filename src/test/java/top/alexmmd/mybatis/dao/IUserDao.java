package top.alexmmd.mybatis.dao;


/**
 * @author wangyonghui
 * @date 2022年08月29日 16:18:00
 */
public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);;
}
