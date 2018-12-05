<#import "parts/common.ftl" as c>

 <@c.page>
 
 <table class="table table-striped table-bordered table-hover">
    <#list teachers as teacher>
        <tr>
            <td>${teacher.lastName} ${teacher.firstName} ${teacher.middleName}</td>
            <td><a href="/teachers/edit/${teacher.id}">Править</a></td>
            <td><a href="/teachers/delete/${teacher.id}">Удалить</a></td>
        </tr>
    </#list>
</table>

<a class="btn btn-primary mt-5" href="/teachers/new">Новый преподаватель</a>

</@c.page>
