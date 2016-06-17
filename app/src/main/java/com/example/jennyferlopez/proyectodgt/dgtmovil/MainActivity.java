package com.example.jennyferlopez.proyectodgt.dgtmovil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jennyferlopez.proyectodgt.R;
import com.example.jennyferlopez.proyectodgt.datos.GestionDatos;
import com.example.jennyferlopez.proyectodgt.datos.Sentencias;
import com.example.jennyferlopez.proyectodgt.objetos.Usuario;

public class MainActivity extends Activity {

	Sentencias sentencias = null;
	GestionDatos gestionDatos;
	Persistencia mypersistencia;
	TextView textToast;
	View layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		gestionDatos=new GestionDatos(getApplicationContext());
		crearBaseDatos();
		
		gestionDatos.sentencias = sentencias;
		mypersistencia = new Persistencia(getApplicationContext(),sentencias);
		
		
		//if(!gestionDatos.existePrograma("1")){
			//registrarProgramas();
		//	gestionDatos.agregarColumnas();     
		//}
		final EditText txtLogin = (EditText) findViewById(R.id.editText1);
		final EditText txtPassword = (EditText) findViewById(R.id.editText2);
		final Button btnAceptar = (Button) findViewById(R.id.BtnBoton5);
		 LayoutInflater inflater = getLayoutInflater();
		 layout = inflater.inflate(R.layout.custom_dialog,(ViewGroup) findViewById(R.id.toast_layout_root));		  
		 textToast = (TextView) layout.findViewById(R.id.texto);
	
		
		// Implementamos el evento �click� del bot�n
		btnAceptar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				try{
				//	BD_backup();
					}
					catch(Exception ex){
						
					}
				
				// Creamos el Intent
				Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);

				// Creamos la informaci�n a pasar entre actividades
				Bundle b = new Bundle();
				int idA = gestionDatos.consultarUsuario(txtLogin.getText()
						.toString(), txtPassword.getText().toString());
				
				if (idA != 0) {
					b.putInt("idUsuario", idA);
					b.putString("nombre", gestionDatos.nombre);
					b.putString("perfil", gestionDatos.perfil);
					b.putString("idEntidad", gestionDatos.idEntidad);
					intent.putExtras(b);
					startActivity(intent);
				} else {
					Toast toast4 = Toast.makeText(getApplicationContext(),
							"Datos Invalidos", Toast.LENGTH_SHORT);
					toast4.show();
				}

			}
		});

	}

	
	
	

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		 menu.add("Usuarios");
		 menu.add("Actualizar");
	      
	      return super.onCreateOptionsMenu(menu);
	
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	      // TODO Auto-generated method stub
	       if(item.toString().equals("Usuarios")){
	    	   Toast.makeText(this, "Sincronizando Usuarios", Toast.LENGTH_SHORT).show();
	    	   obtenerUsuarios();     
	      }
	      else if(item.toString().equals("Actualizar")){
	   	  String link = "http://173.201.37.144:8105/install/SALUD.zip";
	  		Intent intent = null;
	  		intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
	  		startActivity(intent);
	    	//  descargarArchivo();
	      }
	   
	      return super.onOptionsItemSelected(item);
	    }
	
	
	public void descargarArchivo(){
		try {
		    //primero especificaremos el origen de nuestro archivo a descargar utilizando
		    //la ruta completa
		    URL url = new URL("http://173.201.37.144:8105/Medicina/SALUD.zip");
		 
		    //establecemos la conexi�n con el destino
		    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		 
		    //establecemos el m�todo jet para nuestra conexi�n
		    //el m�todo setdooutput es necesario para este tipo de conexiones
		    urlConnection.setRequestMethod("GET");
		    urlConnection.setDoOutput(true);
		 
		    //por �ltimo establecemos nuestra conexi�n y cruzamos los dedos <img src="http://www.insdout.com/wp-includes/images/smilies/icon_razz.gif" alt=":P" class="wp-smiley"> 
		    urlConnection.connect();
		 
		    //vamos a establecer la ruta de destino para nuestra descarga
		    //para hacerlo sencillo en este ejemplo he decidido descargar en 
		    //la ra�z de la tarjeta SD
		    File SDCardRoot = Environment.getExternalStorageDirectory();
		 
		    //vamos a crear un objeto del tipo de fichero
		    //donde descargaremos nuestro fichero, debemos darle el nombre que
		    //queramos, si quisieramos hacer esto mas completo
		    //coger�amos el nombre del origen
		    File file = new File(SDCardRoot,"SALUD.zip");
		 
		    //utilizaremos un objeto del tipo fileoutputstream
		    //para escribir el archivo que descargamos en el nuevo
		    FileOutputStream fileOutput = new FileOutputStream(file);
		 
		    //leemos los datos desde la url
		    InputStream inputStream = urlConnection.getInputStream();
		 
		    //obtendremos el tama�o del archivo y lo asociaremos a una
		    //variable de tipo entero
		    int totalSize = urlConnection.getContentLength();
		    int downloadedSize = 0;
		 
		    //creamos un buffer y una variable para ir almacenando el 
		    //tama�o temporal de este
		    byte[] buffer = new byte[1024];
		    int bufferLength = 0; 
		 
		    //ahora iremos recorriendo el buffer para escribir el archivo de destino
		    //siempre teniendo constancia de la cantidad descargada y el total del tama�o
		    //con esto podremos crear una barra de progreso
		    while ( (bufferLength = inputStream.read(buffer)) > 0 ) {
		 
		        fileOutput.write(buffer, 0, bufferLength);
		        downloadedSize += bufferLength;
		        //podr�amos utilizar una funci�n para ir actualizando el progreso de lo 
		        //descargado
		      //  actualizaProgreso(downloadedSize, totalSize);
		 
		    }
		    //cerramos
		    fileOutput.close();
		 
		//y gestionamos errores
		} catch (MalformedURLException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public void obtenerUsuarios(){
		if(existeConexion()){
   	     mypersistencia = new Persistencia(getApplicationContext(),sentencias);	        	   					
       	   mypersistencia.execute("9");	    	   
       	   try{
       	 //  mypersistencia.wait();
       	   mypersistencia.get();
              Usuario[] listaUsuarios=mypersistencia.listaUsuarios;
              Usuario lect;
              if(listaUsuarios!=null && listaUsuarios.length>0){
      		for(int i=0;i<listaUsuarios.length;i++){
      		lect=listaUsuarios[i];
      		int aux=i+1;
      	//	mostrarMensaje("Guardando "+aux+" de "+listaUsuarios.length, 1);
      		gestionDatos.crearUsuario(lect);
      		}
             }
              else{
           	  mostrarMensaje("No hay datos Usuarios", 3); 
              }
      		                      		
      		
              
             
       	   }
       	   catch(Exception ex){
       		   
       	   }
       	   mostrarMensaje("Proceso Terminado", 3);
    }

    
	          
          else{
       	    mostrarMensaje("No hay conexion con el server", 3);
          }

}


	public void crearBaseDatos() {
		sentencias = new Sentencias(this, "DBCENSO", null, 1);

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

	 
	 public void mostrarMensaje(String mensaje,int tiempo){
		 textToast.setText(mensaje);
		 Toast toast = new Toast(getApplicationContext());
		 toast.setDuration(Toast.LENGTH_LONG);
		 toast.setView(layout);
		 toast.show();
			 
	    }
	 
	 public void registrarProgramas(){
			gestionDatos.crearPrograma("1", "Control Prenatal");
			gestionDatos.crearPrograma("2", "Atencion del Parto");
			gestionDatos.crearPrograma("3", "Vacunacion");
			gestionDatos.crearPrograma("4", "Adulto Mayor");
			gestionDatos.crearPrograma("5", "Salud Oral");
			gestionDatos.crearPrograma("6", "Citologias");
			gestionDatos.crearPrograma("7", "Salud Mental");
			gestionDatos.crearPrograma("8", "Planificacion Familiar");
			gestionDatos.crearPrograma("9", "Salud Visual");
			gestionDatos.crearPrograma("10", "Crecimiento y Desarrollo");
		}
		
	 
	 public static void BD_backup() throws IOException {
			
			//	String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
			
				 try{
			
				final String inFileName = "/data/data/com.example.slfs/databases/DBCEN";
			
				File dbFile = new File(inFileName);
			
				FileInputStream fis = null;
		
				 
			
				fis = new FileInputStream(dbFile);
			
				 
			
				
						File d = new File(Environment
								.getExternalStorageDirectory(), "APS");		
			
			
				if (!d.exists()) {
			
				d.mkdir();
			
				}
			
				String outFileName = d.getAbsolutePath() + "/DBCEN";
			
				 
			
				OutputStream output = new FileOutputStream(outFileName);
			
				 
			
				byte[] buffer = new byte[1024];
			
				int length;
			
				while ((length = fis.read(buffer)) > 0) {
			
				output.write(buffer, 0, length);
			
				}
			
				 
		
				output.flush();
			
				output.close();
		
				fis.close();
			
				 }
				 catch(Exception e){
					e.printStackTrace(); 
				 }
			
				}
		
	 
	 private void copyDataBase()
	    {
	       
	        byte[] buffer = new byte[1024];
	        OutputStream myOutput = null;
	        int length;
	        // Open your local db as the input stream
	        InputStream myInput = null;
	        try
	        {
	            myInput =getApplicationContext().getAssets().open("DBDGT");
	            // transfer bytes from the inputfile to the
	            // outputfile
	            myOutput =new FileOutputStream("/data/data/com.example.slfs/databases/DBDGT");
	            while((length = myInput.read(buffer)) > 0)
	            {
	                myOutput.write(buffer, 0, length);
	            }
	            myOutput.close();
	            myOutput.flush();
	            myInput.close();
	         


	        }
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
	    }

}
