package com.example.jennyferlopez.proyectodgt.dgtmovil;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.example.jennyferlopez.proyectodgt.R;

public class MenuPrincipal extends Activity{

	
	ImageButton imagenNuevo;
	ImageButton imagenGlecturas;
	ImageButton imagenConfiguracion;
	ImageButton imagenSalir;
	
	int idUsuario;
	String idPerfil;
	String idEntidad="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_menu_principal);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		 Bundle bundle = this.getIntent().getExtras();	          
         //Construimos el mensaje a mostrar
         idUsuario=bundle.getInt("idUsuario");
         idPerfil=bundle.getString("perfil");
         idEntidad=bundle.getString("idEntidad");
         
         this.setTitle("Menu Principal - Usuario: "+bundle.getString("nombre"));
				imagenNuevo = (ImageButton) this.findViewById(R.id.imageView1);
				imagenGlecturas = (ImageButton) this.findViewById(R.id.imageView2);
				imagenConfiguracion = (ImageButton) this.findViewById(R.id.imageView4);
				imagenSalir = (ImageButton) this.findViewById(R.id.imageView5);
				
				if(idPerfil.equals("3")){
				imagenGlecturas.setEnabled(false);	
				}
				
				imagenNuevo.setOnClickListener(new OnClickListener() {
		         
					@Override
		             public void onClick(View v) {
						Intent intent=null; 
						if(idEntidad.equals("1")){
		            	  intent = new Intent(MenuPrincipal.this, Censar.class);
						}
						
		      			// Creamos la informaci�n a pasar entre actividades
		      			Bundle b = new Bundle();
		      			b.putInt("idUsuario", idUsuario);
		      			b.putString("idEntidad", idEntidad);
		      				intent.putExtras(b);
		      				startActivity(intent);    
		      				      }
		        });
				
				imagenGlecturas.setOnClickListener(new OnClickListener() {
		             @Override
		             public void onClick(View v) {
		            	  Intent intent = new Intent(MenuPrincipal.this, Sincronizar.class);

		      			// Creamos la informaci�n a pasar entre actividades
		      			Bundle b = new Bundle();
		      			//	b.putInt("idAgente", idAgente);
		      			b.putInt("idUsuario", idUsuario);
		      			b.putString("idEntidad", idEntidad);
		      				intent.putExtras(b);
		      				startActivity(intent);    
		      				      }
		        });
				
				
				
				
				
				imagenSalir.setOnClickListener(new OnClickListener() {
		             @Override
		             public void onClick(View v) {
		            	  Intent intent = new Intent(MenuPrincipal.this, MainActivity.class);

			      			// Creamos la informaci�n a pasar entre actividades
			      			Bundle b = new Bundle();
			      			//	b.putInt("idAgente", idAgente);
			      			
			      				intent.putExtras(b);
			      				startActivity(intent);   
		            	 }
		            	 
		            	 
		        });
				
				
				imagenConfiguracion.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						  Intent intent = new Intent(MenuPrincipal.this, Reprocesar.class);
						  startActivity(intent);
					
					}
				});
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	//	getMenuInflater().inflate(R.menu.menu_principal, menu);
		return true;
	}

	
	
	 
	

}
