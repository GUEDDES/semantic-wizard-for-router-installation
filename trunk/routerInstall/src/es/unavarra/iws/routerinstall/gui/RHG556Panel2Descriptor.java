package es.unavarra.iws.routerinstall.gui;

import es.unavarra.iws.routerinstall.gui.wiz.WizardPanelDescriptor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RHG556Panel2Descriptor extends WizardPanelDescriptor implements ActionListener {
    
    public static final String IDENTIFIER = "RHG556_PANEL_2";
    
    RHG556Panel2 panel2;
    
    public RHG556Panel2Descriptor() {
        
        panel2 = new RHG556Panel2();
        //panel2.addCheckBoxActionListener(this);
        
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(panel2);
        
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return RHG556Panel3Descriptor.IDENTIFIER;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return RHG556Panel1Descriptor.IDENTIFIER;
    }
    
    
    @Override
    public void aboutToDisplayPanel() {
        //setNextButtonAccordingToCheckBox();
    }    

    public void actionPerformed(ActionEvent e) {
        //setNextButtonAccordingToCheckBox();
    }
            
    /*
    private void setNextButtonAccordingToCheckBox() {
         if (panel2.isCheckBoxSelected())
            getWizard().setNextFinishButtonEnabled(true);
         else
            getWizard().setNextFinishButtonEnabled(false);           
    
    }
     * */
}
