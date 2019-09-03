package cn.zcw.mapper;

import cn.zcw.bean.User_role;
import cn.zcw.bean.User_roleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface User_roleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int countByExample(User_roleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int deleteByExample(User_roleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int insert(User_role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int insertSelective(User_role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    List<User_role> selectByExample(User_roleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    User_role selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") User_role record, @Param("example") User_roleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") User_role record, @Param("example") User_roleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(User_role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(User_role record);
}