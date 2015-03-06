<html>
<head>
<title>Welcome!</title>
</head>
<body>
<#--导入的路径为为pname定义的路径开始-->
<#include "/include/top.ftl">
main content。

<#assign n=1/>
${n+1}
<#assign s="1">
${s+1}
<#assign b=true>
<#--对于freemarker而已，只能用${}方式输出数字或者字符串-->
<#--${b}:是一个boolean类型，无法输出，需要将其转化为字符串输出-->
${b?string}<#--将boolean转换为字符串-->
${b?string("yes","no")}

<#--${.now}显示当前日期-->
${.now}-->${.now?string("yyyy/MM/dd")}

<#assign d="2015-03-05 00:00:00"?date("yyyy-MM-dd HH:mm:ss")>
${d}
<#--老版本用datetime-->
<#assign dd="2015-03-05 00:00:00"?datetime("yyyy-MM-dd HH:mm:ss")>
${dd}

</body>
</html> 