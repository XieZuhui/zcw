package cn.zcw.bean;

public class Project_member {

    public Project_member(Integer projectid, Integer memberid, String introduce, String particulars, String contacttel, String customertel) {
        this.projectid = projectid;
        this.memberid = memberid;
        this.introduce = introduce;
        this.particulars = particulars;
        this.contacttel = contacttel;
        this.customertel = customertel;
    }

    public Project_member() {
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_project_member.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_project_member.projectid
     *
     * @mbggenerated
     */
    private Integer projectid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_project_member.memberid
     *
     * @mbggenerated
     */
    private Integer memberid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_project_member.introduce
     *
     * @mbggenerated
     */
    private String introduce;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_project_member.particulars
     *
     * @mbggenerated
     */
    private String particulars;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_project_member.contactTel
     *
     * @mbggenerated
     */
    private String contacttel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_project_member.customerTel
     *
     * @mbggenerated
     */
    private String customertel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_project_member.id
     *
     * @return the value of t_project_member.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_project_member.id
     *
     * @param id the value for t_project_member.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_project_member.projectid
     *
     * @return the value of t_project_member.projectid
     *
     * @mbggenerated
     */
    public Integer getProjectid() {
        return projectid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_project_member.projectid
     *
     * @param projectid the value for t_project_member.projectid
     *
     * @mbggenerated
     */
    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_project_member.memberid
     *
     * @return the value of t_project_member.memberid
     *
     * @mbggenerated
     */
    public Integer getMemberid() {
        return memberid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_project_member.memberid
     *
     * @param memberid the value for t_project_member.memberid
     *
     * @mbggenerated
     */
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_project_member.introduce
     *
     * @return the value of t_project_member.introduce
     *
     * @mbggenerated
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_project_member.introduce
     *
     * @param introduce the value for t_project_member.introduce
     *
     * @mbggenerated
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_project_member.particulars
     *
     * @return the value of t_project_member.particulars
     *
     * @mbggenerated
     */
    public String getParticulars() {
        return particulars;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_project_member.particulars
     *
     * @param particulars the value for t_project_member.particulars
     *
     * @mbggenerated
     */
    public void setParticulars(String particulars) {
        this.particulars = particulars == null ? null : particulars.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_project_member.contactTel
     *
     * @return the value of t_project_member.contactTel
     *
     * @mbggenerated
     */
    public String getContacttel() {
        return contacttel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_project_member.contactTel
     *
     * @param contacttel the value for t_project_member.contactTel
     *
     * @mbggenerated
     */
    public void setContacttel(String contacttel) {
        this.contacttel = contacttel == null ? null : contacttel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_project_member.customerTel
     *
     * @return the value of t_project_member.customerTel
     *
     * @mbggenerated
     */
    public String getCustomertel() {
        return customertel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_project_member.customerTel
     *
     * @param customertel the value for t_project_member.customerTel
     *
     * @mbggenerated
     */
    public void setCustomertel(String customertel) {
        this.customertel = customertel == null ? null : customertel.trim();
    }
}