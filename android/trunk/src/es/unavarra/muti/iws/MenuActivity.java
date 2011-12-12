package es.unavarra.muti.iws;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MenuActivity extends SWRActivity {


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
       
        ImageButton btnInstalar = (ImageButton) findViewById(R.id.btnInstalar);
        btnInstalar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MenuActivity.this, InstalarActivity.class));
			}
		});

        ImageButton btnBusqueda = (ImageButton) findViewById(R.id.btnBusqueda);
        btnBusqueda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MenuActivity.this, BusquedaActivity.class));
			}
		});
        
        ImageButton btnHerramientas = (ImageButton) findViewById(R.id.btnHerramientas);
        btnHerramientas.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MenuActivity.this, HerramientasActivity.class));
			}
		});
        
        ImageButton btnAyuda = (ImageButton) findViewById(R.id.btnAyuda);
        btnAyuda.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MenuActivity.this, AyudaActivity.class));
			}
		}); 
    }

}

