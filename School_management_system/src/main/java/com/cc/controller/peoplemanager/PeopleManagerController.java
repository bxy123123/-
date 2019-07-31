package com.cc.controller.peoplemanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.entity.SearchpeopleByMessage;
import com.cc.entity.Student;
import com.cc.entity.Teacher;
import com.cc.service.PeopleManagerService;
import com.cc.util.FtpClientEntity;
import com.cc.util.ImgUtil;
import com.cc.util.NoteResult;
import com.cc.util.PageUtil;

@Controller
public class PeopleManagerController {

	@Resource
	private PeopleManagerService ps;
	
	
	/**
	 * 根据id删除学生
	 * @param studentid
	 * @return
	 */
	@RequestMapping("/DeleteStudent.do")
	@ResponseBody
	public NoteResult DeleteStudent(Integer studentid){
		NoteResult result=ps.DeleteStudent(studentid);
		return result;
	}
	
	/**
	 * 添加学生
	 * @param student_name
	 * @param student_nation
	 * @param student_sex
	 * @param student_phone
	 * @param student_age
	 * @param student_IDCard
	 * @param student_code
	 * @param file
	 * @param student_birthday
	 * @param student_Date_of_admission
	 * @param student_major
	 * @param student_class
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException 
	 */
	@RequestMapping("/AddStudent.do")
	@ResponseBody
	public NoteResult AddStudent(String student_name,String student_nation,char student_sex,String student_phone,
								Integer student_age,String student_IDCard,String student_code,String file,
								String student_birthday,String student_Date_of_admission,String student_major,String student_class) throws FileNotFoundException, ParseException{
		if(file==null || file.equals("")){
			Student s=new Student();
			s.setStudent_age(student_age);
			String format="yyyy-MM-dd";
			Date date_birthday=new SimpleDateFormat(format).parse(student_birthday);
			Date date_of_admission=new SimpleDateFormat(format).parse(student_Date_of_admission);
			s.setStudent_birthday(date_birthday);
			s.setStudent_class(student_class);
			s.setStudent_code(student_code);
			s.setStudent_Date_of_admission(date_of_admission);
			s.setStudent_IDCard(student_IDCard);
			s.setStudent_major(student_major);
			s.setStudent_name(student_name);
			s.setStudent_nation(student_nation);
			s.setStudent_phone(student_phone);
			s.setStudent_sex(student_sex);
			NoteResult result=ps.AddStudent(s);
			return result;
		}
		ImgUtil iu=new ImgUtil();
		String href="D://"+System.currentTimeMillis()+".jpg";
		String[] b=file.split(",");
		String base=b[1];
		boolean flat=iu.GenerateImage(base, href);
		if(flat){
			System.out.println("生成成功!");
		}
		//存在ftp图片服务器的路径
		String path="pic/Head_image/";
		File f1=new File(href);
		String filename=f1.getName();
		FtpClientEntity a=new FtpClientEntity();
		InputStream input=new FileInputStream(f1);
		FTPClient ftp=a.getConnectionFTP("192.168.100.218", 21, "p004", "cxp004");
		a.uploadFile(ftp, path, filename, input);
		a.closeFTP(ftp);
		
		Student s=new Student();
		s.setStudent_age(student_age);
		String format="yyyy-MM-dd";
		Date date_birthday=new SimpleDateFormat(format).parse(student_birthday);
		Date date_of_admission=new SimpleDateFormat(format).parse(student_Date_of_admission);
		s.setStudent_birthday(date_birthday);
		s.setStudent_class(student_class);
		s.setStudent_code(student_code);
		s.setStudent_Date_of_admission(date_of_admission);
		s.setStudent_headimage(filename);
		s.setStudent_IDCard(student_IDCard);
		s.setStudent_major(student_major);
		s.setStudent_name(student_name);
		s.setStudent_nation(student_nation);
		s.setStudent_phone(student_phone);
		s.setStudent_sex(student_sex);
		NoteResult result=ps.AddStudent(s);
		return result;
	}
	
	/**
	 * 根据id查询学生个人信息
	 * @param student_id
	 * @return
	 */
	@RequestMapping("/Student_Show.do")
	@ResponseBody
	public NoteResult Student_Show(Integer student_id){
		NoteResult result=ps.Student_Show(student_id);
		return result;
	}
	/**
	 * 修改学生信息
	 * @param studentid
	 * @param student_name
	 * @param student_nation
	 * @param student_sex
	 * @param student_phone
	 * @param student_age
	 * @param student_IDCard
	 * @param student_code
	 * @param file
	 * @param student_birthday
	 * @param student_Date_of_admission
	 * @param student_major
	 * @param student_class
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	@RequestMapping("/UpdateStudent.do")
	@ResponseBody
	public NoteResult UpdateStudent(Integer studentid,String student_name,String student_nation,char student_sex,String student_phone,
			Integer student_age,String student_IDCard,String student_code,String file,
			String student_birthday,String student_Date_of_admission,String student_major,String student_class) throws FileNotFoundException, ParseException{
		
		if(file==null || file.equals("")){
			Student s=new Student();
			s.setStudent_age(student_age);
			String format="yyyy-MM-dd";
			Date date_birthday=new SimpleDateFormat(format).parse(student_birthday);
			Date date_of_admission=new SimpleDateFormat(format).parse(student_Date_of_admission);
			s.setStudent_birthday(date_birthday);
			s.setStudent_class(student_class);
			s.setStudent_code(student_code);
			s.setStudent_Date_of_admission(date_of_admission);
			s.setStudent_IDCard(student_IDCard);
			s.setStudent_major(student_major);
			s.setStudent_name(student_name);
			s.setStudent_nation(student_nation);
			s.setStudent_phone(student_phone);
			s.setStudent_sex(student_sex);
			s.setStudent_id(studentid);
			NoteResult result=ps.updateStudent(s);
			return result;
		}
		ImgUtil iu=new ImgUtil();
		String href="D://"+System.currentTimeMillis()+".jpg";
		String[] b=file.split(",");
		String base=b[1];
		boolean flat=iu.GenerateImage(base, href);
		if(flat){
			//System.out.println("生成成功!");
		}
		//存在ftp图片服务器的路径
		String path="pic/Head_image/";
		File f1=new File(href);
		String filename=f1.getName();
		//System.out.println(filename);
		FtpClientEntity a=new FtpClientEntity();
		InputStream input=new FileInputStream(f1);
		FTPClient ftp=a.getConnectionFTP("192.168.100.218", 21, "p004", "cxp004");
		a.uploadFile(ftp, path, filename, input);
		a.closeFTP(ftp);
		
		Student s=new Student();
		s.setStudent_age(student_age);
		String format="yyyy-MM-dd";
		Date date_birthday=new SimpleDateFormat(format).parse(student_birthday);
		Date date_of_admission=new SimpleDateFormat(format).parse(student_Date_of_admission);
		s.setStudent_birthday(date_birthday);
		s.setStudent_class(student_class);
		s.setStudent_code(student_code);
		s.setStudent_Date_of_admission(date_of_admission);
		s.setStudent_headimage(filename);
		s.setStudent_IDCard(student_IDCard);
		s.setStudent_major(student_major);
		s.setStudent_name(student_name);
		s.setStudent_nation(student_nation);
		s.setStudent_phone(student_phone);
		s.setStudent_sex(student_sex);
		s.setStudent_id(studentid);
		NoteResult result=ps.updateStudent(s);
		return result;
	}
	
	/**
	 * 根据id删除教师
	 * @param studentid
	 * @return
	 */
	@RequestMapping("/DeleteTeacher.do")
	@ResponseBody
	public NoteResult DeleteTeacher(Integer teacherid){
		NoteResult result=ps.DeleteTeacher(teacherid);
		return result;
	}
	
	/**
	 *添加教师
	 * @param teacher_name
	 * @param teacher_phone
	 * @param teacher_sex
	 * @param teacher_age
	 * @param teacher_IDCard
	 * @param teacher_address
	 * @param file
	 * @param teacher_role
	 * @param teacher_major
	 * @param teacher_dutytime
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	@RequestMapping("/AddTeacher.do")
	@ResponseBody
	public NoteResult AddTeacher(String teacher_name,String teacher_phone,char teacher_sex,
								Integer teacher_age,String teacher_IDCard,String teacher_address,String file,
								String teacher_role,String teacher_major,String teacher_dutytime) throws FileNotFoundException, ParseException{
		if(file==null || file.equals("")){
			Teacher t=new Teacher();
			String format="yyyy-MM-dd";
			Date date_dutytime=new SimpleDateFormat(format).parse(teacher_dutytime);
			t.setTeacher_address(teacher_address);
			t.setTeacher_age(teacher_age);
			t.setTeacher_dutytime(date_dutytime);
			t.setTeacher_IDCard(teacher_IDCard);
			t.setTeacher_name(teacher_name);
			t.setTeacher_phone(teacher_phone);
			t.setTeacher_profession(teacher_major);
			t.setTeacher_role(teacher_role);
			t.setTeacher_sex(teacher_sex);
			NoteResult result=ps.AddTeacher(t);
			return result;
		}
		ImgUtil iu=new ImgUtil();
		String href="D://"+System.currentTimeMillis()+".jpg";
		String[] b=file.split(",");
		String base=b[1];
		boolean flat=iu.GenerateImage(base, href);
		if(flat){
			
		}
		//存在ftp图片服务器的路径
		String path="pic/Head_image/";
		File f1=new File(href);
		String filename=f1.getName();
		FtpClientEntity a=new FtpClientEntity();
		InputStream input=new FileInputStream(f1);
		FTPClient ftp=a.getConnectionFTP("192.168.100.218", 21, "p004", "cxp004");
		a.uploadFile(ftp, path, filename, input);
		a.closeFTP(ftp);
		
		Teacher t=new Teacher();
		String format="yyyy-MM-dd";
		Date date_dutytime=new SimpleDateFormat(format).parse(teacher_dutytime);
		t.setTeacher_address(teacher_address);
		t.setTeacher_age(teacher_age);
		t.setTeacher_dutytime(date_dutytime);
		t.setTeacher_headimage(filename);
		t.setTeacher_IDCard(teacher_IDCard);
		t.setTeacher_name(teacher_name);
		t.setTeacher_phone(teacher_phone);
		t.setTeacher_profession(teacher_major);
		t.setTeacher_role(teacher_role);
		t.setTeacher_sex(teacher_sex);
		NoteResult result=ps.AddTeacher(t);
		return result;
	}
	
	/**
	 * 查询教师信息
	 * @param teacher_id
	 * @return
	 */
	@RequestMapping("/Teacher_Show.do")
	@ResponseBody
	public NoteResult Teacher_Show(Integer teacher_id){
		NoteResult result=ps.Teacher_Show(teacher_id);
		return result;
	}
	
	/**
	 * 修改教师信息
	 * @param teacher_id
	 * @param teacher_name
	 * @param student_nation
	 * @param teacher_sex
	 * @param teacher_phone
	 * @param teacher_age
	 * @param teacher_IDCard
	 * @param teacher_address
	 * @param file
	 * @param teacher_dutytime
	 * @param teacher_profession
	 * @param teacher_role
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	@RequestMapping("/UpdateTeacher.do")
	@ResponseBody
	public NoteResult UpdateTeacher(Integer teacher_id,String teacher_name,char teacher_sex,String teacher_phone,
			Integer teacher_age,String teacher_IDCard,String teacher_address,String file,
			String teacher_dutytime,String teacher_profession,String teacher_role) throws FileNotFoundException, ParseException{
		
		if(file==null || file.equals("")){
			Teacher t=new Teacher();
			String format="yyyy-MM-dd";
			Date date_dutytime=new SimpleDateFormat(format).parse(teacher_dutytime);
			t.setTeacher_address(teacher_address);
			t.setTeacher_age(teacher_age);
			t.setTeacher_dutytime(date_dutytime);
			t.setTeacher_IDCard(teacher_IDCard);
			t.setTeacher_name(teacher_name);
			t.setTeacher_phone(teacher_phone);
			t.setTeacher_profession(teacher_profession);
			t.setTeacher_role(teacher_role);
			t.setTeacher_sex(teacher_sex);
			t.setTeacher_id(teacher_id);
			NoteResult result=ps.UpdateTeacher(t);
			return result;
		}
		ImgUtil iu=new ImgUtil();
		String href="D://"+System.currentTimeMillis()+".jpg";
		String[] b=file.split(",");
		String base=b[1];
		boolean flat=iu.GenerateImage(base, href);
		if(flat){
		}
		//存在ftp图片服务器的路径
		String path="pic/Head_image/";
		File f1=new File(href);
		String filename=f1.getName();
		FtpClientEntity a=new FtpClientEntity();
		InputStream input=new FileInputStream(f1);
		FTPClient ftp=a.getConnectionFTP("192.168.100.218", 21, "p004", "cxp004");
		a.uploadFile(ftp, path, filename, input);
		a.closeFTP(ftp);
		
		Teacher t=new Teacher();
		String format="yyyy-MM-dd";
		Date date_dutytime=new SimpleDateFormat(format).parse(teacher_dutytime);
		t.setTeacher_address(teacher_address);
		t.setTeacher_age(teacher_age);
		t.setTeacher_dutytime(date_dutytime);
		t.setTeacher_headimage(filename);
		t.setTeacher_IDCard(teacher_IDCard);
		t.setTeacher_name(teacher_name);
		t.setTeacher_phone(teacher_phone);
		t.setTeacher_profession(teacher_profession);
		t.setTeacher_role(teacher_role);
		t.setTeacher_sex(teacher_sex);
		t.setTeacher_id(teacher_id);
		NoteResult result=ps.UpdateTeacher(t);
		return result;
	}
	
	
	/**
	 * 根据输入信息查询学生信息
	 * @param datemin
	 * @param datemax
	 * @param message
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/SearchStudent.do")
	@ResponseBody
	public PageUtil SearchStudent(String currentPage,String datemin,String datemax,String message) throws ParseException{
		String format="yyyy-MM-dd";
		SearchpeopleByMessage s=new SearchpeopleByMessage();
		if(datemin!=null && !datemin.equals("") && datemax!=null && !datemax.equals("")){
			Date datemin1=new SimpleDateFormat(format).parse(datemin);
			Date datemax1=new SimpleDateFormat(format).parse(datemax);
			s.setDatemax(datemax1);
			s.setDatemin(datemin1);
		}
		if(message!=null && !message.equals("")){
			s.setMessage(message);
		}
		s.setCurrentPage(currentPage);
		PageUtil page=ps.SearchStudent(s);
		return page;
	}
	
	/**
	 * 根据输入的信息查询所有教师信息
	 * @param currentPage
	 * @param datemin
	 * @param datemax
	 * @param message
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/SearchTeacher.do")
	@ResponseBody
	public PageUtil SearchTeacher(String currentPage,String datemin,String datemax,String message) throws ParseException{
		String format="yyyy-MM-dd";
		SearchpeopleByMessage s=new SearchpeopleByMessage();
		if(datemin!=null && !datemin.equals("") && datemax!=null && !datemax.equals("")){
			Date datemin1=new SimpleDateFormat(format).parse(datemin);
			Date datemax1=new SimpleDateFormat(format).parse(datemax);
			s.setDatemax(datemax1);
			s.setDatemin(datemin1);
		}
		if(message!=null && !message.equals("")){
			s.setMessage(message);
		}
		s.setCurrentPage(currentPage);
		PageUtil page=ps.SearchTeacher(s);
		return page;
	}
	
	/**
	 * 查询所有专业
	 * @return
	 */
	@RequestMapping("/findProfession.do")
	@ResponseBody
	public NoteResult findProfession(){
		NoteResult result=ps.findProfession();
		return result;
	}
}
