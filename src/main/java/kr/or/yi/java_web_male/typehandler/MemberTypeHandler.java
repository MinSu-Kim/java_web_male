package kr.or.yi.java_web_male.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import kr.or.yi.java_web_male.dto.Member;

public class MemberTypeHandler extends BaseTypeHandler<Member>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Member parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter.toString());
		
	}

	@Override
	public Member getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return new Member(rs.getString(columnName), columnName, columnName, columnName, columnName, columnName, columnName, columnName, columnName, 0, columnName);
	}

	@Override
	public Member getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return new Member(rs.getString(columnIndex), null, null, null, null, null, null, null, null, columnIndex, null);
	}

	@Override
	public Member getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return new Member(cs.getString(columnIndex), null, null, null, null, null, null, null, null, columnIndex, null);
	}

}
