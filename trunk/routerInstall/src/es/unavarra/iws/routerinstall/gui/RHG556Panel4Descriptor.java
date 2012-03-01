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
public class RHG556Panel4Descriptor extends WizardPanelDescriptor implements ActionListener {
    
    public static final String IDENTIFIER = "RHG556_PANEL_4";
    
    RHG556Panel4 panel4;
    
    public RHG556Panel4Descriptor() {
        
        panel4 = new RHG556Panel4();
        //panel4.addCheckBoxActionListener(this);
        
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(panel4);
        
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return RHG556Panel5Descriptor.IDENTIFIER;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return RHG556Panel3Descriptor.IDENTIFIER;
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
