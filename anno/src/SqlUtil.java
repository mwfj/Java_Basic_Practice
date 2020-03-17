import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SqlUtil {
	public String genSql(Object object) {
		String sql = "INSERT INTO ";
		Class class1 = object.getClass();
		Table table = (Table) class1.getAnnotation(Table.class);
		if (table != null) {
			String tableName = table.tableName();
			sql += tableName + "(";
		}
		Field fields[] = class1.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			Column column = field.getAnnotation(Column.class);
			if (column != null) {
				String colName = column.columnName();
				String isStr = column.isStr();
				if (i == fields.length - 1) {
					sql += colName + ")VALUES(";
				} else {
					sql += colName + ",";
				}

			}
		}
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String getMethodName = "get"
					+ (field.getName().charAt(0) + "").toUpperCase()
					+ field.getName().substring(1);
			Column column = field.getAnnotation(Column.class);
			try {
				Method method = class1.getDeclaredMethod(getMethodName);
				Object object2 = method.invoke(object);
				
				if(i==fields.length-1){
					if("yes".equals(column.isStr())){
						sql+="'"+object2+"')";
					}else{
						sql+=object2+")";
					}
				}else{
					if("yes".equals(column.isStr())){
						sql+="'"+object2+"',";
					}else{
						sql+=object2+",";
					}
				}
			} catch (Exception e) {
			}
		}
		return sql;
	}

	public static void main(String[] args) {
		Users users =new Users();
		users.setId(1);
		users.setName("abc");
		users.setPwd("123");
		String sql =new SqlUtil().genSql(users);
		System.out.println(sql);
	}
}
