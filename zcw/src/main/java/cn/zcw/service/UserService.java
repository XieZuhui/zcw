package cn.zcw.service;

import cn.zcw.bean.Datas;
import cn.zcw.bean.Member;
import cn.zcw.bean.Permission;
import cn.zcw.bean.User;
import cn.zcw.util.PageBean;

import java.util.List;
import java.util.Map;

public interface UserService {

    int regist(Member member);
    int validate(String validateCode);
    List<User> doUserLogin(User user);
    List<Member> doMemberLogin(Member member);
    PageBean<User> getUserList(String querytext,Integer pageno, Integer pageSize);

    int regSelect(String loginacct);

    void registMore(String validateCode);

    int getBackSendMail(String loginacct);

    Member getMemberByValidateCode(String validateCode);

    int updateMemberPwd(Member member);
    
    int insert(User user);
	User queryById(Integer id);
	int update(User user);
	int delete(Integer id);
	int deletes(Datas ds);
	int insertUserRoles(Map<String, Object> maps);
	int deleteUserRoles(Map<String, Object> maps);
	List<Integer> queryRoleidsByUserid(Integer id);
	List<Permission> queryPermissionsByUserid(Integer id);
}
