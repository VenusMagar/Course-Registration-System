/**
 * Name : Venus Chhantel
 * Group : N3
 * ID : 20049257 
**/

//Creating course class which is the parent class 
public class Course 
{
    //Declaring instance variables
    private String courseID;
    private String courseName;
    private String courseLeader;
    private int duration;
    
    //Initializing constructor
    public Course(String courseID, String courseName, int duration)
    {
        this.courseID = courseID; 
        this.courseName = courseName;
        this.duration = duration;
        this.courseLeader = "";   
    }
    
    //Accessors methods
    //Defining get method for courseID
    public String getCourseID()
    {
        return this.courseID; 
    }
    
    //Defining get method for courseName
    public String getCourseName()
    {
        return this.courseName; 
    }
    
    //Defining get method for courseLeader
    public String getCourseLeader()
    {
        return this.courseLeader; 
    }
    
    //Defining get method for duration
    public int getDuration()
    {
        return this.duration; 
    }
    
    //Mutator method
    //Defining set method for courseLeader
    public void setCourseLeader(String courseLeader)
    {
        this.courseLeader = courseLeader; 
    }
    
    //Defining display method to display details of the course
    public void display()
    {
        System.out.println("The CourseID is " + courseID + ".");
        System.out.println("The name of this course is " + courseName + ".");
        
        //Displaying courseleader if it is not an empty string  
        if(courseLeader != "") {
            System.out.println("The course leader of this course is " + courseLeader + ".");
        }
        
        System.out.println("The duration of this course is " + duration + " years.");
    }
}
