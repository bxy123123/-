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
	 * �����¼ҳ��
	 * @return
	 */
	@RequestMapping("Login.do")
	public String Login(){
		return "login/login";
	}
	
	/**
	 * ��֤��¼
	 * @return
	 */
	@RequestMapping("CheckLogin.do")
	@ResponseBody
	public NoteResult CheckLogin(String number,String password,String code){
		//��ȡSubject����
		Subject currentUser=SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()){
			//��û�б���֤������£���Ҫ��ȡ�˺ź��������̨�����ݽ���ƥ��
			CaptchaToken token=new CaptchaToken(number,password,code);
			try {
	                currentUser.login(token);
	            }catch (IncorrectCredentialsException ice) {
	                throw new IncorrectCredentialsException("�������!");
	            }catch (UnknownAccountException i) {
	                throw new UnknownAccountException("�˺Ŵ���");
	            }catch (CaptchaErrorException i) {
	                throw new CaptchaErrorException("��֤�����!");
	            }catch (AccountDiscontinuedException i) {
	                throw new AccountDiscontinuedException("���˺��ѱ�ͣ��!");
	            }     
	            catch (AuthenticationException ae) {
	            	System.out.println("��¼ʧ��"+ae.getMessage());
	            }
	        }
		
		return new NoteResult();
	}
	
	/**
	 * ������֤��
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	@RequestMapping("/createImg.do")
	public void createImg(HttpServletRequest req,HttpServletResponse res) throws IOException{
		//������֤�뼰ͼƬ
		Object[] object = ImageUtil.createImage();
		//�Ƚ���֤�����session
		SecurityUtils.getSubject().getSession().setAttribute("imageCode",object[0]);
		//�ٰ�ͼƬ�����ҳ��
		res.setContentType("image/png");
		OutputStream os=res.getOutputStream();
		ImageIO.write((BufferedImage)object[1], "png", os);
		os.close();
	}
}
