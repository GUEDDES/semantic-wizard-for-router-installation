/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unavarra.iws.routerinstall.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.*;

/**
 * A JOutlookBar provides a component that is similar to a JTabbedPane, but
 * instead of maintaining tabs, it uses Outlook-style bars to control the
 * visible component.
 * Steven Haines [modified:aqm]
 */
public class JOutlookBar extends JPanel implements ActionListener {

    /**
     * The top panel: contains the buttons displayed on the top of the
     * JOutlookBar
     */
    private JPanel topPanel = new JPanel(new GridLayout(1, 1));
    /**
     * The bottom panel: contains the buttons displayed on the bottom of the
     * JOutlookBar
     */
    private JPanel bottomPanel = new JPanel(new GridLayout(1, 1));
    /**
     * A LinkedHashMap of bars: we use a linked hash map to preserve the order
     * of the bars
     */
    private Map bars = new LinkedHashMap();
    /**
     * The currently visible bar (zero-based index)
     */
    private int visibleBar = 0;
    /**
     * A place-holder for the currently visible component
     */
    private JComponent visibleComponent = null;

    /**
     * Creates a new JOutlookBar; after which you should make repeated calls to
     * addBar() for each bar
     */
    public JOutlookBar() {
        this.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Adds the specified component to the JOutlookBar and sets the bar's name
     *
     * @param name The name of the outlook bar
     * @param componenet The component to add to the bar
     */
    public void addBar(String name, JComponent component) {
        BarInfo barInfo = new BarInfo(name, component);
        barInfo.getButton().addActionListener(this);
        this.bars.put(name, barInfo);
        render();
    }

    /**
     * Adds the specified component to the JOutlookBar and sets the bar's name
     *
     * @param name The name of the outlook bar
     * @param icon An icon to display in the outlook bar
     * @param componenet The component to add to the bar
     */
    public void addBar(String name, Icon icon, JComponent component) {
        BarInfo barInfo = new BarInfo(name, icon, component);
        barInfo.getButton().addActionListener(this);
        this.bars.put(name, barInfo);
        render();
    }

    /**
     * Adds the specified component to the JOutlookBar and sets the bar's name
     *
     * @param name The name of the outlook bar
     * @param icon An icon to display in the outlook bar
     * @param componenet The component to add to the bar
     */
    public void addBar(String name, String icon, JComponent component) {
        BarInfo barInfo = new BarInfo(name, icon, component);
        barInfo.getButton().addActionListener(this);
        this.bars.put(name, barInfo);
        render();
    }    
    /**
     * Removes the specified bar from the JOutlookBar
     *
     * @param name The name of the bar to remove
     */
    public void removeBar(String name) {
        this.bars.remove(name);
        render();
    }

    /**
     * Returns the index of the currently visible bar (zero-based)
     *
     * @return The index of the currently visible bar
     */
    public int getVisibleBar() {
        return this.visibleBar;
    }

    /**
     * Programmatically sets the currently visible bar; the visible bar index
     * must be in the range of 0 to size() - 1
     *
     * @param visibleBar The zero-based index of the component to make visible
     */
    public void setVisibleBar(int visibleBar) {
        if (visibleBar > 0
                && visibleBar < this.bars.size() - 1) {
            this.visibleBar = visibleBar;
            render();
        }
    }

    /**
     * Causes the outlook bar component to rebuild itself; this means that it
     * rebuilds the top and bottom panels of bars as well as making the
     * currently selected bar's panel visible
     */
    public void render() {
        // Compute how many bars we are going to have where
        int totalBars = this.bars.size();
        int topBars = this.visibleBar + 1;
        int bottomBars = totalBars - topBars;


        // Get an iterator to walk through out bars with
        Iterator itr = this.bars.keySet().iterator();


        // Render the top bars: remove all components, reset the GridLayout to
        // hold to correct number of bars, add the bars, and "validate" it to
        // cause it to re-layout its components
        this.topPanel.removeAll();
        GridLayout topLayout = (GridLayout) this.topPanel.getLayout();
        topLayout.setRows(topBars);
        BarInfo barInfo = null;
        for (int i = 0; i < topBars; i++) {
            String barName = (String) itr.next();
            barInfo = (BarInfo) this.bars.get(barName);
            this.topPanel.add(barInfo.getButton());
        }
        this.topPanel.validate();


        // Render the center component: remove the current component (if there
        // is one) and then put the visible component in the center of this panel
        if (this.visibleComponent != null) {
            this.remove(this.visibleComponent);
        }
        this.visibleComponent = barInfo.getComponent();
        this.add(visibleComponent, BorderLayout.CENTER);


        // Render the bottom bars: remove all components, reset the GridLayout to
        // hold to correct number of bars, add the bars, and "validate" it to
        // cause it to re-layout its components
        this.bottomPanel.removeAll();
        GridLayout bottomLayout = (GridLayout) this.bottomPanel.getLayout();
        bottomLayout.setRows(bottomBars);
        for (int i = 0; i < bottomBars; i++) {
            String barName = (String) itr.next();
            barInfo = (BarInfo) this.bars.get(barName);
            this.bottomPanel.add(barInfo.getButton());
        }
        this.bottomPanel.validate();


        // Validate all of our components: cause this container to re-layout its subcomponents
        this.validate();
    }

    /**
     * Invoked when one of our bars is selected
     */
    public void actionPerformed(ActionEvent e) {
        int currentBar = 0;
        for (Iterator i = this.bars.keySet().iterator(); i.hasNext();) {
            String barName = (String) i.next();
            BarInfo barInfo = (BarInfo) this.bars.get(barName);
            if (barInfo.getButton() == e.getSource()) {
                // Found the selected button
                this.visibleBar = currentBar;
                render();
                return;
            }
            currentBar++;
        }
    }

    /**
     * Debug, dummy method
     */
    public static JPanel getDummyPanel(String name) {
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JTextArea jtaComments = new javax.swing.JTextArea();
        jtaComments.setColumns(20);
        jtaComments.setEditable(false);
        jtaComments.setLineWrap(true);
        jtaComments.setRows(5);
        jtaComments.setText(name);
        jScrollPane1.setViewportView(jtaComments);
        JPanel panel = new JPanel(new BorderLayout());
        //panel.add( new JLabel( name, JLabel.CENTER ) );
        panel.add(jScrollPane1);
        return panel;
    }

    /**
     * Debug test...
     */
    public static void main(String[] args) {
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        //URL imgURL = getClass().getResource("/es/unavarra/iws/routerinstall/resources/img/misc_03_16.png");
        JFrame frame = new JFrame("JOutlookBar Test");
        JOutlookBar outlookBar = new JOutlookBar();
        outlookBar.addBar("Al marcar un número en el terminal telefónico, aparecen problemas en las comunicaciones ADSL.", getDummyPanel("Compruebe que la toma de corriente a la que ha conectado el router proporciona electricidad.Revise que ha enchufado el router a la toma de corriente correctamente.Compruebe que el botón de encendido se encuentra pulsado."));
        outlookBar.addBar("Two", getDummyPanel("Two"));
        outlookBar.addBar("Three", getDummyPanel("Three"));
        outlookBar.addBar("Four", getDummyPanel("Four"));
        outlookBar.addBar("Five", getDummyPanel("Five"));
        outlookBar.addBar("Five3", "/es/unavarra/iws/routerinstall/resources/img/misc_03_16.png",getDummyPanel("Five3"));
        outlookBar.setVisibleBar(2);
        jScrollPane1.setViewportView(outlookBar);
        //frame.getContentPane().add( outlookBar );
        frame.getContentPane().add(jScrollPane1);
        frame.setSize(800, 600);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width / 2 - 400, d.height / 2 - 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Internal class that maintains information about individual Outlook bars;
     * specifically it maintains the following information:
     *
     * name The name of the bar button The associated JButton for the bar
     * component The component maintained in the Outlook bar
     */
    class BarInfo {

        /**
         * The name of this bar
         */
        private String name;
        /**
         * The JButton that implements the Outlook bar itself
         */
        private JButton button;
        /**
         * The component that is the body of the Outlook bar
         */
        private JComponent component;

        /**
         * Creates a new BarInfo
         *
         * @param name The name of the bar
         * @param component The component that is the body of the Outlook Bar
         */
        public BarInfo(String name, JComponent component) {
            this.name = name;
            this.component = component;
            this.button = new JButton("<html><p>"+name+"</p></html>");
            this.button.setPreferredSize(new Dimension(50, 50));
            this.button.setHorizontalAlignment(SwingConstants.LEFT);
        }

        /**
         * Creates a new BarInfo
         *
         * @param name The name of the bar
         * @param icon JButton icon
         * @param component The component that is the body of the Outlook Bar
         */
        public BarInfo(String name, Icon icon, JComponent component) {
            this.name = name;
            this.component = component;
            this.button = new JButton("<html><p>"+name+"</p></html>", icon);
            this.button.setPreferredSize(new Dimension(50, 50));
            this.button.setHorizontalAlignment(SwingConstants.LEFT);
        }

        /**
         * Creates a new BarInfo
         *
         * @param name The name of the bar
         * @param icon JButton icon
         * @param component The component that is the body of the Outlook Bar
         */
        public BarInfo(String name, String icon, JComponent component) {
            this.name = name;
            this.component = component;
            this.button = new JButton("<html><p>"+name+"</p></html>", new javax.swing.ImageIcon(getClass().getResource(icon)));
            this.button.setPreferredSize(new Dimension(50, 50));
            this.button.setHorizontalAlignment(SwingConstants.LEFT);
        }        
        /**
         * Returns the name of the bar
         *
         * @return The name of the bar
         */
        public String getName() {
            return this.name;
        }

        /**
         * Sets the name of the bar
         *
         * @param The name of the bar
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Returns the outlook bar JButton implementation
         *
         * @return The Outlook Bar JButton implementation
         */
        public JButton getButton() {
            return this.button;
        }


        /**
         * Returns the component that implements the body of this Outlook Bar
         *
         * @return The component that implements the body of this Outlook Bar
         */
        public JComponent getComponent() {
            return this.component;
        }
    }
}