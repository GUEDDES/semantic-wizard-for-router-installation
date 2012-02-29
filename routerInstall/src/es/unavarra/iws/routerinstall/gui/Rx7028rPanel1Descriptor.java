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
public class Rx7028rPanel1Descriptor extends WizardPanelDescriptor {
    
    public static final String IDENTIFIER = "RX7028R_INTRODUCTION_PANEL";
    
    public Rx7028rPanel1Descriptor(String primerPaso) {
        super(IDENTIFIER, new Rx7028rPanel1(primerPaso));
    }
    
    @Override
    public Object getNextPanelDescriptor() {
        return Rx7028rPanel2Descriptor.IDENTIFIER;
    }
    
    @Override
    public Object getBackPanelDescriptor() {
        return null;
    } 
}
