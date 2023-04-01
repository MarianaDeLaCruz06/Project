package ui;

import java.util.Calendar;
import java.util.Scanner;
import java.sql.Date;
import java.text.ParseException;

import model.Controller;


public class Main{

	private Scanner reader;
	private Controller controller;

	public Main() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) throws ParseException {

		Main exe = new Main();
		exe.menu();

	}

	// Incomplete
	public void menu() throws ParseException {
		int option = 0;
		int decition = 1;

        while (option != 3) {
            System.out.println("GreenSQA");
            System.out.println("1. Register new project");
            System.out.println("2. Search projects after or before a specific date");
            System.out.println("3. Exit");
            System.out.print("Select option: ");

            option = reader.nextInt();

            switch (option) {
                case 1:
                    RegisterProject();
                    break;
                case 2:
					System.out.println("Digite la opcion segun lo que desea consultar");
					System.out.println("1. Consultar proyectos que finalizan despues de una fecha");
					System.out.println("2. Consultar proyectos que inician antes de una fecha");
					decition = reader.nextInt();

					if (decition == 1){

						searchProjectsAfterDate();

					}else{

						searchProjectsBeforeDate();

					}
				break;
            
                case 3:
                    System.out.println("¡Good Bye!");
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }
	

	//Incomplete
	public void RegisterProject() {


		System.out.println("Register Proyect");

		System.out.print("Enter project name: ");
    	String name = reader.next();

    	System.out.print("Enter client name: ");
    	String clientName = reader.next();

		System.out.print("Type of proyect ");
        System.out.print("1. Desarrollo ");
		System.out.print("2. Mantenimiento");
		System.out.print("3. Despliegue ");
		int typeProject = reader.nextInt();


   		System.out.print("Enter initial date (yyyy-mm-dd): ");
		System.out.println("Day in numbers:");
		int dayI = reader.nextInt();
		System.out.println("Month in numbers:");
		int monthI = reader.nextInt();
		System.out.println("Years in numbers:");
		int yearI = reader.nextInt();

    	System.out.print("Enter final date (yyyy-mm-dd): ");
		System.out.println("Day in numbers:");
		int dayF = reader.nextInt();
		System.out.println("Month in numbers:");
		int monthF = reader.nextInt();
		System.out.println("Years in numbers:");
		int yearF = reader.nextInt();

    	System.out.print("Enter project budget: ");
    	double budget = reader.nextDouble();



		if (controller.RegisterProject(name, clientName, dayI, monthI, yearI, dayF, monthF, yearF, budget, typeProject)){
			System.out.println("The project has been registered");
		}

		else{
			System.out.println("The project has not been registered");
		}

	}

	//Incomplete
	public void searchProjectsAfterDate() throws ParseException {

		System.out.println("Enter date:");
		System.out.println("Day");
		int dia = reader.nextInt();
		System.out.println("Month");
		int mes = reader.nextInt();
		System.out.println("year");
		int año = reader.nextInt();

		System.out.println("Los sistemas encontrados antes de esa fecha son:");
		System.out.println(controller.searchProjectsAfterDate(dia, mes, año));
	}
	//Incomplete
	public void searchProjectsBeforeDate() throws ParseException {

		System.out.println("Digite la fecha de los proyectos que se terminan antes de la misma");
		System.out.println("Day");
		int diaA = reader.nextInt();
		System.out.println("Month");
		int mesS = reader.nextInt();
		System.out.println("Year");
		int añoO = reader.nextInt();

		controller.searchProjectsBeforeDate(diaA, mesS, añoO);

	}

		
}
