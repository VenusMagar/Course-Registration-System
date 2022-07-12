/**
 * Name : Venus Chhantel
 * Group : N3
 * ID : 20049257 
**/

//Importing packages since we are going to make GUI and also use ArrayList
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; 
import javax.swing.table.DefaultTableModel;

//Creating a class where GUI and all its functionality are created
public class INGCollege
{
    //Declaring instance variables as private so that they are not accessible outside this class
    private JFrame frame, aboutFrame, academicDisplayFrame, nonAcademicDisplayFrame;
    private JMenuBar menuBar;
    private JMenu courseMenu, helpMenu;
    private JMenuItem academicMenuItem, nonAcademicMenuItem, aboutMenuItem, exitMenuItem;
    private JPanel academicCoursePanel, nonAcademicCoursePanel, courseSelectionPanel;
    private JLabel lblAcademicCourse, lblAcademicCourseID, lblAcademicCourseName, lblAcademicDuration, lblAcademicLevel, lblAcademicCredit, lblAcademicNumberOfAssessments, lblAcademicCourseLeader, lblAcademicLecturerName, lblAcademicStartingDate, lblAcademicCompletionDate; 
    private JLabel lblNonAcademicCourse, lblNonAcademicCourseID, lblNonAcademicCourseName, lblNonAcademicDuration, lblNonAcademicPrerequisite, lblNonAcademicCourseLeader, lblNonAcademicInstructorName, lblNonAcademicStartDate, lblNonAcademicCompletionDate, lblNonAcademicExamDate; 
    private JLabel lblFooter1, lblFooter2, lblAboutVersion, lblAboutCopyright, lblAboutPowered, lblAboutInfo, lblLogo;
    private JTextField txtAcademicCourseID, txtAcademicCourseName, txtAcademicDuration, txtAcademicLevel, txtAcademicCredit, txtAcademicNumberOfAssessments, txtAcademicCourseLeader, txtAcademicLecturerName, txtAcademicStartingDate, txtAcademicCompletionDate; 
    private JTextField txtNonAcademicCourseID, txtNonAcademicCourseName, txtNonAcademicDuration, txtNonAcademicPrerequisite, txtNonAcademicCourseLeader, txtNonAcademicInstructorName, txtNonAcademicStartDate, txtNonAcademicCompletionDate, txtNonAcademicExamDate;
    private JButton btnAcademicCourse, btnNonAcademicCourse, btnAddAcademicCourse, btnRegisterAcademicCourse, btnAcademicClear, btnAcademicDisplay;
    private JButton btnAddNonAcademicCourse, btnRegisterNonAcademicCourse, btnRemoveNonAcademicCourse, btnNonAcademicClear, btnNonAcademicDisplay;
    private JButton btnAboutClose, btnAcademicDisplayClose, btnNonAcademicDisplayClose;
    private Font textFont1, textFont2, textFont3, textFont4;
    
    //Declaring as static to keep the value static
    public static AcademicCourse academicObj; 
    public static NonAcademicCourse nonAcademicObj;
    
    
    public ArrayList <Course> academicCourseList = new ArrayList <Course>(); //Making academicCourseList ArrayList of Course type
    public ArrayList <Course> nonAcademicCourseList = new ArrayList <Course>(); //Making nonAcademicCourseList ArrayList of Course type
    
    //Initializing a constructor
    public INGCollege() 
    {
        //Creating a frame which is the main frame 
        frame = new JFrame("INGCollege");
        frame.setSize(1150, 780);
        frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
        frame.setIconImage(new ImageIcon(".//ing.png").getImage()); //Adding icon for the frame
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        //Adding WindowListener to show warning message on exit
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                exitWarning(); //Callling exitWarning method
            }
        });
        
        //Creating differents fonts
        textFont1 = new Font("Microsoft Himalaya", Font.PLAIN, 33);
        textFont2 = new Font("Microsoft Himalaya", Font.BOLD, 60);
        textFont3 = new Font("Microsoft Himalaya", Font.PLAIN, 27);
        textFont4 = new Font("Microsoft Himalaya", Font.PLAIN, 23);
        
        //Creating a menu bar
        menuBar = new JMenuBar();
        
        //Creating menus
        courseMenu = new JMenu("Courses");
        helpMenu = new JMenu("Help");
        
        //Creating menu items
        academicMenuItem = new JMenuItem("Academic Course");
        nonAcademicMenuItem = new JMenuItem("Non-academic Course");
        aboutMenuItem = new JMenuItem("About");
        exitMenuItem = new JMenuItem("Exit");
        
        //Setting fonts
        courseMenu.setFont(textFont3);
        helpMenu.setFont(textFont3);
        academicMenuItem.setFont(textFont3);
        nonAcademicMenuItem.setFont(textFont3);
        aboutMenuItem.setFont(textFont3);
        exitMenuItem.setFont(textFont3);
        
        //Adding menus in the menu bar
        menuBar.add(courseMenu);
        menuBar.add(helpMenu);
        
        //Adding menu items in the menu
        courseMenu.add(academicMenuItem);
        courseMenu.add(nonAcademicMenuItem);
        helpMenu.add(aboutMenuItem);
        helpMenu.add(exitMenuItem);
        
        
        //Adding ActionListener to the academicMenuItem to show the academicCoursePanel
        academicMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                academicCoursePanel.setVisible(true);
                nonAcademicCoursePanel.setVisible(false);    
            }
        });
        
        
        //Adding ActionListener to the nonAcademicMenuItem to show the nonAcademicCoursePanel
        nonAcademicMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                nonAcademicCoursePanel.setVisible(true);
                academicCoursePanel.setVisible(false);    
            }
        });
        
        
        //Adding ActionListener to the exitMenuItem to exit the main frame 
        exitMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                exitWarning(); //Calling exitWarning method    
            }
        });
        
        
        //Adding ActionListener to the aboutMenuItem to show the aboutFrame 
        aboutMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Creating a frame
                aboutFrame = new JFrame("About");
                aboutFrame.setSize(600, 500);
                aboutFrame.setLocationRelativeTo(null);
                aboutFrame.setIconImage(new ImageIcon("ing.png").getImage());
                aboutFrame.getContentPane().setBackground(Color.WHITE);
                aboutFrame.setLayout(null);
                aboutFrame.setResizable(false);
                
                //Adding labels in the frame
                lblLogo = new JLabel(new ImageIcon(".//ing (500 x 300).png")); //Adding image
                lblLogo.setBounds(40, 5, 500, 300);
        
                lblAboutVersion = new JLabel("Version : 1.0.0.0");
                lblAboutVersion.setBounds(230, 320, 125, 30);
                lblAboutVersion.setFont(textFont3);
        
                lblAboutCopyright = new JLabel("Copyright @ 2021");
                lblAboutCopyright.setBounds(225, 340, 145, 30);
                lblAboutCopyright.setFont(textFont3);
        
                lblAboutPowered = new JLabel("Powered by : Venus Chhantel");
                lblAboutPowered.setBounds(187, 360, 220, 30);
                lblAboutPowered.setFont(textFont3);
        
                lblAboutInfo = new JLabel("For more information, contact : info@islington.edu.np");
                lblAboutInfo.setBounds(97, 380, 400, 30);
                lblAboutInfo.setFont(textFont3);
            
                //Adding button in the frame
                btnAboutClose = new JButton("Close");
                btnAboutClose.setBounds(245, 415, 100, 30);
                btnAboutClose.setBackground(new Color(62, 64, 129, 255));
                btnAboutClose.setForeground(Color.WHITE);
                btnAboutClose.setFocusable(false);
                btnAboutClose.setFont(textFont3);
        
                //Adding ActionListener in the button to close the aboutFrame when the button is pressed 
                btnAboutClose.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        aboutFrame.dispose();
                    }
                });
        
                //Adding components in the aboutFrame
                aboutFrame.add(btnAboutClose);
                aboutFrame.add(lblAboutVersion);
                aboutFrame.add(lblAboutCopyright);
                aboutFrame.add(lblAboutPowered);
                aboutFrame.add(lblAboutInfo);
                aboutFrame.add(lblLogo);
        
                aboutFrame.setVisible(true); //Making the frame visible after adding all the components
            }
        }); 
        
        //Creating a panel for selection of the course from button to display respective panel
        courseSelectionPanel =  new JPanel();
        courseSelectionPanel.setSize(1150, 55);
        courseSelectionPanel.setLayout(null);
        courseSelectionPanel.setBackground(new Color(116, 191, 68, 255));
        
        //Creating button for academic course in courseSelectionPanel
        btnAcademicCourse = new JButton("Academic Course");
        btnAcademicCourse.setBounds(173, 9, 300, 35);
        btnAcademicCourse.setBackground(Color.WHITE);
        btnAcademicCourse.setForeground(Color.BLACK);
        btnAcademicCourse.setFont(textFont1);
        btnAcademicCourse.setFocusable(false);
        
        //Creating buttons for non academic course in courseSelectionPanel
        btnNonAcademicCourse = new JButton("Non-Academic Course");
        btnNonAcademicCourse.setBounds(663, 9, 300, 35);
        btnNonAcademicCourse.setBackground(Color.WHITE);
        btnNonAcademicCourse.setForeground(Color.BLACK);
        btnNonAcademicCourse.setFont(textFont1);
        btnNonAcademicCourse.setFocusable(false);
        
        
        //Adding action listener when academic course button is being pressed to show academicCoursePanel
        btnAcademicCourse.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                academicCoursePanel.setVisible(true);
                nonAcademicCoursePanel.setVisible(false);
            }
        });
        
        
        //Adding action listener when non-academic course button is being pressed
        btnNonAcademicCourse.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                nonAcademicCoursePanel.setVisible(true);
                academicCoursePanel.setVisible(false);
            }
        });
        
        //Adding componenets in the courseSelectionPanel
        courseSelectionPanel.add(btnAcademicCourse);
        courseSelectionPanel.add(btnNonAcademicCourse);
        
        //Creating a panel for Academic Course
        academicCoursePanel = new JPanel();
        academicCoursePanel.setBounds(0, 50, 1150, 585);
        academicCoursePanel.setLayout(null);
        academicCoursePanel.setBackground(Color.WHITE);
        academicCoursePanel.setVisible(true);
        
        //Creating label of the Academic Course
        lblAcademicCourse = new JLabel("Academic Course");
        lblAcademicCourse.setBounds(410, 35, 350, 50);
        lblAcademicCourse.setFont(textFont2);
        
        //Creating label of the Academic Course ID 
        lblAcademicCourseID = new JLabel("CourseID :");
        lblAcademicCourseID.setBounds(55, 140, 100, 30);
        lblAcademicCourseID.setFont(textFont1);
        
        //Creating label of the Academic Course Name
        lblAcademicCourseName = new JLabel("Course Name :");
        lblAcademicCourseName.setBounds(55, 180, 150, 30);
        lblAcademicCourseName.setFont(textFont1);
        
        //Creating label of the Academic Course Duration
        lblAcademicDuration = new JLabel("Duration :");
        lblAcademicDuration.setBounds(55, 220, 120, 30);
        lblAcademicDuration.setFont(textFont1);
        
        //Creating label of the Academic Course Level
        lblAcademicLevel = new JLabel("Level :");
        lblAcademicLevel.setBounds(600, 140, 100, 30);
        lblAcademicLevel.setFont(textFont1);
        
        //Creating label of the Academic Course Number of Assessments
        lblAcademicNumberOfAssessments = new JLabel("Total Assessments :");
        lblAcademicNumberOfAssessments.setBounds(600, 180, 180, 30);
        lblAcademicNumberOfAssessments.setFont(textFont1);
        
        //Creating label of the Academic Course Credit
        lblAcademicCredit = new JLabel("Credit :");
        lblAcademicCredit.setBounds(600, 220, 100, 30);
        lblAcademicCredit.setFont(textFont1);
        
        //Creating label of the Academic Course Leader
        lblAcademicCourseLeader = new JLabel("Course Leader :");
        lblAcademicCourseLeader.setBounds(55, 350, 145, 30);
        lblAcademicCourseLeader.setFont(textFont1);
        
        //Creating label of the Academic Lecturer Name
        lblAcademicLecturerName = new JLabel("Lecturer Name :");
        lblAcademicLecturerName.setBounds(55, 390, 150, 30);
        lblAcademicLecturerName.setFont(textFont1);
        
        //Creating label for the Academic Starting date
        lblAcademicStartingDate = new JLabel("Starting Date :");
        lblAcademicStartingDate.setBounds(600, 350, 140, 30);
        lblAcademicStartingDate.setFont(textFont1);       
        
        //Creating label for the Academic Completion date
        lblAcademicCompletionDate = new JLabel("Completion Date :");
        lblAcademicCompletionDate.setBounds(600, 390, 170, 30);
        lblAcademicCompletionDate.setFont(textFont1);

        
        //Creating text field of the Academic CourseID
        txtAcademicCourseID = new JTextField();
        txtAcademicCourseID.setBounds(220, 140, 275, 27);
        txtAcademicCourseID.setFont(textFont1);
        
        //Creating text field of the Academic Course Name
        txtAcademicCourseName = new JTextField();
        txtAcademicCourseName.setBounds(220, 180, 275, 27);
        txtAcademicCourseName.setFont(textFont1);
        
        //Creating text field of the Academic CourseID
        txtAcademicDuration = new JTextField();
        txtAcademicDuration.setBounds(220, 220, 275, 27);
        txtAcademicDuration.setFont(textFont1);
        
        //Creating text field of the Academic Level
        txtAcademicLevel = new JTextField();
        txtAcademicLevel.setBounds(795, 140, 275, 27);
        txtAcademicLevel.setFont(textFont1);
        
        //Creating text field of the Academic Course Number of Assessments
        txtAcademicNumberOfAssessments = new JTextField();
        txtAcademicNumberOfAssessments.setBounds(795, 180, 275, 27);
        txtAcademicNumberOfAssessments.setFont(textFont1);
        
        //Creating text field of the Academic Course Credit
        txtAcademicCredit = new JTextField();
        txtAcademicCredit.setBounds(795, 220, 275, 27);
        txtAcademicCredit.setFont(textFont1);
        
        //Creating text field of the Academic Course Leader
        txtAcademicCourseLeader = new JTextField();
        txtAcademicCourseLeader.setBounds(220, 350, 275, 27);
        txtAcademicCourseLeader.setFont(textFont1); 
        
        //Creating text field of the Academic Course Lecturer Name
        txtAcademicLecturerName = new JTextField();
        txtAcademicLecturerName.setBounds(220, 390, 275, 27);
        txtAcademicLecturerName.setFont(textFont1); 
        
        //Creating text field of the Academic Course starting date
        txtAcademicStartingDate = new JTextField();
        txtAcademicStartingDate.setBounds(795, 350, 275, 27);
        txtAcademicStartingDate.setFont(textFont1);
        txtAcademicStartingDate.setForeground(Color.GRAY);
        txtAcademicStartingDate.setText("dd-mm-yy");
        
        
        //Using FocusListener to implement placholder in the textfield of starting date of academic course
        txtAcademicStartingDate.addFocusListener(new FocusListener()
        {
            //Overriding the method if the textfield is focused
            public void focusGained(FocusEvent evt)
            {
                if(txtAcademicStartingDate.getText().equals("dd-mm-yy"))
                {
                    txtAcademicStartingDate.setText("");
                    txtAcademicStartingDate.setForeground(Color.BLACK);
                }  
            }
            
            //Overriding the method if the textfield is not focused
            public void focusLost(FocusEvent evt)
            {
                if(txtAcademicStartingDate.getText().equals(""))
                {
                    txtAcademicStartingDate.setText("dd-mm-yy");
                    txtAcademicStartingDate.setForeground(Color.GRAY);    
                }
            }
        });
        
        //Creating text field of the Academic Course completion date
        txtAcademicCompletionDate = new JTextField();
        txtAcademicCompletionDate.setBounds(795, 390, 275, 27);
        txtAcademicCompletionDate.setFont(textFont1);
        txtAcademicCompletionDate.setForeground(Color.GRAY);
        txtAcademicCompletionDate.setText("dd-mm-yy");
        
        //Using FocusListener to implement placholder in the textfield of completion date of academic course
        txtAcademicCompletionDate.addFocusListener(new FocusListener()
        {
            //Overriding the method if the textfield is focused
            public void focusGained(FocusEvent evt)
            {
                if(txtAcademicCompletionDate.getText().equals("dd-mm-yy"))
                {
                    txtAcademicCompletionDate.setText("");
                    txtAcademicCompletionDate.setForeground(Color.BLACK);
                }  
            }
            
            //Overriding the method if the textfield is not focused
            public void focusLost(FocusEvent evt)
            {
                if(txtAcademicCompletionDate.getText().equals(""))
                {
                    txtAcademicCompletionDate.setText("dd-mm-yy");
                    txtAcademicCompletionDate.setForeground(Color.GRAY);    
                }
            }
        });
        
        
        //Adding add button to add the academic course
        btnAddAcademicCourse = new JButton("Add");
        btnAddAcademicCourse.setBounds(905, 270, 163, 35);
        btnAddAcademicCourse.setFont(textFont1);
        btnAddAcademicCourse.setBackground(new Color(62, 64, 129, 255));
        btnAddAcademicCourse.setForeground(Color.WHITE);
        btnAddAcademicCourse.setFocusable(false);
        
        
        //Adding action listener when add button of academicCoursePanel is being pressed to add the academic course
        btnAddAcademicCourse.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Checking and displaying warning message if any required text fields are empty
                if (txtAcademicCourseID.getText().isEmpty() || txtAcademicCourseName.getText().isEmpty() || txtAcademicDuration.getText().isEmpty() || txtAcademicLevel.getText().isEmpty() || txtAcademicCredit.getText().isEmpty() || txtAcademicNumberOfAssessments.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(academicCoursePanel, "Please fill up all the blanks to add this academic course.", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                //Storing the values in variables after fetching from the textfield
                String academicCourseID = txtAcademicCourseID.getText();
                String academicCourseName = txtAcademicCourseName.getText();
                String academicLevel = txtAcademicLevel.getText();
                String academicCredit = txtAcademicCredit.getText();

                //Using for each loop to access the objects from the academicCourseList and storing in course which is of Course type 
                for (Course course: academicCourseList)
                {
                    //Checking and displaying warning message if the courseID entered by user is already in the arraylist
                    if(course.getCourseID().equals(academicCourseID))
                    {
                        JOptionPane.showMessageDialog(academicCoursePanel, "This academic courseID is already added.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                
                        
                int academicDuration = 0;
                //Implementing try catch for exception handling
                try
                {
                    //Converting into int datatype using parse and storing in  a variable
                    academicDuration = Integer.parseInt(txtAcademicDuration.getText());
                }
                catch(Exception f)
                {
                    //Showing error message if user doesnot input a whole number
                    JOptionPane.showMessageDialog(academicCoursePanel, "Invalid data type in duration. Please enter a whole number.", "Data input error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                
                int academicNumberOfAssessments = 0;
                //Implementing try catch for exceptional handling
                try
                {
                    //Converting into int datatype using parse and storing in  a variable
                    academicNumberOfAssessments =  Integer.parseInt(txtAcademicNumberOfAssessments.getText());        
                }
                catch(Exception f)
                {
                    //Showing error message if user doesnot input a whole number
                    JOptionPane.showMessageDialog(academicCoursePanel, "Invalid data type in number of assessments. Please enter a whole number.", "Data input error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                //Creating object and passing values in the academicCourse after fetching from the text field 
                academicObj = new AcademicCourse(academicCourseID, academicCourseName, academicDuration, academicLevel, academicCredit, academicNumberOfAssessments); 
                academicCourseList.add(academicObj); //Adding the above object in the academicCourseList
                JOptionPane.showMessageDialog(academicCoursePanel, "This academic course is added successfully."); //Showing a message dialog to show the course is successfully added
                return;
            }
        });
        
        
        
        //Adding register button to register the academic course
        btnRegisterAcademicCourse = new JButton("Register");
        btnRegisterAcademicCourse.setBounds(905, 440, 163, 35);
        btnRegisterAcademicCourse.setFont(textFont1);
        btnRegisterAcademicCourse.setBackground(new Color(62, 64, 129, 255));
        btnRegisterAcademicCourse.setForeground(Color.WHITE);
        btnRegisterAcademicCourse.setFocusable(false);
        
        //Adding action listener when register button of academicCoursePanel is being pressed to register the academic course
        btnRegisterAcademicCourse.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Storing the values in variables after fetching from the textfield
                String academicCourseID = txtAcademicCourseID.getText();
                String academicCourseLeader = txtAcademicCourseLeader.getText();
                String academicLecturerName = txtAcademicLecturerName.getText();
                String academicStartingDate = txtAcademicStartingDate.getText();
                String academicCompletionDate = txtAcademicCompletionDate.getText();
                
                //Checking and displaying warning message if any required text fields are empty
                if (academicCourseID.isEmpty() || academicCourseLeader.isEmpty() || academicLecturerName.isEmpty() || academicStartingDate.isEmpty() || academicStartingDate.equals("dd-mm-yy") || academicCompletionDate.isEmpty() || academicCompletionDate.equals("dd-mm-yy"))
                {
                    JOptionPane.showMessageDialog(academicCoursePanel, "Please fill up all the blanks to register this academic course.", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                
                //Iterating using the for loop
                for(int i = 0; i < academicCourseList.size(); i++)
                {
                    //Checking if the user input courseID with the courseID stored in the academicCourseList arraylist
                    if((academicCourseList.get(i).getCourseID()).equals(academicCourseID))
                    {
                        academicObj = (AcademicCourse) academicCourseList.get(i); //Downcasting to AcademicCourse type because we are extracting oject of Course type from which we cannot call the registerAcademicCourse method

                        //Checking if the course is already registered or not 
                        if(academicObj.getIsRegistered() == false)
                        {
                            //If the course is not registered
                            academicObj.registerAcademicCourse(academicCourseLeader, academicLecturerName, academicStartingDate, academicCompletionDate); //registerAcademicCourse method is called from the AcademicCourse class
                            JOptionPane.showMessageDialog(academicCoursePanel, "This academic course is registered successfully.");
                            return;
                        }
                        else
                        {
                            //If already registered, warning message is shown
                            JOptionPane.showMessageDialog(academicCoursePanel, "This academic course is already registered.", "Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                }
                
                JOptionPane.showMessageDialog(academicCoursePanel, "This academic course does not exist.", "Warning", JOptionPane.WARNING_MESSAGE); //Showing warning message dialogue that the academic course doesnot exist
                return;
            }
        });
        
        
        //Adding display button to disaply all the information of academic course
        btnAcademicDisplay = new JButton("Display");
        btnAcademicDisplay.setBounds(410, 540, 163, 35);
        btnAcademicDisplay.setFont(textFont1);
        btnAcademicDisplay.setBackground(new Color(62, 64, 129, 255));
        btnAcademicDisplay.setForeground(Color.WHITE);
        btnAcademicDisplay.setFocusable(false);
        
        
        //Adding action listener when display button of academicCoursePanel is being pressed to display all the academic course in a table
        btnAcademicDisplay.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Creating a frame 
                academicDisplayFrame = new JFrame("Academic Course Display");
                academicDisplayFrame.setSize(1750, 500);
                academicDisplayFrame.setLocationRelativeTo(null);
                academicDisplayFrame.setIconImage(new ImageIcon("ing.png").getImage());
                academicDisplayFrame.getContentPane().setBackground(Color.WHITE);
                academicDisplayFrame.setResizable(true);

                
                String[] columnName = {"CourseID", "CourseName", "Duration", "Level", "Total Assessments", "Credit", "CourseLeader", "Lecturer Name", "Starting Date", "Completion Date"}; //Initializing column array of String type
                
                DefaultTableModel tableModel = new DefaultTableModel(columnName, 0); //Using DefaultTableModel to add the rows later
                JTable table = new JTable(tableModel); //Creating a table with specified numbers of rows and column from tabelModel
                table.setRowHeight(30);
                table.setFont(textFont3);
                JScrollPane sp = new JScrollPane(table);
                
                //Iterating using for loop
                for(int i = 0; i < academicCourseList.size(); i++)
                {
                    academicObj = (AcademicCourse) academicCourseList.get(i); //Downcasting to AcademicCourse type because we are extracting oject of Course type from which we cannot call the methods of AcademicCourse class 
                    
                    //Initialing  data array of Object type and using get methods of respective classes
                    Object[] data = {academicCourseList.get(i).getCourseID(),
                                     academicCourseList.get(i).getCourseName(), 
                                     academicCourseList.get(i).getDuration(),
                                     academicObj.getLevel(), 
                                     academicObj.getNumberOfAssessments(),
                                     academicObj.getCredit(),
                                     academicCourseList.get(i).getCourseLeader(),
                                     academicObj.getLecturerName(),
                                     academicObj.getStartingDate(),
                                     academicObj.getCompletionDate()
                                    };
                                    
                    tableModel.addRow(data); //Adding the row array each time the loop executes
                }
                
                academicDisplayFrame.add(sp); //Adding in the academicDisplayFrame
                
                academicDisplayFrame.setVisible(true); //Making the acaedmicDisplayFrame visible after adding the components
            }
        });
        
        
        
        //Adding clear button to clear the text fields of academic course
        btnAcademicClear = new JButton("Clear");
        btnAcademicClear.setBounds(610, 540, 163, 35);
        btnAcademicClear.setFont(textFont1);
        btnAcademicClear.setBackground(new Color(62, 64, 129, 255));
        btnAcademicClear.setForeground(Color.WHITE);
        btnAcademicClear.setFocusable(false);

        
        //Adding action listener when clear button of academicCoursePanel is being pressed to clear the textfields
        btnAcademicClear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Setting all the text labels to empty string
                txtAcademicCourseID.setText("");
                txtAcademicCourseName.setText("");
                txtAcademicDuration.setText("");
                txtAcademicLevel.setText("");
                txtAcademicNumberOfAssessments.setText("");
                txtAcademicCredit.setText("");
                txtAcademicCourseLeader.setText("");
                txtAcademicLecturerName.setText("");
                txtAcademicStartingDate.setText("");
                txtAcademicCompletionDate.setText("");
            }
        });
        
        
        
        //Adding labels in the academicCoursePanel
        academicCoursePanel.add(lblAcademicCourse);
        academicCoursePanel.add(lblAcademicCourseID);
        academicCoursePanel.add(lblAcademicCourseName);
        academicCoursePanel.add(lblAcademicDuration);
        academicCoursePanel.add(lblAcademicLevel);
        academicCoursePanel.add(lblAcademicNumberOfAssessments);
        academicCoursePanel.add(lblAcademicCredit);
        academicCoursePanel.add(lblAcademicCourseLeader);
        academicCoursePanel.add(lblAcademicLecturerName);
        academicCoursePanel.add(lblAcademicStartingDate);
        academicCoursePanel.add(lblAcademicCompletionDate);
        
        //Adding text field in the academicCoursePanel        
        academicCoursePanel.add(txtAcademicCourseID);
        academicCoursePanel.add(txtAcademicCourseName);
        academicCoursePanel.add(txtAcademicDuration);  
        academicCoursePanel.add(txtAcademicLevel);
        academicCoursePanel.add(txtAcademicNumberOfAssessments);
        academicCoursePanel.add(txtAcademicCredit);
        academicCoursePanel.add(txtAcademicCourseLeader);
        academicCoursePanel.add(txtAcademicLecturerName);
        academicCoursePanel.add(txtAcademicStartingDate);
        academicCoursePanel.add(txtAcademicCompletionDate);
        
        //Adding buttons in the academicCoursePanel
        academicCoursePanel.add(btnAddAcademicCourse);
        academicCoursePanel.add(btnRegisterAcademicCourse);
        academicCoursePanel.add(btnAcademicClear);
        academicCoursePanel.add(btnAcademicDisplay);
        
        
        //Creating a panel for Non-Academic Course
        nonAcademicCoursePanel = new JPanel();
        nonAcademicCoursePanel.setBounds(0, 50, 1150, 585);
        nonAcademicCoursePanel.setLayout(null);
        nonAcademicCoursePanel.setBackground(Color.WHITE);
        nonAcademicCoursePanel.setVisible(false);
        
        //Creating label of the Non-academic Course
        lblNonAcademicCourse = new JLabel("Non-Academic Course");
        lblNonAcademicCourse.setBounds(385, 35, 600, 50);
        lblNonAcademicCourse.setFont(textFont2);
        
        //Creating label of the Non-academic Course ID 
        lblNonAcademicCourseID = new JLabel("CourseID :");
        lblNonAcademicCourseID.setBounds(55, 140, 100, 30);
        lblNonAcademicCourseID.setFont(textFont1);
        
        //Creating label of the Non-cademic Course Name
        lblNonAcademicCourseName = new JLabel("Course Name :");
        lblNonAcademicCourseName.setBounds(55, 180, 135, 30);
        lblNonAcademicCourseName.setFont(textFont1);
        
        //Creating label of the Non-academic Course duration
        lblNonAcademicDuration = new JLabel("Duration :");
        lblNonAcademicDuration.setBounds(610, 140, 100, 30);
        lblNonAcademicDuration.setFont(textFont1);
        
        //Creating label of the Non-academic Course prerequisite
        lblNonAcademicPrerequisite = new JLabel("Prerequiste :");
        lblNonAcademicPrerequisite.setBounds(610, 180, 120, 30);
        lblNonAcademicPrerequisite.setFont(textFont1);
        
        //Creating label of the Non-academic Course Leader
        lblNonAcademicCourseLeader = new JLabel("Course Leader :");
        lblNonAcademicCourseLeader.setBounds(55, 310, 150, 30);
        lblNonAcademicCourseLeader.setFont(textFont1);
        
        //Creating label of the Non-academic Instructor Name
        lblNonAcademicInstructorName = new JLabel("Instructor Name :");
        lblNonAcademicInstructorName.setBounds(55, 350, 165, 30);
        lblNonAcademicInstructorName.setFont(textFont1);
        
        //Creating label of the Non-academic start date
        lblNonAcademicStartDate = new JLabel("Start Date :");
        lblNonAcademicStartDate.setBounds(55, 390, 120, 30);
        lblNonAcademicStartDate.setFont(textFont1);
        
        //Creating label for the Non-academic completion date
        lblNonAcademicCompletionDate = new JLabel("Completion Date :");
        lblNonAcademicCompletionDate.setBounds(610, 310, 165, 30);
        lblNonAcademicCompletionDate.setFont(textFont1);       
        
        //Creating label for the Academic exam date
        lblNonAcademicExamDate = new JLabel("Exam Date :");
        lblNonAcademicExamDate.setBounds(610, 350, 155, 30);
        lblNonAcademicExamDate.setFont(textFont1);
        
        
        //Creating text field of the Non-academic CourseID 
        txtNonAcademicCourseID = new JTextField();
        txtNonAcademicCourseID.setBounds(220, 140, 275, 27);
        txtNonAcademicCourseID.setFont(textFont1);
        
        //Creating text field of the Non-academic Course Name
        txtNonAcademicCourseName = new JTextField();
        txtNonAcademicCourseName.setBounds(220, 180, 275, 27);
        txtNonAcademicCourseName.setFont(textFont1);
        
        //Creating text field of the Non-academic duration
        txtNonAcademicDuration = new JTextField();
        txtNonAcademicDuration.setBounds(795, 140, 275, 27);
        txtNonAcademicDuration.setFont(textFont1);
        
        //Creating text field of the Non-academic prerequiste
        txtNonAcademicPrerequisite = new JTextField();
        txtNonAcademicPrerequisite.setBounds(795, 180, 275, 27);
        txtNonAcademicPrerequisite.setFont(textFont1);
        
        //Creating text field of the Non-academic Course Leader
        txtNonAcademicCourseLeader = new JTextField();
        txtNonAcademicCourseLeader.setBounds(220, 310, 275, 27);
        txtNonAcademicCourseLeader.setFont(textFont1); 
        
        //Creating text field of the Non-academic course Instructor Name
        txtNonAcademicInstructorName = new JTextField();
        txtNonAcademicInstructorName.setBounds(220, 350, 275, 27);
        txtNonAcademicInstructorName.setFont(textFont1); 
        
        //Creating text field of the Non-academic course start date
        txtNonAcademicStartDate = new JTextField();
        txtNonAcademicStartDate.setBounds(220, 390, 275, 27);
        txtNonAcademicStartDate.setFont(textFont1);
        txtNonAcademicStartDate.setForeground(Color.GRAY);
        txtNonAcademicStartDate.setText("dd-mm-yy");
        
        //Using FocusListener to implement placholder in the textfield of start date of non academic course
        txtNonAcademicStartDate.addFocusListener(new FocusListener()
        {
            //Overriding the method if the textfield is focused
            public void focusGained(FocusEvent evt)
            {
                if(txtNonAcademicStartDate.getText().equals("dd-mm-yy"))
                {
                    txtNonAcademicStartDate.setText("");
                    txtNonAcademicStartDate.setForeground(Color.BLACK);
                }  
            }
            
            //Overriding the method if the textfield is not focused
            public void focusLost(FocusEvent evt)
            {
                if(txtNonAcademicStartDate.getText().equals(""))
                {
                    txtNonAcademicStartDate.setText("dd-mm-yy");
                    txtNonAcademicStartDate.setForeground(Color.GRAY);    
                }
            }
        });
        
        //Creating text field of the non-academic course completion date
        txtNonAcademicCompletionDate = new JTextField();
        txtNonAcademicCompletionDate.setBounds(795, 310, 275, 27);
        txtNonAcademicCompletionDate.setFont(textFont1); 
        txtNonAcademicCompletionDate.setForeground(Color.GRAY);
        txtNonAcademicCompletionDate.setText("dd-mm-yy");
        
        //Using FocusListener to implement placholder in the textfield of completion date of non academic course
        txtNonAcademicCompletionDate.addFocusListener(new FocusListener()
        {
            //Overriding the method if the textfield is focused
            public void focusGained(FocusEvent evt)
            {
                if(txtNonAcademicCompletionDate.getText().equals("dd-mm-yy"))
                {
                    txtNonAcademicCompletionDate.setText("");
                    txtNonAcademicCompletionDate.setForeground(Color.BLACK);
                }  
            }
            
            //Overriding the method if the textfield is not focused
            public void focusLost(FocusEvent evt)
            {
                if(txtNonAcademicCompletionDate.getText().equals(""))
                {
                    txtNonAcademicCompletionDate.setText("dd-mm-yy");
                    txtNonAcademicCompletionDate.setForeground(Color.GRAY);    
                }
            }
        });
        
        
        //Creating text field of the Non-academic course exam date
        txtNonAcademicExamDate = new JTextField();
        txtNonAcademicExamDate.setBounds(795, 350, 275, 27);
        txtNonAcademicExamDate.setFont(textFont1);
        txtNonAcademicExamDate.setForeground(Color.GRAY);
        txtNonAcademicExamDate.setText("dd-mm-yy");
        
        //Using FocusListener to implement placholder in the textfield of exam date of non academic course
        txtNonAcademicExamDate.addFocusListener(new FocusListener()
        {
            //Overriding the method if the textfield is focused
            public void focusGained(FocusEvent evt)
            {
                if(txtNonAcademicExamDate.getText().equals("dd-mm-yy"))
                {
                    txtNonAcademicExamDate.setText("");
                    txtNonAcademicExamDate.setForeground(Color.BLACK);
                }  
            }
            
            //Overriding the method if the textfield is not focused
            public void focusLost(FocusEvent evt)
            {
                if(txtNonAcademicExamDate.getText().equals(""))
                {
                    txtNonAcademicExamDate.setText("dd-mm-yy");
                    txtNonAcademicExamDate.setForeground(Color.GRAY);    
                }
            }
        });
        
        //Adding add button to add the non-academic course
        btnAddNonAcademicCourse = new JButton("Add");
        btnAddNonAcademicCourse.setBounds(905, 230, 163, 35);
        btnAddNonAcademicCourse.setFont(textFont1);
        btnAddNonAcademicCourse.setBackground(new Color(62, 64, 129, 255));
        btnAddNonAcademicCourse.setForeground(Color.WHITE);
        btnAddNonAcademicCourse.setFocusable(false);
        
        
        //Adding action listener when add button of nonAcademicCoursePanel is being pressed to add the non-academic course
        btnAddNonAcademicCourse.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Checking and displaying warning message if any required text fields are empty
                if (txtNonAcademicCourseID.getText().isEmpty() || txtNonAcademicCourseName.getText().isEmpty() || txtNonAcademicDuration.getText().isEmpty() || txtNonAcademicPrerequisite.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(nonAcademicCoursePanel, "Please fill up the blanks to add this non-academic course.", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                //Storing the values in variables after fetching from the textfield
                String nonAcademicCourseID = txtNonAcademicCourseID.getText();
                String nonAcademicCourseName = txtNonAcademicCourseName.getText();
                String nonAcademicPrerequisite = txtNonAcademicPrerequisite.getText();
                
                //Using for each loop to access the objects from the nonAcademicCourseList and storing in course which is of Course type 
                for (Course course: nonAcademicCourseList)
                {
                    //Checking and displaying warning message if the courseID entered by user is already in the arraylist
                    if(course.getCourseID().equals(nonAcademicCourseID))
                    {
                        JOptionPane.showMessageDialog(nonAcademicCoursePanel, "This non-academic courseID is already added.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                
                
                //Implementing try catch for exception handling        
                int nonAcademicDuration = 0;
                try
                {
                    //Converting into int datatype using parse and storing in  a variable
                    nonAcademicDuration = Integer.parseInt(txtNonAcademicDuration.getText());
                }
                catch(Exception f)
                {
                    //Showing error message if user doesnot input a whole number
                    JOptionPane.showMessageDialog(nonAcademicCoursePanel, "Invalid data type in duration. Please enter a whole number.", "Data input error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                        
                //Creating object and passing values in the nonAcademicCourse after fetching from the text field 
                nonAcademicObj = new NonAcademicCourse(nonAcademicCourseID, nonAcademicCourseName, nonAcademicDuration,  nonAcademicPrerequisite);
                nonAcademicCourseList.add(nonAcademicObj); //Adding the above object in the nonAcademicCourseList
                JOptionPane.showMessageDialog(nonAcademicCoursePanel, "This non-academic course is added successfully."); //Showing a message dialog to show the course is successfully added
                return;     
            }
        });        
        
        
        //Adding register button to register the non-academic course
        btnRegisterNonAcademicCourse = new JButton("Register");
        btnRegisterNonAcademicCourse.setBounds(700, 440, 163, 35);
        btnRegisterNonAcademicCourse.setFont(textFont1);
        btnRegisterNonAcademicCourse.setBackground(new Color(62, 64, 129, 255));
        btnRegisterNonAcademicCourse.setForeground(Color.WHITE);
        btnRegisterNonAcademicCourse.setFocusable(false);
        
        //Adding action listener when register button of nonAcademicCoursePanel is being pressed to register the non-academic course
        btnRegisterNonAcademicCourse.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Storing the values in variables after fetching from the textfield
                String nonAcademicCourseID = txtNonAcademicCourseID.getText();
                String nonAcademicCourseLeader = txtNonAcademicCourseLeader.getText();
                String nonAcademicInstuctorName = txtNonAcademicInstructorName.getText();
                String nonAcademicStartDate = txtNonAcademicStartDate.getText();
                String nonAcademicCompletionDate = txtNonAcademicCompletionDate.getText();
                String nonAcademicExitDate = txtNonAcademicExamDate.getText();
                
                //Checking and displaying warning message if any required text fields are empty
                if (nonAcademicCourseID.isEmpty() || nonAcademicCourseLeader.isEmpty() || nonAcademicInstuctorName.isEmpty() || nonAcademicStartDate.isEmpty() || nonAcademicCompletionDate.isEmpty() || nonAcademicExitDate.isEmpty() || nonAcademicStartDate.equals("dd-mm-yy") || nonAcademicCompletionDate.equals("dd-mm-yy") || nonAcademicExitDate.equals("dd-mm-yy"))
                {
                    JOptionPane.showMessageDialog(nonAcademicCoursePanel, "Please fill up all the blanks to register this non-academic course.", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                //Iterating using the for loop
                for (int i = 0; i < nonAcademicCourseList.size(); i++)
                {
                    //Checking if the user input courseID with the courseID stored in the nonAcademicCourseList arraylist
                    if((nonAcademicCourseList.get(i).getCourseID()).equals(nonAcademicCourseID))
                    {
                        nonAcademicObj = (NonAcademicCourse) nonAcademicCourseList.get(i); //Downcasting to NonAcademicCourse type because we are extracting oject of Course type from which we cannot call the registerNonAcademicCourse method
                        
                        //Checking if the course is already registered or not 
                        if(nonAcademicObj.getIsRegistered() == false)
                        {
                            //If the course is not registered
                            nonAcademicObj.registerNonAcademicCourse(nonAcademicCourseLeader, nonAcademicInstuctorName, nonAcademicStartDate, nonAcademicCompletionDate, nonAcademicExitDate); //registerNonAcademicCourse method is called from the NonAcademicCourse class
                            JOptionPane.showMessageDialog(nonAcademicCoursePanel, "This non-academic course is registered successfully.");
                            return;
                        }
                        else
                        {
                            //If already registered, warning message is shown
                            JOptionPane.showMessageDialog(nonAcademicCoursePanel, "This non-academic course is already registered.", "Warning", JOptionPane.WARNING_MESSAGE); 
                            return;
                        }
                    }
                }
                
                JOptionPane.showMessageDialog(nonAcademicCoursePanel, "This non-academic course does not exist", "Warning", JOptionPane.WARNING_MESSAGE); //Showing warning message dialogue that the non-academic course doesnot exist
                return;
            }
        });
        
        
        //Adding display button to disaply all the information of non-academic course
        btnNonAcademicDisplay = new JButton("Display");
        btnNonAcademicDisplay.setBounds(410, 540, 163, 35);
        btnNonAcademicDisplay.setFont(textFont1);
        btnNonAcademicDisplay.setBackground(new Color(62, 64, 129, 255));
        btnNonAcademicDisplay.setForeground(Color.WHITE);
        btnNonAcademicDisplay.setFocusable(false);
        
        //Adding action listener when display button of nonAcademicCoursePanel is being pressed to display all the details of non academic course in a table
        btnNonAcademicDisplay.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Creating a frame
                nonAcademicDisplayFrame = new JFrame("Non Academic Course Display");
                nonAcademicDisplayFrame.setSize(1750, 500);
                nonAcademicDisplayFrame.setLocationRelativeTo(null);
                nonAcademicDisplayFrame.setIconImage(new ImageIcon("ing.png").getImage());
                nonAcademicDisplayFrame.getContentPane().setBackground(Color.WHITE);
                nonAcademicDisplayFrame.setResizable(true);
                
                
                String[] columnName = {"CourseID", "CourseName", "Duration", "Prerequisite", "Course Leader", "Instructor Name", "Start Date", "Completion Date", "Exam Date"}; //Initializing column array of String type
                
                DefaultTableModel tableModel2 = new DefaultTableModel(columnName, 0); //Using DefaultTableModel to add the rows later
                JTable table2 = new JTable(tableModel2); //Creating a table with specified numbers of rows and column from tabelModel2
                table2.setRowHeight(30);
                table2.setFont(textFont3);
                JScrollPane sp2 = new JScrollPane(table2);
                
                //Iterating using for loop
                for(int i = 0; i < nonAcademicCourseList.size(); i++)
                {
                    nonAcademicObj = (NonAcademicCourse) nonAcademicCourseList.get(i); //Downcasting to NonAcademicCourse type because we are extracting oject of Course type from which we cannot call the methods of NonAcademicCourse class
                    
                    //Initialing  data array of Object type and using get methods of respective classes
                    Object[] data = {nonAcademicCourseList.get(i).getCourseID(),
                                     nonAcademicCourseList.get(i).getCourseName(), 
                                     nonAcademicCourseList.get(i).getDuration(),
                                     nonAcademicObj.getPrerequisite(), 
                                     nonAcademicCourseList.get(i).getCourseLeader(),
                                     nonAcademicObj.getInstructorName(),
                                     nonAcademicObj.getStartingDate(),
                                     nonAcademicObj.getCompletionDate(),
                                     nonAcademicObj.getExamDate(),
                                    };
                    tableModel2.addRow(data); //Adding the row array each time the loop executes
                }
                
                nonAcademicDisplayFrame.add(sp2); //Adding in the nonAcademicDisplayFrame 
                
                nonAcademicDisplayFrame.setVisible(true); //Making the acaedmicDisplayFrame visible after adding the components
            }
        });
        
        //Adding remove button to remove the non-academic course
        btnRemoveNonAcademicCourse = new JButton("Remove");
        btnRemoveNonAcademicCourse.setBounds(905, 440, 163, 35);
        btnRemoveNonAcademicCourse.setFont(textFont1);
        btnRemoveNonAcademicCourse.setBackground(new Color(62, 64, 129, 255));
        btnRemoveNonAcademicCourse.setForeground(Color.WHITE);
        btnRemoveNonAcademicCourse.setFocusable(false);
        
        //Adding action listener when remove button of nonAcademicCoursePanel is being pressed then the course is removed from the nonAcademicList 
        btnRemoveNonAcademicCourse.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int removeResponse = JOptionPane.showConfirmDialog(frame, "Are you sure to remove this course?","Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (removeResponse == JOptionPane.YES_OPTION)
                {
                    //Storing the values in variables after fetching from the textfield
                    String nonAcademicCourseID = txtNonAcademicCourseID.getText();
                
                    //Checking and displaying warning message if any required text fields are empty
                    if (nonAcademicCourseID.isEmpty())
                    {
                        JOptionPane.showMessageDialog(nonAcademicCoursePanel, "Please fill up the courseID to remove the non-academic course.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                
                    //Iterating using the for loop
                    for (int i = 0; i < nonAcademicCourseList.size(); i++)
                    {
                        //Checking if the user input courseID with the courseID stored in the nonAcademicCourseList arraylist
                        if((nonAcademicCourseList.get(i).getCourseID()).equals(nonAcademicCourseID))
                        {
                            nonAcademicObj = (NonAcademicCourse) nonAcademicCourseList.get(i);//Downcasting to NonAcademicCourse type because we are extracting oject of Course type from which we cannot call the remove method
                        
                            //Checking if the course is already registered or not 
                            if(nonAcademicObj.getIsRemoved() == false)
                            {
                                //If the course is not registered
                                nonAcademicObj.remove(); //Using remove method of arraylist to remove that index from the NonAcademicCourse class
                                JOptionPane.showMessageDialog(nonAcademicCoursePanel, "This non-academic course is removed successfully.");
                                nonAcademicCourseList.remove(i); //remove method is used to remove from the nonAcademicCourseList
                                return;
                            }
                        }
                    }
                
                    JOptionPane.showMessageDialog(nonAcademicCoursePanel, "This non-academic course does not exist", "Warning", JOptionPane.WARNING_MESSAGE); //Showing warning message dialogue that the non-academic course doesnot exist
                    return;
                }
            }
        });
        
        //Adding clear button to clear the text fields of non-academic course
        btnNonAcademicClear = new JButton("Clear");
        btnNonAcademicClear.setBounds(610, 540, 163, 35);
        btnNonAcademicClear.setFont(textFont1);
        btnNonAcademicClear.setBackground(new Color(62, 64, 129, 255));
        btnNonAcademicClear.setForeground(Color.WHITE);
        btnNonAcademicClear.setFocusable(false);
        
        //Adding action listener when clear button of nonAcademicCoursePanel is being pressed to clear the textfields
        btnNonAcademicClear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Setting all the text labels to empty string
                txtNonAcademicCourseID.setText("");
                txtNonAcademicCourseName.setText("");
                txtNonAcademicDuration.setText("");
                txtNonAcademicPrerequisite.setText("");
                txtNonAcademicCourseLeader.setText("");
                txtNonAcademicInstructorName.setText("");
                txtNonAcademicStartDate.setText("");
                txtNonAcademicCompletionDate.setText("");
                txtNonAcademicExamDate.setText("");
            }
        });
        
        
        //Adding labels in the nonAcademicCoursePanel
        nonAcademicCoursePanel.add(lblNonAcademicCourse);
        nonAcademicCoursePanel.add(lblNonAcademicCourseID);
        nonAcademicCoursePanel.add(lblNonAcademicCourseName);
        nonAcademicCoursePanel.add(lblNonAcademicDuration);
        nonAcademicCoursePanel.add(lblNonAcademicPrerequisite);
        nonAcademicCoursePanel.add(lblNonAcademicCourseLeader);
        nonAcademicCoursePanel.add(lblNonAcademicInstructorName);
        nonAcademicCoursePanel.add(lblNonAcademicStartDate);
        nonAcademicCoursePanel.add(lblNonAcademicCompletionDate);
        nonAcademicCoursePanel.add(lblNonAcademicExamDate);
        
        //Adding text filed in the nonAcademicPanel
        nonAcademicCoursePanel.add(txtNonAcademicCourseID);
        nonAcademicCoursePanel.add(txtNonAcademicCourseName);
        nonAcademicCoursePanel.add(txtNonAcademicDuration);
        nonAcademicCoursePanel.add(txtNonAcademicPrerequisite);
        nonAcademicCoursePanel.add(txtNonAcademicCourseLeader);
        nonAcademicCoursePanel.add(txtNonAcademicInstructorName);
        nonAcademicCoursePanel.add(txtNonAcademicStartDate);
        nonAcademicCoursePanel.add(txtNonAcademicCompletionDate);
        nonAcademicCoursePanel.add(txtNonAcademicExamDate);
        
        //Adding buttons in the nonAcademicPanel
        nonAcademicCoursePanel.add(btnAddNonAcademicCourse);
        nonAcademicCoursePanel.add(btnRegisterNonAcademicCourse);
        nonAcademicCoursePanel.add(btnRemoveNonAcademicCourse);
        nonAcademicCoursePanel.add(btnNonAcademicDisplay);
        nonAcademicCoursePanel.add(btnNonAcademicClear);
        
        //Adding footer labels in  the frame
        lblFooter1 = new JLabel("Copyright @ 2021 | Contact: info@islington.edu.np");
        lblFooter1.setBounds(398, 650, 510, 35);
        lblFooter1.setForeground(Color.GRAY);
        lblFooter1.setFont(textFont3);
        
        lblFooter2 = new JLabel("Powered by: Venus Chhantel");
        lblFooter2.setBounds(495, 675, 500, 35);
        lblFooter2.setForeground(Color.GRAY);
        lblFooter2.setFont(textFont4);
        
        //Adding components in the frame
        frame.add(courseSelectionPanel); 
        frame.add(academicCoursePanel); 
        frame.add(nonAcademicCoursePanel);
        frame.add(lblFooter1);
        frame.add(lblFooter2);
        
        //Adding menu in the frame
        frame.setJMenuBar(menuBar);
        
        //Making frame visible after all the componenets are added in the frame
        frame.setVisible(true);
    }
    
    
    //Creating a main method
    public static void main(String args[])
    {
        new INGCollege();
    }
    
    //Creating a method to show warning message before exiting the main frame
    public void exitWarning()
    {
        int exitResponse = JOptionPane.showConfirmDialog(frame, "Are you sure to exit?","Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (exitResponse == JOptionPane.YES_OPTION)
        {
            frame.dispose();
        }
    }
}
