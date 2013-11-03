package app.test;

import app.dao.CampoDAO;
import app.dao.LocalDAO;
import app.dao.PersonaDAO;
import app.dao.ServicioDAO;
import app.dao.SocioDAO;
import app.model.Campo;
import app.model.Local;
import app.model.Persona;
import app.model.Servicio;
import app.model.Socio;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    public static void main(String[] args) {
        //AppTest.deleteLocal(); AppTest.updateLocal();AppTest.addLocal(); AppTest.listLocal();AppTest.getLocal();
       // AppTest.addPersona();  AppTest.updatePersona();AppTest.getPersona(); AppTest.listPersona();
        AppTest.getLocal();
        
        //AppTest.getAll();
       // AppTest.addCampo();
        //AppTest.addCampo();
        //AppTest.listCampo();
    }


      public static void listPersona() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");

        PersonaDAO personaDAO = (PersonaDAO) context.getBean("personaDAO");
        List<Persona> personas = personaDAO.list();
        for (Persona persona : personas) {

            System.out.println(persona.getNombres()+ " " + persona.getMaterno());
        }
    }
       public static void getPersona() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        PersonaDAO personaDAO = (PersonaDAO) context.getBean("personaDAO");
        Persona persona = personaDAO.get(new Persona(1L));
        System.out.println(persona.getId() + " " + persona.getNombres());
    }
        public static void updatePersona() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        PersonaDAO personaDAO = (PersonaDAO) context.getBean("personaDAO");
        Persona persona = new Persona();
        persona.setId(1L);
        persona.setNombres("Carmen");
        persona.setMaterno("Asencio");
        persona.setPaterno("Quesquen");
        persona.setDireccion("Callao");
        persona.setCelular("968835659");
        
        persona.setEmail("carmenasencioquesquen@gmail.com");
        personaDAO.update(persona);

    }
    
       public static void addPersona() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        PersonaDAO personaDAO =  (PersonaDAO) context.getBean("personaDAO");
        Persona persona = new Persona();
        persona.setNombres("Carmen");
        persona.setPaterno("Asencio");
        persona.setMaterno("Quesquen");
        persona.setMaterno("carmenasencioquesquen@gmail.com");
        personaDAO.save(persona);
        System.out.println(persona.getId() + " " + persona.getPaterno());
    }
    public static void deleteLocal() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");
        Local local = new Local();
        local.setId(3L);
        localDAO.delete(local);
    }

    public static void updateLocal() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");
        Local local = new Local();
        local.setId(3L);
        local.setDireccion("Callao");
        local.setDescripcion("carmen");
        local.setTelefono("968835659");
        localDAO.update(local);

    }

    public static void addLocal() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");
        Local local = new Local();
        local.setDireccion("Callao");
        local.setDescripcion("lo");
        local.setTelefono("968835659");
        localDAO.save(local);
        System.out.println(local.getId() + " " + local.getDescripcion());

    }

    public static void listLocal() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");

        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");
        List<Local> locales = localDAO.list();
        for (Local local : locales) {

            System.out.println(local.getDescripcion() + " " + local.getTelefono());
        }
    }

    public static void getLocal() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");
        Local local = localDAO.get(new Local(2L));
        System.out.println(local.getId() + " " + local.getDescripcion());
    }

    
    public static void getServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");

        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        List<Servicio> servicios = servicioDAO.list();
        for (Servicio servicio : servicios) {
            System.out.println(servicio.getDescripcion() + " " + servicio.getCostoHora());
        }
    }

    public static void listCampo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        CampoDAO campoDAO = (CampoDAO) context.getBean("campoDAO");

        Campo campo = campoDAO.get(new Campo(5L));

        System.out.println(campo.getId() + " " + campo.getDescripcion()
                + " " + campo.getLocal().getDescripcion());
    }

    public static void addCampo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");
        CampoDAO campoDAO = (CampoDAO) context.getBean("campoDAO");

        Local local = localDAO.get(new Local(131L));

        Campo campo = new Campo();
        campo.setCostoHora(12D);
        campo.setDescripcion("Campos de Ludo");
        //campo.setEstado(1);
        campo.setLocal(local);
        campo.setTipo(1);

        campoDAO.save(campo);

        System.out.println(campo.getId() + " " + campo.getDescripcion());
    }
}
