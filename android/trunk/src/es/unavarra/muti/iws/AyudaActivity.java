package es.unavarra.muti.iws;

import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class AyudaActivity extends SWRActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda);
        
        TabHost host = (TabHost) findViewById(R.id.TabHostAyuda);
        host.setup();
        
        TabSpec tabFAQ = host.newTabSpec("tabFAQ");
        tabFAQ.setIndicator(getResources().getString(R.string.faq), getResources().getDrawable(android.R.drawable.ic_menu_info_details));
        tabFAQ.setContent(R.id.tabFAQ);
        host.addTab(tabFAQ);

        TabSpec tabAyuda = host.newTabSpec("tabAyuda");
        tabAyuda.setIndicator(getResources().getString(R.string.ayuda2), getResources().getDrawable(android.R.drawable.ic_menu_help));
        tabAyuda.setContent(R.id.tabAyuda);
        host.addTab(tabAyuda);

        // default tab
        host.setCurrentTabByTag("tabFAQ");        
    }
}