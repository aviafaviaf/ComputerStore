<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Панель администратора</h1><hr>
    <h3>Создать товар</h3>
    <form action="admin/product/create" method="post" enctype="multipart/form-data">
        Название товара: <input type="text" name="title"><br><br>
        Описание товара: <textarea name="description"></textarea><br><br>
        Цена: <input type="number" name="price"><br><br>
        Фото 1: <input type="file" name="file1"><br><br>
        Фото 2: <input type="file" name="file2"><br><br>
        Фото 3: <input type="file" name="file3"><br><br>
        <input type="submit" value="Добавить товар"/><br>
    </form>
    <h3>Удалить товар</h3>
    <form action="admin/product/delete" method="post">
        <input type="number" name="id"/>
        <input type="submit" value="Удалить">
    </form>
</@t.template>