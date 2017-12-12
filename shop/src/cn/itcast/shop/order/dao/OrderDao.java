package cn.itcast.shop.order.dao;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.order.vo.Order;
import cn.itcast.shop.order.vo.OrderItem;
import cn.itcast.shop.utils.PageHibernateCallback;

public class OrderDao extends HibernateDaoSupport {

	// Dao层的保存订单额操作
	public void save(Order order) {
		String orderTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrdertime());
		String saveOrder = "insert into orders (total, ordertime, state, name, phone, addr, uid) values ('" + order.getTotal() + "', '" + 
								orderTime + "', '" + order.getState() + "', '', '', '', '" + order.getUser().getUid() + "')";
		this.getSessionFactory().getCurrentSession().createSQLQuery(saveOrder).executeUpdate();
		Order o = (Order) this.getSessionFactory().getCurrentSession().createSQLQuery("SELECT * FROM orders WHERE oid = (SELECT MAX(oid) FROM orders)").addEntity(Order.class).uniqueResult();
		Set<OrderItem> set = order.getOrderItems();
		String sql;
		for(OrderItem orderItem:set) {
			System.out.println(orderItem.toString());
			sql = "INSERT INTO `orderitem` (count, subtotal, pid , oid) VALUES ('" + orderItem.getCount() + "', '" + orderItem.getSubtotal() + "', '" + 
						orderItem.getProduct().getPid() + "', '" + o.getOid() + "');";
			this.getSessionFactory().getCurrentSession().createSQLQuery(sql).executeUpdate();
		}
//		this.getHibernateTemplate().save(order);
	}

	// Dao层查询我的订单分页查询:统计个数
	public int findCountByUid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.uid = ? and o.state != 0";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// Dao层查询我的订单分页查询:查询数据
	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		String hql = "from Order o where o.user.uid = ? and o.state != 0 order by o.ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql, new Object[] { uid },
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// DAO层根据订单id查询订单
	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	// DAO层修改订单的方法:
	public void update(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);
	}

	// DAO中统计订单个数的方法
	public int findCount() {
		String hql = "select count(*) from Order";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// DAO中分页查询订单的方法
	public List<Order> findByPage(int begin, int limit) {
		String hql = "from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql, null, begin, limit));
		return list;
	}

	// DAo中根据订单id查询订单项
	public List<OrderItem> findOrderItem(Integer oid) {
		String hql = "from OrderItem oi where oi.order.oid = ?";
		List<OrderItem> list = this.getHibernateTemplate().find(hql, oid);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public Integer getSaveOrderId(Integer uid) {
		String sql = "SELECT * FROM orders WHERE oid = (SELECT MAX(oid) FROM orders) and uid = " + uid;
		Order order = (Order) this.getSessionFactory().getCurrentSession().createSQLQuery(sql).addEntity(Order.class).uniqueResult();
		return order.getOid();
	}

}
