<#import "parts/common.ftl" as c> 

<@c.page>
Новая Аудитория

<form action="saveNew" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Название :</label>
        <div class="col-sm-6">
            <input type="text" name="name" class="form-control" />
        </div>
    </div>
    <button class="btn btn-primary" type="submit">Создать</button>
</form>
</@c.page>
