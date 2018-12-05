<#import "parts/common.ftl" as c>

 <@c.page>
 
 <table class="table table-striped table-bordered table-hover">
    <#list students as student>
        <tr>
            <td>${student.lastName} ${student.firstName} ${student.middleName}</td>
            <td>${student.group.name}</td>
            <td><a href="/students/edit/${student.id}">Править</a></td>
            <td><a href="/students/delete/${student.id}">Удалить</a></td>
        </tr>
    </#list>
</table>

<a class="btn btn-primary mt-5" href="/students/new">Новый студент</a>

</@c.page>
