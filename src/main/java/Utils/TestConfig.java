package Utils;
public class TestConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "rajiv.mynapatti@indianic.com";
	public static String password = "mynapatti$1";
	public static String[] to ={"rajiv.mynapatti@indianic.com"};
	public static String  messageBody=("Please find attached to this email a copy of Extent Report.<br><br><br>"
			
			 +"\n Please, let us know if you have any question regarding the information provided in the attachment.<br><br>"
			+"\n Thank you.");
	
	public static String subject ="Happy Quickeeing :)";
	public static String attachmentPath=System.getProperty("user.dir")+"/target/Extent_Reports/Extent_Reports.zip";
	public static String attachmentName="Extent Reports";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/acs";
	
	
	
	
	
	
	
	
	
}
