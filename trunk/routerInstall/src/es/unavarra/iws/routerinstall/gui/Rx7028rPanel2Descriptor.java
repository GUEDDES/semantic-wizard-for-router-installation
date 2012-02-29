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
public class Rx7028rPanel2Descriptor extends WizardPanelDescriptor implements ActionListener {
    
    public static final String IDENTIFIER = "RX7028R_CONNECTOR_CHOOSE_PANEL";
    
    Rx7028rPanel2 panel2;
    
    public Rx7028rPanel2Descriptor() {
        
        panel2 = new Rx7028rPanel2();
        panel2.addCheckBoxActionListener(this);
        
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(panel2);
        
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        //return Rx7028rPanel3Descriptor.IDENTIFIER;
        return "RX7028R_PANEL2";
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return Rx7028rPanel1Descriptor.IDENTIFIER;
    }    
    
    @Override
    public void aboutToDisplayPanel() {
        setNextButtonAccordingToCheckBox();
    }
    
    public void actionPerformed(ActionEvent ae) {
        setNextButtonAccordingToCheckBox();
    }
    
    private void setNextButtonAccordingToCheckBox() {
         if (panel2.isCheckBoxSelected())
            getWizard().setNextFinishButtonEnabled(true);
         else
            getWizard().setNextFinishButtonEnabled(false);           
    }
}
