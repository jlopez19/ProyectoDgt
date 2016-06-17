package com.example.jennyferlopez.proyectodgt.objetos;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class UbicacionVivienda implements KvmSerializable{

	public String ID;
    public String ID_DEPARTAMENTO;
    public String ID_MUNICIPIO;
    public String ID_ZONA;
    public String ID_BARRIO;
    public String MANZANA;
    public String ESTRATO;
    public String DIRECCION;
    public String VEREDA;
    public String TELEFONO;
    public String NO_FICHA;
    public String FORMULARIO;
    public String FECHA;
    public String ID_ENTIDAD;
    public String ID_USUARIO;
    public String IDENTIFICADOR;
    public String X;
    public String Y;
    public String RESPUESTAS;
    public String VIVIENDA_AFILIADOS;
    public String OBSERVACION;
    
    
    @Override
  	public Object getProperty(int arg0) {
  	 
  	    switch(arg0)
  	        {
  	        case 0:
  	            return ID;
  	        case 1:
  	            return ID_DEPARTAMENTO;
  	        case 2:
  	            return ID_MUNICIPIO;
  	        case 3:
	            return ID_ZONA;
	        case 4:
	            return ID_BARRIO;
	        case 5:
	            return MANZANA;
	        case 6:
	            return ESTRATO;
	        case 7:
	            return DIRECCION;
	        case 8:
	            return VEREDA;
	        case 9:
	            return TELEFONO;
	        case 10:
	            return NO_FICHA;
	        case 11:
	            return FORMULARIO;
	        case 12:
	            return FECHA;  
	        case 13:
	            return ID_ENTIDAD;  
	        case 14:
	            return ID_USUARIO;  
	        case 15:
	            return IDENTIFICADOR;  
	        case 16:
	            return X;  
	        case 17:
	            return Y; 
	        case 18:
	            return RESPUESTAS; 
	        case 19:
	            return VIVIENDA_AFILIADOS;
	        case 20:
	            return OBSERVACION;
  	      default:break;
  	        }
  	 
  	    return null;
  	}
  	
  	@Override
  	public int getPropertyCount() {
  	    return 21;
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
  	            info.name = "ID_DEPARTAMENTO";
  	            break;
  	        case 2:
  	            info.type = PropertyInfo.STRING_CLASS;
  	            info.name = "ID_MUNICIPIO";
  	            break;
  	      case 3:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "ID_ZONA";
	            break;
	        case 4:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "ID_BARRIO";
	            break;
	        case 5:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "MANZANA";
	            break;
	        case 6:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "ESTRATO";
	            break;
	        case 7:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "DIRECCION";
	            break;
	        case 8:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "VEREDA";
	            break;
	        case 9:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "TELEFONO";
	            break;
	        case 10:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "NO_FICHA";
	            break;
	        case 11:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "FORMULARIO";
	            break;
	        case 12:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "FECHA";
	            break;
	        case 13:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "ID_ENTIDAD";
	            break;
	        case 14:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "ID_USUARIO";
	            break;
	        case 15:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "IDENTIFICADOR";
	            break;
	        case 16:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "X";
	            break;
	        case 17:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "Y";
	            break;
	        case 18:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "RESPUESTAS";
	            break; 
	        case 19:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "VIVIENDA_AFILIADOS";
	            break;  
	        case 20:
	            info.type = PropertyInfo.STRING_CLASS;
	            info.name = "OBSERVACION";
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
  	        	ID_DEPARTAMENTO = val.toString();
  	            break;
  	        case 2:
  	        	ID_MUNICIPIO = val.toString();
  	            break;
  	        case 3:
  	        	ID_ZONA = val.toString();
	            break;
	        case 4:
	        	ID_BARRIO = val.toString();
	            break;
	        case 5:
	        	MANZANA = val.toString();
	            break;
	        case 6:
	        	ESTRATO = val.toString();
  	            break;
  	        case 7:
  	        	DIRECCION = val.toString();
  	            break;
  	      case 8:
  	    	    VEREDA = val.toString();
	            break;
	        case 9:
	        	TELEFONO = val.toString();
	            break;
	        case 10:
	        	FORMULARIO = val.toString();
	            break;
	        case 11:
	        	NO_FICHA = val.toString();
	            break;
	        case 12:
	        	FECHA = val.toString();
	            break;
	        case 13:
	        	ID_ENTIDAD = val.toString();
	            break;      
	        case 14:
	        	ID_USUARIO = val.toString();
	            break;  
	        case 15:
	        	IDENTIFICADOR = val.toString();
	            break;   
	        case 16:
	        	X = val.toString();
	            break;      
	        case 17:
	        	Y = val.toString();
	            break;  
	        case 18:
	        	RESPUESTAS = val.toString();
	            break; 
	        case 19:
	        	VIVIENDA_AFILIADOS = val.toString();
	            break; 
	        case 20:
	        	OBSERVACION = val.toString();
	            break; 
  	        default:
  	            break;
  	        }
  	}
    
	
}


