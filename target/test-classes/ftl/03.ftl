<html>
<head>
<title>Welcome!</title>
</head>
<body>
<#--导入的路径为为pname定义的路径开始-->
<#include "/include/top.ftl">
<#--以下定义是和root中的username有冲突,其实不是覆盖，优先级高的将其隐藏-->
<#assign username="barricelli">

${username}<#--模板中存在，则在模板中找-->

${.globals.username}<#--model中找-->

<#list emps as emp>
<#--循环变量仅仅只是在循环中有效，除了循环马上失效，不会影响模板变量-->
	${emp.name}
</#list>

<#--
freemarker的几种数据范围
1.数据对象变量--root中的变量
2.模板变量--模板文件中通过assign定义
3.局部变量
4.循环变量

优先级： 模板变量   > root中（model中找）

-->

</body>
</html> 