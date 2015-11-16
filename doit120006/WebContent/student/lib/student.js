window.onload = function(){
  try{
    Calendar.setup({
    inputField  : "birthday",   //ID of the input field
    ifFormat    : "%Y-%m-%d",   // the date format
    button      : "trigger"     // ID of the button
  });
    ajax('code/getcode.action?code=Province&upid=',getCode,'province',null);
    ajax('code/getcode.action?code=Grade&upid=',getCode,'grade',null);
    ajax('code/getcode.action?code=Schoolclass&upid=',getCode,'schoolclass',null);
    ajax('code/getcode.action?code=Degree&upid=',getCode,'degree',null);
    ajax('code/getcode.action?code=Sex&upid=',getCode,'sex',null);
  }catch(e){
    alert("Window onload errror:" + e);
  }
};

function provinceSelected(){
  try{
    if(frm.province.options.length==1){
    ajax('code/getcode.action?code=Province&upid=',getCode,'provice',null);
    }else{
      var province = frm.province.value;
      if(province!=''){
        ajax('code/getcode.action?code=School&upid='+province,getCode,'school',null);
      }else{
        delOption('school');
        alert("请选择一个省份");
      }
    }
  }catch(e){
    alert("error message");
  }
}

function schoolClick(){
  if(frm.school.options.length==1){
    alert("请选择一个省份！");
  }
}

function schoolSelected(){
  try{
  var school = frm.school.value;
  if(school!=''){
    ajax('code/getcode.action?code=Department&upid='+school,getCode,'department',null);
  }else{
    delOption('department');
    alert("请选择一个学校");
  }
  }catch(e){
    alert("error message");
  }
}

function departmentClick(){
  if(frm.department.options.length==1){
    alert("请选择一个学校！");
  }
}

function departmentSelected(){
  try{
  var department = frm.department.value;
  if(department!=''){
    ajax('code/getcode.action?code=Major&upid='+department,getCode,'major',null);
  }else{
    delOption('major');
    alert("请选择一个院系");
  }
  }catch(e){
    alert("error message");
  }
}

function majorClick(){
  if(frm.major.options.length==1){
    alert("请选择一个院系！");
  }
}

function gradeClick(){
  if(frm.grade.options.length==1){
    alert("请选择一个年级！");
  }
}

function degreeClick(){
  if(frm.degree.options.length==1){
    alert("请选择学生类别！");
  }
}

function gradeSelected(){
  if(frm.studentId.value.length<=4)
    frm.studentId.value = frm.grade.value;
}

function schoolclassClick(){
  if(frm.schoolclass.options.length==1){
    alert("请选择一个班级！");
  }
}

function sexClick(){
  if(frm.sex.options.length==1){
    alert("请选择性别！");
  }
}
