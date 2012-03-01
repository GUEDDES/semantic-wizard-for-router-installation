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
public class RSagemFast_2604Panel7Descriptor extends WizardPanelDescriptor implements ActionListener {
    
    public static final String IDENTIFIER = "RSAGEMFAST_2604_PANEL_7";
    
    RSagemFast_2604Panel7 panel7;
    
    public RSagemFast_2604Panel7Descriptor() {
        
        panel7 = new RSagemFast_2604Panel7();
        //panel5.addCheckBoxActionListener(this);
        
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(panel7);
        
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return RSagemFast_2604Panel8Descriptor.IDENTIFIER;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return RSagemFast_2604Panel6Descriptor.IDENTIFIER;
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
