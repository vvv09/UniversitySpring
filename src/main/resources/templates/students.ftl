<#import "parts/common.ftl" as c>

 <@c.page>
 
 <table class="table table-striped table-bordered table-hover">
    <#list students as student>
        <tr>
            <td>${student.lastName} ${student.firstName} ${student.middleName}</td>
            <td><a href="">Править</a></td>
            <td><a href="">Удалить</a></td>
        </tr>
    </#list>
</table>

<a class="btn btn-primary mt-5" href="">Новый студент</a>

</@c.page>
