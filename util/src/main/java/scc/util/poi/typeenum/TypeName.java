package scc.util.poi.typeenum;


public enum TypeName {
	整形数值范围负2的31次方至正2的31次方减1,
	整形数值范围负128至正127,
	整形数值范围负32768至正32767,
	整形数值范围负2的63次方至正2的63次方减1,
	单精度浮点数32位,
	单精度浮点数64位,
	是否类型,
	单字符类型,
	字符串类型,
	数值类型,
	日期,
	未知类型;
	TypeName(){}
	public static TypeName getTypeName(String type){
		switch (type) {
		case "java.util.Date":
			return TypeName.日期;
		case "int":
			return TypeName.整形数值范围负2的31次方至正2的31次方减1;
		case "java.lang.Integer":
			return TypeName.整形数值范围负2的31次方至正2的31次方减1;
		case "byte":
			return TypeName.整形数值范围负128至正127;
		case "java.lang.Byte":
			return TypeName.整形数值范围负128至正127;
		case "short":
			return TypeName.整形数值范围负32768至正32767;
		case "java.lang.Short":
			return TypeName.整形数值范围负32768至正32767;
		case "long":
			return TypeName.整形数值范围负2的63次方至正2的63次方减1;
		case "java.lang.Long":
			return TypeName.整形数值范围负2的63次方至正2的63次方减1;
		case "float":
			return TypeName.单精度浮点数32位;
		case "java.lang.Float":
			return TypeName.单精度浮点数32位;
		case "double":
			return TypeName.单精度浮点数64位;
		case "java.lang.Double":
			return TypeName.单精度浮点数64位;
		case "boolean":
			return TypeName.是否类型;
		case "java.lang.Boolean":
			return TypeName.是否类型;
		case "char":
			return TypeName.单字符类型;
		case "java.lang.Character":
			return TypeName.单字符类型;
		case "java.lang.String":
			return TypeName.字符串类型;
		case "java.math.BigDecimal":
			return TypeName.数值类型;
		default:
			return TypeName.未知类型;
		}
	}
}
