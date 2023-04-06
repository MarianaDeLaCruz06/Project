package model;

import java.util.Calendar;
import java.util.GregorianCalendar;


import java.text.ParseException;

public class Controller {

	private Project[] projects;

	public Controller() {

		projects = new Project[10];
	
	}


	
	public boolean registerProject(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget, int dayI, int monthI, int yearI, int dayF, int monthF, int yearF, int type){
		
		boolean completeRegister = false;

        int pos = getFirstValidPosition();

		TypeProject typeProject = TypeProject.POR_DEFINIR;

        if(pos != -1){

			if (type == 1){
            	typeProject = TypeProject.DEVELOP;
        	}
       		else if(type == 2) {
            	typeProject = TypeProject.MAINTENANCE;
        	}
        	else{
            typeProject = TypeProject.DEPLOYMENT;
        }

            projects[pos] = new Project(name, clientName, initialDate, finalDate, budget, typeProject);

			completeRegister = true;
        }

		Calendar fechaInicial = new GregorianCalendar(dayI, monthI, yearI);
		Calendar fechaFinal = new GregorianCalendar(dayF, monthF, yearF);
		
		return completeRegister;

	}
	
	public int getFirstValidPosition(){
        int pos = -1;
        boolean isFound = false;
        for(int i=0; i<projects.length && !isFound; i++){
            if(projects[i]==null){
                pos = i;
                isFound = true;
            }
        }
    
        return pos;
    }

	public String searchProjectsAfterDate(int dia, int mes, int año) throws ParseException {

		Calendar fechaBusquedaA = new GregorianCalendar(dia, mes, año);
		String msg = "";

		for(int i = 0; i<projects.length; i++){

			if(projects[i] == null){

				return msg;
			}else{

				int valor = fechaBusquedaA.compareTo(projects[i].getFinalDate());
				if (valor == 1){
					msg += projects[i].getProjectInfo();
				}
			}

		}

		return msg;

	}
 
	public String searchProjectsBeforeDate(int diaA, int mesS, int añoO) throws ParseException {
		
		Calendar fechaBusquedaB = new GregorianCalendar(diaA, mesS, añoO);
		String msg = "";

		for(int i = 0; i<projects.length; i++){

			if(projects[i] == null){

				return msg;
			}else{

				int valor = fechaBusquedaB.compareTo(projects[i].getFinalDate());
				if (valor == 1){
					msg += projects[i].getProjectInfo();
				}
			}

		}

		return msg;

	}
	
	public boolean RegisterProject(String nameProject, String clientName, int dayI, int monthI, double yearI, int dayF,
			int month, double yearF, double budget, int typeProject) {
		return false;
	}

 
}