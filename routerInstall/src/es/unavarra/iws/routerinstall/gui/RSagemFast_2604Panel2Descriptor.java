package es.unavarra.iws.routerinstall.gui;

import es.unavarra.iws.routerinstall.gui.wiz.WizardPanelDescriptor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RSagemFast_2604Panel2Descriptor extends WizardPanelDescriptor implements ActionListener {
    
    public static final String IDENTIFIER = "RSAGEMFAST_2604_PANEL_2";
    
    RSagemFast_2604Panel2 panel2;
    
    public RSagemFast_2604Panel2Descriptor() {
        
        panel2 = new RSagemFast_2604Panel2();
        //panel2.addCheckBoxActionListener(this);
        
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(panel2);
        
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return RSagemFast_2604Panel3Descriptor.IDENTIFIER;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return RSagemFast_2604Panel1Descriptor.IDENTIFIER;
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
