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
public class Rct351Panel1Descriptor extends WizardPanelDescriptor {
    
    public static final String IDENTIFIER = "CT-351_START";
    QueryManager qm;
    String nextStep;
    
    public Rct351Panel1Descriptor(String primerPaso, QueryManager qm) {
        super(IDENTIFIER, new Rct351Panel1(qm.getCurrentStepTitle()));
        this.qm = qm;
        this.nextStep = qm.getNextStepOK();
        
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return nextStep;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return null;
    }  

    
}
