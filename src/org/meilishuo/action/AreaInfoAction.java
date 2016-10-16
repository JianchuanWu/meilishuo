package org.meilishuo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.meilishuo.entity.Areainfo;
import org.meilishuo.entity.Goodsinfo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
/**
 * 用于地区数据获取的action
 * @author Administrator
 *
 */
@Controller
@Namespace(value = "/mls/crol/area")
@ParentPackage("struts-default")
@Results(value = {
		
		})
@Lazy(true)
public class AreaInfoAction extends BaseAction {
	
	private Integer aid;
	
	
	/**
	 * 获取二级城市信息
	 * @throws IOException
	 * @throws JSONException
	 */
	@Action(value="showCities")
	public void getCities() throws IOException, JSONException{
		HttpServletResponse respons = ServletActionContext.getResponse();
		respons.setCharacterEncoding("utf-8");
		
		JSONArray infoes = new JSONArray();
		Collection<Areainfo> cities = null;
		if(aid==1){
			cities = getService().getZhiZiaShi();
		}else{
			Areainfo pr = (Areainfo) getService().getInfoByID(getKey(), aid);
		 	cities = pr.getOwn_areas();
		}
		for (Areainfo a : cities) {
			JSONObject city = new JSONObject();
			city.put("aid", a.getAid());
			city.put("aname", a.getAname());
			infoes.put(city);
		}
		PrintWriter out = respons.getWriter();
		out.print(infoes.toString());
		out.flush();
		out.close();
	}
	
	
	/**
	 * 获取省级单位和直辖市信息
	 * @throws JSONException
	 * @throws IOException
	 */
	@Action(value="showAreas")
	public void getAreas() throws JSONException, IOException{
		
		HttpServletResponse respons = ServletActionContext.getResponse();
		respons.setCharacterEncoding("utf-8");
		
		JSONArray infoes = new JSONArray();
		JSONObject zxs = new JSONObject();
		zxs.put("aid", 1);
		zxs.put("aname", "直辖市");
		infoes.put(zxs);
		JSONArray provinces = new JSONArray();
		List<Areainfo> ps = getService().getProvince();
		for (Areainfo a : ps) {
			JSONObject p = new JSONObject();
			p.put("aid", a.getAid());
			p.put("aname", a.getAname());
			infoes.put(p);
		}
		PrintWriter out = respons.getWriter();
		out.print(infoes.toString());
		out.flush();
		out.close();
	}
	
	
	
	
	/**============================================================================**/
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return this.getService().AREAINFO;
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

	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}

	
}
