function GetParameterFromUrl(sourceurl,str) {
	var rs = new RegExp("(^|)" + str + "=([^&]*)(&|$)", "gi").exec(sourceurl), tmp;
	if (tmp = rs)
		return tmp[2];
	return "";
}