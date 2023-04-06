package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

    private Capsule[] capsules;
	private Project[] project;
	private Stage[] stages;

	/**
	* Constructor that initializes the capsules, projects, and stages arrays with default values.
	*/
    public Controller() {
        capsules = new Capsule[50];
        testCases();
		project = new Project[10];
		stages = new Stage[6];
	}

	/**
	* Method that registers a new project with the given parameters.
	* @param nameProject the name of the project
	* @param nameClient the name of the client
	* @param dateS the start day of the project
	* @param monthS the start month of the project
	* @param yearS the start year of the project
	* @param dateE the end day of the project
	* @param monthE the end month of the project
	* @param yearE the end year of the project
	* @param budget the budget of the project
	* @param managerName the name of the project manager
	* @param managerPhone the phone number of the project manager
	* @return true if the project is successfully registered, false otherwise
	*/
	public boolean registerProject(String nameProject, String nameClient, int dateS, int monthS, int yearS, int dateE, int monthE, int yearE, Double budget, String managerName, String managerPhone){
        
        
        Calendar initialDate = new GregorianCalendar(yearS, monthS, dateS);
        Calendar finalDate = new GregorianCalendar(yearE, monthE, dateE);

        Project newProject = new Project(nameProject, nameClient, initialDate, finalDate, budget, managerName, managerPhone);

		Calendar startDatePlanned = new GregorianCalendar(0000, (1), 00);
        Calendar endDatePlanned = new GregorianCalendar(0000, (1), 00);      
        Calendar startDateReal = new GregorianCalendar(0000, (1), 00);
        Calendar endDateReal = new GregorianCalendar(0000, (1), 00);

		createStage(Stages.INITIATION, startDatePlanned, endDatePlanned, startDateReal, endDateReal, StatusStage.TO_DEFINE);


        for(int i=0; i < project.length; i++){

			if(project[i] == null){

				project[i] = newProject;
				return true;
			}
		}
        
        
        return false;

    }

	public String showProjects(){
        String msg="";
        for (int i=0; i<project.length;i++){
            if(project[i] == null){
				return msg;
			} else {
				msg +="\n"+(i+1)+". "+ project[i].getProjectInfo();
			}
		} 
        
        return msg;
    }

    public void testCases() {
		
		capsules[0] = new Capsule("A001", "Gestion de repositorios", Type.TECHNICAL, "GitHub es una herramienta util");
		capsules[1] = new Capsule("A002", "Gestion de equipos", Type.EXPERIENCES, "Es importante definir responsabilidades claras");
		
	}

	public boolean createStage(Stages TypeStage, Calendar startDatePlanned, Calendar endDatePlanned, Calendar startDateReal, Calendar endDateReal, StatusStage StatusStage){

        Stage newStage = new Stage(TypeStage, startDatePlanned, endDatePlanned, startDateReal, endDateReal, StatusStage);

        for(int i=0; i <stages.length; i++){

			if(stages[i] == null){

				stages[i] = newStage;
				return true;
			}
		}
        
        return false;

    }

	public boolean editStage(int stageOption, int dateSP, int monthSP, int yearSP, int dateSR, int monthSR, int yearSR){
        boolean ind = false;

		if(ind==false){
			Calendar date = new GregorianCalendar(yearSP, monthSP, dateSP);
			Calendar date1 = new GregorianCalendar(yearSR, monthSR, dateSR);
			stages[stageOption].setStartDatePlanned(date);
			stages[stageOption].setStartDateReal(date1);

			ind = true;
		}
        
        return ind;

    }

	public boolean nextStage(int cont, int stageOption) {

		Calendar date = new GregorianCalendar(00, 01, 00);
	
		stages[stageOption].setStatusStage(StatusStage.TO_DEFINE);
		stages[stageOption].setStartDatePlanned(date);
		stages[stageOption].setEndDatePlanned(date);
		stages[stageOption].setStartDateReal(date);
		stages[stageOption].setEndDateReal(date);
	
		Stages[] stagesArray = {Stages.INITIATION, Stages.ANALYSIS, Stages.DESIGN, Stages.EXECUTION, Stages.CLOSING, Stages.DESIGN, Stages.CONTROL};
		Stages selectedStage = stagesArray[stageOption];
	
		switch (cont) {
			case 2:
				stages[stageOption].setTypeStage(selectedStage);
				return true;
			case 3:
				stages[stageOption].setTypeStage(selectedStage);
				return true;
			default:
				if (selectedStage != null) {
					stages[stageOption].setTypeStage(selectedStage);
					return true;
				}
		}
	
		return false;
	}

	public boolean CulminateStage(int stageOption, int dateSR, int monthSR, int yearSR, int dateER, int monthER, int yearER, int statusN){
        boolean indic = false;
        
        Calendar newDateStartReal=new GregorianCalendar(yearSR, monthSR ,dateSR);
        Calendar newDateEndReal=new GregorianCalendar(yearER, monthER, yearER);

        if (statusN == 1){
            stages[stageOption].setStartDateReal(newDateStartReal);
            stages[stageOption].setEndDateReal(newDateEndReal);
            stages[stageOption].setStatusStage(StatusStage.APPROVED);
            indic = true;
        } else if(statusN == 2){
            stages[stageOption].setStartDateReal(newDateStartReal);
            stages[stageOption].setEndDateReal(newDateEndReal); 
            stages[stageOption].setStatusStage(StatusStage.NOT_APPROVED);
            indic = true;
        }

        return indic;
    }

	public String showStages(int stageOption, int num){
        String msg="";
    
       if (num==1){
        	msg=stages[stageOption].toStringStageReal();
       }else{
        	msg =stages[stageOption].toStringStage();
       }
        return msg;
    }

	/**
	* Method that registers a new capsule with the given parameters.
	* @param id the id of the capsule
	* @param description the description of the capsule
	* @param type the type of the capsule (Technical or Experiences)
	* @param lessonLearned the lesson learned from the capsule
	* @return true if the capsule is successfully registered, false otherwise
	*/
    public boolean registerCapsule(String id, String description, String type, String lessonLearned) {
        
		Type typeN = Type.TECHNICAL;
		if(type.equalsIgnoreCase("Technical")){
			typeN = Type.EXPERIENCES;
		}
		
		Capsule newCapsule = new Capsule(id, description, typeN, lessonLearned);

        for(int i = 0; i<capsules.length; i++){

			if(capsules[i] == null){
				capsules[i] = newCapsule;
				return true;
			}

		}

        return false;

    }


	/**
	 * Aprobar una cápsula existente.
	 * @param id The id of the capsule to be updated.
	 * @param status The new status to be set for the capsule (either "approved" or "not approved").
	 * @return True if the capsule was found and the status was updated successfully, false otherwise.
	 */
	public boolean approveCapsule(String id, String status) {
		id = "";

		Status statusN = Status.NOT_APPROVED;
		if(status.equalsIgnoreCase("APPROVED")){
			statusN = Status.APPROVED;
		}

		for(int i = 0; i<capsules.length; i++){
			if(capsules[i]!=null){
				id = capsules[i].getId();
				if(id.equals(id)){
					capsules[i].setStatus(statusN);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns a string with a list of all the capsule IDs in the system.
	 * @return A string with the list of capsule IDs.
	 */
    public String searchCapsule(){

		String msg = "";

		for(int i = 0; i < capsules.length; i++ ){

			if(capsules[i]!=null){
                msg += "\n"+ (i+1) + ". " + capsules[i].getId();
            }
		}

		return msg;
	}

	/**
	 * Returns a string with a list of all the capsules in the system, including their properties.
	 * @return A string with the list of capsules and their properties.
	 */
    public String getCapsule() {

		String msg = "";
		for(int i = 0; i<capsules.length; i++){
			if(capsules[i]!=null){
				msg += "\n" + capsules[i].toString();
			}
		}

		return msg;

	}
  
}
