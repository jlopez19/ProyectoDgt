package com.example.jennyferlopez.proyectodgt.objetos;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class Respuesta implements KvmSerializable{

	 public String ID ;
     public String COD_PREGUNTA ;
     public String COD_RESPUESTA ;
     public String DATO ;
     public String ID_ENTIDAD;
     public String CODIGO_ENCUENTA ;
     
    @Override
  	public Object getProperty(int arg0) {
  	 
  	    switch(arg0)
  	        {
  	        case 0:
  	            return ID ;
  	        case 1:
  	            return COD_PREGUNTA ;
  	        case 2:
  	            return COD_RESPUESTA ;
  	        case 3:
  	            return DATO ;
  	        case 4:
	            return ID_ENTIDAD ;
	        case 5:
	            return CODIGO_ENCUENTA ;
  	        }
  	 
  	    return null;
  	}
  	
  	@Override
  	public int getPropertyCount() {
  	    return 6;
  	}
  	
  	@Override
  	public void getPropertyInfo(int ind, Hashtable ht, PropertyInfo info) {
  	    switch(ind)
  	        {
  	        case 0:
  	            info.type = PropertyInfo.STRING_CLASS;
  	            info.name = "ID";
  	            break;
  	        case 1:
  	            info.type = PropertyInfo.STRING_CLASS;
  	            info.name = "COD_PREGUNTA";
  	            break;
  	        case 2:
  	            info.type = PropertyInfo.STRING_CLASS;
  	            info.name = "COD_RESPUESTA";
  	            break;
  	        case 3:
  	            info.type = PropertyInfo.STRING_CLASS;
  	            info.name = "DATO";
  	            break;
  	        case 4:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "ID_ENTIDAD";
	            break;
	        case 5:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "CODIGO_ENCUENTA";
	            break;
  	       
  	        default:break;
  	        }
  	}

  	@Override
  	public void setProperty(int ind, Object val) {
  	    switch(ind)
  	        {
  	        case 0:
  	        	ID = val.toString();
  	            break;
  	        case 1:
  	        	COD_PREGUNTA = val.toString();
  	            break;
  	        case 2:
  	        	COD_RESPUESTA = val.toString();
  	            break;
  	        case 3:
  	        	DATO= val.toString();
  	            break;
  	        case 4:
  	        	ID_ENTIDAD = val.toString();
	            break;
	        case 5:
	        	CODIGO_ENCUENTA= val.toString();
	            break;
  	       
  	        
  	        default:
  	            break;
  	        }
  	}
    
	
}
