package cn.zcw.bean;

public class Member_cert {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member_cert.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member_cert.memberid
     *
     * @mbggenerated
     */
    private Integer memberid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member_cert.certid
     *
     * @mbggenerated
     */
    private Integer certid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member_cert.iconpath
     *
     * @mbggenerated
     */
    private String iconpath;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member_cert.id
     *
     * @return the value of t_member_cert.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member_cert.id
     *
     * @param id the value for t_member_cert.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member_cert.memberid
     *
     * @return the value of t_member_cert.memberid
     *
     * @mbggenerated
     */
    public Integer getMemberid() {
        return memberid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member_cert.memberid
     *
     * @param memberid the value for t_member_cert.memberid
     *
     * @mbggenerated
     */
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member_cert.certid
     *
     * @return the value of t_member_cert.certid
     *
     * @mbggenerated
     */
    public Integer getCertid() {
        return certid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member_cert.certid
     *
     * @param certid the value for t_member_cert.certid
     *
     * @mbggenerated
     */
    public void setCertid(Integer certid) {
        this.certid = certid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member_cert.iconpath
     *
     * @return the value of t_member_cert.iconpath
     *
     * @mbggenerated
     */
    public String getIconpath() {
        return iconpath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member_cert.iconpath
     *
     * @param iconpath the value for t_member_cert.iconpath
     *
     * @mbggenerated
     */
    public void setIconpath(String iconpath) {
        this.iconpath = iconpath == null ? null : iconpath.trim();
    }

    @Override
    public String toString() {
        return "Member_cert{" +
                "id=" + id +
                ", memberid=" + memberid +
                ", certid=" + certid +
                ", iconpath='" + iconpath + '\'' +
                '}';
    }
}