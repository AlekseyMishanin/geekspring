<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Описание содержимого страницы">
    <meta name="keywords" content="Ключевые слова">
    <link href="../resources/css/main.css" rel="stylesheet">
</head>
<body lang="ru">

    <div class="container">
    <h1>Product list</h1>
        <div class="listProduct">
            <c:forEach var="pr" items="${products}">
                <div class="productBox">
                    <div class="productRow">
                        Id <c:out value = "${pr.id}"/>
                    </div>
                    <div class="productRow">
                        Title <c:out value = "${pr.title}"/>
                    </div>
                    <div class="productRow">
                        Cost <c:out value = "${pr.cost}"/>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>