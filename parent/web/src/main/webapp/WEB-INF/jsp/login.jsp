<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">
    <h1 style="color:red;">${param.errorMsg}</h1>
    <form id="loginform" action="doLogin" method="post" class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 用户登录</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="loginaccount" name="loginaccount" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="userpassword" name="userpassword" placeholder="请输入登录密码" style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <select class="form-control" >
                <option value="member">会员</option>
                <option value="user">管理</option>
            </select>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
            <br>
            <label>
                忘记密码
            </label>
            <label style="float:right">
                <a href="reg.html">我要注册</a>
            </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="doLogin()" > 登录</a>
    </form>
</div>
<script src="${pageContext.request.contextPath}/jquery/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/layer/layer.js"></script>
<script>
    function doLogin() {
        //非空校验
        var loginaccount = $("#loginaccount").val();
        //表单元素的value的取值不会为null,取值是空字符串
        if (loginaccount == ""){
            // alert("用户登录账号不能为空,请输入!!")
            layer.msg("用户登录账号不能为空,请输入!!", {time:3000, icon:5, shift:6}, function () {

            });
            return;
        }
        var userpassword = $("#userpassword").val();
        if (userpassword == ""){
            // alert("用户密码不能为空,请输入");
            layer.msg("用户密码不能为空,请输入!!", {time:3000, icon:5, shift:6}, function () {

            });
            return;
        }
        // alert("提交表单");
        // $("#loginform").submit();
        // 使用ajax提交数据
        var loadingIndex = null;
        $.ajax({
            type : "POST",
            url  : "doAJAXLogin",
            data : {
                "loginaccount" : loginaccount,
                "userpassword"  : userpassword
            },
            beforeSend : function(){
                loadingIndex = layer.msg('处理中', {icon: 16});
            },
            success : function(result) {
                layer.close(loadingIndex);
                if (result.success){
                    window.location.href = "main";
                }else{
                    layer.msg("输入的账号或密码输入不正确!!!!", {time:3000, icon:5, shift:6}, function () {

                    });
                }
            }
        });
    }
</script>
</body>
</html>