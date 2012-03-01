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
public class RTG585v7Panel1Descriptor extends WizardPanelDescriptor {
    
    public static final String IDENTIFIER = "RTG585v7_INTRODUCTION_PANEL";
    
    public RTG585v7Panel1Descriptor(String primerPaso) {
        super(IDENTIFIER, new RTG585v7Panel1(primerPaso));
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return RTG585v7Panel2Descriptor.IDENTIFIER;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return null;
    }  
    
}
