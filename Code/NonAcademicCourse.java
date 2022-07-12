/**
 * Name : Venus Chhantel
 * Group : N3
 * ID : 20049257 
**/

//Creating NonAcademicCourse class which is a subclass of the Course class
public class NonAcademicCourse extends Course
{
    //Declaring instance variables
    private String instructorName;
    private String startingDate;
    private String completionDate;
    private String examDate;
    private String prerequisite;
    private boolean isRegistered;
    private boolean isRemoved;
    
    //Initializing constructor
    public NonAcademicCourse(String courseID, String courseName, int duration, String prerequisite)
    {
        super(courseID, courseName, duration); //Using super keyword to refer the Course parent class instance variables
        this.prerequisite = prerequisite;
        this.startingDate = "";
        this.completionDate = "";
        this.examDate = "";
        this.instructorName = "";
        this.isRegistered = false;
        this.isRemoved = false;
    }
    
    //Accesssor methods
    //Declaring get method for instructorName
    public String getInstructorName()
    {
        return this.instructorName; 
    }
 
    //Declaring get method for startDate
    public String getStartingDate()
    {
        return this.startingDate; 
    }
    
    //Declaring get method for completionDate
     public String getCompletionDate()
    {
        return this.completionDate; 
    }
    
    //Declaring get method for examDate
     public String getExamDate()
    {
        return this.examDate;
    }
    
    //Declaring get method for prerequisite
    public String getPrerequisite()
    {
        return this.prerequisite; 
    }
    
    //Declaring get method for isRegistered
     public boolean getIsRegistered()
    {
        return this.isRegistered; 
    }
    
    //Declaring get method for isRemoved
     public boolean getIsRemoved()
    {
        return this.isRemoved; 
    }
    
    //Mutator method 
    //Defining set method for instructorName if not already registered
    public void setInstructorName(String instructorName)
    {
        if(this.isRegistered == true) {
            System.out.println("This course is already registered. So, the instructor name cannot be updated.");
        }
        else {
            this.instructorName = instructorName;
        }
    }
    
    //Defining register method for NonAcademicCourse
    public void registerNonAcademicCourse(String courseLeader, String instructorName, String startingDate, String completionDate, String examDate)
    {
        if(this.isRegistered == true) {
            System.out.println("This non-academic course is already registered.");
            System.out.println("The lecturer of this non-academic course is " + instructorName + ".");
            System.out.println("This non-academic course will start from " + startingDate + ".");
            System.out.println("This non-academic course will be completed by " + completionDate + ".");
            System.out.println("The exam of this non-academic course will be on "+ examDate + ".");
        }
        else {
            super.setCourseLeader(courseLeader); //Using super keyword to invoke the setCourseLeader method from Course parent class
            setInstructorName(instructorName);
            this.startingDate = startingDate;
            this.completionDate = completionDate;
            this.examDate = examDate;
            this.isRegistered = true;  
        }
    }
    
    //Defining remove method for NonAcademicCourse
    public void remove()
    {
        if(this.isRemoved == true) {
            System.out.println("This course has been already removed.");
        }
        else {
            super.setCourseLeader(""); //Using super keyword to invoke the setCourseLeader method from Course parent class
            instructorName = "";
            startingDate = ""; 
            completionDate = "";
            examDate = "";
            this.isRegistered = false;
            this.isRemoved = true;
        }
    }
    
    //Defining display method to display NonAcademicCourse
    public void display()
    {
        super.display(); //Using super keyword to invoke display method from Course parent class
        
        if(this.isRegistered == true) {
            System.out.println("The instructor of this non-academic course is " + instructorName + ".");
            System.out.println("This non-academic course will start on " + startingDate + ".");
            System.out.println("This non-academic course will be completed by " + completionDate + ".");
            System.out.println("The exam of this non-academic course is on " + examDate + ".");
        }
        
    }
}
