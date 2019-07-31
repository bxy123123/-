package com.cc.realm;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import com.cc.entity.User;
import com.cc.exception.AccountDiscontinuedException;
import com.cc.exception.CaptchaEmptyException;
import com.cc.exception.CaptchaErrorException;
import com.cc.service.LoginService;
import com.cc.util.CaptchaToken;

public class LoginRealm extends AuthorizingRealm {

	@Resource
	private LoginService ls;

	/**
	 * ��֤
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
				//�ȶ��˺ź������Ƿ���ȷ
				//1.��AuthenticationToken����ת����UsernamePasswordToken����
				CaptchaToken captchaToken = (CaptchaToken) token;
				//��ȡ�û��ڵ�¼ҳ��������˺�
				String number=captchaToken.getUsername();
				// ��ȡ�û��ڵ�¼ҳ���������֤��
			    String loginCaptcha = captchaToken.getCaptchaCode();
			    //��session��ȡ����֤��
				String imgCode=(String) SecurityUtils.getSubject().getSession().getAttribute("imageCode");
			    // ��֤��δ����
			    if (loginCaptcha == null || "".equals(loginCaptcha)) {
			        // �׳��Զ����쳣(�̳�AuthenticationException), Shiro�Ჶ��AuthenticationException�쳣
			        // ���ָ��쳣ʱ��Ϊ��¼ʧ��,ִ�е�¼ʧ���߼�,��¼ʧ��ҳ�п����ж������CaptchaEmptyExceptionʱΪ��֤��Ϊ��
			        throw new CaptchaEmptyException();
			    }
			     // �Ƚϵ�¼�������֤���SESSION�������֤���Ƿ�һ��
			        if (!loginCaptcha.equalsIgnoreCase(imgCode)) {
			            // �׳��Զ����쳣(�̳�AuthenticationException), Shiro�Ჶ��AuthenticationException�쳣
			            // ���ָ��쳣ʱ��Ϊ��¼ʧ��,ִ�е�¼ʧ���߼�,��¼ʧ��ҳ�п����ж������CaptchaEmptyExceptionʱΪ��֤�����
			            throw new CaptchaErrorException("��֤������!");
			        }
				//��service�е��÷���,��ø��û�����Ϣ
				User user = ls.checkLogin(number);
				
				//�ж��˺��Ƿ�ͣ��
					if(user.getUser_status()==1){
						 throw new AccountDiscontinuedException("���˺��ѱ�ͣ��!");
					}
				//��ֵ����
				ByteSource salt=ByteSource.Util.bytes(number);
				//�Զ��������ȶ�
				SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(number,user.getUser_pwd(),salt,getName());
				SecurityUtils.getSubject().getSession().setAttribute("User", user);
				return info; 
	}

	public static void main(String[] args) {
		String algorithmName="MD5";
		Object source="123456";
		Object salt=ByteSource.Util.bytes("18255944522");
		int a=1024;
		Object result=new SimpleHash(algorithmName, source,salt,a);
		System.out.println(result);
	}
	
	/**
	 * ��Ȩ
	 */
		@Override
		protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
			//1.��PrincipalCollection��ȡ��¼�û�����Ϣ
			//User username = (User) principals.getPrimaryPrincipal();
			User user = (User) SecurityUtils.getSubject().getSession().getAttribute("User");
			String role_id =String.valueOf(user.getRole_id());
			//2.���õ�¼���û���Ϣ���鿱�����û��Ľ�ɫ��Ȩ��(�п���Ҫ�����ݿ��в�ѯ)
			Set<String> Set = new HashSet<String>();
			Set.add(role_id);
			//3.����SimpleAuthorizationInfo,���������ɫ��Ȩ��
			SimpleAuthorizationInfo sai=new SimpleAuthorizationInfo(Set);
			//sai.setStringPermissions(Set);
			//4.����SimpleAuthorizationInfo����
			return sai;
		}
}
