/**
 * Name : Venus Chhantel
 * Group : N3
 * ID : 20049257 
**/

//Creating AcademicCourse class which is a subclass of the Course class
public class AcademicCourse extends Course
{
    //Declaring instance variables
    private String lecturerName;
    private String level;
    private String credit;
    private String startingDate;
    private String completionDate;
    private int numberOfAssessments;
    private boolean isRegistered;
    
    //Initializing constructor
    public AcademicCourse(String courseID, String courseName, int duration, String level, String credit, int numberOfAssessments)
    {
        super(courseID, courseName, duration); //Using super keyword to refer the Course parent class instance variables
        this.level = level;
        this.credit = credit;
        this.numberOfAssessments = numberOfAssessments;
        this.lecturerName = "";
        this.startingDate = "";
        this.completionDate = "";
        this.isRegistered = false;
    }
    
    //Accessor methods
    //Defining get method for lecturerName
    public String getLecturerName()
    {
        return this.lecturerName; 
    }
    
    //Defining get method for level
    public String getLevel()
    {
        return this.level; //Defining get method
    }
    
    //Defining get method for credit
    public String getCredit()
    {
        return this.credit;
    }
    
    //Defining get method for startingDate
    public String getStartingDate()
    {
        return this.startingDate;
    }
    
    //Defining get method for completionDate
    public String getCompletionDate()
    {
        return this.completionDate; 
    }
    
    //Defining get method for numberOfAssessments
    public int getNumberOfAssessments()
    {
        return this.numberOfAssessments;
    }
    
    //Defining get method for isRegistered
    public boolean getIsRegistered()
    {
        return this.isRegistered; 
    }
    
    //Mutator method
    //Defining set method for lecturerName
    public void setLecturerName(String lecturerName)
    {
        this.lecturerName = lecturerName; 
    }
    
    //Defining set method for numberOfAssessments
    public void setNumberOfAssessments(int numberOfAssessments)
    {
        this.numberOfAssessments = numberOfAssessments;
    }
    
    //Defining register method to register particular academicCourse if not registered
    public void registerAcademicCourse(String courseLeader, String lecturerName, String startingDate, String completionDate)
    {
        if(this.isRegistered == true) {
            System.out.println("This academic course is already registered.");
            System.out.println("The lecturer of this academic course is " + lecturerName + ".");
            System.out.println("This academic course will start from " + startingDate + ".");
            System.out.println("This academic course will be completed by " + completionDate + ".");
        }
        else {
            super.setCourseLeader(courseLeader); //Using super keyword to invoke the setCourseLeader method from Course parent class
            this.lecturerName = lecturerName;
            this.startingDate = startingDate;
            this.completionDate = completionDate; 
            this.isRegistered = true;
        }
    }
    
    //Defining display method to display AcademicCourse detail if registered
    public void display()
    {
        super.display(); //Using super keyword to invoke display method from Course parent class 
        
        if(this.isRegistered == true) {
            System.out.println("The lecturer of this academic course is " + lecturerName + ".");
            System.out.println("The level for this academic course is " + level + ".");
            System.out.println("The total credit hours for this academic course is " + credit + " credit hours.");
            System.out.println("This academic course will start from " + startingDate + ".");
            System.out.println("This academic course will be completed by " + completionDate + ".");
            System.out.println("There are total " + numberOfAssessments + " assessments in this academic course.");
        }
    }
}
