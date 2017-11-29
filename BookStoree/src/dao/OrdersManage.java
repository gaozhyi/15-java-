package dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.*;
import entity.*;

public class OrdersManage extends HibernateDaoSupport{
	
	//查询所有订单
	@SuppressWarnings("unchecked")
	public List<Orders> allOrders(final int pageNumber,final int pageSize){
		List<Orders> allOrders = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from Orders as orders order by ordersTime desc";
				Query query = session.createQuery(hql);
				query.setFirstResult((pageNumber-1)*pageSize);
				query.setMaxResults(pageSize);
				List<Orders> list = query.list();
				return list;
			}
		});
		return allOrders;
	}
	
	//查询所有订单
	@SuppressWarnings("unchecked")
	public List<Orders> allOrdersByDeal(final String isDeal,final int pageNumber,final int pageSize){
		List<Orders> allOrders = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from Orders as orders where orders.isDeal = '"+isDeal+"' order by ordersTime desc";
				Query query = session.createQuery(hql);
				query.setFirstResult((pageNumber-1)*pageSize);
				query.setMaxResults(pageSize);
				List<Orders> list = query.list();
				return list;
			}
		});
		return allOrders;
	}

	//添加一个新的订单
	@SuppressWarnings("unchecked")
	public int addOrders(Orders orders){
		int i = 0;
		try{
			this.getHibernateTemplate().save(orders);
			String hql = "select max(ordersId) from Orders";
			List<Integer> idList = this.getHibernateTemplate().find(hql);
			if(idList.size()>0){
				i = idList.get(0);
			}
		}catch (RuntimeException re) {
			throw re;
		}
		return i ;
	}
	
	//删除一个订单
	public int deleteOrders(int ordersId){
		int i = 0;
		try{
			this.getHibernateTemplate().delete(this.getHibernateTemplate().get("entity.Orders", ordersId));
			i = 1;
		}catch(RuntimeException re){
			throw re;
		}
		return i ;
	}
	
	//修改订单
	public void updateOrders(Orders orders){
		try{
			this.getHibernateTemplate().update(orders);
		}catch(RuntimeException re){
			throw re;
		}
	}
	
	//根据ID查询订单
	public Orders findOrders(int ordersId){
		try{
			Orders orders = (Orders)this.getHibernateTemplate().get("entity.Orders", ordersId);
			return orders;
		}catch(RuntimeException re){
			throw re;
		}
	}
	
	//添加一条订单图书信息
	public void addOrdersbook(Ordersbook ordersbook){
		try{
			this.getHibernateTemplate().save(ordersbook);
		}catch (RuntimeException re) {
			throw re;
		}
	}
	
	//根据userId获取该用户所有订单
	@SuppressWarnings("unchecked")
	public List<Orders> allOrdersByUser(int userId,int pageNumber,int pageSize){
		String hql = "from Orders as orders where orders.user.userId="+userId+" order by ordersTime desc";
		try{
			List<Orders> allOrdersByUser = this.getHibernateTemplate().find(hql);
			return allOrdersByUser;
		}catch(RuntimeException re){
			throw re;
		}
	}
	//根据userId,订单处理状态获取该用户所有订单
	@SuppressWarnings("unchecked")
	public List<Orders> allOrdersByUserDeal(int userId,String isDeal,int pageNumber,int pageSize){
		String hql = "from Orders as orders where orders.user.userId="+userId+" and orders.isDeal='"+isDeal+"' order by ordersTime desc";
		try{
			List<Orders> allOrdersByUser = this.getHibernateTemplate().find(hql);
			return allOrdersByUser;
		}catch(RuntimeException re){
			throw re;
		}
	}
	
	//根据ordersId获取该订单所有订单图书
	@SuppressWarnings("unchecked")
	public List<Ordersbook> allOrdersbookByOrders(int ordersId){
		String hql = "from Ordersbook as ordersbook where ordersbook.orders.ordersId="+ordersId;
		try{
			List<Ordersbook> allOrdersbookByOrders = this.getHibernateTemplate().find(hql);
			return allOrdersbookByOrders;
		}catch(RuntimeException re){
			throw re;
		}
	}
	
	
}
