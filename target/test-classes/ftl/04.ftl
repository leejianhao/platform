<html>
<head>
<title>Welcome!</title>
</head>
<body>
<#--如果使用include来导入多个ftl，则会产生变量覆盖问题
 所以应导入相应的ftl编写的函数等模块，不建议使用include，而是用import来代替，include一般用来引入模板的公共部分（无变量定义）-->
<#include "/include/inc1.ftl"/>
<#include "/include/inc2.ftl"/>

<#--import 引入名称空间，类似java package的作用-->
<#import "/include/inc1.ftl" as inc1/>
${inc1.username}

<#import "/include/inc2.ftl" as inc2/>
${inc2.username}

${username}
</body>
</html> 