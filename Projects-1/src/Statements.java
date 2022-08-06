

import javax.management.Query;
import javax.swing.*;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Statements {

    protected static final Logger LOGGER = Logger.getLogger(Statements.class.getName());

    private static final String deleteStatementString1 = "DELETE FROM Equipment WHERE Equipment_ID = ?";
    private static final String deleteStatementString2 = "DELETE FROM Service WHERE Service_ID = ?";
    private static final String deleteStatementString3 = "DELETE FROM Customer WHERE ID_Number = ?";
    private static final String deleteStatementString4 = "DELETE FROM Employee WHERE Employe_ID_number = ?";
    private static final String countCustomers = "SELECT COUNT(*) AS TOTAL FROM Customer";
    private final static String countServicesThisMonth = "SELECT COUNT(*) AS TOTAL FROM pay_for_service WHERE Service_Date >= '2021-12-01'";
    private final static String mostRequestedService = "SELECT Service_Description AS service, COUNT(Service_Description) AS Most_Requested FROM pay_for_service GROUP BY Service_Description ORDER BY Most_Requested DESC LIMIT 1";
    private final static String countLast6Months = "SELECT MONTH(Service_Date) AS Month, COUNT(*) AS Count FROM pay_for_service WHERE MONTH(Service_Date) >= 06 GROUP BY MONTH(Service_Date)";
    private final static String countAmount = "SELECT Service_Description AS Service_Type, SUM(Amount_Charged) AS Count FROM pay_for_service GROUP BY Service_Description";
    private final static String listCustomers = "SELECT Service_Description AS Service, Employe_ID_number AS Number FROM pay_for_service GROUP BY Employe_ID_number";
    private final static String countCustomersPerMonth = "SELECT COUNT(Employe_ID_number) AS Count, MONTH(Service_Date) AS Monthh FROM pay_for_service GROUP BY MONTH(Service_Date)";


    public int deleteEquipment(Equipment equipment) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement deleteStatement = null;
        int deletedID = -1;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString1, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setString(1, equipment.getEquipment_ID());
            deleteStatement.executeUpdate();

            ResultSet rs = deleteStatement.getGeneratedKeys();
            if (rs.next()) {
                deletedID = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Delete", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: delete" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete", "Eroare", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        return deletedID;
    }

    public int deleteService(Service service) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement deleteStatement = null;
        int deletedID = -1;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString2, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setString(1, service.getService_ID());
            deleteStatement.executeUpdate();

            ResultSet rs = deleteStatement.getGeneratedKeys();
            if (rs.next()) {
                deletedID = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Delete", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: delete" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete", "Eroare", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        return deletedID;
    }

    public int deleteCustomer(Customer customer) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement deleteStatement = null;
        int deletedID = -1;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString3, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setString(1, customer.getID_Number());
            deleteStatement.executeUpdate();

            ResultSet rs = deleteStatement.getGeneratedKeys();
            if (rs.next()) {
                deletedID = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Delete", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: delete" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete", "Eroare", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        return deletedID;
    }

    public int deleteEmployee(Employee employee) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement deleteStatement = null;
        int deletedID = -1;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString4, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setString(1, employee.getEmploye_ID_number());
            deleteStatement.executeUpdate();

            ResultSet rs = deleteStatement.getGeneratedKeys();
            if (rs.next()) {
                deletedID = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Delete", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: delete" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete", "Eroare", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        return deletedID;
    }

    public int countCustomers() {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement Statement = null;
        int ID = -1;
        try {
            Statement = dbConnection.prepareStatement(countCustomers, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = Statement.executeQuery();
            if (rs.next()) {
                ID = rs.getInt("TOTAL");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Count warning" + e.getMessage());
        } finally {
            ConnectionFactory.close(Statement);
            ConnectionFactory.close(dbConnection);
        }
        return ID;
    }

    public int countServicesThisMonth() {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement Statement = null;
        int ID = -1;
        try {
            Statement = dbConnection.prepareStatement(countServicesThisMonth, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = Statement.executeQuery();
            if (rs.next()) {
                ID = rs.getInt("TOTAL");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Count warning" + e.getMessage());
        } finally {
            ConnectionFactory.close(Statement);
            ConnectionFactory.close(dbConnection);
        }
        return ID;
    }

    public String mostRequestedService() {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement Statement = null;
        String ID = "";
        try {
            Statement = dbConnection.prepareStatement(mostRequestedService, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = Statement.executeQuery();
            if (rs.next()) {
                ID = rs.getString("service");
                int i = rs.getInt("Most_Requested");
                ID = ID + " " +i;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Count warning" + e.getMessage());
        } finally {
            ConnectionFactory.close(Statement);
            ConnectionFactory.close(dbConnection);
        }
        return ID;
    }

    public String getCountLast6Months() {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement Statement = null;
        String cc = "";
        int month, count;
        try {
            Statement = dbConnection.prepareStatement(countLast6Months);

            ResultSet rs = Statement.executeQuery();
            while (rs.next()) {
                month = rs.getInt("Month");
                count = rs.getInt("Count");
                cc = cc + month +" " +count + '\n';
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Count warning" + e.getMessage());
        } finally {
            ConnectionFactory.close(Statement);
            ConnectionFactory.close(dbConnection);
        }
        return cc;
    }

    public String getCountAmount() {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement Statement = null;
        String cc = "";
        String service;
        int count;

        try {
            Statement = dbConnection.prepareStatement(countAmount);

            ResultSet rs = Statement.executeQuery(countAmount);

            while (rs.next()) {
                count = rs.getInt("Count");
                service = rs.getString("Service_Type");
                cc = cc + service + " " +count + '\n';
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Count warning" + e.getMessage());
        } finally {
            ConnectionFactory.close(Statement);
            ConnectionFactory.close(dbConnection);
        }
        return cc;
    }

    public String getListCustomers() {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement Statement = null;
        String cc = "";
        String service;
        int count;

        try {
            Statement = dbConnection.prepareStatement(listCustomers);

            ResultSet rs = Statement.executeQuery(listCustomers);

            while (rs.next()) {
                count = rs.getInt("Number");
                service = rs.getString("Service");
                cc = cc + service + " " +count + '\n';
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Count warning" + e.getMessage());
        } finally {
            ConnectionFactory.close(Statement);
            ConnectionFactory.close(dbConnection);
        }
        return cc;
    }

    public String getCountCustomersPerMonth() {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement Statement = null;
        String cc = "";
        int count, month;

        try {
            Statement = dbConnection.prepareStatement(countCustomersPerMonth);

            ResultSet rs = Statement.executeQuery(countCustomersPerMonth);

            while (rs.next()) {
                count = rs.getInt("Count");
                month = rs.getInt("Monthh");
                cc = cc + count + " " +month + '\n';
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Count warning" + e.getMessage());
        } finally {
            ConnectionFactory.close(Statement);
            ConnectionFactory.close(dbConnection);
        }
        return cc;
    }

}
