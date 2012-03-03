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
public class InstalacionGeneralDescriptor extends WizardPanelDescriptor {
    
    String IDENTIFIER;
    QueryManager qm;
    InstalacionGeneral panel;
    String prevStep;
    String nextStep;
    
    public InstalacionGeneralDescriptor(QueryManager qm, String prevStep) {
        this.qm = qm;
        IDENTIFIER = qm.getCurrentStepName();
        //panel = new InstalacionGeneral(qm.getCurrentStepName(), qm.getCurrentStepDescription());
        InstallationError err = qm.getError();
        panel = new InstalacionGeneral(qm.getCurrentStepTitle(), qm.getCurrentStepDescription(), err.getTitle(), err.getProblemDescription()+err.getProblemSolution());
        this.prevStep = prevStep;
        nextStep = qm.getNextStepOK();
        
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
        return prevStep;
    }  

    
}
