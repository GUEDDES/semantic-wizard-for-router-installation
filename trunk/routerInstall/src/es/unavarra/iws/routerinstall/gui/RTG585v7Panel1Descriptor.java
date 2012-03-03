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
public class RTG585v7Panel1Descriptor extends WizardPanelDescriptor {
    
    public static final String IDENTIFIER = "TG585V7_START";
    QueryManager qm;
    String nextStep;
    
    public RTG585v7Panel1Descriptor(String primerPaso, QueryManager qm) {
        super(IDENTIFIER, new RTG585v7Panel1(primerPaso));
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
