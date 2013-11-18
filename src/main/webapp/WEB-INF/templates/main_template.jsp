<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" /></title>
    <link rel="stylesheet" type="text/css" href="/assets/css/core.css" media="screen" />
</head>
<body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />
    <tiles:insertAttribute name="body.javascript" ignore="true" />
</body>
</html