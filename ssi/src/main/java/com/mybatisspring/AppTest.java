package com.mybatisspring;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import com.mybatis.dao.UserMapper;
import com.mybatis.entity.Users;


public class AppTest {

	private static SqlSessionFactory sf;
	static{
		try {
			String resource = "mybits-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sf = new SqlSessionFactoryBuilder().build(inputStream,"development");//mybits数据源id
////////////配置多个数据源//////////////////////////////////////////////////////
//			DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
//			TransactionFactory transactionFactory = new JdbcTransactionFactory();
//			Environment environment = new Environment("development", transactionFactory, dataSource);
//			Configuration configuration = new Configuration(environment);
//			configuration.addMapper(UserMapper.class);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
////////////配置多个数据源//////////////////////////////////////////////////////
			Reader readerFrom = getReader(resource);
	        //Reader readerTo = getReader(resource);
	        //不同的environment 连接不同的数据源
	        SqlSessionFactory sessionFactoryFrom = getSqlSessionFactory(readerFrom, "development");
	        //SqlSessionFactory sessionFactoryTo = getSqlSessionFactory(readerTo, "to");

	        SqlSession sessionFrom = sessionFactoryFrom.openSession(true);
	       // SqlSession sessionTo = sessionFactoryTo.openSession(true);
			//sf = sessionFactoryFrom;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test() {
		
		SqlSession s = sf.openSession();
		Users u = new Users();
		u.setUsername("tom6");
		u.setPwd("123456");
		u.setEmail("123@");
		u.setPhone("12345678912");
		//s.insert("opeuser.insertuser",u);
		//s.commit();
		
		
		//UserMapper um = s.getMapper(UserMapper.class);//注解添加
		//um.insertuser(u);
		//s.commit();
		List<Users> list = s.selectList("opeuser.selectUserAll");
		//List<Users> list = um.querylist();
		System.out.println(list.get(1).getUsername());
	}
	
	
	/**
	 * 
	 * @param resource
	 * @return
	 * @throws IOException
	 */
	
    private static Reader getReader(String resource) throws IOException {
        return Resources.getResourceAsReader(resource);
    }

    /**
     * 
     * @param reader
     * @param environmentId
     * @return
     */
    private static SqlSessionFactory getSqlSessionFactory(Reader reader, String environmentId) {

        return new SqlSessionFactoryBuilder().build(reader, environmentId);
    }
}
