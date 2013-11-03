
package app.dao;

import app.model.SolicitudAlquiler;
import app.zelper.GenericDAO;
import java.util.List;

public interface SolicitudAlquilerDAO extends GenericDAO<SolicitudAlquiler> {
     public  List<SolicitudAlquiler> SolicitudAlquiler(Integer campo);
}
