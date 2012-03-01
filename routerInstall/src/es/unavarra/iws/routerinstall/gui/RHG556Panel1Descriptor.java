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
public class RHG556Panel1Descriptor extends WizardPanelDescriptor {
    
    public static final String IDENTIFIER = "RHG556_INTRODUCTION_PANEL";
    
    public RHG556Panel1Descriptor(String primerPaso) {
        super(IDENTIFIER, new RHG556Panel1(primerPaso));
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return RHG556Panel2Descriptor.IDENTIFIER;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return null;
    }  
    
}
