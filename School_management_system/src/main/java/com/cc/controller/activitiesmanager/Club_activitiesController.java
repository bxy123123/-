package com.cc.controller.activitiesmanager;

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

import com.cc.entity.Club_activities;
import com.cc.service.ClubActivitiesService;
import com.cc.util.FtpClientEntity;
import com.cc.util.ImgUtil;
import com.cc.util.NoteResult;

/**
 * 社团活动管理操作
 * @author Administrator
 *
 */
@Controller
public class Club_activitiesController {

	@Resource
	private ClubActivitiesService cs;
	
	
	/**
	 * 添加社团活动
	 * @param club_activities_name
	 * @param club_activities_place
	 * @param club_activities_unit
	 * @param club_activities_starttime
	 * @param club_activities_endtime
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	@RequestMapping("/AddClubActivities.do")
	@ResponseBody
	public NoteResult AddClubActivities(String club_activities_name,String club_activities_place,int club_activities_number,String club_activities_unit,
			String club_activities_starttime,String club_activities_endtime,String file) throws FileNotFoundException, ParseException{
		
		String format="yyyy-MM-dd";
		Date date_starttime=new SimpleDateFormat(format).parse(club_activities_starttime);
		Date date_of_endtime=new SimpleDateFormat(format).parse(club_activities_endtime);
		Club_activities c=new Club_activities();
		
		if(file==null || file.equals("")){
			c.setClubactivities_endtime(date_of_endtime);
			c.setClubactivities_name(club_activities_name);
			c.setClubactivities_place(club_activities_place);
			c.setClubactivities_status(0);
			c.setClubactivities_time(date_starttime);
			c.setOrganizational_unit(club_activities_unit);
			c.setClubactivities_number(club_activities_number);
			NoteResult result=cs.AddClubActivities(c);
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
		String path="pic/sports_Poster/";
		File f1=new File(href);
		String filename=f1.getName();
		System.out.println(filename);
		FtpClientEntity a=new FtpClientEntity();
		InputStream input=new FileInputStream(f1);
		FTPClient ftp=a.getConnectionFTP("192.168.100.218", 21, "p004", "cxp004");
		a.uploadFile(ftp, path, filename, input);
		a.closeFTP(ftp);
		
		
		c.setClubactivities_endtime(date_of_endtime);
		c.setClubactivities_name(club_activities_name);
		c.setClubactivities_place(club_activities_place);
		c.setClubactivities_status(0);
		c.setClubactivities_time(date_starttime);
		c.setOrganizational_unit(club_activities_unit);
		c.setSports_Poster(filename);
		c.setClubactivities_number(club_activities_number);
		NoteResult result=cs.AddClubActivities(c);
		return result;
	}
	
	/**
	 * 删除社团活动
	 * @param id
	 * @return
	 */
	@RequestMapping("/DeleteClubActivities.do")
	@ResponseBody
	public NoteResult  DeleteClubActivities(Integer id){
		NoteResult result=cs.DeleteClubActivities(id);
		return result;
	}
	
	/**
	 * 根据id查询社团活动信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/ShowClubActivities.do")
	@ResponseBody
	public NoteResult ShowClubActivities(Integer id){
		NoteResult result=cs.ShowClubActivities(id);
		return result;
	}
	
	/**
	 * 修改社团活动
	 * @param club_activities_name
	 * @param club_activities_place
	 * @param club_activities_number
	 * @param club_activities_unit
	 * @param club_activities_starttime
	 * @param club_activities_endtime
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	@RequestMapping("/UpdateClubActivities.do")
	@ResponseBody
	public NoteResult UpdateClubActivities(Integer id,String club_activities_place,int club_activities_number,String club_activities_unit,
			String club_activities_starttime,String club_activities_endtime,String file) throws FileNotFoundException, ParseException{
		System.out.println(club_activities_starttime+",,");
		System.out.println(club_activities_endtime+",,,");
		System.out.println(1);
		String format="yyyy-MM-dd";
		Date date_starttime=new SimpleDateFormat(format).parse(club_activities_starttime);
		Date date_of_endtime=new SimpleDateFormat(format).parse(club_activities_endtime);
		Club_activities c=new Club_activities();
		if(file==null || file.equals("")){
			c.setClubactivities_endtime(date_of_endtime);
			c.setClubactivities_place(club_activities_place);
			c.setClubactivities_status(0);
			c.setClubactivities_time(date_starttime);
			c.setOrganizational_unit(club_activities_unit);
			c.setClubactivities_number(club_activities_number);
			c.setClubactivities_id(id);
			NoteResult result=cs.UpdateClubActivities(c);
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
		String path="pic/sports_Poster/";
		File f1=new File(href);
		String filename=f1.getName();
		FtpClientEntity a=new FtpClientEntity();
		InputStream input=new FileInputStream(f1);
		FTPClient ftp=a.getConnectionFTP("192.168.100.218", 21, "p004", "cxp004");
		a.uploadFile(ftp, path, filename, input);
		a.closeFTP(ftp);
		
		
		c.setClubactivities_endtime(date_of_endtime);
		c.setClubactivities_place(club_activities_place);
		c.setClubactivities_status(0);
		c.setClubactivities_time(date_starttime);
		c.setOrganizational_unit(club_activities_unit);
		c.setSports_Poster(filename);
		c.setClubactivities_number(club_activities_number);
		c.setClubactivities_id(id);
		NoteResult result=cs.UpdateClubActivities(c);
		return result;
	}
	/**
	 * 更改预约状态
	 */
	@RequestMapping("/clubActivitiesStart.do")
	@ResponseBody
	public NoteResult clubActivitiesStart(Integer id,Integer number){
		NoteResult result=cs.clubActivitiesStart(id,number);
		return result;
	}
	/**
	 * 更改预约状态
	 */
	@RequestMapping("/clubActivitiesStartStop.do")
	@ResponseBody
	public NoteResult clubActivitiesStartStop(Integer id){
		NoteResult result=cs.clubActivitiesStartStop(id);
		return result;
	}
	
	/**
	 * 查询所有场地
	 * @return
	 */
	@RequestMapping("/findAllPlace.do")
	@ResponseBody
	public NoteResult findAllPlace(){
		NoteResult result=cs.findAllPlace();
		return result;
	}
}
