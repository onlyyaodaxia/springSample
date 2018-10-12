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
    <script>
        // 加载首页
        $(document).ready(function(){
            showAtRight('dubbo')
        });
    </script>
</head>
<body>
<%--header--%>
<div class="navbar navbar-duomi navbar-static-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home/index" id="logo">测试首页
            </a>
        </div>
    </div>
</div>
<%--左导航和右侧内容--%>
    <%--<div class="container" style="margin-top: 30px">--%>
        <div class="row">
            <div class="col-md-2">
                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a href="#" onclick="showAtRight('dubbo')">dubbo</a></li>
                    <li><a href="#" onclick="showAtRight('hello')">hello</a></li>
                </ul>
            </div>
            <div class="col-md-10">
                <div id="content" class="container" style="margin-top: 30px">

                </div>
            </div>

        </div>
    <%--</div>--%>


    <script type="text/javascript">

        /*
        * 对选中的标签激活active状态，对先前处于active状态但之后未被选中的标签取消active
        * （实现左侧菜单中的标签点击后变色的效果）
        */
    $(document).ready(function () {
    $('ul.nav > li').click(function (e) {
        //e.preventDefault();    加上这句则导航的<a>标签会失效
        $('ul.nav > li').removeClass('active');
        $(this).addClass('active');
        });
        });


        /*
     * 利用div实现左边点击右边显示的效果（以id="content"的div进行内容展示）
     * 注意：
     *   ①：js获取网页的地址，是根据当前网页来相对获取的，不会识别根目录；
     *   ②：如果右边加载的内容显示页里面有css，必须放在主页（即例中的index.jsp）才起作用
     *   （如果单纯的两个页面之间include，子页面的css和js在子页面是可以执行的。 主页面也可以调用子页面的js。但这时要考虑页面中js和渲染的先后顺序 ）
    */
        function showAtRight(url) {
            var xmlHttp;

            if (window.XMLHttpRequest) {
                // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlHttp=new XMLHttpRequest();    //创建 XMLHttpRequest对象
            }
            else {
                // code for IE6, IE5
                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
            }

            xmlHttp.onreadystatechange=function() {
                //onreadystatechange — 当readystate变化时调用后面的方法

                if (xmlHttp.readyState == 4) {
                    //xmlHttp.readyState == 4    ——    finished downloading response

                    if (xmlHttp.status == 200) {

                        //xmlHttp.status == 200        ——    服务器反馈正常

                        document.getElementById("content").innerHTML=xmlHttp.responseText;    //重设页面中id="content"的div里的内容
                        initEvents();
                    }
                    //错误状态处理
                    else if (xmlHttp.status == 404){
                        alert("出错了☹   （错误代码：404 Not Found），……！");
                        /* 对404的处理 */
                        return;
                    }
                    else if (xmlHttp.status == 403) {
                        alert("出错了☹   （错误代码：403 Forbidden），……");
                        /* 对403的处理  */
                        return;
                    }
                    else {
                        alert("出错了☹   （错误代码：" + request.status + "），……");
                        /* 对出现了其他错误代码所示错误的处理   */
                        return;
                    }
                }

            }

            //把请求发送到服务器上的指定文件（url指向的文件）进行处理
            xmlHttp.open("GET", url, true);        //true表示异步处理
            xmlHttp.send();
            function initEvents () {
                $("#mySubmit").click(function(e){
                    // e.preventDefault();
                    var methodParam=$("#methodParam").val();
                    console.log(methodParam);
                    console.log(JSON.parse(methodParam));


                    var param={
                        dubboUrl:$("#dubboUrl").val(),
                        dubboVersion:$("#dubboVersion").val(),
                        interfaceName:$("#interfaceName").val(),
                        methodName:$("#methodName").val(),
                        // methodParams:[{"ParamType":$("#methodParamTypes").val(),"Object":JSON.parse(methodParam)}]
                        methodParams:JSON.parse(methodParam)

                    };
                    console.log("stringify:"+JSON.stringify(param));

                    $.ajax({            //几个参数需要注意一下
                        type: "POST",//提交数据的方法类型
                        dataType: "text",//预期服务器返回的数据类型
                        contentType:"application/json",
                        url: "/dubbo/send" ,//后台接收参数的文件地址
                        data:  JSON.stringify(param),
                        success: function (result) {
                            console.log(result);//打印服务端返回的数据(调试用)
                            $("#parseResult").text(JSON.stringify(result),null,2);
                        },
                        error : function() {
                            console.error("on submit error.............");

                        }
                    });

                });

            }

        }



    </script>

</body>
</html>
