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
public class Rct351Panel1Descriptor extends WizardPanelDescriptor {
    
    public static final String IDENTIFIER = "RCT351_INTRODUCTION_PANEL";
    
    public Rct351Panel1Descriptor(String primerPaso) {
        super(IDENTIFIER, new Rct351Panel1(primerPaso));
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return Rct351Panel2Descriptor.IDENTIFIER;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return null;
    }  

    
}
