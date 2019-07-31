<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>学院综合管理系统-综合管理</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/aboutHui.shtml">学院综合管理系统</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml"></a> 
			<span class="logo navbar-slogan f-l mr-10 hidden-xs">v2.0</span> 
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
		<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li id="cl_role"></li>
				<li class="dropDown dropDown_hover">
					<a href="#" class="dropDown_A" id="cl_name"><i class="Hui-iconfont">&#xe6d5;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" onClick="myselfinfo()">个人信息</a></li>
						<li><a href="logout.do">切换账户</a></li>
						<li><a href="javascript:;" onClick="updatepwd()">修改密码</a></li>
						<li><a href="logout.do">退出</a></li>
				</ul>
			</li>
				<li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger"></span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>
				<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</div>
</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i> 班级管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<shiro:hasAnyRoles name="6,0">
			<dd>
				<ul>
					<li><a data-href="classInformation.do" data-title="班级信息管理" href="javascript:void(0)">班级信息管理</a></li>
					<li><a data-href="class_curriculum.do" data-title="班级课程管理" href="javascript:void(0)">班级课程管理</a></li>
					<li><a data-href="class_Schedule.do" data-title="教师班表" href="javascript:void(0)">教师班表</a></li>
			</ul>
		</dd>
		</shiro:hasAnyRoles>
	</dl>
	
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont">&#xe613;</i> 专业管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<shiro:hasAnyRoles name="3,0">
			<dd>
				<ul>
					<li><a data-href="profession.do" data-title="专业信息管理" href="javascript:void(0)">专业信息管理</a></li>
				</ul>
			</dd>
			</shiro:hasAnyRoles>
		</dl>
		<dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe620;</i>活动组织管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<shiro:hasAnyRoles name="4,0">
			<dd>
				<ul>
					<li><a data-href="Club_activities.do" data-title="社团活动管理" href="javascript:void(0)">社团活动管理</a></li>
					<li><a data-href="school_activities.do" data-title="校方活动管理" href="javascript:void(0)">校方活动管理</a></li>
			</ul>
		</dd>
		</shiro:hasAnyRoles>
	</dl>
		<dl id="menu-comments">
			<dt><i class="Hui-iconfont">&#xe622;</i> 场地管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<shiro:hasAnyRoles name="2,0">
			<dd>
				<ul>
					<li><a data-href="place_place.do" data-title="场地信息管理" href="javascript:;">场地信息管理</a></li>
					<li><a data-href="place_arrange.do" data-title="场地安排管理" href="javascript:;">场地安排管理</a></li>
			</ul>
		</dd>
	</shiro:hasAnyRoles>
	</dl>
		<dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 人员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<shiro:hasAnyRoles name="1,0">
			<dd>
				<ul>
					<li><a data-href="member_student_list.do" data-title="学生列表" href="javascript:;">学生列表</a></li>
					<li><a data-href="member_teacher_list.do" data-title="教师列表" href="javascript:;">教师列表</a></li>
			</ul>
		</dd>
		</shiro:hasAnyRoles>
	</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<shiro:hasRole name="0">
			<dd>
				<ul>
					<li><a data-href="admin_role.do" data-title="账号管理" href="javascript:void(0)">账号管理</a></li>
					<li><a data-href="admin_log.do" data-title="日志管理" href="javascript:void(0)">日志管理</a></li>
				</ul>
		</dd>
		</shiro:hasRole>
	</dl>
		<!-- <dl id="menu-tongji">
			<dt><i class="Hui-iconfont">&#xe61a;</i> 系统统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="charts-1.html" data-title="折线图" href="javascript:void(0)">折线图</a></li>
					<li><a data-href="charts-2.html" data-title="时间轴折线图" href="javascript:void(0)">时间轴折线图</a></li>
					<li><a data-href="charts-3.html" data-title="区域图" href="javascript:void(0)">区域图</a></li>
					<li><a data-href="charts-4.html" data-title="柱状图" href="javascript:void(0)">柱状图</a></li>
					<li><a data-href="charts-5.html" data-title="饼状图" href="javascript:void(0)">饼状图</a></li>
					<li><a data-href="charts-6.html" data-title="3D柱状图" href="javascript:void(0)">3D柱状图</a></li>
					<li><a data-href="charts-7.html" data-title="3D饼状图" href="javascript:void(0)">3D饼状图</a></li>
			</ul>
		</dd>
	</dl> -->
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 辅导员功能<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
		<shiro:hasRole name="5">
			<dd>
				<ul>
					<li><a data-href="class_student_Information.do" data-title="班级学生信息查看" href="javascript:void(0)">班级学生信息查看</a></li>
					<li><a data-href="LookClassAchievement.do" data-title="班级学生成绩查看" href="javascript:void(0)">班级学生成绩查看</a></li>
					<li><a data-href="class_curriculum_Information.do" data-title="班级课程查看" href="javascript:void(0)">班级课程查看</a></li>
			</ul>
		</dd>
	</shiro:hasRole>
	</dl>
	<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 教师功能<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
		 <shiro:hasRole name="7">
			<dd>
				<ul>
					<li><a data-href="student_achievement_entry.do" data-title="学生成绩录入" href="javascript:void(0)">学生成绩录入</a></li>
					<li><a data-href="class_curriculum_look.do" data-title="班级课程查看" href="javascript:void(0)">班级课程查看</a></li>
			</ul>
		</dd>
	 </shiro:hasRole>
	</dl>
</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="我的桌面" data-href="welcome.do">我的桌面</span>
					<em></em></li>
		</ul>
	</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="welcome.do"></iframe>
	</div>
</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/cookie_util.js"></script>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
$(function(){
	//个人信息
	MyselfInfo();
	
});

//个人信息
var userid=0;
function MyselfInfo(){
	$.ajax({
		url:path+"/MyselfInfo.do",
		type:"post",
		data:{},
		dataType:"json",
		success:function(d){
			var user=d.data;
			userid=user.user_id;
			if(d.status==0){ 
			$("#cl_role").html(user.user_role);
			$("#cl_name").html(user.user_name);
			SetCookie("user_role",user.user_role);
			SetCookie("user_name",user.user_name);
			addlog(1);
			}
		},
		error:function(){
			alert("加载个人信息失败!");
		}
	});
}
/*弹出个人信息页面*/
function myselfinfo(){
	SetCookie("userid",userid);
	layer.open({
		type: 2,
		area: ['800px','600px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看信息',
		content: 'myselfInfo.do',
	});
}
/*弹出修改密码页面*/
function updatepwd(){
	SetCookie("user_id",userid);
	layer.open({
		type: 2,
		area: ['500px','360px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '修改密码',
		content: 'updatepwd.do',
	});
}


/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}


</script> 


</body>
</html>