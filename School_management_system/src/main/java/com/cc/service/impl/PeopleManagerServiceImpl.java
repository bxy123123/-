package com.cc.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import com.cc.dao.PeopleManagerDao;
import com.cc.entity.Professional;
import com.cc.entity.SearchpeopleByMessage;
import com.cc.entity.Student;
import com.cc.entity.Teacher;
import com.cc.entity.User;
import com.cc.service.PeopleManagerService;
import com.cc.util.ByteSourceUtils;
import com.cc.util.NoteResult;
import com.cc.util.PageUtil;

@Service
public class PeopleManagerServiceImpl implements PeopleManagerService {

	@Resource
	private PeopleManagerDao pd;
	
	/**
	 * 根据id删除学生
	 */
	public NoteResult DeleteStudent(Integer studentid) {
		pd.DeleteStudent(studentid);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}

	/**
	 * 添加学生
	 */
	public NoteResult AddStudent(Student s) {
		NoteResult result = new NoteResult();
		pd.AddStudent(s);
		result.setStatus(0);
		return result;
	}

	/**
	 * 根据id查询学生个人信息
	 */
	public NoteResult Student_Show(Integer student_id) {
		Student s=pd.Show_studentInfo(student_id);
		NoteResult result = new NoteResult();
		result.setData(s);
		result.setStatus(0);
		return result;
	}

	/**
	 * 根据id修改学生
	 */
	public NoteResult updateStudent(Student s) {
		
		NoteResult result = new NoteResult();
		pd.UpdateStudent(s);
		result.setStatus(0);
		return result;
	}

	/**
	 * 根据Id删除教师
	 */
	public NoteResult DeleteTeacher(Integer teacherid) {
		pd.DeleteTeacher(teacherid);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}

	/**
	 * 添加教师
	 */
	public NoteResult AddTeacher(Teacher t) {
		NoteResult result = new NoteResult();
		pd.AddTeacher(t);
		String pwd="000000";
		String hash="MD5";
		Object salt=ByteSourceUtils.bytes(t.getTeacher_phone());
		int d=1024;
		Object Md5Pwd=new SimpleHash(hash,pwd,salt,d);
		String mp = Md5Pwd.toString();
		User u = new User();
		u.setUser_age(t.getTeacher_age());
		u.setUser_name(t.getTeacher_name());
		u.setUser_sex(t.getTeacher_sex());
		u.setUser_phone(t.getTeacher_phone());
		u.setUser_pwd(mp);
		u.setUser_IDCard(t.getTeacher_IDCard());
		if(t.getTeacher_role().equals("辅导员")){
			u.setRole_id(5);
		}
		if(t.getTeacher_role().equals("教师")){
			u.setRole_id(7);
		}
		u.setUser_status(0);
		u.setUser_role(t.getTeacher_role());
		pd.AddUser(u);
		result.setStatus(0);
		return result;
	}

	/**
	 * 查询教师信息
	 */
	public NoteResult Teacher_Show(Integer teacher_id) {
		Teacher t=pd.Show_teacherInfo(teacher_id);
		NoteResult result = new NoteResult();
		result.setData(t);
		result.setStatus(0);
		return result;
	}

	/**
	 * 修改教师信息
	 */
	public NoteResult UpdateTeacher(Teacher t) {
		NoteResult result = new NoteResult();
		pd.UpdateTeacher(t);
		result.setStatus(0);
		return result;
	}


	/**
	 * 根据输入信息查询学生信息
	 */
	public PageUtil SearchStudent(SearchpeopleByMessage s) {
		PageUtil page = new PageUtil();
		String str = s.getCurrentPage();
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = pd.SearchStudentCount(s);
		page.setTotalCount(size);
		page.setCurrentPage(current);
		Date datemin=s.getDatemin();
		Date datemax=s.getDatemax();
		String message=s.getMessage();
		List<Student> list=pd.SearchStudent(datemin,datemax,message,page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}

	/**
	 * 根据输入的信息查询所有教师信息
	 */
	public PageUtil SearchTeacher(SearchpeopleByMessage s) {
		PageUtil page = new PageUtil();
		String str = s.getCurrentPage();
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = pd.SearchTeacherCount(s);
		page.setTotalCount(size);
		page.setCurrentPage(current);
		Date datemin=s.getDatemin();
		Date datemax=s.getDatemax();
		String message=s.getMessage();
		List<Teacher> list=pd.SearchTeacher(datemin,datemax,message,page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}

	/**
	 * 查询所有专业
	 */
	public NoteResult findProfession() {
		List<Professional> list=pd.findProfession();
		NoteResult result=new NoteResult();
		result.setData(list);
		result.setStatus(0);
		return result;
	}

}
