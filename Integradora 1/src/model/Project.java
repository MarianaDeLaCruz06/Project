package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//import model.Manager;


public class Project {

    private String nameproject;
    private String clientName;
    private Calendar startDate;
    private Calendar endDate;
    private double budget;
    private String managerName;
    private String managerPhone;
    

    private DateFormat formatter;

    /**
    * Constructs a new Project object.
    * @param nameproject the name of the project
    * @param clientName the name of the client
    * @param startDate the start date of the project
    * @param endDate the end date of the project
    * @param budget the budget of the project
    * @param managerName the name of the project manager
    * @param managerPhone the phone number of the project manager
    */
    public Project(String nameproject, String clientName, Calendar startDate, Calendar endDate, 
                   double budget, String managerName, String managerPhone) {
        

        this.formatter = new SimpleDateFormat("dd/M/yy");

        this.nameproject = nameproject;
        this.clientName = clientName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.managerName = managerName;
        this.managerPhone = managerPhone;

    }

    // Getters and Setters
    public String getName() {
        return nameproject;
    }

    public void setName(String nameproject) {
        this.nameproject = nameproject;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getStartDateFormated() {
        return formatter.format(this.startDate.getTime());
    }

    public Calendar getStartDate(){
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public String getEndDateFormated() {
        return formatter.format(this.endDate.getTime());
    }

    public Calendar getEndDate(){
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getManagerName(){
        return managerName;
    }

    public String getManagerNumber(){
        return managerPhone;
    }

    public String getProjectInfo() {
		String msg = "";
        
        msg = "\nName: " + nameproject + "\nClient: " + clientName + "\nInitial Date: " + getStartDateFormated() + 
		"\nFinal Date: " + getEndDateFormated() + "\nTotalBudget: " + budget + ".\n";

        return msg;
	}


}
