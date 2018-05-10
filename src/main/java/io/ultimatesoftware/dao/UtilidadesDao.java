package io.ultimatesoftware.dao;

import io.ultimatesoftware.entities.Canton;
import io.ultimatesoftware.entities.Patologia;
import io.ultimatesoftware.sghc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UtilidadesDao {

    private Set<Canton> cantonSet = new HashSet<>();
    public ObservableList<String> getProvincias(){
        EntityManager em= Connection.emf.createEntityManager();
        ObservableList<String> provincias = FXCollections.observableArrayList(
                em.createNativeQuery("select descripcion from provincia order by descripcion").getResultList());
        em.close();
        return provincias;
    }
    public ObservableList<String> getCantones(String Provincia){
        if(cantonSet.isEmpty()) {
            EntityManager em = Connection.emf.createEntityManager();
            cantonSet = new HashSet<>();
            cantonSet.addAll(em.createQuery("From Canton order by provinciaid").getResultList());
            em.close();
        }

        List<String> cantonList= cantonSet.stream().filter(x -> x.getProvincia().getDescripcion().equals(Provincia)).map(
                Canton::getDescripcion).sorted().collect(Collectors.toList());
        ObservableList<String> cantones = FXCollections.observableArrayList( cantonList );

        return cantones;
    }

    public ObservableList<String> getEstadosCiviles(){

        ObservableList<String> estadosCiv = FXCollections.observableArrayList(
                "Casado","Soltero","Viudo","Union Libre","Divorciado"
        );
        return estadosCiv;
    }

    public ObservableList<String> getEstudios(){

        ObservableList<String> estudios = FXCollections.observableArrayList(
                "Tercer Nivel","Secundaria","Primaria","Ninguna"
        );
        return estudios;
    }

    public ObservableList<String> getAntecedendetes(){

        ObservableList<String> antecedentes = FXCollections.observableArrayList(
                "Diabetes","Tb Pulmonar","Hipertensión","Gemelares"
        );
        return antecedentes;
    }
    public ObservableList<String> getGrupoSangre(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "A","B","AB","O"
        );
        return list;
    }
    public ObservableList<String> getPositivoNegativo(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "Positivo","Negativo"
        );
        return list;
    }
    public ObservableList<String> getPresentacion(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "Cefálica","Pelviana","Transversa"
        );
        return list;
    }
    public ObservableList<String> getSexo(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "M","F"
        );
        return list;
    }
    public ObservableList<String> getReanimacionRespiratoria(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "No","Máscara","Tubo"
        );
        return list;
    }
    public ObservableList<String> getVdrl(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "Cefálica","Pelviana","Transversa"
        );
        return list;
    }
    public ObservableList<String> getExamenFisico(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "Normal","Anormal"
        );
        return list;
    }
    public ObservableList<String> getPeso(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "Adecuado","Pequeño","Grande"
        );
        return list;
    }

    public ObservableList<String> getAlimentos(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "Pecho","Mixto","Artificial"
        );
        return list;
    }
    public ObservableList<String> getEstadoEgreso(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "Sano","Traslado","Con Patologías","Fallece"
        );
        return list;
    }
    public ObservableList<String> getAnticoncepcion(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "Ninguna","Referida","Condón","D/U","Píldora","Ligadura",
                "Inyectables","Ritmo","Otro"
        );
        return list;
    }
    public ObservableList<String> getPatologias(String Grupo){

        EntityManager em= Connection.emf.createEntityManager();
        ObservableList<String> provincias = FXCollections.observableArrayList(
                em.createNativeQuery("select descripcion from patologia where grupo='"+Grupo+"'").getResultList());
        em.close();
        return provincias;
    }
    public ObservableList<String> getLoquios(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "Ninguna","Referida","Condón","D/U","Píldora","Ligadura",
                "Inyectables","Ritmo","Otro"
        );
        return list;
    }
    public ObservableList<String> getInicio(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "Esporádico","Inducido","Cesaria Electiva"
        );
        return list;
    }
    public ObservableList<String> getTerminacion(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "Espontáneo","Forcep","Cesaria","Otra"
        );
        return list;
    }
    public ObservableList<String> getMembranas(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "Int","Rot"
        );
        return list;
    }
    public ObservableList<String> getMuerteIntraUte(){

        ObservableList<String> list = FXCollections.observableArrayList(
                "No","Si","Si emb.","Si ignora momento"
        );
        return list;
    }
    public ObservableList<String> getMedicacionParto(){
        ObservableList<String> list = FXCollections.observableArrayList(
                "Ninguna","Anest. Reg.","Anest. General","Anest. Tranquil.","Ocitoc.","Antibióticos","Otros"
        );
        return list;
    }
    public ObservableList<String> getNivelAtencion(){
        ObservableList<String> list = FXCollections.observableArrayList(
                "3°","2°","1°","Domic","Otro"
        );
        return list;
    }
    public ObservableList<String> getAtendio(){
        ObservableList<String> list = FXCollections.observableArrayList(
                "Médico","Enf. Ost.","Auxiliar","Estudiante Parto","Otro"
        );
        return list;
    }
}
