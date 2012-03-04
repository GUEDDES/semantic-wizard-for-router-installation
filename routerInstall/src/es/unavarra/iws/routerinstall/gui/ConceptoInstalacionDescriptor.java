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
        IDENTIFIER = qm.getCurrentStepName();
        
        if (step == "START"){
            this.prevStep = "START";
            this.nextStep = "ERROR"+prevStep;
        }else if (step == "FINISH"){
            this.prevStep = prevStep;
            this.nextStep = "FINISH";
        }
        
        if (nextStep == "FINISH"){
            panel = new ConceptoInstalacion(qm.getComment("ERROR"+prevStep));
        }else{
            panel = new ConceptoInstalacion(qm.getCurrentStepDescription());
        }
        
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(panel);
    }
    
    public String getIdentifier(){
        return IDENTIFIER;
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return nextStep;
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
