package cn.zcw.bean;

import cn.zcw.util.PageBean;

/**
 * ajax结果
 */
public class AJAXResult<T> {

    private boolean success;
    private PageBean<T> pageBean;
    private String username;

    public PageBean<T> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<T> pageBean) {
        this.pageBean = pageBean;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
