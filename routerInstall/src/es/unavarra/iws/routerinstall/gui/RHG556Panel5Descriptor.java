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
public class RHG556Panel5Descriptor extends WizardPanelDescriptor implements ActionListener {
    
    public static final String IDENTIFIER = "RHG556_PANEL_5";
    
    RHG556Panel5 panel5;
    
    public RHG556Panel5Descriptor() {
        
        panel5 = new RHG556Panel5();
        //panel5.addCheckBoxActionListener(this);
        
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(panel5);
        
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return RHG556Panel6Descriptor.IDENTIFIER;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return RHG556Panel4Descriptor.IDENTIFIER;
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
