import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class StudentCrud {

    private static final String url = "jdbc:mysql://localhost:3306/JDBCPractise";
    private static final String  username = "root";
    private static final String password = "root";



    public static void main(String[] args) {

        //boilerplate code
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            //now we need to perform crud
            //create
            /*String query = String.format("insert into Students(name, age, marks) values('%s', %d, %f)","Maanish",21, 86.7);

            int rowAffected = statement.executeUpdate(query);

            if(rowAffected > 0){
                System.out.println("values haas been inserted successfully");
            }
            else{
                System.out.println("Failed...");
            }*/

            String queryUpdate = String.format("update Students set name = '%s' where id = %d","Nilu",4);

            //update
            /*int rowUpdated = statement.executeUpdate(queryUpdate);

            if(rowUpdated > 0){
                System.out.println("values haas been updated successfully");
            }
            else{
                System.out.println("Failed...");
            }*/

            //delete

            /*String queryDelete = "delete from Students where id = 5";
            int rowDeleted = statement.executeUpdate(queryDelete);
            if(rowDeleted > 0){
                System.out.println("values haas been deleted successfully");
            }
            else{
                System.out.println("Failed...");
            }*/

            //read
            //we need to use executeQuery()
            String queryRead = "select * from Students";
            ResultSet resultSet = statement.executeQuery(queryRead);
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
