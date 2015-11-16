/**
 * Filename: page.js
 */
var trid = '-';
function selectnode(id){
    try{
        if(trid != id){
            document.all['tr_'+ trid].style.backgroundColor = '';
            document.all['tr_'+ trid].style.color = '';
        }
    }catch(Exception){
    }finally{
        trid = id;
        document.all['tr_'+ trid].style.backgroundColor = 'gold';
        document.all['tr_'+ trid].style.color = 'black';
    }
}

function getFirst(){
	frm.pagePoint.value = 0;
	frm.submit();
}

function getPrevious(){
	var p = parseInt(frm.pagePoint.value);
	if(p>0)	p=p-1;
	frm.pagePoint.value = p;
	frm.submit();
}

function getNext(){
	var pg = parseInt(frm.pagePoint.value);
	var pc = parseInt(frm.pageCount.value);
	if(pg < pc)	pg = pg + 1;
	frm.pagePoint.value = pg;
	frm.submit();
}

function getLast(){
	frm.pagePoint.value = frm.pageCount.value;
	frm.submit();
}

