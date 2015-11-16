//	Filename:	code.js
/**
 * 解析code的XML内容，ajax中的参数func，增加select的option列表主函数
 * @param xmlobj 	：xhr对象，ajax中的参数对象xhr
 * @param tag		：要添加option的select对象id，ajax中的参数tag
 * @param fn		：级联方法，ajax中的参数p
 */
function getCode(xmlobj,tag,fn){
	//获取code节点集合
	var codes = xmlobj.getElementsByTagName("code");
	//删除目标option内容
	delOption(tag);
	//添加code内容到select的option列表
	for(var i=0;i<codes.length;i++){
		var code = codes[i];
		addOption(tag,code);
	}
	//如果级联方法fn不为null则调用执行之
	if(fn!=null) fn();
}

/**
 * 增加option对象操作
 * @param slt		：=tag参数
 * @param code		：XML中的一个code节点对象
 */
function addOption(slt,code){
	//获得要添加option的select对象
	var select = document.getElementById(slt);
	//实例化一个新的option对象，name=code.name，id=code.id
	var option = new Option(code.getAttribute("name"),code.getAttribute("id"));
	//在select对象options列表的末尾增加新实例化的option
	select.options[select.options.length] = option;
}

/**
 * 删除指定select的所有option对象
 * @param dst	：希望选择的select的id
 */
function delOption(dst){
	var select = document.getElementById(dst);
	while(select.options.length>1){
		select.remove(1);
	}
}   

/**
 * 遍历指定id的select的options列表，找到其值等于src的option设置为选定
 * @param src	：希望选定的option对象值
 * @param dst	：指定select的id
 */
function setSelected(src,dst){
	var select = document.getElementById(dst);
	if(src!=null){
		for(var i=0;i<select.options.length;i++){
			if(select.options[i].value==src){
				select.options[i].selected='selected';
			}
		}
	}
}
