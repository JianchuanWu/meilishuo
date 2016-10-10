package org.meilishuo.webtool;

import java.io.Serializable;

/**
 * ItemList内部单项，以固定格式(id, text) 提取指定实体对象的相关数据
 * @author Administrator
 *
 */
public class Item {
	private Serializable id;
	private Serializable text;
	public Serializable getId() {
		return id;
	}
	public void setId(Serializable id) {
		this.id = id;
	}
	public Serializable getText() {
		return text;
	}
	public void setText(Serializable text) {
		this.text = text;
	}
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public Item(Object id, Object text) {
		this.id = (Serializable) id;
		this.text = (Serializable) text;
	}
	
}
