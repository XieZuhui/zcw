package cn.zcw.service;

import cn.zcw.bean.User;

public interface UserService {

    int regist(User user);
    int doLogin(User user);
}
