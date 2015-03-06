<html>
<head>
<title>Welcome!</title>
</head>
<body>
hello:${emp.name}---${emp.id} -- ${emp.age}

<#--list-->
<#if emp.age lt 18>
	${emp.name}是未成年
	
<#elseif emp.age gt 65>
	${emp.name}，作为一个程序员，你可以光荣退休了。
<#else>
	${emp.name}，加入绿云电商吧
</#if>

<#list emps as emp>
	hello:${emp.name}---${emp.id} -- ${emp.age}
</#list>
</body>
</html> 