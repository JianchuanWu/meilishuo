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
	 * @throws UnsupportedEncodingException **/
	@Action(value="getInfoes")
	public String showGoodsInfoes() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, UnsupportedEncodingException{
		
		
		if(typeinfo!=null){
			typeinfo=(Typeinfo) getService().getInfoByID(getService().TYPEINFO, typeinfo.getTpid());
			System.out.println(typeinfo.getTpname());
			System.out.println(typeinfo.getSpecificationses());
		}
		
		
		if(1>0)
			return null;
		
		
		
		//�����ռ����ѡ�������  ��session�������ȡ------>�������
		Map<String, List> items = (Map<String, List>) ActionContext.getContext().getSession().get("items");
		
		
		//���������������ݿ���ȡ��ع������
		if(items==null){
//			List list_typeinfo = new ItemList("Tpid", "Tpname", "typeinfo.tpid", getService().getInfoByProperties(ModelService.TYPEINFO, Restrictions.eq("tpparentid", 1)));
//			List list_clothingSize = new ItemList("Csid", "Csname", "csid", getService().getInfoByProperties(ModelService.CLOTHINGSIZE, Restrictions.eq("tpid", 1)));
//			List list_clothingCollat = new ItemList("Ccid", "Cctext", "ccid", getService().getInfoByProperties(ModelService.CLOTHINGCOLAR, Restrictions.eq("tpid", 1)));
//			List list_clothingTypeversion = new ItemList("Ctid", "Cttext", "ctid", getService().getInfoByProperties(ModelService.CLOTHINGTYPEVERSION, Restrictions.eq("tpid", 1)));
//			List list_clothingElement = new ItemList("Ceid", "Cetext", "ceid", getService().getInfoByProperties(ModelService.CLOTHINGELEMENT, Restrictions.eq("tpid", 1)));
//			
//			items = new LinkedHashMap<String, List>();
//			
//			items.put("��Ŀ", list_typeinfo);
//			items.put("����", list_clothingTypeversion);
//			items.put("�³�", list_clothingSize);
//			items.put("����", list_clothingCollat);
//			items.put("Ԫ��", list_clothingElement);
//			
//			ActionContext.getContext().getSession().put("items", items);
//			
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
		if(this.critera_propertyname != null || critera_propertyname_remove != null){
			
			Map criteriaMap = (Map) ActionContext.getContext().getSession().get("criteriaMap");
			if(criteriaMap == null){
				criteriaMap = new LinkedHashMap();
				ActionContext.getContext().getSession().put("criteriaMap",criteriaMap);
				
			}
			criteriaMap.put(critera_propertyname, new Integer(critera_propertyvalue));
			criterion = Restrictions.allEq(criteriaMap);
		}
		else if(critera_propertyname_remove != null){
			Map criteriaMap = (Map) ActionContext.getContext().getSession().get("criteriaMap");
			
			criteriaMap.remove(critera_propertyname_remove);
			criterion = Restrictions.allEq(criteriaMap);
			
			if(criteriaMap.size() == 0){
				List<Typeinfo> types = getService().getInfoByProperties(getService().TYPEINFO, Restrictions.eq("tpparentid", 1));
				
				criterion = Restrictions.in("typeinfo", types);
			}
		}else{
			List<Typeinfo> types = getService().getInfoByProperties(getService().TYPEINFO, Restrictions.eq("tpparentid", 1));
			
			criterion = Restrictions.in("typeinfo", types);
		}
		
		List<Goodsinfo> infoes = getService().getInfoByProperties(getService().GOODSINFO, criterion);
		
		Map<String, Object> map = (Map<String, Object>) ActionContext.getContext().get("request");
		
		map.put("infoes", infoes);
		
		
		
		return "infoes";
	}
	
	
	
	
	/**============================================================================**/
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
