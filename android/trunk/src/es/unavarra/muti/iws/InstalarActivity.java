package es.unavarra.muti.iws;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class InstalarActivity extends SWRActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instalar);
    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.opciones, menu);
        menu.findItem(R.id.menu_herramientas_item).setIntent(new Intent(this, HerramientasActivity.class));
        menu.findItem(R.id.menu_ayuda_item).setIntent(new Intent(this, AyudaActivity.class));
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        startActivity(item.getIntent());
        return true;
    }    
}