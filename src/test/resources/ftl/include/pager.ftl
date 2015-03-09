<#macro pager totalPage curPage url showPage clz="">
	<#if showPage gte totalPage> 
		<@showPager start=1 end=totalPager url=url clz=clz curPage=curPage/>
		<#else>
	<#--	<@showPager start=1 end=showPage url=url clz=clz curPage=curPage/>-->
		<#local half=(showPage/2)/>  
		<#--half大于当前页，表示把前面的值全部显示出来-->
		<#if half gte curPage>
			<@showPager start=1 end=halt url=url clz=clz curPage=curPage/>
			<@showPager start=(curPage+1) end=showPage url=url clz=clz curPage=curPage/>
		<#elseif (half+curPage) gte totalPage >
			<@showPager start=(totalPage-showPage) end=(curPage-1) url=url clz=clz curPage=curPage/>
			<@showPager start=curPage end=totalPage url=url clz=clz curPage=curPage/>
		<#else>
			<@showPager start=(curPage-half) end=curPage url=url clz=clz curPage=curPage/>
			<@showPager start=(curPage+1) end=(curPage+half) url=url clz=clz curPage=curPage/>
		</#if>
	</#if>
	
</#macro>

<#macro showPager start end url clz curPage>
	<#list start..end as page>
		<#if curPage==page>
			[${page}]
			<#else>
			<a href="${url}" ${(clz=="")?string("","class='${clz}'")}>${page}</a>
		</#if>
	</#list>
</#macro>