package hojun.lee.db.manager;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class LeeDBManager {
	private SqlSessionFactory ssf;
	private static final LeeDBManager LDBM = new LeeDBManager();
	private LeeDBManager() {

	}
	public static LeeDBManager getLdbm() {
		return LDBM;
	}
	public void newSSF(String cfgFile) throws IOException {
		InputStream is = Resources.getResourceAsStream(cfgFile);
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		ssf = ssfb.build(is);
	}
	public SqlSessionFactory getSsf() {
		return ssf;
	}
}
