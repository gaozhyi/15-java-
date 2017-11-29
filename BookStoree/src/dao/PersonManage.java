package dao;

import java.util.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.*;

public class PersonManage extends HibernateDaoSupport {

	//管理员登录验证
	@SuppressWarnings("unchecked")
	public boolean checkManager(String managerName,String managerPassword){
		boolean flag = false;
		String hql = "from Manager as manager where manager.managerName = '"+managerName+"' and manager.managerPassword = '"+managerPassword+"'";
		List<Manager> managerList = this.getHibernateTemplate().find(hql);
		if(managerList.size()>0){
			flag = true;
		}
		return flag;
	}
	
	//获取用户信息
	public User findUser(int userId){
		try{
			User user = (User)this.getHibernateTemplate().get("entity.User", userId);
			return user;
		}catch(RuntimeException re){
			throw re;
		}
	}
	
	//普通用户登录验证
	@SuppressWarnings("unchecked")
	public User checkUser(String userName,String userPassword){
		String hql = "from User as user where user.userName = '"+userName+"' and user.userPassword = '"+userPassword+"'";
		User user = null;
		try{
			List<User> userList = this.getHibernateTemplate().find(hql);
			if(userList.size() > 0){
				user = new User();
				user = userList.get(0);
			}
		}catch(RuntimeException re){
			throw re;
		}
		return user;
	}
	//检查注册用户名是否已经存在
	@SuppressWarnings("unchecked")
	public boolean isUserNameExist(String userName){
		boolean flag = true;
		String hql = "from User as user where user.userName = '"+userName+"'";
		try{
			List<User> userList= this.getHibernateTemplate().find(hql);
			if(userList.size() == 0){
				flag = false;
			}
			return flag;
		}catch (RuntimeException re) {
			throw re;
		}
	}
	//添加一条用户信息
	public int addUser(User user){
		int i = 0;
		try{
			this.getHibernateTemplate().save(user);
			i = 1;
		}catch(RuntimeException re){
			throw re;
		}
		return i ;
	}
	//修改一条用户信息
	public int updateUserInfor(User user){
		int i = 0;
		try{
			this.getHibernateTemplate().update(user);
			i = 1;
		}catch (RuntimeException re) {
			throw re;
		}
		return i;
	}
	//根据sexId查询Sex
	public Sex findSex(int sexId){
		try{
			Sex sex = (Sex)this.getHibernateTemplate().get("entity.Sex", sexId);
			return sex;
		}catch (RuntimeException re) {
			throw re;
		}
	}
}
