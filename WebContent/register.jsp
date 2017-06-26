<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员注册</title>
<style type="text/css">

.clear{
	clear: both;
}

#bgcolor{
	background-color: #FF2C4C;
}
#bg_img {
	margin-top:20px;
	background: url("../images/loginbg.jpg") no-repeat;
	width: 100% ;
	height: 530px;
}

#login_context{
	margin-top:55px;
	margin-left:850px;
    height: 430px;
    width: 420px;
    padding: 40px;
    background-color: #ffffff;
    border-radius: 4px;
    box-sizing: border-box;
	float:left;
}

#login_top{
	font-family:"Microsoft JhengHei";
	margin: 10px 0 0 -58px;
    padding: 18px 10px 18px 60px;
    background: #F13E70;
    position: relative;
    color: #fff;
    font-size: 16px;
    
}

#darkbannerwrap {
    background: url(../images/aiwrap.png);
    width: 18px;
    height: 10px;
    margin: 0 0 20px -58px;
    position: relative;
}

#errorMsg{
	font-family:"Microsoft JhengHei";
	font-size: 10px;
	color: #FF4400;
	margin-bottom: 5px;
	margin-left:3px;
	margin-right:34px;

}

input[type=text],
input[type=password]{
    border: 1px solid #DCDEE0;
    vertical-align: middle;
    border-radius: 3px;
    height: 35px;
    padding: 0px 16px;
    font-size: 15px;
    color: #555555;
    outline:none;
    width:80%;
}

input[type=text]:focus,
input[type=password]:focus{
    border: 1px solid #27A9E3;
}

#password{
	margin-top:25px;		
}

#code{
	margin-top:25px;		
	
}

span {
	float: left;
}

input[type=submit],
input[type=button]{
    display: inline-block;
    vertical-align: middle;
    padding: 12px 24px;
    margin: 0px;
    font-size: 18px;
    line-height: 24px;
    text-align: center;
    white-space: nowrap;
    vertical-align: middle;
    cursor: pointer;
    color: #ffffff;
    background-color: #F13E70;
    border-radius: 3px;
    border: none;
    -webkit-appearance: none;
    outline:none;
    width:100%;
}
#codeImg{
	margin-top: 10px;
}

#login{
	margin-top: 25px;
}


</style>

</head>
<body>
  	<jsp:include page="header.jsp"/>
	   	<div id="bgcolor">
	  	  	<div id = "bg_img">
	  	  		<div id="login_context">
	  	  			<div id="login_top">仲有书-会员注册</div>
	  	  			<div id="darkbannerwrap"></div>
					<form action="Register" method="post" name="form1">
	  	  			<div id = "errorMsg">  ${error }${msg }</div> 
	  	  			<div id="name">
	  	  				<input name="userName" type="text">
	  	  			</div>
	  	  			<div class="clear"></div>
	  	  			<div id="password">
	  	  				<input name="password" type="password">
	  	  			</div>
	  	  			<div class="clear"></div>
	  	  			<div class="clear"></div>
	  	  			<div id="login">
	  	  				<input value="注册" style="width:100%;" type="submit" onclick="return check();">
	  	  			</div>
	  				</form>
	  	  		</div>
	  	  	</div>
  	  	</div>  
  	  	<jsp:include page="tail.jsp"/>
</body>
<script type="text/javascript">
	function check() {
		if(form1.userName.value == "") {
			alert('请输入用户名！');
			return false;
		}
		if(form1.password.value == "") {
			alert('请输入密码！');
			return false;
		}
		return true;
	}
</script>
</html>