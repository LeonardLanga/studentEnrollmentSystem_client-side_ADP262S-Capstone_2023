
package za.ac.cput.studentenrolmentsystem;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonard
 */
public class StudentEnrolmentClient extends JFrame implements ActionListener{
    private JPanel loginPanel, centerPanel, centerPanel1, centerPanel2, northPanel, northPanel1, southPanel;
    private JLabel headingLbl, loginIdLbl, passwordLbl, roleLbl;
    private JTextField loginIdTxt, passwordTxt;
    private JButton exitBtn, clearBtn,loginBtn;
    private JRadioButton adminRadioBtn, studentRadioBtn;
    private Font ft2, ft3, ft4, ft5, ft6, ft7;
    private ButtonGroup group;
    private String selectedRole;
    private ClientConnection conn = new ClientConnection();
    
/*-----------------StudentEnrolment-------------------*/
    private JPanel enrolPanel, enrolNorthPanel, enrolNorthPanel1, enrolNorthPanel2, enrolCenterPanel, enrolSouthPanel;
    private JLabel enrolHeading, enrolComboBoxLbl;
    private JComboBox enrolComboBox;
    private JButton enrolLogOutBtn, enrolBtn, cancelEnrol;
    private DefaultTableModel model;
    private JTable table;
/*-----------------EndStudentEnrolment-------------------*/
    
    
/*-----------------AdminWindow-------------------*/
    private JPanel adminPanel, adminNorthPanel, adminNorthPanel1, adminNorthPanel2, adminNorthPanel3, adminPanelCenter, 
                   adminPanelCenter1,adminPanelCenter2, adminPanelCenter3,adminPanelCenter4,adminSouthPanel;
    
    private JLabel adminHeading, adminComboBoxLbl, adminUserIdLbl, adminCourseCodeLbl, deleteCourseRecordComboBoxLbl, deleteUserRecordComboBoxLbl;
    
    private JTextField adminUserIdTxt, adminCourseCodeTxt;
    
    private JButton retrieveACourseRecordBtn, retrieveAStudRecordBtn, retrieveAllStudsInParticularCourseBtn, 
                    retrieveStudsEnrolledCourseBtn, deleteCourseRecordBtn, deleteUserRecordBtn,adminLogOutBtn;
    
    private DefaultTableModel retrieveACourseModel, retrieveAStudRecordModel, retrieveAllStudsInParticularCourseModel, retrieveStudsEnrolledCourseModel;
    
    private JTable retrieveACourseTable, retrieveAStudRecordTable, retrieveAllStudsInParticularCourseTable, retrieveStudsEnrolledCourseTable;
    
    private JComboBox adminComboBox, deleteCourseRecordComboBox, deleteUserRecordComboBox;
    
    private String courseToDelete;
    
    private Object userToDelete;
    
/*-----------------EndOfAdminWindow-------------------*/
    
    
    public StudentEnrolmentClient(){
        super("Student Enrolment System");
        ft2 = new Font("Courier New", Font.PLAIN, 12);
        ft3 = new Font("Courier New", Font.BOLD, 14);
        ft4 = new Font("Courier New", Font.BOLD, 22);
        ft5 = new Font("Courier New", Font.PLAIN, 13);
        ft6 = new Font("Courier New", Font.BOLD, 12);
        ft7 = new Font("Courier New", Font.PLAIN, 14);
        
        loginPanel = new JPanel();
        northPanel = new JPanel();
        northPanel1 = new JPanel();
        northPanel1.setBackground(Color.BLUE);
        centerPanel = new JPanel();
        centerPanel1 = new JPanel();
        centerPanel2 = new JPanel();
        southPanel = new JPanel();
        
        group = new ButtonGroup();
        
        headingLbl = new JLabel("Log-In");
        headingLbl.setHorizontalAlignment(SwingConstants.CENTER);
        headingLbl.setForeground(Color.YELLOW);
        headingLbl.setFont(ft4);
        
        loginIdLbl = new JLabel("User Id : ");
        loginIdLbl.setFont(ft3);      
        passwordLbl = new JLabel("Password : ");
        passwordLbl.setFont(ft3);
        roleLbl = new JLabel("Role : ");
        roleLbl.setFont(ft3);
        
        loginIdTxt = new JTextField();
        loginIdTxt.setFont(ft7);
        passwordTxt = new JTextField();
        passwordTxt.setFont(ft7);

        loginBtn = new JButton("Log-In");
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBackground(Color.BLUE);
        loginBtn.setFont(ft3);
        loginBtn.setFocusPainted(false);
        loginBtn.setEnabled(false);
        
        clearBtn = new JButton("Clear");
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setBackground(Color.MAGENTA);
        clearBtn.setFont(ft3);
        clearBtn.setFocusPainted(false);
        
        exitBtn = new JButton("Exit");
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setBackground(Color.RED);
        exitBtn.setFont(ft3);
        exitBtn.setFocusPainted(false);
        
        adminRadioBtn = new JRadioButton("Admin");
        adminRadioBtn.setForeground(Color.BLACK);
        adminRadioBtn.setFont(ft2);
        adminRadioBtn.setFocusPainted(false);
        
        studentRadioBtn = new JRadioButton("Student");
        studentRadioBtn.setForeground(Color.BLACK);
        studentRadioBtn.setFont(ft2);
        studentRadioBtn.setFocusPainted(false);
  
        
        
/*-----------------StudentEnrolment-------------------*/
        enrolPanel = new JPanel();
        enrolNorthPanel = new JPanel();
        enrolNorthPanel1= new JPanel();
        enrolNorthPanel1.setBackground(Color.BLUE);
        enrolNorthPanel2 = new JPanel();
        enrolCenterPanel = new JPanel();
        enrolSouthPanel = new JPanel();
        
        enrolHeading = new JLabel("Student Window");
        enrolHeading.setHorizontalAlignment(SwingConstants.CENTER);
        enrolHeading.setForeground(Color.YELLOW);
        enrolHeading.setFont(ft4);
        
        enrolComboBoxLbl = new JLabel("Select a course to either enrol or cancel enrolment :");
        enrolComboBoxLbl.setForeground(Color.BLACK);
        enrolComboBoxLbl.setFont(ft5);
        
        enrolBtn = new JButton("Enrol");
        cancelEnrol = new JButton("Cancel Enrolment");
        enrolLogOutBtn = new JButton("Log-Out");
        
        enrolBtn.setForeground(Color.WHITE);
        enrolBtn.setBackground(Color.BLUE);
        enrolBtn.setFont(ft3);
        enrolBtn.setFocusPainted(false);
        
        cancelEnrol.setForeground(Color.WHITE);
        cancelEnrol.setBackground(Color.MAGENTA);
        cancelEnrol.setFont(ft3);
        cancelEnrol.setFocusPainted(false);
        
        enrolLogOutBtn.setForeground(Color.WHITE);
        enrolLogOutBtn.setBackground(Color.RED);
        enrolLogOutBtn.setFont(ft3);
        enrolLogOutBtn.setFocusPainted(false);
/*-----------------EndStudentEnrolment-------------------*/



/*-----------------AdminWindow-------------------*/
        adminPanel = new JPanel();
        adminNorthPanel = new JPanel();
        adminNorthPanel1 = new JPanel();
        adminNorthPanel2 = new JPanel();
        adminNorthPanel3 = new JPanel();
        adminNorthPanel1.setBackground(Color.BLUE);
        
        adminPanelCenter = new JPanel();
        adminPanelCenter1 = new JPanel();
        adminPanelCenter2 = new JPanel();
        adminPanelCenter3 = new JPanel();
        adminPanelCenter4 = new JPanel();
        
        adminSouthPanel = new JPanel(); 
        
        adminHeading = new JLabel("Admin Window");
        adminHeading.setHorizontalAlignment(SwingConstants.CENTER);
        adminHeading.setForeground(Color.YELLOW);
        adminHeading.setFont(ft4);
        
        adminComboBoxLbl = new JLabel("Select which task you would like to complete: ");
        adminComboBoxLbl.setForeground(Color.BLACK);
        adminComboBoxLbl.setFont(ft5);
        
        deleteCourseRecordComboBoxLbl = new JLabel("Select the course code of the course you would like to delete :");
        deleteCourseRecordComboBoxLbl.setForeground(Color.BLACK);
        deleteCourseRecordComboBoxLbl.setFont(ft5);
        
        deleteUserRecordComboBoxLbl = new JLabel("Select the user id of the User you would like to delete :");
        deleteUserRecordComboBoxLbl.setForeground(Color.BLACK);
        deleteUserRecordComboBoxLbl.setFont(ft5);
        
        adminUserIdLbl = new JLabel("Enter the Users Id :");
        adminUserIdLbl.setFont(ft3);
        
        adminCourseCodeLbl = new JLabel("Enter the course code :");
        adminCourseCodeLbl.setFont(ft3);
        
        adminUserIdTxt = new JTextField();
        adminUserIdTxt.setFont(ft7);
        adminCourseCodeTxt = new JTextField();
        adminCourseCodeTxt.setFont(ft7);
        
        retrieveACourseRecordBtn = new JButton("Submit");
        retrieveACourseRecordBtn.setForeground(Color.WHITE);
        retrieveACourseRecordBtn.setBackground(Color.BLUE);
        retrieveACourseRecordBtn.setFont(ft3);
        retrieveACourseRecordBtn.setFocusPainted(false);
        
        retrieveAStudRecordBtn = new JButton("Submit");
        retrieveAStudRecordBtn.setForeground(Color.WHITE);
        retrieveAStudRecordBtn.setBackground(Color.BLUE);
        retrieveAStudRecordBtn.setFont(ft3);
        retrieveAStudRecordBtn.setFocusPainted(false);
        
        retrieveAllStudsInParticularCourseBtn = new JButton("Submit");
        retrieveAllStudsInParticularCourseBtn.setForeground(Color.WHITE);
        retrieveAllStudsInParticularCourseBtn.setBackground(Color.BLUE);
        retrieveAllStudsInParticularCourseBtn.setFont(ft3);
        retrieveAllStudsInParticularCourseBtn.setFocusPainted(false);
        
        retrieveStudsEnrolledCourseBtn = new JButton("Submit");
        retrieveStudsEnrolledCourseBtn.setForeground(Color.WHITE);
        retrieveStudsEnrolledCourseBtn.setBackground(Color.BLUE);
        retrieveStudsEnrolledCourseBtn.setFont(ft3);
        retrieveStudsEnrolledCourseBtn.setFocusPainted(false);
        
        deleteCourseRecordBtn = new JButton("Delete");
        deleteCourseRecordBtn.setForeground(Color.WHITE);
        deleteCourseRecordBtn.setBackground(Color.MAGENTA);
        deleteCourseRecordBtn.setFont(ft3);
        deleteCourseRecordBtn.setFocusPainted(false);
        
        deleteUserRecordBtn = new JButton("Delete");
        deleteUserRecordBtn.setForeground(Color.WHITE);
        deleteUserRecordBtn.setBackground(Color.MAGENTA);
        deleteUserRecordBtn.setFont(ft3);
        deleteUserRecordBtn.setFocusPainted(false);
        
        adminLogOutBtn = new JButton("Log-out");
        adminLogOutBtn.setForeground(Color.WHITE);
        adminLogOutBtn.setBackground(Color.RED);
        adminLogOutBtn.setFont(ft3);
        adminLogOutBtn.setFocusPainted(false);
/*-----------------EndOfAdminWindow-------------------*/


        conn.connectToServer();
    }

    public void setGui(){
        loginPanel.setLayout(null);
        loginPanel.setPreferredSize(new Dimension(1000,500));
        northPanel.setLayout(new GridLayout(1, 1));
        northPanel.setBounds(0, 0, 1000, 100);
        northPanel1.setLayout(new BorderLayout());
        
        
        centerPanel.setLayout(new GridLayout(3, 2,0,10));
        centerPanel.setBounds(150, 190, 700, 150);
        centerPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        centerPanel2.setLayout(new GridLayout(1,2));
        
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBounds(0,400,1000, 70);
        
        loginBtn.setPreferredSize(new Dimension(180, 35));
        clearBtn.setPreferredSize(new Dimension(180, 35));
        exitBtn.setPreferredSize(new Dimension(180, 35));
        
        northPanel1.add(headingLbl);
        northPanel.add(northPanel1);
        
        group.add(adminRadioBtn);
        group.add(studentRadioBtn);
        
        centerPanel1.add(roleLbl);
        centerPanel2.add(adminRadioBtn);
        centerPanel2.add(studentRadioBtn);
        
        centerPanel.add(loginIdLbl);
        centerPanel.add(loginIdTxt);
        centerPanel.add(passwordLbl);
        centerPanel.add(passwordTxt);
        centerPanel.add(centerPanel1);
        centerPanel.add(centerPanel2);
        
        southPanel.add(loginBtn);
        southPanel.add(clearBtn);
        southPanel.add(exitBtn);
        
        adminRadioBtn.addActionListener(this);
        studentRadioBtn.addActionListener(this);
        loginBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        
        loginPanel.add(northPanel);
        loginPanel.add(centerPanel);
        loginPanel.add(southPanel);
                
        
/*-----------------StudentEnrolment-------------------*/
        
        enrolPanel.setLayout(new BorderLayout());
        enrolPanel.setPreferredSize(new Dimension(1000,500));
        enrolNorthPanel.setLayout(new GridLayout(2, 1));
        enrolNorthPanel1.setLayout(new BorderLayout());
        enrolNorthPanel2.setLayout(new FlowLayout());
        enrolCenterPanel.setLayout(new BorderLayout());
        enrolSouthPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        enrolNorthPanel.setPreferredSize(new Dimension(1000, 150));
        enrolSouthPanel.setPreferredSize(new Dimension(1000, 50)); 
        
        enrolComboBox = new JComboBox(new String[]{});
        enrolComboBox.setPreferredSize(new Dimension(220, 25));
        enrolComboBox.setFont(ft6);
        
        enrolNorthPanel1.add(enrolHeading);
        enrolNorthPanel2.add(enrolComboBoxLbl);
        enrolNorthPanel2.add(enrolComboBox);
        
        enrolNorthPanel.add(enrolNorthPanel1);
        enrolNorthPanel.add(enrolNorthPanel2);

        model = new DefaultTableModel();
        table = new JTable(model);
        
        model.addColumn("Course Code");
        model.addColumn("Coures Title");
        model.addColumn("Course Description");

        table.setFont(ft2);
        table.getTableHeader().setFont(ft7);
        table.setEnabled(false);
        
        enrolCenterPanel.add(new JScrollPane(table));
        
        enrolBtn.setPreferredSize(new Dimension(180, 35));
        cancelEnrol.setPreferredSize(new Dimension(180, 35));
        enrolLogOutBtn.setPreferredSize(new Dimension(180, 35));

        enrolSouthPanel.add(enrolBtn);
        enrolSouthPanel.add(cancelEnrol);
        enrolSouthPanel.add(enrolLogOutBtn);
        
        enrolComboBox.addActionListener(this);
        enrolBtn.addActionListener(this);
        cancelEnrol.addActionListener(this);
        enrolLogOutBtn.addActionListener(this);
        
        enrolPanel.add(enrolNorthPanel, BorderLayout.NORTH);
        enrolPanel.add(enrolCenterPanel, BorderLayout.CENTER);
        enrolPanel.add(enrolSouthPanel, BorderLayout.SOUTH);
        

/*-----------------EndStudentEnrolment-------------------*/   



/*-----------------AdminWindow-------------------*/
        adminPanel.setLayout(new BorderLayout());
        adminPanel.setPreferredSize(new Dimension(1000,500));
        adminNorthPanel.setLayout(new GridLayout(3, 1));
        adminNorthPanel1.setLayout(new BorderLayout());
        adminNorthPanel2.setLayout(new FlowLayout());
        adminNorthPanel3.setLayout(new FlowLayout());
        
        adminPanelCenter.setLayout(new FlowLayout(FlowLayout.CENTER));
        adminPanelCenter1.setLayout(new BorderLayout());
        adminPanelCenter1.setPreferredSize(new Dimension(980,290));
        adminPanelCenter2.setLayout(new BorderLayout());
        adminPanelCenter2.setPreferredSize(new Dimension(980,290));
        adminPanelCenter3.setLayout(new BorderLayout());
        adminPanelCenter3.setPreferredSize(new Dimension(980,290));
        adminPanelCenter4.setLayout(new BorderLayout());
        adminPanelCenter4.setPreferredSize(new Dimension(980,290));
        
        adminSouthPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        adminNorthPanel.setPreferredSize(new Dimension(1000, 150));
        adminSouthPanel.setPreferredSize(new Dimension(1000, 50));

        adminComboBox = new JComboBox(new String[]{"Non-Selected", "Add user", "Add course", "Retrieve  a user record", "Retrieve all user records", 
            "Retrieve a course record", "Retrieve all course records", "Retrieve student's enrolled course", "Retrieve all students in particular course"});
        adminComboBox.setFont(ft6);
        
        deleteCourseRecordComboBox = new JComboBox(new String[]{});
        deleteCourseRecordComboBox.setFont(ft6);
        deleteCourseRecordComboBox.setPreferredSize(new Dimension(220, 25));
        
        deleteUserRecordComboBox = new JComboBox(new String[]{});
        deleteUserRecordComboBox.setFont(ft6);
        deleteUserRecordComboBox.setPreferredSize(new Dimension(220, 25));
        
        retrieveACourseRecordBtn.setPreferredSize(new Dimension(180, 35));
        retrieveAStudRecordBtn.setPreferredSize(new Dimension(180, 35));
        retrieveAllStudsInParticularCourseBtn.setPreferredSize(new Dimension(180, 35));
        retrieveStudsEnrolledCourseBtn.setPreferredSize(new Dimension(180, 35));
        deleteCourseRecordBtn.setPreferredSize(new Dimension(180, 35));
        deleteUserRecordBtn.setPreferredSize(new Dimension(180, 35));
        adminLogOutBtn.setPreferredSize(new Dimension(180, 35));
        
        adminUserIdTxt.setPreferredSize(new Dimension(220, 30));
        adminCourseCodeTxt.setPreferredSize(new Dimension(220, 30));
        
        adminNorthPanel1.add(adminHeading);
        adminNorthPanel2.add(adminComboBoxLbl);
        adminNorthPanel2.add(adminComboBox);
        adminNorthPanel3.add(adminUserIdLbl);
        adminNorthPanel3.add(adminUserIdTxt);
        adminNorthPanel3.add(adminCourseCodeLbl);
        adminNorthPanel3.add(adminCourseCodeTxt);
        adminNorthPanel3.add(deleteCourseRecordComboBoxLbl);
        adminNorthPanel3.add(deleteCourseRecordComboBox);
        adminNorthPanel3.add(deleteUserRecordComboBoxLbl);
        adminNorthPanel3.add(deleteUserRecordComboBox);

        adminNorthPanel.add(adminNorthPanel1);
        adminNorthPanel.add(adminNorthPanel2);
        adminNorthPanel.add(adminNorthPanel3);

/*-----------------------------------------------------------------*/
        retrieveACourseModel = new DefaultTableModel();
        retrieveACourseTable = new JTable(retrieveACourseModel);

        retrieveACourseModel.addColumn("Course Code");
        retrieveACourseModel.addColumn("Course Title");
        retrieveACourseModel.addColumn("Course Description");

        retrieveACourseTable.setFont(ft2);
        retrieveACourseTable.getTableHeader().setFont(ft7);
        retrieveACourseTable.setEnabled(false);
/*---------------------------------------------------------------*/       

/*-----------------------------------------------------------------*/
        retrieveAStudRecordModel = new DefaultTableModel();
        retrieveAStudRecordTable = new JTable(retrieveAStudRecordModel);

        retrieveAStudRecordModel.addColumn("User Id");
        retrieveAStudRecordModel.addColumn("Name");
        retrieveAStudRecordModel.addColumn("Lastname");
        retrieveAStudRecordModel.addColumn("Password");
        retrieveAStudRecordModel.addColumn("Role");

        retrieveAStudRecordTable.setFont(ft2);
        retrieveAStudRecordTable.getTableHeader().setFont(ft7);
        retrieveAStudRecordTable.setEnabled(false);
/*---------------------------------------------------------------*/ 

/*-----------------------------------------------------------------*/
        retrieveAllStudsInParticularCourseModel = new DefaultTableModel();
        retrieveAllStudsInParticularCourseTable = new JTable(retrieveAllStudsInParticularCourseModel);

        retrieveAllStudsInParticularCourseModel.addColumn("Course Code");
        retrieveAllStudsInParticularCourseModel.addColumn("Student Id");
        retrieveAllStudsInParticularCourseModel.addColumn("Name");
        retrieveAllStudsInParticularCourseModel.addColumn("Lastname");

        retrieveAllStudsInParticularCourseTable.setFont(ft2);
        retrieveAllStudsInParticularCourseTable.getTableHeader().setFont(ft7);
        retrieveAllStudsInParticularCourseTable.setEnabled(false);
/*---------------------------------------------------------------*/ 

/*-----------------------------------------------------------------*/
        retrieveStudsEnrolledCourseModel = new DefaultTableModel();
        retrieveStudsEnrolledCourseTable = new JTable(retrieveStudsEnrolledCourseModel);

        retrieveStudsEnrolledCourseModel.addColumn("Student Id");
        retrieveStudsEnrolledCourseModel.addColumn("Course Code");
        retrieveStudsEnrolledCourseModel.addColumn("Coures Title");
        retrieveStudsEnrolledCourseModel.addColumn("Course Description");

        retrieveStudsEnrolledCourseTable.setFont(ft2);
        retrieveStudsEnrolledCourseTable.getTableHeader().setFont(ft7);
        retrieveStudsEnrolledCourseTable.setEnabled(false);
/*---------------------------------------------------------------*/ 
           
        adminPanelCenter1.add(new JScrollPane(retrieveACourseTable));
        adminPanelCenter2.add(new JScrollPane(retrieveAStudRecordTable));
        adminPanelCenter3.add(new JScrollPane(retrieveAllStudsInParticularCourseTable));
        adminPanelCenter4.add(new JScrollPane(retrieveStudsEnrolledCourseTable));
        
        adminPanelCenter.add(adminPanelCenter1);
        adminPanelCenter.add(adminPanelCenter2);
        adminPanelCenter.add(adminPanelCenter3);
        adminPanelCenter.add(adminPanelCenter4);
        
        adminSouthPanel.add(retrieveACourseRecordBtn);
        adminSouthPanel.add(retrieveAStudRecordBtn);
        adminSouthPanel.add(retrieveAllStudsInParticularCourseBtn);
        adminSouthPanel.add(retrieveStudsEnrolledCourseBtn);
        adminSouthPanel.add(deleteCourseRecordBtn);
        adminSouthPanel.add(deleteUserRecordBtn);
        adminSouthPanel.add(adminLogOutBtn);
        
        adminComboBox.addActionListener(this);
        deleteCourseRecordComboBox.addActionListener(this);
        deleteUserRecordComboBox.addActionListener(this);
        retrieveACourseRecordBtn.addActionListener(this);
        retrieveAStudRecordBtn.addActionListener(this);
        retrieveAllStudsInParticularCourseBtn.addActionListener(this);
        retrieveStudsEnrolledCourseBtn.addActionListener(this);
        deleteCourseRecordBtn.addActionListener(this);
        deleteUserRecordBtn.addActionListener(this);
        adminLogOutBtn.addActionListener(this);
        
        adminPanel.add(adminNorthPanel, BorderLayout.NORTH);
        adminPanel.add(adminPanelCenter, BorderLayout.CENTER);
        adminPanel.add(adminSouthPanel, BorderLayout.SOUTH);
        
        
/*-----------------EndOfAdminWindow-------------------*/

        
        this.add(loginPanel, BorderLayout.NORTH);
        this.add(enrolPanel, BorderLayout.CENTER);
        enrolPanel.setVisible(false);
        this.add(adminPanel,BorderLayout.SOUTH);
        adminPanel.setVisible(false);
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
/*--------------Login-------------------------------------*/
        if (e.getSource() == adminRadioBtn) 
        {
            selectedRole = adminRadioBtn.getText();
            loginBtn.setEnabled(true); 
        }
        if (e.getSource() == studentRadioBtn) 
        {
            selectedRole = studentRadioBtn.getText();
            loginBtn.setEnabled(true);
        }
        if (e.getSource() == loginBtn)
        {
           validateLogin();
        }
        if(e.getSource() == clearBtn)
        {
            loginIdTxt.setText("");
            passwordTxt.setText("");
            group.clearSelection();
            loginBtn.setEnabled(false); 
        }
        if (e.getSource() == exitBtn) 
        {
            conn.closeConnection();
        }
/*--------------EndOfLogin-------------------------------------*/  


/*--------------StudentEnrolment-------------------------------------*/
        if (e.getSource() == enrolBtn){
            enrol();
        }
        if (e.getSource() == cancelEnrol) {
            cancelEnrolment();
            
        }
        if (e.getSource() == enrolLogOutBtn) {
            enrolPanel.setVisible(false);
            loginPanel.setVisible(true);           
        }
/*--------------EndOfStudentEnrolment-------------------------------------*/


/*--------------AdminWindow-------------------------------------*/
        if (e.getSource() == adminComboBox) {
            getComboBoxSelectedItem();
        }
        if (e.getSource() == adminLogOutBtn) {
           adminPanel.setVisible(false);
           loginPanel.setVisible(true); 
        }
        if (e.getSource() == retrieveACourseRecordBtn) {
            retrieveACourseRecord();
        }
        if (e.getSource() == retrieveAStudRecordBtn) {
           retrieveAStudentRecord();
        }
        if (e.getSource() == retrieveAllStudsInParticularCourseBtn) {
           retrieveAllStudentsInParticularCourse();
        }
        if (e.getSource() == retrieveStudsEnrolledCourseBtn) {
           retrieveStudentsEnrolledCourse();
        }
        
        if (e.getSource() == deleteCourseRecordComboBox) {  
           courseToDelete = (String)deleteCourseRecordComboBox.getSelectedItem();
        }
        if (e.getSource() == deleteUserRecordComboBox) {
           userToDelete = deleteUserRecordComboBox.getSelectedItem();
        }
        
        if (e.getSource() == deleteCourseRecordBtn) {
            deleteCourseRecord();
            retrieveACourseModel.setRowCount(0);
            retrieveAllCourseRecords();
        }
        if (e.getSource() == deleteUserRecordBtn) {
            deleteUserRecord();
            retrieveAStudRecordModel.setRowCount(0);
            retrieveAllStudentRecords();

        }  
/*-----------------EndOfAdminWindow----------------------------*/
    }
    
    public void validateLogin(){
        String userId = loginIdTxt.getText();
        String password = passwordTxt.getText();
        String role = selectedRole;
        
        try{
            if (userId.equalsIgnoreCase("") && password.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Both UserId and Password Cannot be Empty");
            }
            else if(userId.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "UserId Cannot be Empty");
            }
            else if(password.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Password Cannot be Empty");
            }
            else if (userId.length() < 3) {
                JOptionPane.showMessageDialog(null, "UserId is too Short");
            }
            else if (userId.length() > 10) {
                JOptionPane.showMessageDialog(null, "UserId is too long");
            }
            else  if (password.length() < 3) {
                JOptionPane.showMessageDialog(null, "Password is too Short");
            }
            else if (password.length() > 10) {
                JOptionPane.showMessageDialog(null, "Password is too long");
            }
            else
            {
                int studentId = Integer.parseInt(userId);
                
                String userDetails = "1" + "#" + studentId + "#" + password + "#" + role;

                conn.out.writeObject(userDetails);
                conn.out.flush();
                
                boolean found = (Boolean)conn.in.readObject();  
                
                if (found == true && role.equals("Student")){
                    JOptionPane.showMessageDialog(null, "Student login Successful");
                    loginPanel.setVisible(false);
                    
                    retrieveAllCourses();
                    enrolPanel.setVisible(true);
                }
                else if(found == true && role.equals("Admin")) {
                    JOptionPane.showMessageDialog(null, "Admin login Successful");
                    loginPanel.setVisible(false);
                    
                    adminComboBox.setSelectedIndex(0);
                    
                    deleteCourseRecordBtn.setVisible(false);
                    deleteUserRecordBtn.setVisible(false);
                    deleteCourseRecordComboBoxLbl.setVisible(false);
                    deleteCourseRecordComboBox.setVisible(false);
                    deleteUserRecordComboBoxLbl.setVisible(false);
                    deleteUserRecordComboBox.setVisible(false);
                    adminUserIdLbl.setVisible(false);
                    adminUserIdTxt.setVisible(false);
                    adminCourseCodeLbl.setVisible(false);
                    adminCourseCodeTxt.setVisible(false);
                    adminPanelCenter1.setVisible(false);
                    adminPanelCenter2.setVisible(false);
                    adminPanelCenter3.setVisible(false);
                    adminPanelCenter4.setVisible(false);
                    retrieveACourseRecordBtn.setVisible(false);
                    retrieveAStudRecordBtn.setVisible(false);
                    retrieveAllStudsInParticularCourseBtn.setVisible(false);
                    retrieveStudsEnrolledCourseBtn.setVisible(false);
                    
                    adminPanel.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Login Unsuccessful. Incorrect Login Credentials");
                }
            }
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "UserId cannot be a string");
        }
        catch(ClassNotFoundException | IOException cnfe){
            JOptionPane.showMessageDialog(null, cnfe.getMessage());
        }
     
    }
    
    public void retrieveAllCourses(){
        try{
            conn.out.writeObject("retrieveCourses");
            conn.out.flush();

            ArrayList<Course> courseList = (ArrayList)conn.in.readObject();

            if (courseList.isEmpty()) {
                JOptionPane.showMessageDialog(null, """
                                                    No Courses where found in the database
                                                    You cannot enrol currently""");
            }
            else {
                populateTable(courseList);
                populateComboBox(courseList);
            }


        }
        catch(ClassNotFoundException | IOException cnfe){
            JOptionPane.showMessageDialog(null,cnfe.getMessage());
        }
    }
    
    public void populateTable(ArrayList<Course> courseList){
        model.setRowCount(0);
        
        for(Course i : courseList){
            model.addRow(new Object []{i.getCourseCode(), i.getCourseTitle(), i.getCourseDescription()});
        }
            
    }
        
    public void populateComboBox(ArrayList<Course> courseList){
        enrolComboBox.removeAllItems();
        enrolComboBox.addItem("");
        for(Course i : courseList){
            enrolComboBox.addItem(i.getCourseCode());
        }
    }
        
    public void enrol(){
        String userId = loginIdTxt.getText();
        String courseCode = (String)enrolComboBox.getSelectedItem();
        
        if (courseCode.equals("")) {
            JOptionPane.showMessageDialog(null,"Please select a course code from the combobox to proceed.");
        }else{
            String enrolDetails =  "2" + "#" + userId + "#" + courseCode;

            try{
                conn.out.writeObject(enrolDetails);
                conn.out.flush();

                int response = (Integer)conn.in.readObject();


                if(response > 0){
                   JOptionPane.showMessageDialog(null,"""
                                                      Enrol Successful.
                                                      Student Number: """ + userId + " Enrolled for course: " + courseCode); 
                }
                else{
                    JOptionPane.showMessageDialog(null,"""
                                                      Enrol Unsuccessful.
                                                      Student Number: """ + userId + " Is already enrolled for course: " + courseCode);
                }
            }
            catch(ClassNotFoundException | IOException cnfe){
                JOptionPane.showMessageDialog(null,cnfe.getMessage());
            } 
        }
         
    }
    
    public void cancelEnrolment(){
        String userId = loginIdTxt.getText();
        String courseCode = (String)enrolComboBox.getSelectedItem();
        
        if (courseCode.equals("")) {
            JOptionPane.showMessageDialog(null,"Please select a course code from the combobox to proceed.");
        }else{
            String confirmation = "Confirm Enrolment Cancelation For Course : " + courseCode;
            int result = JOptionPane.showOptionDialog(null,confirmation,"Cancel Enrolment",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,null,null);

            if (result == JOptionPane.YES_OPTION) {
                String enrolDetails =  "7" + "#" + userId + "#" + courseCode;

                try{
                    conn.out.writeObject(enrolDetails);
                    conn.out.flush();

                    int response = (Integer)conn.in.readObject();

                    if(response > 0)
                    {
                       JOptionPane.showMessageDialog(null, "Success! Enrolment Cancelation for Course : " + courseCode + " Was Successul."); 
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, """
                                                            "Enrolment Cancelation UnSuccesful. "
                                                            Student with the Student Number : """ + userId + " was never enrolled for course : " + courseCode); 
                    }

                }
                catch(ClassNotFoundException | IOException cnfe){
                    JOptionPane.showMessageDialog(null,cnfe.getMessage());
                } 
            }  
        }
    }
    
    public void getComboBoxSelectedItem() {
        String selectedChoice = (String) adminComboBox.getSelectedItem();
       
        if (selectedChoice.equals("Add user")) {
            adminUserIdLbl.setVisible(false);
            adminUserIdTxt.setVisible(false);
            adminCourseCodeLbl.setVisible(false);
            adminCourseCodeTxt.setVisible(false);
            adminPanelCenter1.setVisible(false);
            adminPanelCenter2.setVisible(false);
            adminPanelCenter3.setVisible(false);
            adminPanelCenter4.setVisible(false);
            retrieveAStudRecordBtn.setVisible(false);
            retrieveACourseRecordBtn.setVisible(false);
            deleteCourseRecordBtn.setVisible(false);
            deleteUserRecordBtn.setVisible(false);
            deleteCourseRecordComboBoxLbl.setVisible(false);
            deleteCourseRecordComboBox.setVisible(false);
            deleteUserRecordComboBoxLbl.setVisible(false);
            deleteUserRecordComboBox.setVisible(false);
            
            addStudentGui();    
        } else if (selectedChoice.equals("Add course")) {
            adminUserIdLbl.setVisible(false);
            adminUserIdTxt.setVisible(false);
            adminCourseCodeLbl.setVisible(false);
            adminCourseCodeTxt.setVisible(false);
            adminPanelCenter1.setVisible(false);
            adminPanelCenter2.setVisible(false);
            adminPanelCenter3.setVisible(false);
            adminPanelCenter4.setVisible(false);
            retrieveAStudRecordBtn.setVisible(false);
            retrieveACourseRecordBtn.setVisible(false);
            deleteCourseRecordBtn.setVisible(false);
            deleteUserRecordBtn.setVisible(false);
            deleteCourseRecordComboBoxLbl.setVisible(false);
            deleteCourseRecordComboBox.setVisible(false);
            deleteUserRecordComboBoxLbl.setVisible(false);
            deleteUserRecordComboBox.setVisible(false);
            
            addCourseGui();    
        }else if(selectedChoice.equals("Retrieve a course record")){
            retrieveACourseModel.setRowCount(0);
                    
            adminUserIdLbl.setVisible(false);
            adminUserIdTxt.setVisible(false);
            adminPanelCenter1.setVisible(false);
            adminPanelCenter2.setVisible(false);
            adminPanelCenter3.setVisible(false);
            adminPanelCenter4.setVisible(false);
            retrieveAStudRecordBtn.setVisible(false);
            retrieveAllStudsInParticularCourseBtn.setVisible(false);
            retrieveStudsEnrolledCourseBtn.setVisible(false);
            deleteCourseRecordBtn.setVisible(false);
            deleteUserRecordBtn.setVisible(false);
            deleteCourseRecordComboBoxLbl.setVisible(false);
            deleteCourseRecordComboBox.setVisible(false);
            deleteUserRecordComboBoxLbl.setVisible(false);
            deleteUserRecordComboBox.setVisible(false);
            
            adminCourseCodeTxt.setText("");
            adminCourseCodeLbl.setVisible(true);
            adminCourseCodeTxt.setVisible(true);
            retrieveACourseRecordBtn.setVisible(true);
        } else if (selectedChoice.equals("Retrieve  a user record")) {
            retrieveAStudRecordModel.setRowCount(0);
            
            adminCourseCodeLbl.setVisible(false);
            adminCourseCodeTxt.setVisible(false);
            adminPanelCenter1.setVisible(false);
            adminPanelCenter2.setVisible(false);
            adminPanelCenter3.setVisible(false);
            adminPanelCenter4.setVisible(false);
            retrieveACourseRecordBtn.setVisible(false);
            retrieveAllStudsInParticularCourseBtn.setVisible(false);
            retrieveStudsEnrolledCourseBtn.setVisible(false);
            deleteCourseRecordBtn.setVisible(false);
            deleteUserRecordBtn.setVisible(false);
            deleteCourseRecordComboBoxLbl.setVisible(false);
            deleteCourseRecordComboBox.setVisible(false);
            deleteUserRecordComboBoxLbl.setVisible(false);
            deleteUserRecordComboBox.setVisible(false);
            
            adminUserIdTxt.setText("");
            adminUserIdLbl.setVisible(true);
            adminUserIdTxt.setVisible(true);
            retrieveAStudRecordBtn.setVisible(true);
        } else if (selectedChoice.equals("Retrieve all course records")){
            retrieveACourseModel.setRowCount(0);
                    
            adminUserIdLbl.setVisible(false);
            adminUserIdTxt.setVisible(false);
            adminCourseCodeLbl.setVisible(false);
            adminCourseCodeTxt.setVisible(false);
            adminPanelCenter1.setVisible(false);
            adminPanelCenter2.setVisible(false);
            adminPanelCenter3.setVisible(false);
            adminPanelCenter4.setVisible(false);
            retrieveAStudRecordBtn.setVisible(false);
            retrieveACourseRecordBtn.setVisible(false);
            retrieveAllStudsInParticularCourseBtn.setVisible(false);
            retrieveStudsEnrolledCourseBtn.setVisible(false);
            deleteUserRecordBtn.setVisible(false);
            deleteUserRecordComboBoxLbl.setVisible(false);
            deleteUserRecordComboBox.setVisible(false);
            
            deleteCourseRecordBtn.setVisible(true);
            deleteCourseRecordComboBoxLbl.setVisible(true);
            deleteCourseRecordComboBox.setVisible(true);
            retrieveAllCourseRecords();
        }else if(selectedChoice.equals("Retrieve all user records")){
            retrieveAStudRecordModel.setRowCount(0);
            
            adminUserIdLbl.setVisible(false);
            adminUserIdTxt.setVisible(false);
            adminCourseCodeLbl.setVisible(false);
            adminCourseCodeTxt.setVisible(false);
            adminPanelCenter1.setVisible(false);
            adminPanelCenter2.setVisible(false);
            adminPanelCenter3.setVisible(false);
            adminPanelCenter4.setVisible(false);
            retrieveAStudRecordBtn.setVisible(false);
            retrieveACourseRecordBtn.setVisible(false);
            retrieveAllStudsInParticularCourseBtn.setVisible(false);
            retrieveStudsEnrolledCourseBtn.setVisible(false);
            deleteCourseRecordBtn.setVisible(false);
            deleteCourseRecordComboBoxLbl.setVisible(false);
            deleteCourseRecordComboBox.setVisible(false);
            
            deleteUserRecordComboBoxLbl.setVisible(true);
            deleteUserRecordComboBox.setVisible(true);
            deleteUserRecordBtn.setVisible(true);
            retrieveAllStudentRecords();
        }else if(selectedChoice.equals("Retrieve all students in particular course")){
            retrieveAllStudsInParticularCourseModel.setRowCount(0);
            
            adminUserIdLbl.setVisible(false);
            adminUserIdTxt.setVisible(false);
            adminPanelCenter1.setVisible(false);
            adminPanelCenter2.setVisible(false);
            adminPanelCenter3.setVisible(false);
            adminPanelCenter4.setVisible(false);
            retrieveAStudRecordBtn.setVisible(false);
            retrieveACourseRecordBtn.setVisible(false);
            retrieveStudsEnrolledCourseBtn.setVisible(false);
            deleteCourseRecordBtn.setVisible(false);
            deleteUserRecordBtn.setVisible(false);
            deleteCourseRecordComboBoxLbl.setVisible(false);
            deleteCourseRecordComboBox.setVisible(false);
            deleteUserRecordComboBoxLbl.setVisible(false);
            deleteUserRecordComboBox.setVisible(false);
            
            adminCourseCodeTxt.setText("");
            adminCourseCodeLbl.setVisible(true);
            adminCourseCodeTxt.setVisible(true);
            retrieveAllStudsInParticularCourseBtn.setVisible(true);
        }else if(selectedChoice.equals("Retrieve student's enrolled course")){
            retrieveStudsEnrolledCourseModel.setRowCount(0);
            
            adminCourseCodeLbl.setVisible(false);
            adminCourseCodeTxt.setVisible(false);
            adminPanelCenter1.setVisible(false);
            adminPanelCenter2.setVisible(false);
            adminPanelCenter3.setVisible(false);
            adminPanelCenter4.setVisible(false);
            retrieveAStudRecordBtn.setVisible(false);
            retrieveACourseRecordBtn.setVisible(false);
            retrieveAllStudsInParticularCourseBtn.setVisible(false);
            deleteCourseRecordBtn.setVisible(false);
            deleteUserRecordBtn.setVisible(false);
            deleteCourseRecordComboBoxLbl.setVisible(false);
            deleteCourseRecordComboBox.setVisible(false);
            deleteUserRecordComboBoxLbl.setVisible(false);
            deleteUserRecordComboBox.setVisible(false);
            
            adminUserIdTxt.setText("");
            adminUserIdLbl.setVisible(true);
            adminUserIdTxt.setVisible(true);
            retrieveStudsEnrolledCourseBtn.setVisible(true);
        }
        
    }
    
    public void addStudentGui(){
        JLabel userIdLbl = new JLabel("UserId:");
        JLabel nameLbl = new JLabel("Name:");
        JLabel lastnameLbl = new JLabel("LastName:");
        JLabel passWordLbl = new JLabel("Password:");
        JLabel role = new JLabel("Role:");
        
        JTextField userIdTxt = new JTextField(10);
        JTextField nameTxt = new JTextField(10);
        JTextField lastnameTxt = new JTextField(10);
        JTextField passWordTxt = new JTextField(10);
        
        JRadioButton adminRadio = new JRadioButton("Admin");
        adminRadio.setFocusPainted(false);
        JRadioButton studentRadio = new JRadioButton("Student");
        studentRadio.setFocusPainted(false);
        
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(adminRadio);
        btnGroup.add(studentRadio);
        
        JPanel addStudcenterPanel1 = new JPanel(new GridLayout(1,1));
        JPanel addStudcenterPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        addStudcenterPanel1.add(role);
        
        addStudcenterPanel2.add(adminRadio);
        addStudcenterPanel2.add(studentRadio);

        JPanel addStudCenterPanel = new JPanel(new GridLayout(5,2));
        addStudCenterPanel.setPreferredSize(new Dimension(500,250));
        
        addStudCenterPanel.add(userIdLbl);
        addStudCenterPanel.add(userIdTxt);
        addStudCenterPanel.add(nameLbl);
        addStudCenterPanel.add(nameTxt);
        addStudCenterPanel.add(lastnameLbl);
        addStudCenterPanel.add(lastnameTxt);
        addStudCenterPanel.add(passWordLbl);
        addStudCenterPanel.add(passWordTxt);
        addStudCenterPanel.add(addStudcenterPanel1);
        addStudCenterPanel.add(addStudcenterPanel2);
        
        String  choice[] = {"Add User","Exit"};
        int result = JOptionPane.showOptionDialog(null,addStudCenterPanel,"Add User",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,choice,null);
        
        if (result == JOptionPane.OK_OPTION) {
            
            String selectedOptionRole;
            String userId = userIdTxt.getText();
            String name = nameTxt.getText();
            String lastname = lastnameTxt.getText();
            String password = passWordTxt.getText();
            
           
            
            try{
                if (userId.equalsIgnoreCase("") && name.equalsIgnoreCase("") && lastname.equalsIgnoreCase("") && password.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "\"All Fields Cannot Be Empty.\"");
                } else if (userId.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "UserId Cannot be Empty");
                } else if (password.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "Password Cannot be Empty");
                } else if (userId.length() < 3) {
                    JOptionPane.showMessageDialog(null, "UserId is too Short");
                } else if (userId.length() > 10) {
                    JOptionPane.showMessageDialog(null, "UserId is too long");
                } else if (password.length() < 3) {
                    JOptionPane.showMessageDialog(null, "Password is too Short");
                } else if (password.length() > 12) {
                    JOptionPane.showMessageDialog(null, "Password is too long");
                }else if (name.matches(".*\\d.*")) {
                    JOptionPane.showMessageDialog(null, "Name cannot contain numbers.");
                } else if (lastname.matches(".*\\d.*")) {
                    JOptionPane.showMessageDialog(null, "Lastname cannot contain numbers.");
                }else if (!adminRadio.isSelected() && !studentRadio.isSelected()) {
                    JOptionPane.showMessageDialog(null,"Please select a role before clicking the add user button");
                }else{
                    if (adminRadio.isSelected()) {
                        selectedOptionRole = adminRadio.getText();
                    }else{
                        selectedOptionRole = studentRadio.getText();
                    }

                    User user = new User(Integer.parseInt(userId), name, lastname, password, selectedOptionRole);

                    conn.out.writeObject(user);
                    conn.out.flush();

                    int response = (Integer) conn.in.readObject();

                    if (response > 0 && selectedOptionRole.equalsIgnoreCase("Admin")) {
                        JOptionPane.showMessageDialog(null, """
                                                               "Admin Was Added Successfully"
                                                               Admin Details : 
                                                               Admin Code : """ + userId + "\nName : " + name + "\nLastname: " + lastname + "\nPassword : " + password);
                    } else if (response > 0 && selectedOptionRole.equalsIgnoreCase("Student")) {
                        JOptionPane.showMessageDialog(null, """
                                                               "Student Was Added Successfully"
                                                               Student Details : 
                                                               Student Number :  """ + userId + "\nName : " + name + "\nLastname: " + lastname + "\nPassword : " + password);
                    } else {
                        JOptionPane.showMessageDialog(null, """
                                                               "User Addition Was Unsuccessfull"
                                                                User with this Id :  """ + userId + "  already exits in the database. " + """ 
                                                                \nEntered User Details : 
                                                                User Id :   """ + userId + "\nName : " + name + "\nLastname : " + lastname + "\nPassword : " + password + "\nRole : " + selectedOptionRole);
                    }
                }  
            } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "UserId cannot be a string");
            } catch (ClassNotFoundException | IOException cnfe) {
                JOptionPane.showMessageDialog(null, cnfe.getMessage());
            }
        }
    }
    
    public void addCourseGui(){
        JLabel courseCodeLbl = new JLabel("Course Code:");
        JLabel courseTitleLbl = new JLabel("Course Title:");
        JLabel courseDescriptionLbl = new JLabel("Course Description:");
        
        JTextField courseCodeTxt = new JTextField();
        JTextField courseTitleTxt = new JTextField();
        
        courseCodeTxt.setPreferredSize(new Dimension(250,50));
        courseTitleTxt.setPreferredSize(new Dimension(250,50));
        
        JTextArea courseDescriptionArea = new JTextArea(10,10);
        
        JPanel addCourCenterPanel = new JPanel(new GridLayout(3,2));
        addCourCenterPanel.setPreferredSize(new Dimension(500,300));
        
        JPanel addCourCenterPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel addCourCenterPanel2 = new JPanel(new FlowLayout());
        JPanel addCourCenterPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel addCourCenterPanel4 = new JPanel(new FlowLayout());
        JPanel addCourCenterPanel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        addCourCenterPanel1.add(courseCodeLbl);
        addCourCenterPanel2.add(courseCodeTxt);
        addCourCenterPanel3.add(courseTitleLbl);
        addCourCenterPanel4.add(courseTitleTxt);
        addCourCenterPanel5.add(courseDescriptionLbl);
        
        addCourCenterPanel.add(addCourCenterPanel1);
        addCourCenterPanel.add(addCourCenterPanel2);
        addCourCenterPanel.add(addCourCenterPanel3);
        addCourCenterPanel.add(addCourCenterPanel4);
        addCourCenterPanel.add(addCourCenterPanel5);
        addCourCenterPanel.add(new JScrollPane(courseDescriptionArea));
        
        String  choice[] = {"Add Course","Exit"};        
        int result = JOptionPane.showOptionDialog(null,addCourCenterPanel,"Add Course",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,choice,null);
        
        if (result == JOptionPane.OK_OPTION) {
            String courseCode = (((courseCodeTxt.getText()).toUpperCase()).trim()).replaceAll("\\s", "");
            String courseTitle = courseTitleTxt.getText();
            String courseDescription = courseDescriptionArea.getText();

            try {
                if (courseCode.equalsIgnoreCase("") && courseTitle.equalsIgnoreCase("") && courseDescription.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "\"All Fields Cannot Be Empty.\"");
                }else if (courseCode.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "\"Course Code Field Cannot be Empty.\"");
                }else if (courseTitle.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "\"Course Title Field Cannot be Empty.\"");
                }else if (courseDescription.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "\"Course Description Field Cannot be Empty.\"");
                }else if (courseCode.length() < 3) {
                    JOptionPane.showMessageDialog(null, "Course code is too Short");
                }else if (courseCode.length() > 20) {
                    JOptionPane.showMessageDialog(null, "Course code is too long");
                }
                else {
                    Course course = new Course(courseCode, courseTitle, courseDescription);

                    conn.out.writeObject(course);
                    conn.out.flush();

                    int response = (Integer) conn.in.readObject();

                    if (response >  0) {
                        JOptionPane.showMessageDialog(null, """
                                                       "Course Addition Was Successful."
                                                       Course Details : 
                                                       Course Code : """ + courseCode + "\ncourse Title : " + courseTitle + "\nCourse Description : " + courseDescription);
                    } else {
                        JOptionPane.showMessageDialog(null, """
                                                       "Course Addition Unsuccesful. A course with the entered course code is already available in the database."
                                                       Course Details : 
                                                       Course Code : """ + courseCode + "\ncourse Title : " + courseTitle + "\nCourse Description : " + courseDescription);
                    }
                }
            }catch (ClassNotFoundException | IOException cnfe) {
                JOptionPane.showMessageDialog(null, cnfe.getMessage());
            }

        }
        
    }
    
    public void retrieveACourseRecord() {
        String courseCode = (((adminCourseCodeTxt.getText()).toUpperCase()).trim()).replaceAll("\\s", "");

        try {
            if (courseCode.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Course code field cannot be left empty.");
                adminCourseCodeTxt.requestFocus();
            }else if (courseCode.length() < 3) {
                JOptionPane.showMessageDialog(null, "Course code is too Short");
                adminCourseCodeTxt.setText("");
                adminCourseCodeTxt.requestFocus();
            }else if (courseCode.length() > 20) {
                JOptionPane.showMessageDialog(null, "Course code is too long");
                adminCourseCodeTxt.setText("");
                adminCourseCodeTxt.requestFocus();
            }else {
                String retrieveCourse = "3" + "#" + courseCode;
                conn.out.writeObject(retrieveCourse);
                conn.out.flush();

                ArrayList<Course> courseList = (ArrayList) conn.in.readObject();

                if (!courseList.isEmpty()) 
                {
                    displayCourseRecord(courseList);
                    adminPanelCenter1.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "\"No record with the course code : " + courseCode + " was found.\""); 
                    adminCourseCodeTxt.setText("");
                }
                adminCourseCodeTxt.requestFocus();
            }
        } catch (ClassNotFoundException | IOException cnfe) {
            JOptionPane.showMessageDialog(null, cnfe.getMessage());
        }
    }
    
    public void displayCourseRecord(ArrayList<Course> courseList) {
        for(Course i : courseList){
            retrieveACourseModel.addRow(new Object[]{i.getCourseCode(), i.getCourseTitle(), i.getCourseDescription()}); 
        }
    }
    
    public void retrieveAStudentRecord() {
        String userId = adminUserIdTxt.getText();

        try {
            if (userId.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Student number field cannot be left empty.");
                adminUserIdTxt.requestFocus();
            } else if (userId.length() < 3) {
                JOptionPane.showMessageDialog(null, "Student number is too Short");
                adminUserIdTxt.setText("");
                adminUserIdTxt.requestFocus();
            } else if (userId.length() > 10) {
                JOptionPane.showMessageDialog(null, "Student number is too long");
                adminUserIdTxt.setText("");
                adminUserIdTxt.requestFocus();
            } else {
                int studentNumber = Integer.parseInt(userId);

                String retrieveUser = "4" + "#" + studentNumber;

                conn.out.writeObject(retrieveUser);
                conn.out.flush();

                ArrayList<User> userList = (ArrayList) conn.in.readObject();

                if (userList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "\"No record with the student number : " + studentNumber + " was found.\"");
                    adminUserIdTxt.setText("");
                } else {
                    displayStudentRecord(userList);
                    adminPanelCenter2.setVisible(true);
                }
                adminUserIdTxt.requestFocus();
            }

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Student number cannot be a string");
        } catch (ClassNotFoundException | IOException cnfe) {
            JOptionPane.showMessageDialog(null, cnfe.getMessage());
        }
    }

    public void displayStudentRecord(ArrayList<User> userList) {
        for(User i : userList){
            retrieveAStudRecordModel.addRow(new Object[]{i.getUsersId(), i.getUsersName(), i.getUsersLastName(), i.getUsersPassword(),i.getRole()});
        }
    }
    
    public void retrieveAllCourseRecords() {
        try {
            conn.out.writeObject("retrieveCourses");
            conn.out.flush();

            ArrayList<Course> courseList = (ArrayList) conn.in.readObject();

            if (courseList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "\"No Records Found.\"");
            } else {
                displayCourseRecord(courseList);
                populateDeleteCourseRecordComboBox(courseList);
                adminPanelCenter1.setVisible(true);
            }
        } catch (ClassNotFoundException | IOException cnfe) {
            JOptionPane.showMessageDialog(null, cnfe.getMessage());
        }
    }
    
    public void populateDeleteCourseRecordComboBox(ArrayList<Course> courseList){
        deleteCourseRecordComboBox.removeAllItems();
        deleteCourseRecordComboBox.addItem("");
        for (Course i : courseList) {
            deleteCourseRecordComboBox.addItem(i.getCourseCode());
        }
    }
    
    public void retrieveAllStudentRecords() {
        try {
            conn.out.writeObject("retrieveUsers");
            conn.out.flush();

            ArrayList<User> userList = (ArrayList) conn.in.readObject();

            if (userList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "\"No Records Found.\"");
            } else {
                displayStudentRecord(userList);
                populateDeleteUserRecordComboBox(userList);
                adminPanelCenter2.setVisible(true);
            }

        } catch (ClassNotFoundException | IOException cnfe) {
            JOptionPane.showMessageDialog(null, cnfe.getMessage());
        }
    }
    
    public void populateDeleteUserRecordComboBox(ArrayList<User> userList){
        deleteUserRecordComboBox.removeAllItems();
        deleteUserRecordComboBox.addItem("");
        for (User i : userList) {
            deleteUserRecordComboBox.addItem(i.getUsersId());
        }
    }
    
    public void retrieveAllStudentsInParticularCourse() {
        String courseCode = (((adminCourseCodeTxt.getText()).toUpperCase()).trim()).replaceAll("\\s", "");

        try {
            if (courseCode.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Course code field cannot be left empty.");
                adminCourseCodeTxt.requestFocus();
            }else if (courseCode.length() < 3) {
                JOptionPane.showMessageDialog(null, "Course code is too Short");
                adminCourseCodeTxt.setText("");
                adminCourseCodeTxt.requestFocus();
            }else if (courseCode.length() > 20) {
                JOptionPane.showMessageDialog(null, "Course code is too long");
                adminCourseCodeTxt.setText("");
                adminCourseCodeTxt.requestFocus();
            }else {
                String combinedString = "5" + "#" + courseCode;

                conn.out.writeObject(combinedString);
                conn.out.flush();

                ArrayList<User> studentList = (ArrayList) conn.in.readObject();

                if (studentList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "\"No Students are currently enrolled in the course : " + courseCode + "\"");
                } else {
                    displayAllStudentsInParticularCourse(studentList);
                    adminPanelCenter3.setVisible(true);
                    adminCourseCodeTxt.requestFocus();
                }

            }
        } catch (ClassNotFoundException | IOException cnfe) {
            JOptionPane.showMessageDialog(null, cnfe.getMessage());
        }
    }

    public void displayAllStudentsInParticularCourse(ArrayList<User> studentList) {
        for (User i : studentList) {
            retrieveAllStudsInParticularCourseModel.addRow(new Object[]{adminCourseCodeTxt.getText(), i.getUsersId(), i.getUsersName(), i.getUsersLastName()});
        }

    }  
    
    public void retrieveStudentsEnrolledCourse() {
        String userId = adminUserIdTxt.getText();

        try {
            if (userId.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Student number field cannot be left empty.");
                adminUserIdTxt.requestFocus();
            } else if (userId.length() < 3) {
                JOptionPane.showMessageDialog(null, "Student number is too Short");
                adminUserIdTxt.setText("");
                adminUserIdTxt.requestFocus();
            } else if (userId.length() > 10) {
                JOptionPane.showMessageDialog(null, "Student number is too long");
                adminUserIdTxt.setText("");
                adminUserIdTxt.requestFocus();
            } else {
                int userNumber = Integer.parseInt(userId);

                String retrieveStudEnrolCourseStr = "6" + "#" + userNumber;

                conn.out.writeObject(retrieveStudEnrolCourseStr);
                conn.out.flush();

                ArrayList<Course> courseList = (ArrayList) conn.in.readObject();

                if (courseList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "\"Student with student number : " + userNumber + "is not enrolled in any of the available courses.\"");
                } else {
                    displayStudentsEnrolledCourse(courseList);
                    adminPanelCenter4.setVisible(true);
                }
                adminUserIdTxt.requestFocus();
            }

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Student number cannot be a string");
        } catch (ClassNotFoundException | IOException cnfe) {
            JOptionPane.showMessageDialog(null, cnfe.getMessage());
        }
    }

    public void displayStudentsEnrolledCourse(ArrayList<Course> courseList) {
        for (Course i : courseList) {
            retrieveStudsEnrolledCourseModel.addRow(new Object[]{Integer.parseInt(adminUserIdTxt.getText()), i.getCourseCode(), i.getCourseTitle(), i.getCourseDescription()});
        }

    }
    
    public void deleteCourseRecord(){
        if (courseToDelete.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a course code from the combobox to proceed");
        }else{
            String confirmation = "Confirm Deletion of Course : " + courseToDelete;
            int result = JOptionPane.showOptionDialog(null,confirmation,"Delete Course",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,null,null);

            if (result == JOptionPane.YES_OPTION) {
                String deleteString = "8" + "#" + courseToDelete;

                try{
                    conn.out.writeObject(deleteString);
                    conn.out.flush();

                    int response = (Integer)conn.in.readObject();

                    if(response > 0){

                       JOptionPane.showMessageDialog(null, "Success! Deletion of course : " + courseToDelete + " was succesful"); 
                    }
                    else{
                        JOptionPane.showMessageDialog(null, """
                                                            "Course Deletion Was UnSuccessful". 
                                                             Course with the specified course code is not available in the database.""");
                    }
                }
                catch(ClassNotFoundException | IOException cnfe){
                    JOptionPane.showMessageDialog(null, cnfe.getMessage());
                }
            }
        }
        
        
    }
    
    public void deleteUserRecord(){
        if (userToDelete.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a user id from the combobox to proceed");
        }else{
            String confirmation = "Confirm Deletion of User : " + userToDelete;
            int result = JOptionPane.showOptionDialog(null,confirmation,"Delete User",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,null,null);

            if (result == JOptionPane.YES_OPTION) {
                String deleteString = "9" + "#" + userToDelete;

                try{
                    conn.out.writeObject(deleteString);
                    conn.out.flush();

                    int response = (Integer)conn.in.readObject();

                    if(response > 0){

                       JOptionPane.showMessageDialog(null, "Success! Deletion of User : " + userToDelete + " was succesful"); 
                    }
                    else{
                        JOptionPane.showMessageDialog(null, """
                                                            "User Deletion Was UnSuccessful". 
                                                             User with the specified user id is not available in the database.""");
                    }
                }
                catch(ClassNotFoundException | IOException cnfe){
                    JOptionPane.showMessageDialog(null, cnfe.getMessage());
                }
            }
        }
        
    }
    
    
    public static void main(String[] args) {
        StudentEnrolmentClient client = new StudentEnrolmentClient();
        client.setGui();
    }
    
}
