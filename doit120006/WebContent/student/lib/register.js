window.onload = function(){
  try{
	  Calendar.setup({  
		    inputField  : "birthday",   //ID of the input field  
		    ifFormat    : "%Y-%m-%d",   // the date format  
		    button      : "trigger"     // ID of the button  
		  });
    ajax('../lib/sex.xml',getCode,'sex',null);
    ajax('../lib/schoolclass.xml',getCode,'schoolclass',null);
    ajax('../lib/grade.xml',getCode,'grade',null);
    ajax('../lib/major.xml',getCode,'major',null);

  }catch(e){
    alert("Window onload errror:" + e);
  }
};
