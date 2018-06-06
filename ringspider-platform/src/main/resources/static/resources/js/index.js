
var re=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
var objExp=new RegExp(re);


function pan(){
	var str=document.getElementById("email").value;

	if(document.getElementById("username").value=="" || document.getElementById("username").value=="Name")
	{
	alert("Please enter your name."); 
	return false; 
	}	
    if(document.getElementById("email").value=="" || document.getElementById("email").value=="E-mail")
	{
	alert("Please enter E-mail."); 
	return false; 
	}	
    else if(objExp.test(str)==false)
	{
	alert("Please enter a valid E-mail."); 
	return false;
	}
	else if(document.getElementById("content").value=="" || document.getElementById("content").value=="Your Message")
	{
	alert("Please enter your message."); 
	return false;
	}	
	else if(document.getElementById("checkcodestr").value=="" || document.getElementById("checkcodestr").value=="CAPTCHA")
	{
	alert("Please enter CAPTCHA."); 
	return false;
	}	
	return true;

}