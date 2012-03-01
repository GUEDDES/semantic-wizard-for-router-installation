/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

import es.unavarra.iws.routerinstall.gui.wiz.WizardPanelDescriptor;

/**
 *
 * @author aqm
 */
public class Router1Panel1Descriptor extends WizardPanelDescriptor {
    
    public static final String IDENTIFIER = "RCT5071_PANEL1";
    
    public Router1Panel1Descriptor(String primerPaso) {
        super(IDENTIFIER, new Router1Panel1(primerPaso));
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
