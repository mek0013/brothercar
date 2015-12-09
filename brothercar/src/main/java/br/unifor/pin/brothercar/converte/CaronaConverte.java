package br.unifor.pin.brothercar.converte;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.brothercar.dao.CaronasDAO;
import br.unifor.pin.brothercar.entity.Caronas;

@Component(value = "caronaConverter")
@ManagedBean(name = "caronaConverter")
public class CaronaConverte implements Converter {
	
	@Autowired
	private CaronasDAO caronaDAO;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		 if (value == null || value.isEmpty()) {
             return null;
         }

         try {
               
             Caronas carona = caronaDAO.buscar(Integer.valueOf(value));
             
             return carona;
         } catch (Exception e) {
             e.printStackTrace();
             throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to Customer", value)), e);
         }
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (!(value instanceof Caronas)) {
            return null;
        }

       String s =  String.valueOf(((Caronas) value).getId());
       
       return s;
	}

}
