/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

import es.unavarra.iws.routerinstall.gui.wiz.WizardPanelDescriptor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author aqm
 */
public class Rx7028rPanel6Descriptor extends WizardPanelDescriptor implements ActionListener {
    
    public static final String IDENTIFIER = "RX7028R_PANEL_6";
    
    Rx7028rPanel6 panel6;
    
    public Rx7028rPanel6Descriptor() {
        
        panel6 = new Rx7028rPanel6();
        //panel5.addCheckBoxActionListener(this);
        
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(panel6);
        
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return Rx7028rPanel7Descriptor.IDENTIFIER;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return Rx7028rPanel5Descriptor.IDENTIFIER;
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
         if (panel5.isCheckBoxSelected())
            getWizard().setNextFinishButtonEnabled(true);
         else
            getWizard().setNextFinishButtonEnabled(false);           
    }*/
    
}
