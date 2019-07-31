//获取分页条  
function getPageBar(a) {
//	 var curPage = 1;//当前页码  
//	var curPage,total, pageSize, totalPage; 
	//页码大于最大页数  
	if (curPage > totalPage)
		curPage = totalPage;
	//页码小于1  
	if (curPage < 1)
		curPage = 1;
	pageStr = "<span>共" + total + "条</span><span>" + curPage + "/"
			+ totalPage + "</span>";

	//如果是第一页  
	if (curPage == 1) {
		pageStr += "<span>首页</span><span>上一页</span>";
	} else {
		pageStr += "<span><a href='javascript:getData"+a+"(1,2)' rel='1'>首页</a></span><span><a href='javascript:getData"+a+"("+(curPage - 1)+",2)' rel='"
				+ (curPage - 1) + "'>上一页</a></span>";
	}

	//如果是最后页  
	if (curPage >= totalPage) {
		pageStr += "<span>下一页</span><span>尾页</span>";
	} else {
		pageStr += "<span><a href='javascript:getData"+a+"("+((curPage) + 1)+")' rel='"
				+ (parseInt(curPage) + 1)
				+ "'>下一页</a></span><span><a href='javascript:getData"+a+"("+totalPage+")' rel='"
				+ totalPage + "'>尾页</a></span>";
	}

	$("#pageCount").html(pageStr);
}
//显示账号数据
function getDataAdminUser(page) {
	$.ajax({
		url :path+"/paging.do",
		type : "post",
		data : {"currentPage" : page},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var user = json.data;//返回内容
			if(user == "" || user == null){
				alert("查无信息");
			}else{
				var s = '角色编辑'
				var a = 'admin_role_update.do'
				for(var i=0;i<user.length;i++){
					var tds="";
					var user_id=user[i].user_id;
					tds += "<tr class='text-c'>";
					tds += "	<td><input type='checkbox' value='' name=''></td>";
					tds += "	<td>"+user[i].user_id+"</td>";
					tds += "	<td>"+user[i].user_role+"</td>";
					tds += "	<td>"+user[i].user_name+"</td>";
					tds += "	<td><a href='#'>"+user[i].user_phone+"</a></td>";
					if(user[i].user_status == 1){
						tds += "	<td class='td-status'><span class='label label-defaunt radius'>已停用</span></td>";
					}else {
						tds += "	<td class='td-status'><span class='label label-success radius'>已启用</span></td>";
					}
					var time=getMyDate(user[i].user_createtime);
					tds += "	<td>"+time+"</td>";
					tds += "	<td class='f-14'>";
					if(user[i].user_status == 0 ){
						tds +="			<a style=\"text-decoration:none\" onClick=\"member_stop(this,'"+user_id+"')\" href=\"javascript:;\" title=\"停用\"><i class=\"Hui-iconfont\">&#xe631;</i></a>"
					}else {
						tds +="			<a style=\"text-decoration:none\" onClick=\"member_start(this,'"+user_id+"')\" href=\"javascript:;\" title=\"启用\"><i class=\"Hui-iconfont\">&#xe6e1;</i></a>"
					}
					tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"admin_role_edit('"+s+"','"+a+"','"+user_id+"')\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
					tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"admin_role_del(this,'"+user_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
					tds += "	</td>"; 
					tds += "</tr>";
				     $("#content").append(tds);
				}
			}
				
		},
		complete : function() { //生成分页条  
			var a = "AdminUser";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}

//搜角色(账号管理)
function getDataAdminRoleInfoByMessage(page,message) {
	$.ajax({
		url :path+"/pageAdminRoleInfoByMessage.do",
		type : "post",
		data : {"currentPage" : page,"message":message},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var user = json.data;//返回内容
			if(user == "" || user == null){
				alert("查无信息");
			}else{
				var s = '角色编辑'
				var a = 'admin_role_update.do'
				for(var i=0;i<user.length;i++){
					var tds="";
					var user_id=user[i].user_id;
					tds += "<tr class='text-c'>";
					tds += "	<td><input type='checkbox' value='' name=''></td>";
					tds += "	<td>"+user[i].user_id+"</td>";
					tds += "	<td>"+user[i].user_role+"</td>";
					tds += "	<td>"+user[i].user_name+"</td>";
					tds += "	<td><a href='#'>"+user[i].user_phone+"</a></td>";
					if(user[i].user_status == 1){
						tds += "	<td class='td-status'><span class='label label-defaunt radius'>已停用</span></td>";
					}else {
						tds += "	<td class='td-status'><span class='label label-success radius'>已启用</span></td>";
					}
					var time=getMyDate(user[i].user_createtime);
					tds += "	<td>"+time+"</td>";
					tds += "	<td class='f-14'>";
					if(user[i].user_status == 0 ){
						tds +="			<a style=\"text-decoration:none\" onClick=\"member_stop(this,'"+user_id+"')\" href=\"javascript:;\" title=\"停用\"><i class=\"Hui-iconfont\">&#xe631;</i></a>"
					}else {
						tds +="			<a style=\"text-decoration:none\" onClick=\"member_start(this,'"+user_id+"')\" href=\"javascript:;\" title=\"启用\"><i class=\"Hui-iconfont\">&#xe6e1;</i></a>"
					}
					tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"admin_role_edit('"+s+"','"+a+"','"+user_id+"')\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
					tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"admin_role_del(this,'"+user_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
					tds += "	</td>"; 
					tds += "</tr>";
				     $("#content").append(tds);
				}
			}
				
		},
		complete : function() { //生成分页条  
			var a = "AdminRoleInfoByMessage";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}
//显示管理员日志数据
function getDataAdminLog(page) {
	$.ajax({
		url :path+"/pageAdminLog.do",
		type : "post",
		data : {"currentPage" : page},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var log = json.data;//返回内容
			if(log == "" || log == null){
				alert("查无信息");
			}else{
						var s = '管理员日志管理'
						for(var i=0;i<log.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox'   id='ch'  value='"+log[i].log_id+"' name='check_item'></td>";
							tds += "	<td>"+log[i].log_role+"</td>";
							tds += "	<td>"+log[i].log_name+"</td>";
							tds += "	<td>"+log[i].log_function+"</td>";
							tds += "	<td>"+log[i].log_creationtime+"</td>";
							tds += "	<td class='f-14'>";
							tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"log_del(this,'"+log[i].log_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
							
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "AdminLog";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}

//显示所有学生信息
function getDataStudentInfo(page) {
	$.ajax({
		url :path+"/pageStudentInfo.do",
		type : "post",
		data : {"currentPage" : page},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var student = json.data;//返回内容
			if(student == "" || student == null){
				alert("查无信息");
			}else{
						var st='个人信息'
						var url='member_student_show.do'
						var s1='学生编辑'
						var url1='member_update_student.do'
						for(var i=0;i<student.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+student[i].student_id+"</td>";
							tds += "	<td>";
							tds	+= "       <u style=\"cursor:pointer\" class='text-primary' onclick=\"member_student_show('"+st+"','"+url+"','"+student[i].student_id+"','360','600')\">"+student[i].student_name+"</u>";                        
							tds += "	</td>";
							tds += "	<td>"+student[i].student_sex+"</td>";
							tds += "	<td>"+student[i].student_age+"</td>";
							tds += "	<td>"+student[i].student_phone+"</td>";
							tds += "	<td class='text-l'>"+student[i].student_code+"</td>";
							var time=getMyDate1(student[i].student_Date_of_admission);
							tds += "	<td>"+time+"</td>";
							tds += "    <td class='td-status'>";
							tds += "    	<span class=\"label label-success radius\">"+student[i].student_major+"</span>";
							tds += "    </td>";
							tds += "	<td>"+student[i].student_class+"</td>";
							tds += "	<td class='td-manage'>";
							tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"member_student_edit('"+s1+"','"+url1+"','"+student[i].student_id+"')\" style=\"text-decoration:none\" class='ml-5'><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
							tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"member_student_del(this,'"+student[i].student_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "StudentInfo";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}
//根据输入的信息查询学生的信息
function getDataStudentInfoBymessage(page,datemin,datemax,message){
	$.ajax({
		url :path+"/SearchStudent.do",
		type : "post",
		data : {"currentPage" : page,"datemin":datemin,"datemax":datemax,"message":message},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var student = json.data;//返回内容
			if(student == "" || student == null){
				alert("查无信息");
			}else{
						var st='个人信息'
						var url='member_student_show.do'
						var s1='学生编辑'
						var url1='member_update_student.do'
						for(var i=0;i<student.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+student[i].student_id+"</td>";
							tds += "	<td>";
							tds	+= "       <u style=\"cursor:pointer\" class='text-primary' onclick=\"member_student_show('"+st+"','"+url+"','"+student[i].student_id+"','360','600')\">"+student[i].student_name+"</u>";                        
							tds += "	</td>";
							tds += "	<td>"+student[i].student_sex+"</td>";
							tds += "	<td>"+student[i].student_age+"</td>";
							tds += "	<td>"+student[i].student_phone+"</td>";
							tds += "	<td class='text-l'>"+student[i].student_code+"</td>";
							var time=getMyDate1(student[i].student_Date_of_admission);
							tds += "	<td>"+time+"</td>";
							tds += "    <td class='td-status'>";
							tds += "    	<span class=\"label label-success radius\">"+student[i].student_major+"</span>";
							tds += "    </td>";
							tds += "	<td>"+student[i].student_class+"</td>";
							tds += "	<td class='td-manage'>";
							tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"member_student_edit('"+s1+"','"+url1+"','"+student[i].student_id+"')\" style=\"text-decoration:none\" class='ml-5'><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
							tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"member_student_del(this,'"+student[i].student_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "StudentInfoBymessage";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}
//显示所有教师信息
function getDataTeacherInfo(page) {
	$.ajax({
		url :path+"/pageTeacherInfo.do",
		type : "post",
		data : {"currentPage" : page},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var teacher = json.data;//返回内容
			if(teacher == "" || teacher == null){
				alert("查无信息");
			}else{
						var st='个人信息'
						var url='member_teacher_show.do'
						var s1='教师编辑'
						var url1='member_update_teacher.do'
						for(var i=0;i<teacher.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+teacher[i].teacher_id+"</td>";
							tds += "	<td>";
							tds	+= "       <u style=\"cursor:pointer\" class=\"text-primary\" onclick=\"member_teacher_show('"+st+"','"+url+"','"+teacher[i].teacher_id+"','360','600')\">"+teacher[i].teacher_name+"</u>";                        
							tds += "	</td>";
							tds += "	<td>"+teacher[i].teacher_sex+"</td>";
							tds += "	<td>"+teacher[i].teacher_age+"</td>";
							tds += "	<td>"+teacher[i].teacher_phone+"</td>";
							tds += "	<td class='text-l'>"+teacher[i].teacher_role+"</td>";
							tds += "	<td>"+teacher[i].teacher_profession+"</td>";
							var time=getMyDate1(teacher[i].teacher_dutytime);
							tds += "	<td>"+time+"</td>";
							tds += "	<td class='td-manage'>";
							tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"member_teacher_edit('"+s1+"','"+url1+"','"+teacher[i].teacher_id+"')\" style=\"text-decoration:none\" class='ml-5'><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
							tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"member_teacher_del(this,'"+teacher[i].teacher_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "TeacherInfo";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}
//根据输入的信息查询教师的信息
function getDataTeacherInfoBymessage(page,datemin,datemax,message){
	$.ajax({
		url :path+"/SearchTeacher.do",
		type : "post",
		data : {"currentPage" : page,"datemin":datemin,"datemax":datemax,"message":message},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var teacher = json.data;//返回内容
			if(teacher == "" || teacher == null){
				alert("查无信息");
			}else{
						var st='个人信息'
						var url='member_teacher_show.do'
						var s1='教师编辑'
						var url1='member_update_teacher.do'
						for(var i=0;i<teacher.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+teacher[i].teacher_id+"</td>";
							tds += "	<td>";
							tds	+= "       <u style=\"cursor:pointer\" class=\"text-primary\" onclick=\"member_teacher_show('"+st+"','"+url+"','"+teacher[i].teacher_id+"','360','600')\">"+teacher[i].teacher_name+"</u>";                        
							tds += "	</td>";
							tds += "	<td>"+teacher[i].teacher_sex+"</td>";
							tds += "	<td>"+teacher[i].teacher_age+"</td>";
							tds += "	<td>"+teacher[i].teacher_phone+"</td>";
							tds += "	<td class='text-l'>"+teacher[i].teacher_role+"</td>";
							tds += "	<td>"+teacher[i].teacher_profession+"</td>";
							var time=getMyDate1(teacher[i].teacher_dutytime);
							tds += "	<td>"+time+"</td>";
							tds += "	<td class='td-manage'>";
							tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"member_teacher_edit('"+s1+"','"+url1+"','"+teacher[i].teacher_id+"')\" style=\"text-decoration:none\" class='ml-5'><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
							tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"member_teacher_del(this,'"+teacher[i].teacher_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "TeacherInfoBymessage";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}
//显示场地数据
function getDataPlace(page) {
	$.ajax({
		url :path+"/pagePlace.do",
		type : "post",
		data : {"currentPage" : page},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var place = json.data;//返回内容
			if(place == "" || place == null){
				alert("查无信息");
			}else{
				var s = '场地编辑'
				var a = 'place_place_update.do'
						for(var i=0;i<place.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+place[i].place_id+"</td>";
							tds += "	<td>"+place[i].place_name+"</td>";
							tds += "	<td>"+place[i].place_place+"</td>";
							tds += "	<td>"+place[i].place_accommodatingPopulation+"</td>";
							tds += "	<td>"+place[i].place_indoorAndOutdoor+"</td>";
							tds += "	<td class='f-14'>";
							tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"place_role_edit('"+s+"','"+a+"','"+place[i].place_id+"')\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
							tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"place_role_del(this,'"+place[i].place_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "Place";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}

//显示场地安排数据
function getDataPlaceArrange(page) {
	$.ajax({
		url :path+"/pagePlaceArrange.do",
		type : "post",
		data : {"currentPage" : page},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var place = json.data;//返回内容
			if(place == "" || place == null){
				alert("查无信息");
			}else{
						for(var i=0;i<place.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='"+place[i].arrange_id+"' name='check_item'></td>";
							tds += "	<td>"+place[i].arrange_company+"</td>";
							tds += "	<td>"+place[i].arrange_place+"</td>";
							tds += "	<td>"+place[i].arrange_usetime+"</td>";
							tds += "	<td>"+place[i].arrange_stoptime+"</td>";
							tds += "	<td>"+place[i].arrange_people+"</td>";
							tds += "	<td>"+place[i].arrange_content+"</td>";
							if(place[i].arrange_statr == 0){
								tds += "	<td class='td-status'><span class='label label-defaunt radius'>未审核</span></td>";
							}else if(place[i].arrange_statr == 2){
								tds += "	<td class='td-status'><span class='label label-success radius'>未通过审核</span></td>";
							}else if(place[i].arrange_statr == 1){
								tds += "	<td class='td-status'><span class='label label-success radius'>已通过审核</span></td>";
							}else {
								tds += "	<td class='td-status'><span class='label label-success radius'>已取消预约</span></td>";
							}
							tds += "	<td class='f-14'>";
							if(place[i].arrange_statr == 0){
								tds +="			<a style=\"text-decoration:none\" onClick=\"member_start(this,'"+place[i].arrange_id+"')\" href=\"javascript:;\" title=\"通过审核\"><i class=\"Hui-iconfont\">&#xe6e1;</i></a>"
								tds +="			<a style=\"text-decoration:none\" onClick=\"member_stop(this,'"+place[i].arrange_id+"')\" href=\"javascript:;\" title=\"不通过审核\"><i class=\"Hui-iconfont\">&#xe631;</i></a>"
							}
							if(place[i].arrange_statr==1 || place[i].arrange_statr==2 || place[i].arrange_statr==4){
								tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"place_role_del(this,'"+place[i].arrange_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							}
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "PlaceArrange";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}
//显示社团活动信息
function getDataClubActivitiesInfo(page){
	$.ajax({
		url :path+"/pageClubActivities.do",
		type : "post",
		data : {"currentPage" : page},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var Club_activities = json.data;//返回内容
			var path2="http://192.168.100.218/p004/pic/sports_Poster/";
			if(Club_activities == "" || Club_activities == null){
				alert("查无信息");
			}else{
				var s = '社团活动编辑'
					var a = 'Club_activities_update.do'
						for(var i=0;i<Club_activities.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+Club_activities[i].clubactivities_id+"</td>";
							tds += "	<td>"+Club_activities[i].clubactivities_name+"</td>";
							tds += "	<td>"+Club_activities[i].clubactivities_place+"</td>";
							var img=Club_activities[i].sports_Poster;
							tds += "	<td>";
							if(img==null || img==""){
								tds += "		<a href=\"temp/big/keting.jpg\" data-lightbox=\"gallery\"><img width=\"210\" class=\"picture-thumb\" src=\"temp/big/keting.jpg\"></a>";
							}else{
								tds += "		<a href="+path2+img+" data-lightbox=\"gallery\"><img width=\"210\" height=\"150\" class=\"picture-thumb\" src="+path2+img+"></a>";
							}
							tds += "    </td>";
							var time=getMyDate1(Club_activities[i].clubactivities_time);
							var endtime=getMyDate1(Club_activities[i].clubactivities_endtime);
							tds += "	<td>"+time+"</td>";
							tds += "	<td>"+endtime+"</td>";
							tds += "	<td>"+Club_activities[i].organizational_unit+"</td>";
							
							if(Club_activities[i].clubactivities_status==0){
								tds += "	<td class=\"td-status\"><span class=\"label label-defaunt radius\">未预约</span></td>";
							}else if(Club_activities[i].clubactivities_status==1){
								tds += "	<td class=\"td-status\"><span class=\"label label-success radius\">预约成功</span></td>";
							}else if(Club_activities[i].clubactivities_status==2){
								tds += "	<td class=\"td-status\"><span style=\"cursor:pointer\" title=\"查看失败原因\" onclick=\"club_reason("+Club_activities[i].clubactivities_id+");\" class=\"label label-success radius\" style=\"color:red\">预约失败</span></td>";
							}else if(Club_activities[i].clubactivities_status==3){
								tds += "	<td class=\"td-status\"><span class=\"label label-success radius\">预约中</span></td>";
							}
							
							
							tds += "	<td class='f-14'>";
							if(Club_activities[i].clubactivities_status==0){
								tds += "     <a style=\"text-decoration:none\" onClick=\"clubActivities_start(this,'"+Club_activities[i].clubactivities_id+"')\" href=\"javascript:;\" title=\"预约\"><i class=\"Hui-iconfont\">&#xe603;</i></a>";
							}else if(Club_activities[i].clubactivities_status==3){
								tds += "     <a style=\"text-decoration:none\" onClick=\"clubActivities_stop(this,'"+Club_activities[i].clubactivities_id+"')\" href=\"javascript:;\" title=\"取消预约\"><i class=\"Hui-iconfont\">&#xe6de;</i></a>";
							}else if(Club_activities[i].clubactivities_status==2){
								tds += "     <a style=\"text-decoration:none\" onClick=\"clubActivities_start(this,'"+Club_activities[i].clubactivities_id+"')\" href=\"javascript:;\" title=\"重新预约\"><i class=\"Hui-iconfont\">&#xe603;</i></a>";
							}
							if(Club_activities[i].clubactivities_status!=1 && Club_activities[i].clubactivities_status!=3){
								tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"clubActivities_update('"+s+"','"+a+"','"+Club_activities[i].clubactivities_id+"')\" class='ml-5' style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
							}
							if(Club_activities[i].clubactivities_status!=3){
								tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"clubActivities_del(this,'"+Club_activities[i].clubactivities_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							}
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "ClubActivitiesInfo";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}
//显示校园活动信息
function getDataSchoolActivitiesInfo(page){
	$.ajax({
		url :path+"/pageSchoolActivities.do",
		type : "post",
		data : {"currentPage" : page},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var school_activities = json.data;//返回内容
			if(school_activities == "" || school_activities == null){
				alert("查无信息");
			}else{
				var s = '校园活动编辑'
					var a = 'school_activities_update.do'
						for(var i=0;i<school_activities.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+school_activities[i].school_activities_id+"</td>";
							tds += "	<td>"+school_activities[i].school_activities_name+"</td>";
							tds += "	<td>"+school_activities[i].school_activities_place+"</td>";
							tds += "	<td>"+school_activities[i].school_activities_organizer+"</td>";
							tds += "	<td>"+school_activities[i].school_activities_participants+"</td>";
							var time=getMyDate1(school_activities[i].school_activities_starttime);
							var endtime=getMyDate1(school_activities[i].school_activities_endtime);
							tds += "	<td>"+time+"</td>";
							tds += "	<td>"+endtime+"</td>";
							if(school_activities[i].school_activities_status==0){
								tds += "	<td class=\"td-status\"><span class=\"label label-defaunt radius\">未预约</span></td>";
							}else if(school_activities[i].school_activities_status==1){
								tds += "	<td class=\"td-status\"><span class=\"label label-success radius\">预约成功</span></td>";
							}else if(school_activities[i].school_activities_status==2){
								tds += "	<td class=\"td-status\"><span style=\"cursor:pointer\" title=\"查看失败原因\" onclick=\"school_reason("+school_activities[i].school_activities_id+");\" class=\"label label-success radius\" style=\"color:red\">预约失败</span></td>";
							}else if(school_activities[i].school_activities_status==3){
								tds += "	<td class=\"td-status\"><span class=\"label label-success radius\">预约中</span></td>";
							}
							
							tds += "	<td class='f-14'>";
							if(school_activities[i].school_activities_status==0){
								tds += "     <a style=\"text-decoration:none\" onClick=\"clubActivities_start(this,'"+school_activities[i].school_activities_id+"')\" href=\"javascript:;\" title=\"预约\"><i class=\"Hui-iconfont\">&#xe603;</i></a>";
							}else if(school_activities[i].school_activities_status==3){
								tds += "     <a style=\"text-decoration:none\" onClick=\"clubActivities_stop(this,'"+school_activities[i].school_activities_id+"')\" href=\"javascript:;\" title=\"取消预约\"><i class=\"Hui-iconfont\">&#xe6de;</i></a>";
							}else if(school_activities[i].school_activities_status==2){
								tds += "     <a style=\"text-decoration:none\" onClick=\"clubActivities_start(this,'"+school_activities[i].school_activities_id+"')\" href=\"javascript:;\" title=\"重新预约\"><i class=\"Hui-iconfont\">&#xe603;</i></a>";
							}
							if(school_activities[i].school_activities_status!=1 && school_activities[i].school_activities_status!=3){
								tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"schoolActivities_update('"+s+"','"+a+"','"+school_activities[i].school_activities_id+"')\" class='ml-5' style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
							}
							if(school_activities[i].school_activities_status!=3){
								tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"schoolActivities_del(this,'"+school_activities[i].school_activities_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							}
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "ClubActivitiesInfo";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}

//显示班级信息
function getDataClassInformationInfo(page){
	$.ajax({
		url :path+"/pageClassInformation.do",
		type : "post",
		data : {"currentPage" : page},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var classInformation = json.data;//返回内容
			if(classInformation == "" || classInformation == null){
				alert("查无信息");
			}else{
					var s = '班级信息编辑'
					var a = 'classInformation_update.do'
					var st='辅导员信息'
					var url='class_Instructor_show.do'
						for(var i=0;i<classInformation.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+classInformation[i].class_id+"</td>";
							tds += "	<td>"+classInformation[i].class_name+"</td>";
							tds += "	<td>";
							tds+="			<u style=\"cursor:pointer\" class=\"text-primary\" onclick=\"class_Instructor_show('"+st+"','"+url+"','"+classInformation[i].instructor_IDCard+"','360','600')\">"+classInformation[i].class_Instructor+"</u>";
							tds +="		</td>";
							tds += "	<td>"+classInformation[i].class_number+"</td>";
							tds += "	<td class='f-14'>";
							tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"class_update('"+s+"','"+a+"','"+classInformation[i].class_id+"')\" class='ml-5' style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
							tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"class_del(this,'"+classInformation[i].class_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "ClassInformationInfo";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}
//根据班级或辅导员名称搜班级信息
function getDataClassInformationInfoByMessage(page,message){
	$.ajax({
		url :path+"/pageClassInformationByMessage.do",
		type : "post",
		data : {"currentPage" : page,"message":message},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var classInformation = json.data;//返回内容
			if(classInformation == "" || classInformation == null){
				alert("查无信息");
			}else{
					var s = '班级信息编辑'
					var a = 'classInformation_update.do'
					var st='辅导员信息'
					var url='class_Instructor_show.do'
						for(var i=0;i<classInformation.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+classInformation[i].class_id+"</td>";
							tds += "	<td>"+classInformation[i].class_name+"</td>";
							tds += "	<td>";
							tds+="			<u style=\"cursor:pointer\" class=\"text-primary\" onclick=\"class_Instructor_show('"+st+"','"+url+"','"+classInformation[i].instructor_IDCard+"','360','600')\">"+classInformation[i].class_Instructor+"</u>";
							tds +="		</td>";
							tds += "	<td>"+classInformation[i].class_number+"</td>";
							tds += "	<td class='f-14'>";
							tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"class_update('"+s+"','"+a+"','"+classInformation[i].class_id+"')\" class='ml-5' style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
							tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"class_del(this,'"+classInformation[i].class_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "ClassInformationInfoByMessage";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}
//教师班表
function getDataClassScheduleInfo(page,message){
	$.ajax({
		url :path+"/pageClassSchedule.do",
		type : "post",
		data : {"currentPage" : page,"message":message},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var classschedule = json.data;//返回内容
			if(classschedule == "" || classschedule == null){
				alert("查无信息");
			}else{
					var s = '教师班表编辑'
					var a = 'classschedule_update.do'
					var st='教师信息'
					var url='class_Instructor_show.do'
						for(var i=0;i<classschedule.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+classschedule[i].class_schedule_id+"</td>";
							tds += "	<td>";
							tds+="			<u style=\"cursor:pointer\" class=\"text-primary\" onclick=\"class_teacher_show('"+st+"','"+url+"','"+classschedule[i].teacher_idcard+"','360','600')\">"+classschedule[i].class_schedule_teachername+"</u>";
							tds +="		</td>";
							tds += "	<td>"+classschedule[i].class_schedule_classname+"</td>";
							tds += "	<td class='f-14'>";
							tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"class_schedule_update('"+s+"','"+a+"','"+classschedule[i].class_schedule_id+"')\" class='ml-5' style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
							tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"class_schedule_del(this,'"+classschedule[i].class_schedule_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "ClassScheduleInfo";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}
function onc(btn){
	if(btn.checked == true){
		$(btn).html("checked");
	}else{
		$(btn).html("");
	}
}

//显示专业信息
function getDataProfessionInfo(page){
	$.ajax({
		url :path+"/pageProfession.do",
		type : "post",
		data : {"currentPage" : page},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var profession = json.data;//返回内容
			if(profession == "" || profession == null){
				alert("查无信息");
			}else{
				var s = '专业信息编辑'
					var a = 'profession_update.do'
						for(var i=0;i<profession.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+profession[i].professional_id+"</td>";
							tds += "	<td>"+profession[i].professional_name+"</td>";
							tds += "	<td>"+profession[i].professional_time+"</td>";
							tds += "	<td>"+profession[i].professional_introduce+"</td>";
							tds += "	<td>"+profession[i].professional_tuition+"</td>";
							tds += "	<td>"+profession[i].development_direction+"</td>";
							tds += "	<td class='f-14'>";
							tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"profession_update('"+s+"','"+a+"','"+profession[i].professional_id+"')\" class='ml-5' style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
							tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"profession_del(this,'"+profession[i].professional_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "ProfessionInfo";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}

//根据专业名称搜专业
function getDataProfessionInfoByMessage(page,message){
	$.ajax({
		url :path+"/pageProfessionByMessage.do",
		type : "post",
		data : {"currentPage" : page,"message":message},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var profession = json.data;//返回内容
			if(profession == "" || profession == null){
				alert("查无信息");
			}else{
				var s = '专业信息编辑'
					var a = 'profession_update.do'
						for(var i=0;i<profession.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+profession[i].professional_id+"</td>";
							tds += "	<td>"+profession[i].professional_name+"</td>";
							tds += "	<td>"+profession[i].professional_time+"</td>";
							tds += "	<td>"+profession[i].professional_introduce+"</td>";
							tds += "	<td>"+profession[i].professional_tuition+"</td>";
							tds += "	<td>"+profession[i].development_direction+"</td>";
							tds += "	<td class='f-14'>";
							tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"profession_update('"+s+"','"+a+"','"+profession[i].professional_id+"')\" class='ml-5' style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
							tds += "		<a title=\"删除\" href=\"javascript:;\" onclick=\"profession_del(this,'"+profession[i].professional_id+"')\" class='ml-5' style='text-decoration:none'><i class='Hui-iconfont'>&#xe6e2;</i></a>";
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "ProfessionInfoByMessage";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}
//显示班级课程安排
function getDataclass_curriculum(message){
	$.ajax({
		url :path+"/ShowClassCurriculum.do",
		type : "post",
		data : {"message":message},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			var curriculum = json.data;
			if(curriculum == "" || curriculum == null){
			}else{
				var s = '班级课程编辑编辑'
					var a = 'class_curriculum_update.do'
						for(var i=0;i<curriculum.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td>"+curriculum[i].class_curriculum_time+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_one+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_two+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_three+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_four+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_five+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_six+"</td>";
							tds += "	<td class='f-14'>";
							tds += "		<a title=\"编辑\" href=\"javascript:;\" onclick=\"class_curriculum_update('"+s+"','"+a+"','"+curriculum[i].class_curriculum_id+"')\" class='ml-5' style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
							tds += "	</td>"; 
							tds += "</tr>";
							$("#content").append(tds);
							var classname=curriculum[i].class_curriculum_classname;
						}
							$("#classname").html(classname);
			}
			
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}

//显示班级学生信息
function getDataClassStudentInfo(page,message) {
	$.ajax({
		url :path+"/pageClassStudentInfo.do",
		type : "post",
		data : {"currentPage" : page,"message":message},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var student = json.data;//返回内容
			if(student == "" || student == null){
				alert("查无信息");
			}else{
						var st='个人信息'
						var url='member_student_show.do'
						for(var i=0;i<student.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+student[i].student_id+"</td>";
							tds += "	<td>";
							tds	+= "       <u style=\"cursor:pointer\" class='text-primary' onclick=\"member_student_show('"+st+"','"+url+"','"+student[i].student_id+"','360','600')\">"+student[i].student_name+"</u>";                        
							tds += "	</td>";
							tds += "	<td>"+student[i].student_sex+"</td>";
							tds += "	<td>"+student[i].student_age+"</td>";
							tds += "	<td>"+student[i].student_phone+"</td>";
							tds += "	<td class='text-l'>"+student[i].student_code+"</td>";
							var time=getMyDate1(student[i].student_Date_of_admission);
							tds += "	<td>"+time+"</td>";
							tds += "    <td class='td-status'>";
							tds += "    	<span class=\"label label-success radius\">"+student[i].student_major+"</span>";
							tds += "    </td>";
							tds += "	<td>"+student[i].student_class+"</td>";
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "ClassStudentInfo";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}

//显示辅导员所带的班级的所有课程
function getDataclass_curriculumInformation(){
	$.ajax({
		url :path+"/ShowClassCurriculumInformation.do",
		type : "post",
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			var curriculum = json.data;
			if(curriculum == "" || curriculum == null){
				alert("查无信息");
			}else{
						for(var i=0;i<curriculum.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td>"+curriculum[i].class_curriculum_time+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_one+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_two+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_three+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_four+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_five+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_six+"</td>";
							tds += "</tr>";
							$("#content").append(tds);
							var classname=curriculum[i].class_curriculum_classname;
						}
							$("#classname").html(classname);
			}
			
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}

//根据选择的班级查询该班所有的学生
function getDatastudentachievementInfo(page,classname,message){
	$.ajax({
		url :path+"/pagefindStudentByClassName.do",
		type : "post",
		data : {"currentPage" : page,"classname":classname,"message":message},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var student = json.data;//返回内容
			if(student == "" || student == null){
				
			}else{
						for(var i=0;i<student.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+student[i].student_name+"</td>";
							tds += "	<td>"+student[i].student_code+"</td>";
							tds += "	<td>"+student[i].student_major+"</td>";
							tds += "	<td>";
							tds += "		<input type='text' value='' style='height:25px;border:1px solid #E0E0E0;'>";		
							tds += "	</td>";
							tds += "	<td>";
							tds += "		<input type='text' value='' style='height:25px;border:1px solid #E0E0E0;'>";		
							tds += "	</td>";
							tds += "	<td>"
							tds += "		<input type='text' value='' readonly onclick=\"calculate_total_achievement(this)\" style='height:25px;border:1px solid #E0E0E0;'>";	
							tds += "	</td>";
							tds += "	<td>";
							tds += "    	<a onclick=\"student_achievement(this)\">保存</a>";
							tds += "	</td>";
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "studentachievementInfo";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}

//根据选择的学期查询该班所有的学生
function getDatastudentachievementBySemesterInfo(page,classname,semester,message){
	$.ajax({
		url :path+"/pagefindStudentBySemester.do",
		type : "post",
		data : {"currentPage" : page,"classname":classname,"semester":semester,"message":message},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var student = json.data;//返回内容
			if(student == "" || student == null){
				getDatastudentachievementInfo(page,classname,message);
			}else{
						for(var i=0;i<student.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+student[i].student_name+"</td>";
							tds += "	<td>"+student[i].student_code+"</td>";
							tds += "	<td>"+student[i].student_profession+"</td>";
							tds += "	<td>";
							tds += "		<input type='text' value='"+student[i].student_midterm_achievement+"' style='height:25px;border:1px solid #E0E0E0;'>";		
							tds += "	</td>";
							tds += "	<td>";
							tds += "		<input type='text' value='"+student[i].student_final_achievement+"' style='height:25px;border:1px solid #E0E0E0;'>";		
							tds += "	</td>";
							tds += "	<td>"
							tds += "		<input type='text' readonly  onclick=\"calculate_total_achievement(this)\" value='"+student[i].student_total_achievement+"' style='height:25px;border:1px solid #E0E0E0;'>";	
							tds += "	</td>";
							tds += "	<td>";
							tds += "    	<a onclick=\"student_achievement(this)\">保存</a>";
							tds += "	</td>";
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "studentachievementBySemesterInfo";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}
//教师查看所带班级的课程
function Lookclass_curriculum(classname){
	$.ajax({
		url :path+"/Lookclass_curriculum.do",
		type : "post",
		data:{"classname":classname},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			var curriculum = json.data;
			if(curriculum == "" || curriculum == null){
				
			}else{
						for(var i=0;i<curriculum.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td>"+curriculum[i].class_curriculum_time+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_one+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_two+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_three+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_four+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_five+"</td>";
							tds += "	<td>"+curriculum[i].class_curriculum_six+"</td>";
							tds += "</tr>";
							$("#content").append(tds);
							var classname=curriculum[i].class_curriculum_classname;
						}
							$("#class_name").html(classname);
			}
			
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}

//辅导员查看所带班级的成绩
function getDataClassAchievementInfo(page,semester,message){
	$.ajax({
		url :path+"/pageLookClassAchievement.do",
		type : "post",
		data : {"currentPage" : page,"semester":semester,"message":message},
		dataType : "json",
		success : function(json) {
			$("#content").empty();
			total = json.totalCount; //总记录数  
			$("#tiao").html(total);
			pageSize = json.pageSize; //每页显示条数  
			curPage = json.currentPage; //当前页  
			totalPage = json.totalPage; //总页数  
			var student = json.data;//返回内容
			if(student == "" || student == null){
				layer.msg('暂时还没有这个学期的成绩',{icon: 5,time:2000});
			}else{
						for(var i=0;i<student.length;i++){
							var tds="";
							tds += "<tr class='text-c'>";
							tds += "	<td><input type='checkbox' value='' name=''></td>";
							tds += "	<td>"+student[i].student_name+"</td>";
							tds += "	<td>"+student[i].student_code+"</td>";
							tds += "	<td>"+student[i].student_profession+"</td>";
							tds += "	<td>";
							tds += "		<input type='text' value='"+student[i].student_midterm_achievement+"' disabled style='height:25px;border:1px solid #E0E0E0;'>";		
							tds += "	</td>";
							tds += "	<td>";
							tds += "		<input type='text' value='"+student[i].student_final_achievement+"'disabled style='height:25px;border:1px solid #E0E0E0;'>";		
							tds += "	</td>";
							tds += "	<td>"
							tds += "		<input type='text' readonly onclick=\"calculate_total_achievement(this)\" value='"+student[i].student_total_achievement+"' disabled style='height:25px;border:1px solid #E0E0E0;'>";	
							tds += "	</td>";
							tds += "</tr>";
							$("#content").append(tds);
						}
			}
			
		},
		complete : function() { //生成分页条  
			var a = "ClassAchievementInfo";
			getPageBar(a);
		},
		error : function() {
			alert("数据加载失败");
		}
	});
}
function getMyDate(str){  
    var oDate = new Date(str),  
    oYear = oDate.getFullYear(),  
    oMonth = oDate.getMonth()+1,  
    oDay = oDate.getDate(),  
    oHour = oDate.getHours(),  
    oMin = oDate.getMinutes(),  
    oSen = oDate.getSeconds(),  
    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间  
    return oTime;  
}; 

function getMyDate1(str){  
    var oDate = new Date(str),  
    oYear = oDate.getFullYear(),  
    oMonth = oDate.getMonth()+1,  
    oDay = oDate.getDate(),  
    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay);//最后拼接时间  
    return oTime;  
}; 

//补0操作
function getzf(num){  
  if(parseInt(num) < 10){  
      num = '0'+num;  
  }  
  return num;  
}