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
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
				//比对账号和密码是否正确
				//1.把AuthenticationToken对象转换成UsernamePasswordToken对象
				CaptchaToken captchaToken = (CaptchaToken) token;
				//获取用户在登录页面输入的账号
				String number=captchaToken.getUsername();
				// 获取用户在登录页面输入的验证码
			    String loginCaptcha = captchaToken.getCaptchaCode();
			    //从session中取出验证码
				String imgCode=(String) SecurityUtils.getSubject().getSession().getAttribute("imageCode");
			    // 验证码未输入
			    if (loginCaptcha == null || "".equals(loginCaptcha)) {
			        // 抛出自定义异常(继承AuthenticationException), Shiro会捕获AuthenticationException异常
			        // 发现该异常时认为登录失败,执行登录失败逻辑,登录失败页中可以判断如果是CaptchaEmptyException时为验证码为空
			        throw new CaptchaEmptyException();
			    }
			     // 比较登录输入的验证码和SESSION保存的验证码是否一致
			        if (!loginCaptcha.equalsIgnoreCase(imgCode)) {
			            // 抛出自定义异常(继承AuthenticationException), Shiro会捕获AuthenticationException异常
			            // 发现该异常时认为登录失败,执行登录失败逻辑,登录失败页中可以判断如果是CaptchaEmptyException时为验证码错误
			            throw new CaptchaErrorException("验证码有误!");
			        }
				//从service中调用方法,获得该用户的信息
				User user = ls.checkLogin(number);
				
				//判断账号是否停用
					if(user.getUser_status()==1){
						 throw new AccountDiscontinuedException("该账号已被停用!");
					}
				//盐值加密
				ByteSource salt=ByteSource.Util.bytes(number);
				//自动完成密码比对
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
	 * 授权
	 */
		@Override
		protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
			//1.从PrincipalCollection获取登录用户的信息
			//User username = (User) principals.getPrimaryPrincipal();
			User user = (User) SecurityUtils.getSubject().getSession().getAttribute("User");
			String role_id =String.valueOf(user.getRole_id());
			//2.利用登录的用户信息来查勘车该用户的角色或权限(有可能要从数据库中查询)
			Set<String> Set = new HashSet<String>();
			Set.add(role_id);
			//3.创建SimpleAuthorizationInfo,并设置其角色的权限
			SimpleAuthorizationInfo sai=new SimpleAuthorizationInfo(Set);
			//sai.setStringPermissions(Set);
			//4.返回SimpleAuthorizationInfo对象
			return sai;
		}
}
