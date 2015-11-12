<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>Simple Spring MVC</title>
</head>
<body>
    <div>
        <h1>${title}</h1>
        <p>
            <c:if test="${not empty name}">
                Hello ${name}
            </c:if>

            <c:if test="${empty name}">
                Welcome Welcome!
            </c:if>
        </p>
    </div>
    <div>
        Msg: ${msg}
        asd: ${asd}
        Message: ${message}
    </div>
</body>
</html>