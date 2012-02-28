package es.unavarra.iws.routerinstall.gui;

import es.unavarra.iws.routerinstall.gui.wiz.Wizard;
import es.unavarra.iws.routerinstall.gui.wiz.WizardPanelDescriptor;

public class TestMain {
    
    public static void main(String[] args) {
        
        Wizard wizard = new Wizard();
        wizard.getDialog().setTitle("Test Wizard Dialog");
        
        WizardPanelDescriptor descriptor1 = new Router1Panel1Descriptor();
        wizard.registerWizardPanel(Router1Panel1Descriptor.IDENTIFIER, descriptor1);

        WizardPanelDescriptor descriptor2 = new Router1Panel2Descriptor();
        wizard.registerWizardPanel(Router1Panel2Descriptor.IDENTIFIER, descriptor2);

        WizardPanelDescriptor descriptor3 = new Router1Panel3Descriptor();
        wizard.registerWizardPanel(Router1Panel3Descriptor.IDENTIFIER, descriptor3);
        
        wizard.setCurrentPanel(Router1Panel1Descriptor.IDENTIFIER);
        
        int ret = wizard.showModalDialog();
        
       /* System.out.println("Dialog return code is (0=Finish,1=Cancel,2=Error): " + ret);
        System.out.println("Second panel selection is: " + 
            (((Router1Panel2)descriptor2.getPanelComponent()).getRadioButtonSelected())); */
        
        System.exit(0);
        
    }
    
}
