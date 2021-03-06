package com.example.jennyferlopez.proyectodgt.dgtmovil;


import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Region.Op;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jennyferlopez.proyectodgt.R;
import com.example.jennyferlopez.proyectodgt.datos.GestionDatos;
import com.example.jennyferlopez.proyectodgt.datos.Sentencias;
import com.example.jennyferlopez.proyectodgt.objetos.Opcion;
import com.example.jennyferlopez.proyectodgt.objetos.Pregunta;

public class Sincronizar extends Activity {

	Persistencia mypersistencia;
	GestionDatos gestionDatos;
	private Button bt_aceptar; 

	String[] lecturasTabla=null;
	Pregunta[] listaPreguntas;
	Opcion[] listaOpciones;
	

	Sentencias sentencias;
	TextView resultado;
	int idUsuario=0;
	String idPerfil="";
	String idEntidad="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sincronizar);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		bt_aceptar = (Button) this.findViewById(R.id.btnOK);
		resultado = (TextView) this.findViewById(R.id.textcodigo);
		
	    this.setTitle("Gestion Solicitudes");
		 Bundle bundle = this.getIntent().getExtras();	          
         //Construimos el mensaje a mostrar
		 
         idUsuario=bundle.getInt("idUsuario");
       
         idPerfil=bundle.getString("perfil");
         idEntidad=bundle.getString("idEntidad");
         gestionDatos=new GestionDatos(getApplicationContext());
		crearBaseDatos();
		gestionDatos.sentencias = sentencias;
		
	
		mypersistencia = new Persistencia(getApplicationContext(),sentencias);
		bt_aceptar.setOnClickListener(new OnClickListener() {
	           @Override
	           public void onClick(View v) {
	     mostrarMensaje("Iniciando Proceso", 3);
	 
	     if(existeConexion()){
	    	     mypersistencia = new Persistencia(getApplicationContext(),sentencias);	        	   					
	        	 mypersistencia.idEntidad=idEntidad;
	        	
                  mypersistencia.execute("20");	    	   
	        	   try{
	        	 //  mypersistencia.wait();
	        	   lecturasTabla=mypersistencia.get();
	               listaPreguntas=mypersistencia.listaPreguntas;
	               listaOpciones=mypersistencia.listaOpciones;
	               resultado.setText("Total Obtenidos "+listaPreguntas.length);
	               gestionDatos.eliminarOpciones();
	                 guardarPreguntas();
	                 resultado.setText("Datos Almacenados "+listaPreguntas.length);
	        	   }
	        	   catch(Exception ex){
	        		   
	        	   }
	        	   mostrarMensaje("Proceso Terminado", 3);
	     }
	     
		          
	           else{
	        	    mostrarMensaje("No hay conexion con el server", 3);
	           }
	           }
	      });
		
			}
	
	
	public boolean existeConexion(){
		try{
		 mypersistencia = new Persistencia(getApplicationContext(),sentencias);
		mypersistencia.execute("4");
		String[] res=mypersistencia.get();
	if(res!=null && res.length>0){
		if(res[0].equals("true")){// envio bien editar estado y enviado
        return true;
		}
		else{
			return  false;
		}
	}
	}
	catch(Exception e){
		return false;
	}
	return false;
	}
	
	public void crearBaseDatos() {
		sentencias = new Sentencias(this, "DBDGT", null, 1);

	}
	
	public void guardarPreguntas(){
		Pregunta lect;
		Opcion op;
		for(int i=0;i<listaPreguntas.length;i++){
		lect=listaPreguntas[i];
		int aux=i+1;
		if(i%100==0){
		mostrarMensaje("Guardando "+aux+" de "+listaPreguntas.length, 1);
		}
		gestionDatos.crearPreguta(lect);
		}
		
		for(int i=0;i<listaOpciones.length;i++){
			op=listaOpciones[i];
			int aux=i+1;
			if(i%100==0){
			mostrarMensaje("Guardando "+aux+" de "+listaOpciones.length, 1);
			}
			gestionDatos.crearOpcion(op);
			}
	//	borrarLecturas();
	}

	 public void mostrarMensaje(String mensaje,int tiempo){
	  	  Toast toast4 = Toast.makeText(getApplicationContext(),
						mensaje, tiempo);
		  
				toast4.show(); 
	    }
	
	 
	 public void borrarLecturas(){
		 File carpetaImagenes = new File(
					Environment.getExternalStorageDirectory(), "Lecturas");
		 String[] children = carpetaImagenes.list();
	        for (int i = 0; i < children.length; i++) {
	            new File(carpetaImagenes, children[i]).delete();
	        }
	 }
	 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
