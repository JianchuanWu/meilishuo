package org.meilishuo.mdservice;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.Criterion;
import org.meilishuo.interfaces.DAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public class ModelService_old {

	public static final String GOODSINFO = "goodsInfoDAO";
	

	@Resource(name = "daoMap")
	private Map<String, DAO> daoMap;

	public Map<String, DAO> getDaoMap() {
		return daoMap;
	}

	public void setDaoMap(Map<String, DAO> daoMap) {
		this.daoMap = daoMap;
	}

	// ----------------以下是根据DAO 相关实现 进行的基础操作方法封装--------------------
	/**
	 * 获取指定表格所有信息
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @return 封装有相关信息实体类对象的List
	 */
	public List getAll(String key) {
		return this.daoMap.get(key).getAll();
	}

	/**
	 * 返回指定信息
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @param id
	 *            主键编号
	 * @return 封装有相关数据的实体类对象
	 */
	public Object getInfoByID(String key, Serializable id) {
		return this.daoMap.get(key).getByID(id);
	}

	/**
	 * 根据提供的条件做相应的查询获取信息的方法，并可以指定分页操作
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @param pagetNum
	 *            指定页面编号
	 * @param rowCount
	 *            单页显示信息行数
	 * @param criterions
	 *            查询条件
	 * @return 封装有相关信息实体类对象的List
	 */
	public List getInfoByProperties(String key, Integer pagetNum,
			Integer rowCount, Criterion... criterions) {
		return this.daoMap.get(key).getInfoesByPage(pagetNum, rowCount,
				criterions);
	}

	/**
	 * 根据提供的条件做相应的查询获取信息的方法
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @param criterions
	 *            查询条件
	 * @return 封装有相关信息实体类对象的List
	 */
	public List getInfoByProperties(String key, Criterion... criterions) {
		return this.daoMap.get(key).getInfoesByProperties(criterions);
	}

	/**
	 * 对指定表格进行批量数据添加的方法
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @param entities
	 *            根据hibernate规范和业务需要封装有相关数据的实体类对象
	 */
	public void insert_batch(String key, Object... entities) {
		this.daoMap.get(key).execute_insert(entities);
	}

	/**
	 * 对指定表格进行批量数据删除的方法
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @param entities
	 *            根据hibernate规范和业务需要封装有相关数据的实体类对象
	 */
	public void delete_batch(String key, Object... entities) {
		this.daoMap.get(key).execute_delete(entities);
	}

	/**
	 * 对指定表格进行批量数据更新的方法
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @param entities
	 *            根据hibernate规范和业务需要封装有相关数据的实体类对象
	 */
	public void update_batch(String key, Object... entities) {
		this.daoMap.get(key).execute_update(entities);
	}

	/**
	 * 根据每页行数得到指定表格信息可以分成的页数
	 * 
	 * @param type
	 *            指定表格
	 * @param rowCount
	 *            指定每页行数
	 * @return 可以分页数的数量
	 */
	public int getPageCount(String type, int rowCount) {
		return this.daoMap.get(type).getPageCountByRowCount(rowCount);
	}

	// ----------------以下是根据DAO 相关实现 进行的业务需要方法--------------------

	/**
	 * 根据分页操作获取指定信息
	 * 
	 * @param type
	 *            指定表格
	 * @param pageNum
	 *            指定页码
	 * @param rowCount
	 *            指定每页显示行数
	 * @return 查询结果
	 */
	public List getInfoByPageNum(String type, int pageNum, int rowCount) {
		return this.getInfoByProperties(type, pageNum, rowCount);
	}

	

}
