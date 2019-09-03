package cn.zcw.mapper;

import cn.zcw.bean.Ticket;
import cn.zcw.bean.TicketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ticket
     *
     * @mbggenerated
     */
    int countByExample(TicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ticket
     *
     * @mbggenerated
     */
    int deleteByExample(TicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ticket
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ticket
     *
     * @mbggenerated
     */
    int insert(Ticket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ticket
     *
     * @mbggenerated
     */
    int insertSelective(Ticket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ticket
     *
     * @mbggenerated
     */
    List<Ticket> selectByExample(TicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ticket
     *
     * @mbggenerated
     */
    Ticket selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ticket
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Ticket record, @Param("example") TicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ticket
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Ticket record, @Param("example") TicketExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ticket
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Ticket record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ticket
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Ticket record);
}