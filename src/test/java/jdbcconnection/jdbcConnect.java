package jdbcconnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.By;

import resource.base;

public class jdbcConnect extends base {
	
	public Properties prop;
	
	public void jdbcSQLTesting() throws IOException, SQLException {
			prop= initializeSQLServer();
			
			//declare access connection 
			Connection con = DriverManager.getConnection("jdbc:sqlserver://"+prop.getProperty("localhost")+
					":"+prop.getProperty("port")+"/demo", "fendy","123456");
			
			//declare statment s
			Statement s= con.createStatement();
			
			//declare statement to execute (get data from DB)
			ResultSet rs= s.executeQuery("select * from TableNew where Coloum='values'");
			
			//should input rs.next()
			while (rs.next()) {
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString("password"));
	}
			driver.findElement(By.xpath("//*(id=un")).sendKeys(rs.getString("username"));
			driver.findElement(By.xpath("//*(id=un")).sendKeys(rs.getString("password"));

	}
	
	}
	
