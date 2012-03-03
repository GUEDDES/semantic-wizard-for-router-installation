/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

import es.unavarra.iws.routerinstall.gui.wiz.WizardPanelDescriptor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import es.unavarra.iws.routerinstall.engine.*;

/**
 *
 * @author aqm
 */
public class UltimoPasoDescriptor extends WizardPanelDescriptor implements ActionListener {
    
    String IDENTIFIER;
    QueryManager qm;
    UltimoPaso panel;
    String prevStep;
    
    public UltimoPasoDescriptor(QueryManager qm, String prevStep, String ultimo, String router) {
        IDENTIFIER = ultimo;
        panel = new UltimoPaso(qm, router);
        this.prevStep = prevStep;
        
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(panel);
        System.out.println(prevStep);
        System.out.println(IDENTIFIER);
        System.out.println("############");
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return FINISH;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return prevStep;
    }    
    
    @Override
    public void aboutToDisplayPanel() {
        //setNextButtonAccordingToCheckBox();
    }
    
    public void actionPerformed(ActionEvent ae) {
        //setNextButtonAccordingToCheckBox();
    }
    /*
    private void setNextButtonAccordingToCheckBox() {
         if (panel6.isCheckBoxSelected())
            getWizard().setNextFinishButtonEnabled(true);
         else
            getWizard().setNextFinishButtonEnabled(false);           
    }
    */
}
