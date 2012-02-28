package es.unavarra.iws.routerinstall.gui;

import es.unavarra.iws.routerinstall.gui.wiz.WizardPanelDescriptor;

public class Router1Panel1Descriptor extends WizardPanelDescriptor {
    
    public static final String IDENTIFIER = "INTRODUCTION_PANEL";
    
    public Router1Panel1Descriptor() {
        super(IDENTIFIER, new Router1Panel1());
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return Router1Panel2Descriptor.IDENTIFIER;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return null;
    }  
    
}
