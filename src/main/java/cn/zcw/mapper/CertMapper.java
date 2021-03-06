package cn.zcw.mapper;

import cn.zcw.bean.Cert;
import cn.zcw.bean.CertExample;
import cn.zcw.bean.Datas;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CertMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cert
     *
     * @mbggenerated
     */
    int countByExample(CertExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cert
     *
     * @mbggenerated
     */
    int deleteByExample(CertExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cert
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cert
     *
     * @mbggenerated
     */
    int insert(Cert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cert
     *
     * @mbggenerated
     */
    int insertSelective(Cert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cert
     *
     * @mbggenerated
     */
    List<Cert> selectByExample(CertExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cert
     *
     * @mbggenerated
     */
    Cert selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cert
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Cert record, @Param("example") CertExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cert
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Cert record, @Param("example") CertExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cert
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Cert record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cert
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Cert record);

	int deletes(Datas ds);
}