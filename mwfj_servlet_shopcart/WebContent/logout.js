function logout(path) {
	if (window.confirm("真的要退出吗？")) {
		window.location.href = path+"/logout";
	}
}