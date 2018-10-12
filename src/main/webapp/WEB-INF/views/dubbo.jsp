<%--
  Created by IntelliJ IDEA.
  User: wangyaoyao
  Date: 2018/9/10
  Time: 上午11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../../css/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../../css/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="../../lib/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../../css/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<%--form表单--%>
<div class="row">
    <div class="col-md-6">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="dubboUrl" class="col-sm-2 control-label">dubboUrl</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="dubboUrl" placeholder="eg：dubbo://127.0.0.1:20880" value="dubbo://127.0.0.1:20880">
                </div>
            </div>
            <div class="form-group">
                <label for="dubboVersion" class="col-sm-2 control-label">dubboVersion</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="dubboVersion" >
                </div>
            </div>
            <div class="form-group">
                <label for="interfaceName" class="col-sm-2 control-label">interfaceName</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="interfaceName" placeholder="eg：com.example.api.DemoService" value="com.example.api.DemoService">
                </div>
            </div>
            <div class="form-group">
                <label for="methodName" class="col-sm-2 control-label">methodName</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="methodName" placeholder="eg：callPerson" value="callPerson">
                </div>
            </div>

            <div class="form-group">
                <label for="methodParam" class="col-sm-2 control-label">methodParam</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="methodParam" placeholder="eg：xxx"   rows="10" >[{"Object":{"name":"wyy"},"ParamType":"com.example.model.Person"}]</textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-default" id="mySubmit" >确定</button>
                </div>
            </div>
        </form>
    </div>
    <div class="col-md-6" id="result">
        result：
        <pre id="parseResult">
        </pre>
    </div>
</div>


</body>
</html>
