package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
	private static final String driver="oracle.jdbc.driver.OracleDriver";
	private static final String url="jdbc:oracle:thin:@localhost:1521:inspur";
	private static final String user="scott";
	private static final String password="tiger";
	private static  Connection conn=null;
	
	//��̬����鸺���������
		static 
		{
			try
			{
				Class.forName(driver);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		//����ģʽ�������ݿ����Ӷ���
		public static Connection getConnection() throws Exception
		{
			if(conn==null)
			{
				conn = DriverManager.getConnection(url, user, password);
				return conn;
			}
			return conn;
		}
		
		public static void main(String[] args) {
			
			try
			{
			   Connection conn = DBHelper.getConnection();
			   if(conn!=null)
			   {
				   System.out.println("���ݿ�����������");
			   }
			   else
			   {
				   System.out.println("���ݿ������쳣��");
			   }
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
}
