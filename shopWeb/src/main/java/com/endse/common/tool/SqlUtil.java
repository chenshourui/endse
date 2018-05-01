package com.endse.common.tool;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 
 * @File:
 * @Description: SQL帮助类，目前实现了mysql,oracle版本,只要修改com.juanpi.scm.framework.utils.
 *               SqlUtil. CURRENT_DB的值,就可以切换不同数据库实现
 * @author
 * @Email:
 */
public class SqlUtil {

	/**
	 * 
	 * @Name: buildPageSearchSql
	 * @Description: 构造分页查询的sql语句,mysql用limit实现,oracle用rownum实现<br/>
	 *               关于Mysql实现方式：Mysql实现方式直接在传入的原始sql语句后面拼接limit函数，
	 *               所以若原始sql本身带limit函数，则返回的结果sql其实是有语法错误的
	 *
	 * @param originalSql
	 *            原始要被包装的sql(需要完整且语法正确)
	 * @param pageStart
	 *            该页开始行数(结果包含该行，行数初始从1开始)
	 * @param pageSize
	 *            页大小，即返回的行数
	 * @return
	 */
	public static String buildPageSearchSql(String originalSql, int pageStart, int pageSize) {
		if (pageStart < 1) {
			throw new IllegalArgumentException("pageStart不能小于1");
		}
		if (pageSize < 1) {
			throw new IllegalArgumentException("pageSize不能小于1");
		}
		switch (CURRENT_DB) {
		case MYSQL: {
			StringBuilder sb = new StringBuilder();
			sb.append(originalSql);
			sb.append(" limit " + (pageStart - 1) + "," + pageSize);
			return sb.toString();
		}
		case ORACLE: {
			StringBuilder sqlBuilderAll = new StringBuilder();
			if (pageStart == 1) {
				sqlBuilderAll.append("SELECT A.*, ROWNUM RN FROM (" + originalSql + ") A WHERE ROWNUM <= " + pageSize);

			} else {
				sqlBuilderAll.append("SELECT * FROM ( SELECT A.*, ROWNUM RN FROM (" + originalSql + ") A "
						+ " WHERE ROWNUM < " + (pageStart + pageSize) + ")WHERE RN >=  " + pageStart);
			}
			return sqlBuilderAll.toString();
		}
		default:
			throw new RuntimeException("没有指定数据库实现方式");
		}

	}

	/**
	 * 
	 * @Name: buildPageSearchSql
	 * @Description: 构造分页查询的sql语句,mysql用limit实现,oracle用rownum实现
	 * @param originalSql
	 *            原始要被包装的sql(需要完整且语法正确)
	 * @param pageStart
	 *            该页开始行数(结果包含该行，行数初始从1开始)
	 * @param pageSize
	 *            页大小，即返回的行数
	 * @return
	 */
	public static String buildPageSearchSql(String originalSql, int pageStart, int pageSize, String orderBySql) {
		if (pageStart < 1) {
			throw new IllegalArgumentException("pageStart不能小于1");
		}
		if (pageSize < 1) {
			throw new IllegalArgumentException("pageSize不能小于1");
		}
		switch (CURRENT_DB) {
		case MYSQL: {
			StringBuilder sb = new StringBuilder();
			sb.append("select * from ( ").append(originalSql).append(" )_inner ").append(orderBySql)
					.append(" limit " + (pageStart - 1) + "," + pageSize);
			return sb.toString();
		}
		case ORACLE: {
			StringBuilder sqlBuilderAll = new StringBuilder();
			if (pageStart == 1) {
				sqlBuilderAll.append("SELECT A.*, ROWNUM RN FROM (" + originalSql + ") A WHERE ROWNUM <= " + pageSize);

			} else {
				sqlBuilderAll.append("SELECT * FROM ( SELECT A.*, ROWNUM RN FROM (" + originalSql + ") A "
						+ " WHERE ROWNUM < " + (pageStart + pageSize) + ")WHERE RN >=  " + pageStart);
			}
			return sqlBuilderAll.toString();
		}
		default:
			throw new RuntimeException("没有指定数据库实现方式");
		}

	}

	/**
	 * 将数据库时间日期列包装在日期转字符串函数中,比如传入列名created_dtm_loc,
	 * Mysql返回：date_format(created_dtm_loc,'%Y-%m-%d %T'); Oracle返回：
	 * to_char(created_dtm_loc,'YYYY-MM-DD HH24:MI:SS'); 日期格式都是如2008-08-08
	 * 08:08:08的格式
	 * 
	 * @param timeColumName
	 *            时间日期列名
	 * @return
	 */
	public static String wrapTimeColInToCharFun(String timeColumName) {
		StringBuilder sb = new StringBuilder();
		switch (CURRENT_DB) {
		case MYSQL:
			sb.append("date_format(").append(timeColumName).append(",'%Y-%m-%d %T')");
			break;
		case ORACLE:
			sb.append("to_char(").append(timeColumName).append(",'YYYY-MM-DD HH24:MI:SS')");
			break;
		default:
			throw new RuntimeException("没有指定数据库实现方式");
		}
		return sb.toString();
	}

	/**
	 * 将字符串包装在字符串转日期函数中，比如传入字符串str="'2008-08-08 08:08:08'",
	 * Mysql返回str_to_date('2008-08-08 08:08:08','%Y-%m-%d %T');
	 * Oracle返回to_date('2008-08-08 08:08:08','YYYY-MM-DD HH24:MI:SS');
	 * 日期格式都是如2008-08-08 08:08:08的格式
	 * 
	 * @param str
	 *            要包装的字符串
	 * @return
	 */
	public static String wrapStrInToDateFun(String str) {
		StringBuilder sb = new StringBuilder();
		switch (CURRENT_DB) {
		case MYSQL:
			sb.append("str_to_date(").append(str).append(",'%Y-%m-%d %T')");
			break;
		case ORACLE:
			sb.append("to_date(").append(str).append(",'YYYY-MM-DD HH24:MI:SS')");
			break;
		default:
			throw new RuntimeException("没有指定数据库实现方式");
		}
		return sb.toString();
	}

	/**
	 * 解析 的数据
	 * 
	 * @param object
	 * @return
	 * @exception NumberFormatException
	 *                if the string does not contain a parsable
	 *                <code>long</code>.
	 */
	public static Long parseLong(Object object) {
		if (object == null) {
			return null;
		} else if (object instanceof Long) {
			return (Long) object;
		} else if (object instanceof Integer) {
			return new Long(((Integer) object));
		} else if (object instanceof BigDecimal) {
			return ((BigDecimal) object).longValue();
		} else if (object instanceof String) {
			return Long.parseLong((String) object);
		} else if (object instanceof BigInteger) {
			return ((BigInteger) object).longValue();
		} else {
			throw new RuntimeException("未处理类型！");
		}
	}

	/**
	 * 解析数据
	 * 
	 * @param object
	 * @return
	 */
	public static String parseString(Object object) {
		return object == null ? null : object.toString();
	}

	/**
	 * 定义数据库实现方式
	 * 
	 * @author
	 *
	 */
	private static enum DbImplements {
		MYSQL, ORACLE;
	}

	/**
	 * 现在使用的DB
	 */
	private static final DbImplements CURRENT_DB = DbImplements.MYSQL;
}
