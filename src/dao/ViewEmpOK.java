package dao;
    import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;

	import model.ViewEmpModel;

	public class ViewEmpOK {
		
		
		public ArrayList<String> setEid() {
			// TODO Auto-generated method stub
			return null;
		}
		
		    private Connection connection;
		 //Database connection parameters
		    private String url = "jdbc:mysql://www.papademas.net:3306/mydb";
		    private String username = "dbuser";
		    private String password = "db1";
		    
		  
		public String[] emp(String eid) throws SQLException{
			
			ResultSet resultset;
			String v="", w="",x = "",y="",z="";
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				System.out.println("Error creating connection to database");
				System.exit(-1);
			}
			String sql = "select eid, efname,elname,ephn,eaddr from rprojectemployee where eid=? ";
			
			try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				// Set the parameters to the query
				// Execute the insert
				statement.setString(1,eid);
				resultset=statement.executeQuery();
				
				
				while(resultset.next())
				{
					resultset.getString(1);
					resultset.getString(2);
					resultset.getString(3);
					resultset.getString(4);
					resultset.getString(5);
				//System.out.println(resultset.getString(1));
				ViewEmpModel ViewEmpModel = new ViewEmpModel();
				

				ViewEmpModel.setEid(resultset.getString(1));
				ViewEmpModel.setEfname(resultset.getString(2));
				ViewEmpModel.setElname(resultset.getString(3));
				ViewEmpModel.setEphn(resultset.getString(4));
				ViewEmpModel.setEaddr(resultset.getString(5));
			    
				v=resultset.getString(1);
				w = resultset.getString(2);
				x = resultset.getString(3);
				y = resultset.getString(4);
				z=  resultset.getString(5);

				}

			} catch (SQLException e) {
				
				System.out.println("Error creating cs");
			}

			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				System.out.println("Error closing connection");
			}

			return (new String[]{v,w,x, y, z,});
		}
		

	}


