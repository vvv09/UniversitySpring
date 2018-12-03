<#import "parts/common.ftl" as c>

 <@c.page>
 
 <table class="table table-striped table-bordered table-hover">
    <#list subjects as subject>
        <tr>
            <td>${subject.name}</td>
            <td><a href="">Править</a></td>
            <td><a href="">Удалить</a></td>
        </tr>
    </#list>
</table>

<a class="btn btn-primary mt-5" href="">Новый предмет</a>

</@c.page>
