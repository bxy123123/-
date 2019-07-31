package com.cc.controller.login;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.exception.AccountDiscontinuedException;
import com.cc.exception.CaptchaErrorException;
import com.cc.util.CaptchaToken;
import com.cc.util.ImageUtil;
import com.cc.util.NoteResult;


@Controller
public class LoginController {
	
	
	/**
	 * 进入登录页面
	 * @return
	 */
	@RequestMapping("Login.do")
	public String Login(){
		return "login/login";
	}
	
	/**
	 * 验证登录
	 * @return
	 */
	@RequestMapping("CheckLogin.do")
	@ResponseBody
	public NoteResult CheckLogin(String number,String password,String code){
		//获取Subject对象
		Subject currentUser=SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()){
			//在没有被验证的情况下，需要获取账号和密码与后台的数据进行匹配
			CaptchaToken token=new CaptchaToken(number,password,code);
			try {
	                currentUser.login(token);
	            }catch (IncorrectCredentialsException ice) {
	                throw new IncorrectCredentialsException("密码错误!");
	            }catch (UnknownAccountException i) {
	                throw new UnknownAccountException("账号错误！");
	            }catch (CaptchaErrorException i) {
	                throw new CaptchaErrorException("验证码错误!");
	            }catch (AccountDiscontinuedException i) {
	                throw new AccountDiscontinuedException("该账号已被停用!");
	            }     
	            catch (AuthenticationException ae) {
	            	System.out.println("登录失败"+ae.getMessage());
	            }
	        }
		
		return new NoteResult();
	}
	
	/**
	 * 生成验证码
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	@RequestMapping("/createImg.do")
	public void createImg(HttpServletRequest req,HttpServletResponse res) throws IOException{
		//创建验证码及图片
		Object[] object = ImageUtil.createImage();
		//先将验证码存入session
		SecurityUtils.getSubject().getSession().setAttribute("imageCode",object[0]);
		//再把图片输出给页面
		res.setContentType("image/png");
		OutputStream os=res.getOutputStream();
		ImageIO.write((BufferedImage)object[1], "png", os);
		os.close();
	}
}
