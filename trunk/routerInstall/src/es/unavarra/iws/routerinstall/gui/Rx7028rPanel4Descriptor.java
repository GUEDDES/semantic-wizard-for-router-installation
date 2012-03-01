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
public class Rx7028rPanel4Descriptor extends WizardPanelDescriptor implements ActionListener {
    
    public static final String IDENTIFIER = "RX7028R_PANEL_4";
    
    Rx7028rPanel4 panel4;
    
    public Rx7028rPanel4Descriptor() {
        
        panel4 = new Rx7028rPanel4();
        //panel4.addCheckBoxActionListener(this);
        
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(panel4);
        
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return Rx7028rPanel5Descriptor.IDENTIFIER;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return Rx7028rPanel3Descriptor.IDENTIFIER;
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
         if (panel4.isCheckBoxSelected())
            getWizard().setNextFinishButtonEnabled(true);
         else
            getWizard().setNextFinishButtonEnabled(false);           
    }
    */
}
