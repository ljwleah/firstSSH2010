// FileName: ajax.js
//调用ajax.js网页的基础上下文（网页引用的起始点）
var currentContext=this;
//设置变量global引用网页的起始点
var global=function(){
	return currentContext;
};

/**
 * 定义AJAX的主函数
 * url:AJAX希望引用的网络资源地址
 * func:AJAX返回内容的接收函数
 * tag:函数func的第一个参数，用于引用网页中的标记
 * p:函数func的第二个参数，传递给func中级联函数的引用
 */ 
function ajax(url,func,tag,p){
	try{
		if(url=="")	return;
		//声明浏览器中的一个活动对象，用于通过HTTP请求XML内容，是AJAX的核心对象
		var xhr = newXMLHttpRequest();
		//声明一个异步响应函数，用于处理xhr的各种状态变化
		var hfun = getReadyStateHandler(xhr,func,tag,p);
		xhr.onreadystatechange = hfun;
		//通过xhr向网络发送到url的请求
		xhr.open("GET",url,true);
		//xhr的发送信息为空
		xhr.send(null);
	}catch(e){
		alert(e);
	}
}

/**
 * 返回不同类型浏览器所定义的XMLHttpRequest对象类型
 */
function newXMLHttpRequest(){
	var xRequest = null;
	var IEXMLHttpVersion = [
	    "MSXML2.XMLHTTP.8.0",
	    "MSXML2.XMLHTTP.7.0",
		"MSXML2.XMLHTTP.6.0",
		"MSXML2.XMLHTTP.5.0",
		"MSXML2.XMLHttp.4.0",
		"MSXML2.XMLHttp.3.0",
		"MSXML2.XMLHttp",
		"Microsoft.XMLHttp"
	];

 	if(window.ActiveXObject){
    	// ...otherwise, use the ActiveX control for IE5.x , IE6, IE7ActiveX
		for(var i=0; i<IEXMLHttpVersion.length; i++){
			try{
				xRequest = new ActiveXObject(IEXMLHttpVersion[i]);
				break;
			}catch(err){;}
		}
	}else if(window.XMLHttpRequest){
		// If IE7, Mozilla, Safari, etc: Use native object
		xRequest = new XMLHttpRequest();
		if (xRequest.overrideMimeType) {
			xRequest.overrideMimeType('text/xml');
		}
	}
	return xRequest;
}

var to=null;	//定义xhr的定时回调
/**
 * ajax(url,func,tag,p)函数中声明的异步响应函数
 * @param oxhr ：引用xhr=XMLHttpRequest对象
 * @param func ：所定义的接收信息处理函数
 * @param tag  ：func函数中用于处理信息的网页标记
 * @param p    ：p在func中调用的一个级联函数
 * @returns {Function}
 */
function getReadyStateHandler(oxhr,func,tag,p){
	return function(){
		var flag = false;	//尚未读取内容或没有读到内容
		if(!to){
			//this 是所有返回的function()
			this.clearTimeout(to);  //如果to变量设置了定时器，清除掉
			to=null;
		}
		/*状态 	名称 			描述
		 *0 	Uninitialized 	初始化状态。XMLHttpRequest 对象已创建或已被 abort() 方法重置。 
		 *1 	Open open() 	方法已调用，但是 send() 方法未调用。请求还没有被发送。 
		 *2 	Send Send() 	方法已调用，HTTP 请求已发送到 Web 服务器。未接收到响应。
		 *3 	Receiving 		所有响应头部都已经接收到。响应体开始接收但未完成。
		 *4 	Loaded HTTP 	响应已经完全接收。 
		 */
		if(oxhr.readyState == 4){
			//由服务器返回的 HTTP 状态代码，如 200 表示成功，
			//而 404 表示 "Not Found" 错误。
			//当 readyState 小于 3 的时候读取这一属性会导致一个异常。
			if(oxhr.status == 200){
				//responseXML对请求的响应，解析为 XML 并作为 Document 对象返回。
				if(oxhr.responseXML==null)	{
					alert("返回的XML内容为空 ");
				}else{
					flag = true;	//读取内容成功
					func(oxhr.responseXML,tag,p);
				}
			}else{
				alert("HTTP请求错误，错误码为" + oxhr.status);
			}
		}else{
			//alert("正在异步接收中");
		}
		if(!flag){	//本次接收处理没有成功
			//设置10ms的定时器，回调this（本处理函数），同时赋值定时器给to
			to = this.setTimeout(this,10);
		}
	};
}