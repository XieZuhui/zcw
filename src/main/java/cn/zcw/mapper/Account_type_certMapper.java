package cn.zcw.mapper;

import cn.zcw.bean.Account_type_cert;
import cn.zcw.bean.Account_type_certExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Account_type_certMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_type_cert
     *
     * @mbggenerated
     */
    int countByExample(Account_type_certExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_type_cert
     *
     * @mbggenerated
     */
    int deleteByExample(Account_type_certExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_type_cert
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_type_cert
     *
     * @mbggenerated
     */
    int insert(Account_type_cert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_type_cert
     *
     * @mbggenerated
     */
    int insertSelective(Account_type_cert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_type_cert
     *
     * @mbggenerated
     */
    List<Account_type_cert> selectByExample(Account_type_certExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_type_cert
     *
     * @mbggenerated
     */
    Account_type_cert selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_type_cert
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Account_type_cert record, @Param("example") Account_type_certExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_type_cert
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Account_type_cert record, @Param("example") Account_type_certExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_type_cert
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Account_type_cert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account_type_cert
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Account_type_cert record);
}