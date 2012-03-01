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
public class RSagemFast_2604Panel1Descriptor extends WizardPanelDescriptor {
    
    public static final String IDENTIFIER = "RSAGEMFAST_2604_INTRODUCTION_PANEL";
    
    public RSagemFast_2604Panel1Descriptor(String primerPaso) {
        super(IDENTIFIER, new RSagemFast_2604Panel1(primerPaso));
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return RSagemFast_2604Panel2Descriptor.IDENTIFIER;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return null;
    }  
    
}
