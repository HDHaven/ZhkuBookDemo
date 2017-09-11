package com.haven.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.haven.bean.PageBean;

@Intercepts({@Signature(type=StatementHandler.class, method="prepare", args={Connection.class, Integer.class})})
public class PageInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("����������...");
		StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
		MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
		MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
		// �����ļ���SQL����ID
		String id = mappedStatement.getId();
		System.out.println("sql���id��"+ id);
		if(id.matches(".+ByPage$")) {
			System.out.println("�������ض���...");
			BoundSql boundSql = statementHandler.getBoundSql();
			// ԭʼ��SQL���
			String sql = boundSql.getSql();
			// ��ѯ��������SQL���
			String countSql = "select count(*) from (" + sql + ")a";
			Connection connection = (Connection)invocation.getArgs()[0];
			PreparedStatement countStatement = connection.prepareStatement(countSql);
			ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
			parameterHandler.setParameters(countStatement);
			ResultSet rs = countStatement.executeQuery();
			
			Map<?,?> parameter = (Map<?,?>)boundSql.getParameterObject();
			PageBean page = (PageBean)parameter.get("page");
			if(rs.next()) {
				page.setTotalNumber(rs.getInt(1));
			}
			// ��������ҳ��ѯ��SQL���
			String pageSql = sql + " limit " + page.getDbIndex() + "," + page.getDbNumber();
			metaObject.setValue("delegate.boundSql.sql", pageSql);
			System.out.println("������������...");
		}
		System.out.println("�������...");
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		System.out.println("plugin...");
		// ����Ŀ��
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		System.out.println("setProperties...");
	}

}
