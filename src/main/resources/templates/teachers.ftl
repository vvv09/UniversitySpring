<#import "parts/common.ftl" as c>

 <@c.page>
 
 <table class="table table-striped table-bordered table-hover">
    <#list teachers as teacher>
        <tr>
            <td>${teacher.lastName} ${teacher.firstName} ${teacher.middleName}</td>
            <td><a href="">Править</a></td>
            <td><a href="">Удалить</a></td>
        </tr>
    </#list>
</table>

<a class="btn btn-primary mt-5" href="">Новый преподаватель</a>

</@c.page>
