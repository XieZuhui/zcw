package cn.zcw.bean;

public class Member_address {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member_address.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member_address.memberid
     *
     * @mbggenerated
     */
    private Integer memberid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member_address.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member_address.id
     *
     * @return the value of t_member_address.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member_address.id
     *
     * @param id the value for t_member_address.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member_address.memberid
     *
     * @return the value of t_member_address.memberid
     *
     * @mbggenerated
     */
    public Integer getMemberid() {
        return memberid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member_address.memberid
     *
     * @param memberid the value for t_member_address.memberid
     *
     * @mbggenerated
     */
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member_address.address
     *
     * @return the value of t_member_address.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member_address.address
     *
     * @param address the value for t_member_address.address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}