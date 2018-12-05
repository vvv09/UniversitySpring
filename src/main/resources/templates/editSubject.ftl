<#import "parts/common.ftl" as c>
<@c.page>
Правка Предмета
<form action="/subjects" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Название :</label>
        <div class="col-sm-6">
            <input type="text" name="name" class="form-control" value="${subject.name}">
        </div>
        <input type="hidden" name="id" value="${subject.id}">
    </div>
    <button class="btn btn-primary" type="submit">Сохранить изменения</button>
</form>
</@c.page>
