package cn.zcw.bean;

public class Member {

    private Integer id;

    private String loginacct;

    private String userpswd;

    private String username;

    private String email;

    private String authstatus;

    private String usertype;

    private String realname;

    private String cardnum;

    private String accttype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginacct() {
        return loginacct;
    }

    public void setLoginacct(String loginacct) {
        this.loginacct = loginacct == null ? null : loginacct.trim();
    }

    public String getUserpswd() {
        return userpswd;
    }

    public void setUserpswd(String userpswd) {
        this.userpswd = userpswd == null ? null : userpswd.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.authstatus
     *
     * @return the value of t_member.authstatus
     *
     * @mbggenerated
     */
    public String getAuthstatus() {
        return authstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.authstatus
     *
     * @param authstatus the value for t_member.authstatus
     *
     * @mbggenerated
     */
    public void setAuthstatus(String authstatus) {
        this.authstatus = authstatus == null ? null : authstatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.usertype
     *
     * @return the value of t_member.usertype
     *
     * @mbggenerated
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.usertype
     *
     * @param usertype the value for t_member.usertype
     *
     * @mbggenerated
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.realname
     *
     * @return the value of t_member.realname
     *
     * @mbggenerated
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.realname
     *
     * @param realname the value for t_member.realname
     *
     * @mbggenerated
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.cardnum
     *
     * @return the value of t_member.cardnum
     *
     * @mbggenerated
     */
    public String getCardnum() {
        return cardnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.cardnum
     *
     * @param cardnum the value for t_member.cardnum
     *
     * @mbggenerated
     */
    public void setCardnum(String cardnum) {
        this.cardnum = cardnum == null ? null : cardnum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.accttype
     *
     * @return the value of t_member.accttype
     *
     * @mbggenerated
     */
    public String getAccttype() {
        return accttype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.accttype
     *
     * @param accttype the value for t_member.accttype
     *
     * @mbggenerated
     */
    public void setAccttype(String accttype) {
        this.accttype = accttype == null ? null : accttype.trim();
    }
}