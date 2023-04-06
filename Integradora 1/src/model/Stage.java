package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Stage {

    
    private Stages TypeStage;
    private Calendar startDatePlanned;
    private Calendar endDatePlanned;
    private Calendar startDateReal;
    private Calendar endDateReal;
    private StatusStage StatusStage;

    private DateFormat formatter;
    
    public Stage(Stages TypeStage, Calendar startDatePlanned, Calendar endDatePlanned, Calendar startDateReal, Calendar endDateReal, StatusStage StatusStage) {
        
        this.formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        this.TypeStage = TypeStage;
        this.startDatePlanned = startDatePlanned;
        this.endDatePlanned = endDatePlanned;
        this.startDateReal = startDateReal;
        this.endDateReal = endDateReal;
        this.StatusStage = StatusStage;

    }
    
    // getters and setters

    public Stages getTypeStage() {
        return TypeStage;
    }

    public void setTypeStage(Stages TypeStage) {
        this.TypeStage = TypeStage;
    }

    public Calendar getStartDatePlanned() {
        return getStartDatePlanned();
    }

    public String getStartDateFormated(){
        return formatter.format(this.startDatePlanned.getTime());
    }

    public void setStartDatePlanned(Calendar startDatePlanned) {
        this.startDatePlanned = startDatePlanned;
    }

    public Calendar getEndDatePlanned() {
        return getEndDatePlanned();
    }

    public String getEndDateFormated(){
        return formatter.format(this.endDatePlanned.getTime());
    }
    
    public void setEndDatePlanned(Calendar endDatePlanned) {
        this.endDatePlanned = endDatePlanned;
    }

    public Calendar getStartDateReal() {
        return getStartDateReal();
    }

    public String getStartDateRealFormated(){
        return formatter.format(this.startDateReal.getTime());
    }

    public void setStartDateReal(Calendar startDateReal) {
        this.startDateReal = startDateReal;
    }

    public Calendar getEndDateReal() {
        return getEndDateReal();
    }

    public String getEndDateRealFormated(){
        return formatter.format(this.endDateReal.getTime());
    }
    
    public void setEndDateReal(Calendar endDateReal) {
        this.endDateReal = endDateReal;
    }

    public StatusStage getStatusStage(){
        return StatusStage;
    }

    public void setStatusStage(StatusStage StatusStage){
        this.StatusStage=StatusStage;
    } 

    public String toStringStage(){
        String msg = "";

        msg = "\n Stage" + TypeStage + "\n Date Start Planned" + getStartDateFormated() + "\n Date End Planned" + getEndDateFormated() + "\n Status of stage" + StatusStage;
    
        return msg;
    }
 
    public String toStringStageReal(){
		String msg = "";

		msg = "\n Stage: " + TypeStage +"\n  Date Start Planned" + getStartDateFormated() +"\n Date End Planned" + getEndDateFormated() +"\n Date Start Real: " + getStartDateFormated() + "\nFecha real fin: "+ getEndDateFormated() + "\n Status of the state: " + StatusStage;
		
        return msg;
	}
    
       
}
