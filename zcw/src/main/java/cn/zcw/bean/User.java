package cn.zcw.bean;

public class User {

    private Integer id;

    private String loginacct;

    private String userpswd;

    private String username;

    private String email;

    private String createtime;

    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.loginacct
     *
     * @return the value of t_user.loginacct
     *
     * @mbggenerated
     */
    public String getLoginacct() {
        return loginacct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.loginacct
     *
     * @param loginacct the value for t_user.loginacct
     *
     * @mbggenerated
     */
    public void setLoginacct(String loginacct) {
        this.loginacct = loginacct == null ? null : loginacct.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.userpswd
     *
     * @return the value of t_user.userpswd
     *
     * @mbggenerated
     */
    public String getUserpswd() {
        return userpswd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.userpswd
     *
     * @param userpswd the value for t_user.userpswd
     *
     * @mbggenerated
     */
    public void setUserpswd(String userpswd) {
        this.userpswd = userpswd == null ? null : userpswd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.username
     *
     * @return the value of t_user.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.username
     *
     * @param username the value for t_user.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.email
     *
     * @return the value of t_user.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.email
     *
     * @param email the value for t_user.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.createtime
     *
     * @return the value of t_user.createtime
     *
     * @mbggenerated
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.createtime
     *
     * @param createtime the value for t_user.createtime
     *
     * @mbggenerated
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}