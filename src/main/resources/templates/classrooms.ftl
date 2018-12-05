<#import "parts/common.ftl" as c>

 <@c.page>
 
 <table class="table table-striped table-bordered table-hover">
    <#list classrooms as classroom>
        <tr>		
			<td>${classroom.name}</td>
			<td><a href="/classrooms/edit/${classroom.id}">Править</a></td>
			<td><a href="/classrooms/delete/${classroom.id}">Удалить</a></td>            
        </tr>
    </#list>   
</table>

<a class="btn btn-primary mt-5" href="/classrooms/new">Новая аудитория</a>

</@c.page>
