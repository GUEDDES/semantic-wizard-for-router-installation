/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

import es.unavarra.iws.routerinstall.gui.wiz.WizardPanelDescriptor;
import es.unavarra.iws.routerinstall.engine.*;

/**
 *
 * @author aqm
 */
public class ConceptoInstalacionDescriptor extends WizardPanelDescriptor {
    
    String IDENTIFIER;
    QueryManager qm;
    ConceptoInstalacion panel;
    String prevStep;
    String nextStep;
    
    public ConceptoInstalacionDescriptor(QueryManager qm, String step, String prevStep) {
        this.qm = qm;
        InstallationError err = qm.getError();
        
        if (step == "START"){
            IDENTIFIER = qm.getCurrentStepName();
            this.prevStep = "START";
            this.nextStep = err.getErrorID();
        }else if (step == "FINISH"){
            IDENTIFIER = err.getErrorID();
            this.prevStep = prevStep;
            this.nextStep = "FINISH";
        }
        
        if (nextStep == "FINISH"){
            panel = new ConceptoInstalacion(err.getTitle(), err.getProblemDescription()+"\n"+err.getProblemSolution());
        }else{
            panel = new ConceptoInstalacion(qm.getCurrentStepTitle(), qm.getCurrentStepDescription());
        }
        
        System.out.println(prevStep);
        System.out.println(nextStep);
        System.out.println(err.getTitle());
        System.out.println("############");
        
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(panel);
    }
    
    public String getIdentifier(){
        return IDENTIFIER;
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        if (nextStep == "FINISH"){
            return null;
            
        }else{
            return nextStep;
        }
        
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        if (prevStep == "START"){
            return null;
        }else{
            return prevStep;
        }
        
    }  

    
}
