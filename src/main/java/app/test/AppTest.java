package app.test;

import app.dao.CampoDAO;
import app.dao.LocalDAO;
import app.dao.PersonaDAO;
import app.dao.ServicioDAO;
import app.dao.SocioDAO;
import app.dao.UsuarioDAO;
import app.model.Campo;
import app.model.Local;
import app.model.Persona;
import app.model.Servicio;
import app.model.Socio;
import app.model.Usuario;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    public static void main(String[] args) {
        //AppTest.deleteLocal(); AppTest.updateLocal();AppTest.addLocal(); AppTest.listLocal();AppTest.getLocal();
        // AppTest.addPersona();  AppTest.updatePersona();AppTest.getPersona(); AppTest.listPersona(); AppTest.deletePersona();
        //AppTest.addCampo();AppTest.listCampo(); AppTest.deleteCampo();AppTest.updateCampo();AppTest.getCampo(); AppTest.addCampo();
        //AppTest.getServico(); AppTest.deleteServicio();AppTest.addServicio(); AppTest.listServicio();
        // AppTest.listSocio();AppTest.addSocio();
        //AppTest.addUsuario();
        AppTest.listUsuario();
    }
    public static void addUsuario() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("usuarioDAO");
        PersonaDAO personaDAO = (PersonaDAO) context.getBean("personaDAO");

        Persona persona = personaDAO.get(new Persona(1L));

        Usuario usuario = new Usuario();
        usuario.setUsuario("carmen");
        usuario.setPassword("123");
        usuario.setEstado(1L);
        usuario.setPersona(persona);

        usuarioDAO.save(usuario);

        System.out.println(usuario.getId() + " " + usuario.getPersona().getPaterno());
    }
       public static void listUsuario() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        UsuarioDAO usuarioDAO = (UsuarioDAO) context.getBean("usuarioDAO");

        List<Usuario> usuarios = usuarioDAO.list();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getId() + " " + usuario.getUsuario());
        }
    }
    
    public static void listSocio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        SocioDAO socioDAO = (SocioDAO) context.getBean("socioDAO");

        List<Socio> socios = socioDAO.list();
        for (Socio socio : socios) {
            System.out.println(socio.getId() + " " + socio.getPersona().getNombres());
        }
    }

    public static void addSocio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        SocioDAO socioDAO = (SocioDAO) context.getBean("socioDAO");
        PersonaDAO personaDAO = (PersonaDAO) context.getBean("personaDAO");

        Persona persona = personaDAO.get(new Persona(1L));

        Socio socio = new Socio();
        socio.setPersona(persona);

        socioDAO.save(socio);

        System.out.println(socio.getId() + " " + socio.getPersona().getPaterno());
    }

    public static void getServico() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        Servicio servicio = servicioDAO.get(new Servicio(2L));
        System.out.println(servicio.getId() + " " + servicio.getDescripcion());
    }

    public static void updateServicio() {
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

    public static void addServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        Servicio servicio = new Servicio();
        servicio.setDescripcion("Alquiler de pelotas");
        servicio.setCostoHora(100D);
        servicioDAO.save(servicio);
        System.out.println(servicio.getId() + " " + servicio.getDescripcion());
    }

    public static void listServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");

        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        List<Servicio> servicios = servicioDAO.list();
        for (Servicio servicio : servicios) {
            System.out.println(servicio.getDescripcion() + " " + servicio.getCostoHora());
        }
    }

    public static void deleteServicio() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        Servicio servicio = new Servicio();
        servicio.setId(1L);
        servicioDAO.delete(servicio);
    }

    public static void deletePersona() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        PersonaDAO personaDAO = (PersonaDAO) context.getBean("personaDAO");
        Persona persona = new Persona();
        persona.setId(2L);
        personaDAO.delete(persona);
    }

    public static void listPersona() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");

        PersonaDAO personaDAO = (PersonaDAO) context.getBean("personaDAO");
        List<Persona> personas = personaDAO.list();
        for (Persona persona : personas) {

            System.out.println(persona.getNombres() + " " + persona.getMaterno());
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
        PersonaDAO personaDAO = (PersonaDAO) context.getBean("personaDAO");
        Persona persona = new Persona();
        persona.setNombres("Carmen");
        persona.setPaterno("Asencio");
        persona.setMaterno("Quesquen");
        persona.setEmail("carmenasencioquesquen@gmail.com");
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

    public static void getCampo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        CampoDAO campoDAO = (CampoDAO) context.getBean("campoDAO");

        Campo campo = campoDAO.get(new Campo(1L));
        System.out.println(campo.getId() + " " + campo.getDescripcion() + " " + campo.getLocal().getDescripcion());
    }

    public static void listCampo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        CampoDAO campoDAO = (CampoDAO) context.getBean("campoDAO");

        Campo campo = campoDAO.get(new Campo(5L));

        System.out.println(campo.getId() + " " + campo.getDescripcion()
                + " " + campo.getLocal().getDescripcion());
    }

    public static void updateCampo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        CampoDAO campoDAO = (CampoDAO) context.getBean("campoDAO");
        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");
        Campo campo = new Campo();
        Local local = localDAO.get(new Local(2L));
        campo.setId(2L);
        campo.setEstado(1);
        campo.setDescripcion("Campo de Baile");
        campo.setCostoHora(200D);
        campo.setLocal(local);

        campoDAO.update(campo);

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

    public static void deleteCampo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        CampoDAO campoDAO = (CampoDAO) context.getBean("campoDAO");
        Campo campo = new Campo();
        campo.setId(4L);
        campoDAO.delete(campo);
    }
}
