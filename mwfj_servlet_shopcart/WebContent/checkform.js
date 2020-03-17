function Check(path) {
  // document.writeln("hahaha");
  var form = document.getElementById("login_form");
  var js_loginname = document.getElementById("login_name");
  var js_pwd = document.getElementById("login_pwd");
  if (js_loginname.value == "mwfj" && js_pwd.value == "mwfj") {
    document.getElementById("success").innerHTML = "登陆成功";
    form.action = path + "/login.action";
    form.method = "post";
    form.submit();
  } else {
    document.getElementById("errmsg").innerHTML = "用户名/密码错误";
  }
}
