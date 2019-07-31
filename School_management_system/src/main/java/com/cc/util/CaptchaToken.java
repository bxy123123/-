package com.cc.util;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * ��չShiro��¼��Token,������֤���ֶ�
 */
public class CaptchaToken extends UsernamePasswordToken {
 
    // ���л�ID
    private static final long serialVersionUID = -2804050723838289739L;
 
    // ��֤��
    private String captchaCode;
 
    /**
     * ���캯��
     * �û����������ǵ�¼�����,��˹��캯���а��������ֶ�
     */
    public CaptchaToken(String username, String password, String captchaCode) {
        // ����UsernamePasswordToken�Ĺ��캯��,�����������ݲ���Ҫ, ������
        super(username, password, false, "");
        this.captchaCode = captchaCode;
    }
 
    /**
     * ��ȡ��֤��
     */
    public String getCaptchaCode() {
        return captchaCode;
    }

}
