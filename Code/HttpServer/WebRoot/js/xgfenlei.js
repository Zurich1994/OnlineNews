// JavaScript Document
// JavaScript Document
function xgfn(){
	var flno=document.xgfenlei.flno.value;
	var flname=document.xgfenlei.flname.value;
	var s1=document.getElementById("s1");
	var s5=document.getElementById("s5");
	s5.innerHTML="";
	s1.innerHTML="";
	var i=1;
	if(flno==""){
		s1.innerHTML="分类编号不能为空";
		i=0;
		}
	if(flname==""){
		s5.innerHTML="分类名称不能为空";
		i=0;
		}
	if(i==1){
		if(confirm("确定修改么？"))
			 
	    {
			document.xgfenlei.submit();
	 
	     }
	    else
	 
	    {
	    }
		}
	}