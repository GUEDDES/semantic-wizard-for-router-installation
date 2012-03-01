package es.unavarra.iws.routerinstall.gui;

import es.unavarra.iws.routerinstall.gui.wiz.WizardPanelDescriptor;


public class Router1Panel3Descriptor extends WizardPanelDescriptor {
    
    public static final String IDENTIFIER = "RCT5071_PANEL_3";
    
    Router1Panel3 panel3;
    
    public Router1Panel3Descriptor() {
        
        panel3 = new Router1Panel3();
        setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(panel3);
        
    }

    public Object getNextPanelDescriptor() {
        return FINISH;
    }
    
    public Object getBackPanelDescriptor() {
        return Router1Panel2Descriptor.IDENTIFIER;
    }
    
    
    public void aboutToDisplayPanel() {
        
       /* panel3.setProgressValue(0);
        panel3.setProgressText("Conexión con el servidor ...");

        getWizard().setNextFinishButtonEnabled(false);
        getWizard().setBackButtonEnabled(false);
        * 
        */
        
    }
    
    public void displayingPanel() {

            /*Thread t = new Thread() {

            public void run() {

                try {
                    Thread.sleep(1000);
                    panel3.setProgressValue(25);
                    panel3.setProgressText("Establecida conexión con el servidor");
                    Thread.sleep(400);
                    panel3.setProgressValue(50);
                    panel3.setProgressText("Transmisión de datos ...");
                    Thread.sleep(1000);
                    panel3.setProgressValue(75);
                    panel3.setProgressText("Recepción de acuse de recibo ...");
                    Thread.sleep(600);
                    panel3.setProgressValue(100);
                    panel3.setProgressText("Los datos transmitidos satisfactoriamente");

                    getWizard().setNextFinishButtonEnabled(true);
                    getWizard().setBackButtonEnabled(true);

                } catch (InterruptedException e) {
                    
                    panel3.setProgressValue(0);
                    panel3.setProgressText("An Error Has Occurred");
                    
                    getWizard().setBackButtonEnabled(true);
                }

            }
        };

        t.start();
             * 
             */
    }
    
    public void aboutToHidePanel() {
        //  Can do something here, but we've chosen not not.
    }    
            
}
