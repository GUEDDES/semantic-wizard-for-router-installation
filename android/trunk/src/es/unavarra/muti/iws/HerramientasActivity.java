package es.unavarra.muti.iws;


import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class HerramientasActivity extends SWRActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.herramientas);
        
        TabHost host = (TabHost) findViewById(R.id.TabHost1);
        host.setup();
        
        TabSpec tabConceptos = host.newTabSpec("tabConceptos");
        tabConceptos.setIndicator(getResources().getString(R.string.conceptos), getResources().getDrawable(android.R.drawable.ic_menu_agenda));
        tabConceptos.setContent(R.id.tabConceptos);
        host.addTab(tabConceptos);

        TabSpec tabConfiguracion = host.newTabSpec("tabConfiguracion");
        tabConfiguracion.setIndicator(getResources().getString(R.string.configuracion), getResources().getDrawable(android.R.drawable.ic_menu_preferences));
        tabConfiguracion.setContent(R.id.tabConfiguracion);
        host.addTab(tabConfiguracion);

        // default tab
        host.setCurrentTabByTag("tabConceptos");
        
    }
}