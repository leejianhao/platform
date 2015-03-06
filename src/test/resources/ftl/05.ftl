<html>
<head>
<title>Welcome!</title>
</head>
<body>
<#--在freemarker出现空置会报错-->
${emp.id} --${emp.group !"anonymous"}
<#--如果使用了兑现个导航，！仅仅会判断最后一个是否为空,如果导航中某个对象为空依然会报错
所以在对象导航中最好使用括号-->
${(emp.group.name) !"anonymous"}

<#--??判断是否为空-->
<#if emp.group??>
	emp.group
</#if>

${emp.group???string}
</body>
</html> 