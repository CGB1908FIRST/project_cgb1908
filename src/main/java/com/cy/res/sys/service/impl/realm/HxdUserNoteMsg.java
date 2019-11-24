package com.cy.res.sys.service.impl.realm;

import org.springframework.stereotype.Service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.cy.res.sys.utils.getSixNumUtil;
@Service
public class HxdUserNoteMsg {
	/**发送短信*/
	public String SendMsg(String mobile){
		String result = getSixNumUtil.getSixNum();
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FhrHRJxrS3oJTLoCywV", "BfB052xEfSrfqkUXLWM4JjHqBjWzMS");
		IAcsClient client = new DefaultAcsClient(profile);
		CommonRequest request = new CommonRequest();
		request.setMethod(MethodType.POST);
		request.setDomain("dysmsapi.aliyuncs.com");
		request.setVersion("2017-05-25");
		request.setAction("SendSms");
		request.putQueryParameter("RegionId", "cn-hangzhou");
		request.putQueryParameter("PhoneNumbers", mobile);
		request.putQueryParameter("SignName", "马季西裤瓦");
		request.putQueryParameter("TemplateCode", "SMS_177541904");
		request.putQueryParameter("TemplateParam","{\"code\":\""+result+"\"}");//
		
        try {
			CommonResponse response = client.getCommonResponse(request);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
        
		return result;
	}
}
