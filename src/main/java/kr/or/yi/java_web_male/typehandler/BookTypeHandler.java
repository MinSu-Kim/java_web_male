package kr.or.yi.java_web_male.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import kr.or.yi.java_web_male.dto.Book;

public class BookTypeHandler extends BaseTypeHandler<Book>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Book parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter.toString());
		
	}

	@Override
	public Book getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return new Book(rs.getString(columnName), 0, null, columnName, columnName, columnName, 0, false, columnName, null, null, null);
	}

	@Override
	public Book getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return new Book(rs.getString(columnIndex), columnIndex, null, null, null, null, columnIndex, false, null, null, null, null);
	}

	@Override
	public Book getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return new Book(cs.getString(columnIndex), columnIndex, null, null, null, null, columnIndex, false, null, null, null, null);
	}
	
}
