package org.meilishuo.action;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.meilishuo.entity.Goodsinfo;
import org.meilishuo.entity.Typeinfo;
import org.meilishuo.mdservice.ModelService;
import org.meilishuo.webtool.ItemList;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Namespace(value = "/mls/crol/mainAction")
@ParentPackage("struts-default")
@Results(value = {
		@Result(name = "infoes", location = "/shangyi.jsp") 
		})
@Lazy(true)
public class MainAction extends BaseAction {
	//��ʾ���  key
	private String itemkey;
	//�ѱ�ѡ�й�� key
	private String itemkey_checked;
	
	//����ı�
	private String itemtext;
	
	
	//ɸѡ�������������ƣ�
	private String critera_propertyname;
	//ɸѡ����������ֵ��
	private String critera_propertyvalue;
	
	//��ȡ����ɸѡ�������������ƣ�
	private String critera_propertyname_remove;
	
	private Typeinfo typeinfo;
	
	
	
	@Resource(name="specificationMap")
	private Map<String, ItemList> specificationMap;
	
	
	
	
	public Typeinfo getTypeinfo() {
		return typeinfo;
	}
	public void setTypeinfo(Typeinfo typeinfo) {
		this.typeinfo = typeinfo;
	}
	public Map<String, ItemList> getSpecificationMap() {
		return specificationMap;
	}
	public void setSpecificationMap(Map<String, ItemList> specificationMap) {
		this.specificationMap = specificationMap;
	}
	public String getCritera_propertyname_remove() {
		return critera_propertyname_remove;
	}
	public void setCritera_propertyname_remove(String critera_propertyname_remove) {
		this.critera_propertyname_remove = critera_propertyname_remove;
	}
	public String getCritera_propertyvalue() {
		return critera_propertyvalue;
	}
	public void setCritera_propertyvalue(String critera_propertyvalue) {
		this.critera_propertyvalue = critera_propertyvalue;
	}
	public String getCritera_propertyname() {
		return critera_propertyname;
	}
	public void setCritera_propertyname(String critera_propertyname) {
		this.critera_propertyname = critera_propertyname;
	}
	public String getItemtext() {
		return itemtext;
	}
	public void setItemtext(String itemtext) {
		this.itemtext = itemtext;
	}
	public String getItemkey() {
		return itemkey;
	}
	public void setItemkey(String itemkey) {
		this.itemkey = itemkey;
	}

	public String getItemkey_checked() {
		return itemkey_checked;
	}
	public void setItemkey_checked(String itemkey_checked) {
		this.itemkey_checked = itemkey_checked;
	}




	/**===================================����=========================================
	 * @throws Exception **/
	@Action(value="getInfoes")
	public String showGoodsInfoes() throws Exception{
		
		//������Ʒ���ͣ�������Ʒ���͵ı�ţ���ȡ������Ʒ������Ϣ���������
		if(typeinfo!=null){
			typeinfo=(Typeinfo) getService().getInfoByID(getService().TYPEINFO, typeinfo.getTpid());
		}
		
		//��session�������д�����ͱ�ţ�������Ʒ�����л�ʹ���жϱȽ�
		if(!ActionContext.getContext().getSession().containsKey("tp_id")){
			ActionContext.getContext().getSession().put("tp_id", typeinfo.getTpid());
		}
		
		//ͨ��session����������ȷ��֮ǰ�����μ���֮ǰ��ʹ�õ���Ʒ����
		Integer tp_id = (Integer) ActionContext.getContext().getSession().get("tp_id");

		//������ε���Ʒ���ͱ�Ų�һ�£����������仯��Ҫ���session�����еĹ���Ա�����ͨ��springѡ��
		if(tp_id.intValue() != typeinfo.getTpid().intValue()){
			ActionContext.getContext().getSession().remove("items");
			ActionContext.getContext().getSession().remove("items_checked");
			
			tp_id = typeinfo.getTpid();
			
			ActionContext.getContext().getSession().put("tp_id", tp_id);
		}
		
		
		
		//�����ռ����ѡ�������  ��session�������ȡ------>�������
		Map<String, List> items = (Map<String, List>) ActionContext.getContext().getSession().get("items");
		
		
		//���������������ݿ���ȡ��ع������
		if(items==null){
			//��ȡ��Ʒ���������еĹ��
 			Map mp1 = typeinfo.getSpecificationses();
			
 			//ͨ����spring���map�ıȽϣ���ȡ���ݿ��й��ѡ�����Ϣ
			Set<String> keys = mp1.keySet();
			for (String key : keys) {
				
				ItemList l = specificationMap.get(key);
				
				//��ȡ�����Ϣ�ĸ���Ʒ�������
				List data = (List) l.invoke(typeinfo.getTpid()).clone();
				
				mp1.put(key, data);
				
				//ԭ�й��list������ɺ���Ҫ��գ��Ա��´�����ѡ��ʹ��
				l.clear();
			}
			
			//������Ʒ����Ĺ���б����session����
			ActionContext.getContext().getSession().put("items", mp1);
			
		}
		
		
		
		

		//�ռ� ��ѡ�Ĺ����ʾѡ�� ����������session�������ȡ------->��ѡ����
		Map<String, List> items_checked = (Map<String, List>) ActionContext.getContext().getSession().get("items_checked");
		
		//���  ��ѡ����   �������򴴽�
		if(items_checked==null){
			
			items_checked = new LinkedHashMap<String, List>();
			
			ActionContext.getContext().getSession().put("items_checked", items_checked);
			
		}
		
		//����������Ŀ�еĵ�������еĵ���ɽ�itemkey������   
		if(itemkey!=null){
			
			//��itemkey��value���뵽  ��ѡ����    ͬʱ��  �������  ��ɾ��
			items_checked.put(itemkey+":"+itemtext+","+critera_propertyname, items.remove(itemkey));
			
		}
		
		//���  ��ѡ���Ĺ�񣨰�ť��  
		if(itemkey_checked!=null){
			
			Set<String> keys = items_checked.keySet();
			
			for (String k : keys) {
				if(k.indexOf(itemkey_checked)!=-1){
					//������뵽  �������    ͬʱ��  ��ѡ����  ��ɾ��
					items.put(itemkey_checked, items_checked.remove(k));
					
					String ck = k.split(",")[1];
					Map mp = (Map) ActionContext.getContext().getSession().get("criteriaMap");
					mp.remove(ck);
					
					break;
				}
			}
			
		}
		
		
		//��������ɸѡ��Criterion
		Criterion criterion = null;
		
		//���ɸѡ��
		if(this.critera_propertyname != null){
			
			Map criteriaMap = (Map) ActionContext.getContext().getSession().get("criteriaMap");
			if(criteriaMap == null){
				criteriaMap = new LinkedHashMap();
				ActionContext.getContext().getSession().put("criteriaMap",criteriaMap);
				
			}
			criteriaMap.put(critera_propertyname, new Integer(critera_propertyvalue));
			criterion = Restrictions.allEq(criteriaMap);
		}
		//�Ƴ�ѡ��
		else if(critera_propertyname_remove != null){
			Map criteriaMap = (Map) ActionContext.getContext().getSession().get("criteriaMap");
			
			criteriaMap.remove(critera_propertyname_remove);
			criterion = Restrictions.allEq(criteriaMap);
			
			if(criteriaMap.size() == 0){
				List<Typeinfo> types = getService().getInfoByProperties(getService().TYPEINFO, Restrictions.eq("tpparentid", tp_id));
				
				criterion = Restrictions.in("typeinfo", types);
			}
		}
		//Ĭ����ɸѡ��
		else{
			List<Typeinfo> types = getService().getInfoByProperties(getService().TYPEINFO, Restrictions.eq("tpparentid", tp_id));
			
			criterion = Restrictions.in("typeinfo", types);
		}
		
		//����ѡ�е���Ϣ��ȡ��Ʒ
		List<Goodsinfo> infoes = getService().getInfoByProperties(getService().GOODSINFO, criterion);
		Map<String, Object> map = (Map<String, Object>) ActionContext.getContext().get("request");
		
		//ͨ�����������򴫵�����
		map.put("infoes", infoes);
		
		
		
		return "infoes";
	}
	
	
	
	
	/**============================================================================**/
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getBatch_list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
