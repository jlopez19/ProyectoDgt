package com.example.jennyferlopez.proyectodgt.objetos;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class ViviendaAfiliado implements KvmSerializable{

	public String CODIGO_ENCUENTA;
    public String IDENTIFICACION;
    
    
    @Override
  	public Object getProperty(int arg0) {
  	 
  	    switch(arg0)
  	        {
  	        case 0:
  	            return CODIGO_ENCUENTA;
  	        case 1:
  	            return IDENTIFICACION;
  	       
  	      default:break;
  	        }
  	 
  	    return null;
  	}
  	
  	@Override
  	public int getPropertyCount() {
  	    return 2;
  	}
  	
  	@Override
  	public void getPropertyInfo(int ind, Hashtable ht, PropertyInfo info) {
  	    switch(ind)
  	        {
  	        case 0:
  	            info.type = PropertyInfo.STRING_CLASS;
  	            info.name = "CODIGO_ENCUENTA";
  	            break;
  	        case 1:
  	            info.type = PropertyInfo.STRING_CLASS;
  	            info.name = "IDENTIFICACION";
  	            break;
  	       
  	        default:break;
  	        }
  	}

  	@Override
  	public void setProperty(int ind, Object val) {
  	    switch(ind)
  	        {
  	        case 0:
  	        	CODIGO_ENCUENTA = val.toString();
  	            break;
  	        case 1:
  	        	IDENTIFICACION = val.toString();
  	            break;
  	      
  	          
  	        default:
  	            break;
  	        }
  	}
    
	
}
