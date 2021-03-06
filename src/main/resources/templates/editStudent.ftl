<#import "parts/common.ftl" as c> 

<@c.page> 
Правка Студента

<form action="/students" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Фамилия :</label>
        <div class="col-sm-6">
            <input type="text" name="lastName" class="form-control" value="${student.lastName}" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Имя :</label>
        <div class="col-sm-6">
            <input type="text" name="firstName" class="form-control" value="${student.firstName}" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Отчество :</label>
        <div class="col-sm-6">
            <input type="text" name="middleName" class="form-control" value="${student.middleName}" />
        </div>
        <input type="hidden" name="id" value="${student.id}" >
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Группа :</label>
        <div class="col-sm-6">
            <select class="form-control" name="groupId">
                <#list groups as group>
                    <option value="${group.id}" <#if group.id == student.group.id> selected = "selected"</#if>>${group.name}</option>
                </#list>
            </select>
        </div>
    </div>
    
    <button class="btn btn-primary" type="submit">Сохранить изменения</button>
</form>
</@c.page>
