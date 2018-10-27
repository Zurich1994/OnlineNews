
function dsort() { 
	
    var array = new Array(); //用于保存 选中的那一条数据的ID  
    var flag; //判断是否一个未选  
    $("input[name='selectFlag']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox 
                if ($(this).attr("checked")) { //判断是否选中   
                    flag = true; //只要有一个被选择 设置为 true 
                } 
            }) 
    if (flag) { 
    	if(confirm('删除分类会删除该分类下的所有新闻，确定删除么')==false)return false;
        $("input[name='selectFlag']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox 
                    if ($(this).attr("checked")) { //判断是否选中   
                        //alert($(this).val()); 
                        array.push($(this).val()); //将选中的值 添加到 array中 
                        //str+=$(this).val()+","; 
                    } 
                }) 
    var condition=document.queryfenlei.condition.value;
        window.self.location = "PLDeleteSortServlet?condition="+condition+"&info=" + array; 
    } else { 
        alert("请至少选择一个分类"); 
    } 
}
function dgoods() { 
    var array = new Array(); //用于保存 选中的那一条数据的ID  
    var flag; //判断是否一个未选  
    $("input[name='selectFlag']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox 
                if ($(this).attr("checked")) { //判断是否选中   
                    flag = true; //只要有一个被选择 设置为 true 
                } 
            }) 
    if (flag) { 
    	if(confirm('确定删除选中所有么')==false)return false;
        $("input[name='selectFlag']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox 
                    if ($(this).attr("checked")) { //判断是否选中   
                        //alert($(this).val()); 
                        array.push($(this).val()); //将选中的值 添加到 array中 
                        //str+=$(this).val()+","; 
                    } 
                }) 
    var condition=document.querygoods.condition.value;
    var selfenlei=document.querygoods.selfenlei.value;
        window.self.location = "PLDeleteGoodsServlet?condition="+condition+"&selfenlei="+selfenlei+"&info=" + array; 
    } else { 
        alert("请至少选择一条新闻"); 
    } 
}
function getsort(what){
	var condition = "";
	window.self.location = "GetSortServlet?what="+what;
}
