package com.example.jennyferlopez.proyectodgt.objetos;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class Pregunta implements KvmSerializable{

	public String ID ;
    public String CODIGO ;
    public String DESCRIPCION ;
    public String ID_ENTIDAD ;
    public String ESTADO ;
    public String ID_GRUPO ;
    public String ID_TIPO_PREGUNTA ;

    @Override
  	public Object getProperty(int arg0) {
  	 
  	    switch(arg0)
  	        {
  	        case 0:
  	            return ID ;
  	        case 1:
  	            return CODIGO ;
  	        case 2:
  	            return DESCRIPCION ;
  	        case 3:
  	            return ID_ENTIDAD ;
  	        case 4:
  	            return ESTADO ;
  	        case 5:
  	            return ID_GRUPO ;
  	        case 6:
  	            return ID_TIPO_PREGUNTA;
  	       
	        
  	        }
  	 
  	    return null;
  	}
  	
  	@Override
  	public int getPropertyCount() {
  	    return 7;
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
  	            info.name = "CODIGO";
  	            break;
  	        case 2:
  	            info.type = PropertyInfo.STRING_CLASS;
  	            info.name = "DESCRIPCION";
  	            break;
  	        case 3:
  	            info.type = PropertyInfo.STRING_CLASS;
  	            info.name = "ID_ENTIDAD";
  	            break;
  	        case 4:
  	            info.type = PropertyInfo.STRING_CLASS;
  	            info.name = "ESTADO";
  	            break;
  	        case 5:
  	            info.type = PropertyInfo.STRING_CLASS;
  	            info.name = "ID_GRUPO";
  	            break;
  	        case 6:
  	            info.type = PropertyInfo.STRING_CLASS;
  	            info.name = "ID_TIPO_PREGUNTA";
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
  	        	CODIGO = val.toString();
  	            break;
  	        case 2:
  	        	DESCRIPCION = val.toString();
  	            break;
  	        case 3:
  	        	ID_ENTIDAD= val.toString();
  	            break;
  	        case 4:
  	        	ESTADO =  val.toString();
  	            break;
  	        case 5:
  	        	ID_GRUPO = val.toString();
  	            break;
  	        case 6:
  	        	ID_TIPO_PREGUNTA = val.toString();
  	            break;
  	        
  	        default:
  	            break;
  	        }
  	}
    
	
}
