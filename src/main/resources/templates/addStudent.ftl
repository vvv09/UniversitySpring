<#import "parts/common.ftl" as c> 

<@c.page>
Новый Студент

<form action="saveNew" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Фамилия :</label>
        <div class="col-sm-6">
            <input type="text" name="lastName" class="form-control" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Имя :</label>
        <div class="col-sm-6">
            <input type="text" name="firstName" class="form-control" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Отчество :</label>
        <div class="col-sm-6">
            <input type="text" name="middleName" class="form-control" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Группа :</label>     
        <div class="col-sm-6">
            <select class="form-control" name="groupId">
                <#list groups as group>
                    <option value="${group.id}">${group.name}</option>
                </#list>
            </select>
        </div>
    </div>
    
	<button class="btn btn-primary" type="submit">Добавить</button>
</form>
</@c.page>
