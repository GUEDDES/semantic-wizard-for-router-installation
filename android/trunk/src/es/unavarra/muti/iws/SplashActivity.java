package es.unavarra.muti.iws;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends SWRActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        iniciarAnimacion();
    }

	/**
	 * Inicia la animacion del Splash
	 */
	private void iniciarAnimacion() {
		
		//Animacion del titulo
		TextView textoTitulo = (TextView) findViewById(R.id.textoTitulo);
        Animation fadeIn = 	AnimationUtils.loadAnimation(this, R.anim.fade_in);
        textoTitulo.startAnimation(fadeIn);
        
        //Animacion de la version
        TextView textoVersion = (TextView) findViewById(R.id.textoVersion);
        textoVersion.startAnimation(fadeIn);
        
        //Animacion del logo y cuando termine llamar a la ventana de Menu para luego eliminar esta activdad
        ImageView logo = (ImageView) findViewById(R.id.imageLogo);
        Animation spinIn = 	AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        logo.startAnimation(spinIn);
        
        spinIn.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationEnd(Animation animation) {
				startActivity(new Intent(SplashActivity.this, MenuActivity.class));
				SplashActivity.this.finish();
			}
			
        	@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

		});
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		super.onPause();
		TextView textoTitulo = (TextView) findViewById(R.id.textoTitulo);
		textoTitulo.clearAnimation();
		TextView textoVersion = (TextView) findViewById(R.id.textoVersion);
		textoVersion.clearAnimation();		
		ImageView logo = (ImageView) findViewById(R.id.imageLogo);
		logo.clearAnimation();
	}
}