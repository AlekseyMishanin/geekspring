<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Описание содержимого страницы">
    <meta name="keywords" content="Ключевые слова">
    <link href="../resources/css/main.css" rel="stylesheet">
</head>

<body lang="ru">
    <div class="container">
        <h1>Product enter data</h1>
        <div class="formProduct">
            <form:form action="addProduct" modelAttribute="product">
                <fieldset>
                    <legend>Входные данные</legend>
                    <div class="formItemBox">
                        <label for="id">ID</label>
                        <form:input path="id" id="id"/>
                    </div>
                    <div class="formItemBox">
                        <label for="title">title</label>
                        <form:input path="title" id="title"/>
                    </div>
                    <div class="formItemBox">
                        <label for="cost">cost</label>
                        <form:input path="cost" id="cost"/>
                    </div>
                    <br>
                    <input type="submit" value="Submit"/>
                </fieldset>
            </form:form>
        </div>
    </div>
</body>
</html>