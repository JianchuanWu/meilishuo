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
import org.apache.struts2.convention.annotation.Results;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.meilishuo.entity.Userinfo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Namespace(value = "/mls/crol/log")
@Results(value = {
			
		})
@Lazy(true)
public class LogAction extends BaseAction {

	private String identifyKey;
	
	private Userinfo userinfo;
	
	
	
	/**
	 * �û���¼
	 * @throws IOException
	 */
	@Action(value="dologin")
	public void login() throws IOException{
		
		userinfo = getService().login(userinfo);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		
		//���ݿ������Ч
		if(userinfo!=null){
			//�û���Ч��������
			if(userinfo.getUflocked()!=1){
				out.print(-1);
			}
			//�û�״̬��������¼�ɹ�
			else{
				//���û���Ϣ��Ϊsession����������ԣ�attribute������
				ActionContext.getContext().getSession().put("activeUser", this.userinfo);
				out.print(1);
			}	
			
		}
		//�û�������Ч���û��������벻��ȷ��
		else{
			out.print(0);
		}
		
		out.flush();
		out.close();
	}
	
	

	/**
	 * �ж���֤���Ƿ���ȷ��
	 * @throws IOException
	 */
	@Action(value="isnormal")
	public void isNormal() throws IOException{
		
		Map<String, Object> sessionMap = ActionContext.getContext().getSession();
		Map<String, Integer> imgs = (Map<String, Integer>) sessionMap.get("identifyCode");
		
		Collection<Integer> values = imgs.values();
		int ok = 1;
		for (Integer value : values) {
			if(value != 360) {
				ok = 0;
				break;
			}
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.print(ok);
		out.flush();
		out.close();
	}
	
	
	
	
	/**
	 * ͨ��ҳ��������ajax������ʵ�־���ͼƬ�Ƕȵı仯
	 * @throws JSONException
	 * @throws IOException
	 */
	@Action(value="doIdentify")
	public void doIdentify() throws JSONException, IOException{
		Map<String, Object> sessionMap = ActionContext.getContext().getSession();
		Map<String, Integer> imgs = (Map<String, Integer>) sessionMap.get("identifyCode");
		
		if(imgs.containsKey(this.identifyKey)){
			int value = imgs.get(identifyKey);
			value+=90;
			if(value>360)
				value=90;
			imgs.put(identifyKey, value);
			
			JSONObject data = new JSONObject();
			data.put("key", this.identifyKey);
			data.put("value", value);
			
			
			HttpServletResponse response = ServletActionContext.getResponse();
			PrintWriter out = response.getWriter();
			out.print(data);
			out.flush();
			out.close();
		}
		
		
		
	}
	
	
	
	/**
	 * ��Ӧҳ��ajax���󣬷�����֤��ͼƬ�Լ�ͼƬtransform��ʼ���Ƕ���ֵ��json����
	 * @throws JSONException
	 * @throws IOException
	 */
	@Action(value="identify")
	public void getIdentifyCode() throws JSONException, IOException{
		Map<String, Integer> imgs = getService().getIdentifyCode();
		Map<String, Object> sessionMap = ActionContext.getContext().getSession();
		//����session�������Ա�֤�������ֱ��״̬�ȶ�
		sessionMap.put("identifyCode", imgs);
		
		JSONArray data = new JSONArray();
		Set<String> kesy = imgs.keySet();
		for (String key : kesy) {
			JSONObject img = new JSONObject();
			img.put("key", key);
			img.put("value", imgs.get(key));
			
			data.put(img);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
		out.close();
	}
	
	
	
	//==================================================================================
	
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
	
	public String getIdentifyKey() {
		return identifyKey;
	}
	public void setIdentifyKey(String identifyKey) {
		this.identifyKey = identifyKey;
	}
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	
}
