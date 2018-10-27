// JavaScript Document
function logincheck(){
	var username=document.f1.username.value;
	var password=document.f1.pass.value;
	var s1=document.getElementById("s1");
	s1.innerHTML="";
	if(username==""&&password==""){
		s1.innerHTML="用户名和密码不能为空!";
		}
	else if(username==""){
		s1.innerHTML="用户名不能为空";
		}
	else if(password==""){
		s1.innerHTML="密码不能为空!";
		}
	else{
		document.f1.submit();
		}
	}
function udj(){
	document.f1.username.placeholder=""; 
	}
function ubdj(){
	document.f1.username.placeholder="请输入用户名，祝您工作愉快";}
function pdj(){
	document.f1.pass.placeholder=""; 
	}
function pbdj(){
	document.f1.pass.placeholder="请输入您的密码";
	}
function czuser(){
	document.f1.username.value="";
	}
function czpass(){
	document.f1.pass.value="";
	}
function tzzc(){
	  window.location.href="zhuce.jsp";
}