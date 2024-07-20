import  java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/JDBCPractise";
    private static final String username = "root";
    private static final String password = "root";




    public static void main(String[] args) {

        //load the driver( DriverManager)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        //we need connection so need url, username and password
        try{
            Connection connection = DriverManager.getConnection(url, username, password);

            //now use the connection to create statement
            Statement statement = connection.createStatement();

            //now using statement we can execute the query
            String query = "select * from Students";

            //to execute the query we need statement instance
            ResultSet resultSet = statement.executeQuery(query); //this return table

            //iterate through resultSet
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");
                System.out.println("Id : "+id+", name : "+name+", age : "+age+", marks : "+marks);
            }




        }catch(SQLException e){
            e.printStackTrace();
        }







    }
}