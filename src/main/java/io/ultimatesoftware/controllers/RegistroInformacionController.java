package io.ultimatesoftware.controllers;

import antlr.debug.ParserTokenAdapter;
import io.ultimatesoftware.dao.PacienteDao;
import io.ultimatesoftware.dao.UtilidadesDao;
import io.ultimatesoftware.entities.*;
import io.ultimatesoftware.sghc.Connection;
import io.ultimatesoftware.sghc.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.PrefixSelectionComboBox;
import org.controlsfx.control.ToggleSwitch;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.validation.*;
import org.controlsfx.validation.decoration.StyleClassValidationDecoration;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class RegistroInformacionController implements Initializable {

    private Boolean editar = false;
    private HomeController homeController;
    protected EntityManager em;
    //Infp Personal
    public CustomTextField txtIdentificacion;
    public CustomTextField txtPrimerNombre;
    public CustomTextField txtSegundoNombre;
    public CustomTextField txtPrimerApellido;
    public CustomTextField txtSegundoApellido;
    public DatePicker dtpFechaNac;
    public PrefixSelectionComboBox cmbProvincia;
    public PrefixSelectionComboBox cmbCanton;
    public CustomTextField txtDireccion;
    public  CustomTextField txtTelefono;
    public PrefixSelectionComboBox cmbEstadoCivil;
    public CustomTextField txtEmail;
    public PrefixSelectionComboBox cmbEstudios;
    public CheckBox chkAlfabeta;

    //switch
    public TitledPane tpaneAntecedentes;
    public TitledPane tpaneAntecedentesObstetricos;
    public TitledPane tpaneEmbarazo;
    public TitledPane tpaneConsultaEmbarazo;
    public TitledPane tpaneRecienNacido;
    public TitledPane tpaneEgreso;
    public TitledPane tpanePuerperio;
    public TitledPane tpaneParto;
    public TitledPane tpaneTrabajoParto;
    public ToggleSwitch switchAntecedentes;
    public ToggleSwitch switchEmbarazo;
    public ToggleSwitch switchConsultaEmbarazo;
    public ToggleSwitch switchRecienNacido;
    public ToggleSwitch switchEgreso;
    public ToggleSwitch switchPuerperio;
    //antecedentes
    public CheckComboBox chkcmbAntecedentesPersonales;
    public CheckComboBox chkcmbAntecedentesFamiliares;
    public CustomTextField txtAntecedentesOtros;
    public CheckBox chkRn;
    public CheckBox chkGemelares;
    public Spinner txtGestas;
    public Spinner txtViven;
    public Spinner txtNacidosMuertos;
    public Spinner txtNacidosVivos;
    public Spinner txtCesareas;
    public Spinner txtVaginales;
    public Spinner txtAbortos;
    public Spinner txtPartos;
    public CustomTextField txtRn;
    public Spinner txtMuertoDespPriSemana;
    public Spinner txtMuertoPrimeraSemana;
    public DatePicker dtpFechaFinAnteriorEmbrazo;
    //////
    public CustomTextField txtTalla;
    public DatePicker dtpFum;
    public DatePicker dtpFpp;
    public CustomTextField txtAntitetanica1Mes;
    public CustomTextField txtAntitetanica2Mes;
    public PrefixSelectionComboBox cmbGrupoSanguineo;
    public PrefixSelectionComboBox cmbRh;
    public CustomTextField txtCigarrillosPorDia;
    public DatePicker dtpHb1;
    public DatePicker dtpHb2;
    public CustomTextField txtHb1;
    public CustomTextField txtHb2;
    public PrefixSelectionComboBox cmbVdrl;
    public CustomTextField txtPesoAnterior;
    public DatePicker dtpGlucosa;
    public CustomTextField txtGlucosa;
    public DatePicker dtpFechaVdrl;
    public CheckBox chkDudas;
    public CheckBox chkPelvis;
    public CheckBox chkAntitetanica;
    public CheckBox chkExClinico;
    public CheckBox chkSensibilidad;
    public CheckBox chkFuma;
    public CheckBox chkExMamas;
    public CheckBox chkExOdontologico;
    public CheckBox chkPapanicolao;
    public CheckBox chkColposcopia;
    public CheckBox chkCervix;
    public CheckBox chkHospitalizacion;
    public CheckBox chkTraslado;
    public CustomTextField txtLugarTraslado;
    //
    public DatePicker dtpFechaConsulta;
    public CustomTextField txtSemanaAmenorreas;
    public CustomTextField txtPeso;
    public CustomTextField txtTensionArterialConsulta;
    public CustomTextField txtAltUterina;
    public CustomTextField txtFcf;
    public CustomTextField txtMovFetal;
    public CustomTextField txtEdema;
    public CustomTextField txtAlbuminuria;
    public CustomTextField txtExaminador;
    public CustomTextField txtSangradoGenital;
    public PrefixSelectionComboBox cmbPresentacion;
    public Button btnNuevoConsulta;
    public Button btnEliminarConsulta;
    public Button txtAgregarConsulta;
    public TableView<EmbarazoConsulta> gridConsulta;
    public PrefixSelectionComboBox cmbSexo;
    public PrefixSelectionComboBox cmbPesoEg;
    public PrefixSelectionComboBox cmbReanimacion;
    public CheckComboBox chkcmbPatologiasRn;
    public PrefixSelectionComboBox cmbVdrlRn;
    public CustomTextField txtPesoNacer;
    public CustomTextField txtTallaRn;
    public CustomTextField txtPerCefalico;
    public CustomTextField txtEdadExFisico;
    public CustomTextField txtApgar1Min;
    public CustomTextField txtApgar6Min;
    public PrefixSelectionComboBox cmbExFisico;
    public PrefixSelectionComboBox cmbGrupoSanguineoRn;
    public TextArea txtObservacionesRn;
    public CheckBox chkAloj;
    public CheckBox chkHospitalizado;
    public CheckBox chkBcg;
    public CheckBox chkPvo;
    public PrefixSelectionComboBox cmbRhRn;
    public DatePicker dtpFechaEgresoRn;
    public CustomTextField txtPesoEgresoRn;
    public PrefixSelectionComboBox cmbAlimento;
    public PrefixSelectionComboBox cmbEstadoRn;
    public CustomTextField txtResponsableRn;
    public CustomTextField txtResponsableMadre;
    public DatePicker dtpFechaEgreso;
    public PrefixSelectionComboBox cmbEstado;
    public CustomTextField txtPulso;
    public DatePicker dtpFechaPuerperio;
    public CustomTextField txtTemperatura;
    public CustomTextField txtTensionArterialPuerperio;
    public CustomTextField txtInvoUterina;
    public CustomTextField txtCaracteristicasLoquios;
    public Button btnNuevoPuerperio;
    public Button btnEliminarPuerperio;
    public Button btnAgregarPuerperio;
    public TableView<Puerperio> gridPuerperio;
    public CustomTextField txtHoraPostParto;

    //columnas table consulta
    public TableColumn colFechaConsulta =new TableColumn();
    public TableColumn colSemanaAmenorreas =new TableColumn();
    public TableColumn colPeso =new TableColumn();
    public TableColumn colTensionArterial =new TableColumn();
    public TableColumn colAlturaUterina =new TableColumn();
    public TableColumn colPresentacion =new TableColumn();
    public TableColumn colFcf =new TableColumn();
    public TableColumn colMovimientoFetal =new TableColumn();
    public TableColumn colEdema =new TableColumn();
    public TableColumn colAlbuminuria =new TableColumn();
    public TableColumn colSangradoGenital =new TableColumn();
    public TableColumn colExaminador =new TableColumn();
    public ObservableList<EmbarazoConsulta> listaConsulta =FXCollections.observableArrayList();

    public ValidationSupport v= new ValidationSupport();
    //parto
    public ToggleSwitch switchParto;
    public CheckBox chkAborto;
    public Spinner txtNConsultaPrenatal;
    public CheckBox chkHospital;
    public CheckBox chkCarnet;
    public DatePicker dtpFechaIngreso;
    public CustomTextField txtTemperaturaParto;
    public CustomTextField txtEdadGestacional;
    public PrefixSelectionComboBox cmbPresentacionParto;
    public CheckBox chkTamanoFetalAdecuado;
    public PrefixSelectionComboBox cmbInicioParto;
    public PrefixSelectionComboBox cmbMembranas;
    public DatePicker dtpFechaRuptura;
    public CustomTextField txtHoraRuptura;
    public CustomTextField txtIndicacion;
    public DatePicker dtpFechaTerminacion;
    public PrefixSelectionComboBox cmbTerminacion;
    public CheckComboBox chkcmbMedicacionParto;
    public PrefixSelectionComboBox cmbNivelAtencion;
    public PrefixSelectionComboBox cmbAtendioParto;
    public PrefixSelectionComboBox cmbAtendioNeonato;
    public CheckComboBox chkcmbPatologiasParto;
    public PrefixSelectionComboBox cmbMuerteIntraUte;
    public CheckBox chkEpisotomia;
    public CheckBox chkDesgarros;
    public CheckBox chkAlumbEsponta;
    public CheckBox chkPlacentaCompl;
    public CustomTextField txtnombreAtenParto;
    public CustomTextField txtnombreAtenNeo;
    public CustomTextField txtnombreRn;
    public ToggleSwitch switchTrabParto;
    public CustomTextField txtHoraTrabParto;
    public CustomTextField txtContracciones;
    public CustomTextField txtTensionArterial;
    public CustomTextField txtAlturaUteTrabParto;
    public CustomTextField txtPosicionTrabParto;
    public CustomTextField txtDilatacionCerv;
    public CustomTextField txtMeconioTrabParto;
    public CustomTextField txtNombreExaminador;
    public CustomTextField txtFcfTrabParto;
    public TableView<TrabajoParto> gridTrabParto ;
    //columnas trabparto
    public TableColumn colHora=new TableColumn();
    public TableColumn colContracciones=new TableColumn();
    public TableColumn colTension=new TableColumn();
    public TableColumn colFcfTrabParto=new TableColumn();
    public TableColumn colAltUterina=new TableColumn();
    public TableColumn colPosicion=new TableColumn();
    public TableColumn colDilatacion=new TableColumn();
    public TableColumn colMeconio=new TableColumn();
    public TableColumn colNombreExam=new TableColumn();
    //Puerperio
    public TableColumn colHoraPostParto=new TableColumn();
    public TableColumn colTemperatura=new TableColumn();
    public TableColumn colPulso=new TableColumn();
    public TableColumn colPresionArterial=new TableColumn();
    public TableColumn colUterina=new TableColumn();
    public TableColumn colLoquios=new TableColumn();
    //
    public ObservableList<TrabajoParto> listaTrabParto =FXCollections.observableArrayList();
    //
    public PrefixSelectionComboBox cmbAnticoncepcion;
    private UtilidadesDao uDao = new UtilidadesDao();
    private Embarazo emb = new Embarazo();
    private Collection<AdmisionPorParto> listaParto = new ArrayList<>();
    private Collection<RecienNacido> listaRecienNacido = new ArrayList<>();
    private Collection<EgresoRecienNacido> listaEgresoRecienNacido = new ArrayList<>();
    private ObservableList<Puerperio> listaPuerperio =FXCollections.observableArrayList();
    private AdmisionPorParto parto = new AdmisionPorParto();
    private RecienNacido rn = new RecienNacido();
    private Paciente p = new Paciente();
    private Antecedente a = new Antecedente();
    private  EgresoRecienNacido eg = new EgresoRecienNacido();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {


            llenarCombos();
            cmbProvincia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    cmbCanton.setItems(uDao.getCantones(cmbProvincia.getSelectionModel().getSelectedItem().toString()));
                    cmbCanton.getSelectionModel().selectFirst();
                }
            });

            //eventos para los switch de editar
            switchAntecedentes.selectedProperty().addListener((observable) -> {
                tpaneAntecedentes.setDisable(!tpaneAntecedentes.isDisable());
                tpaneAntecedentesObstetricos.setDisable(!tpaneAntecedentesObstetricos.isDisable());
            });
            switchEmbarazo.selectedProperty().addListener((observable) -> tpaneEmbarazo.setDisable(!tpaneEmbarazo.isDisable()));
            switchConsultaEmbarazo.selectedProperty().addListener((observable) -> tpaneConsultaEmbarazo.setDisable(!tpaneConsultaEmbarazo.isDisable()));
            switchRecienNacido.selectedProperty().addListener((observable) -> tpaneRecienNacido.setDisable(!tpaneRecienNacido.isDisable()));
            switchEgreso.selectedProperty().addListener((observable) -> tpaneEgreso.setDisable(!tpaneEgreso.isDisable()));
            switchPuerperio.selectedProperty().addListener((observable) -> tpanePuerperio.setDisable(!tpanePuerperio.isDisable()));
            switchParto.selectedProperty().addListener((observable -> tpaneParto.setDisable(!tpaneParto.isDisable())));
            switchTrabParto.selectedProperty().addListener((observable -> tpaneTrabajoParto.setDisable(!tpaneTrabajoParto.isDisable())));
            //
            inicializarColumnas();
            iniciarSpinner();
            registroValidaciones();



        } catch (Exception ex) {
            Message m = new Message();
            m.showMessage("Error",ex.toString(),Alert.AlertType.ERROR);

        }

    }

    public void llenarCombos(){
        //info personal
        cmbProvincia.getItems().setAll(uDao.getProvincias());
        cmbProvincia.getSelectionModel().select(12);
        cmbCanton.getItems().setAll(uDao.getCantones(cmbProvincia.getSelectionModel().getSelectedItem().toString()));
        cmbCanton.getSelectionModel().selectFirst();
        cmbEstadoCivil.getItems().setAll(uDao.getEstadosCiviles());
        cmbEstadoCivil.getSelectionModel().selectFirst();
        cmbEstudios.getItems().setAll(uDao.getEstudios());
        cmbEstudios.getSelectionModel().selectLast();
        //Antecedentes
        chkcmbAntecedentesPersonales.getItems().setAll(uDao.getAntecedendetes());
        chkcmbAntecedentesFamiliares.getItems().setAll(uDao.getAntecedendetes());
        //Embarazo
        cmbGrupoSanguineo.getItems().setAll(uDao.getGrupoSangre());
        cmbRh.getItems().setAll(uDao.getPositivoNegativo());
        cmbVdrl.getItems().setAll(uDao.getPositivoNegativo());
        //Consulta Embarazo
        cmbPresentacion.getItems().setAll(uDao.getPresentacion());
        //parto
        cmbPresentacionParto.getItems().setAll(uDao.getPresentacion());
        cmbInicioParto.getItems().setAll(uDao.getInicio());
        cmbTerminacion.getItems().setAll(uDao.getTerminacion());
        cmbMembranas.getItems().setAll(uDao.getMembranas());
        chkcmbMedicacionParto.getItems().setAll(uDao.getPatologias("parto"));
        cmbNivelAtencion.getItems().setAll(uDao.getNivelAtencion());
        cmbAtendioParto.getItems().setAll(uDao.getAtendio());
        cmbAtendioNeonato.getItems().setAll(uDao.getAtendio());
        chkcmbMedicacionParto.getItems().setAll(uDao.getMedicacionParto());
        cmbMuerteIntraUte.getItems().setAll(uDao.getMuerteIntraUte());
        //trabajo de parto
        //Recien Nacido
        cmbSexo.getItems().setAll(uDao.getSexo());
        cmbReanimacion.getItems().setAll(uDao.getReanimacionRespiratoria());
        cmbPesoEg.getItems().setAll(uDao.getPeso());
        cmbVdrlRn.getItems().setAll(uDao.getVdrl());
        cmbRhRn.getItems().setAll(uDao.getPositivoNegativo());
        cmbExFisico.getItems().setAll(uDao.getExamenFisico());
        cmbGrupoSanguineoRn.getItems().setAll(uDao.getGrupoSangre());
        chkcmbPatologiasRn.getItems().setAll(uDao.getPatologias("reciennacido"));
        // Egreso
        cmbEstadoRn.getItems().setAll(uDao.getEstadoEgreso());
        cmbAlimento.getItems().setAll(uDao.getAlimentos());
        cmbEstado.getItems().setAll(uDao.getEstadoEgreso());
        cmbAnticoncepcion.getItems().setAll(uDao.getAnticoncepcion());


    }
    public void iniciarSpinner(){

        txtPartos.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        txtGestas.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        txtViven.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        txtNacidosMuertos.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        txtNacidosVivos.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        txtMuertoPrimeraSemana.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        txtMuertoDespPriSemana.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        txtAbortos.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        txtCesareas.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        txtVaginales.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, 0));
        txtNConsultaPrenatal.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,99,0));
    }
    public void registroValidaciones(){
        Validator valCedRuc = Validator.createRegexValidator("Solo se permiten números! Entre 10 y 13 dígitos.","[0-9]{10,13}",Severity.ERROR);
        Validator valLetras = Validator.createRegexValidator("Solo se permiten letras!.","[a-zA-Z\\s]{1,25}",Severity.ERROR);
        Validator valNumeros = Validator.createRegexValidator("Solo se permiten números!.","[0-9]*",Severity.ERROR);
        Validator valEmail = Validator.createRegexValidator("Ingresar un email con fornmáto válido","[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",Severity.ERROR);
        Validator valRequerido = Validator.createEmptyValidator("Este campo es requerido",Severity.ERROR);

        v.setErrorDecorationEnabled(true);
        v.setValidationDecorator(new StyleClassValidationDecoration("error","warning"));
        //validacion info personal
        v.registerValidator(txtIdentificacion, valCedRuc);
        v.registerValidator(txtPrimerApellido,valLetras);
        v.registerValidator(txtSegundoApellido,valLetras);
        v.registerValidator(txtPrimerNombre,valLetras);
        v.registerValidator(txtSegundoNombre,valLetras);
        v.registerValidator(cmbProvincia,valLetras);
        v.registerValidator(cmbCanton,valLetras);
        v.registerValidator(txtDireccion,valLetras);
        //v.registerValidator(txtEmail,valEmail);
       // v.registerValidator(txtTelefono, valNumeros);
        v.registerValidator(dtpFechaNac,valRequerido);
        //validacion antecedente4s
        v.registerValidator(txtPartos,valNumeros);
    }

    public void inicializarColumnas() {

        colFechaConsulta.setCellValueFactory(new PropertyValueFactory<EmbarazoConsulta, String>("fecha"));
        colFechaConsulta.setText("Fecha Consulta");
        colAlbuminuria.setCellValueFactory(new PropertyValueFactory<EmbarazoConsulta, String>("albuminuria"));
        colAlbuminuria.setText("Albuminuria");
        colAlturaUterina.setCellValueFactory(new PropertyValueFactory<EmbarazoConsulta, String>("alturaUterina"));
        colAlturaUterina.setText("Altura Uterina");
        colExaminador.setCellValueFactory(new PropertyValueFactory<EmbarazoConsulta, String>("nombreExaminador"));
        colExaminador.setText("Examinador");
        colFcf.setCellValueFactory(new PropertyValueFactory<EmbarazoConsulta, String>("fcf"));
        colFcf.setText("FCF");
        colEdema.setCellValueFactory(new PropertyValueFactory<EmbarazoConsulta, String>("edema"));
        colEdema.setText("Edema");
        colMovimientoFetal.setCellValueFactory(new PropertyValueFactory<EmbarazoConsulta, String>("movFetal"));
        colMovimientoFetal.setText("Movimiento Fetal");
        colPeso.setCellValueFactory(new PropertyValueFactory<EmbarazoConsulta, String>("peso"));
        colPeso.setText("Peso");
        colPresentacion.setCellValueFactory(new PropertyValueFactory<EmbarazoConsulta, String>("presentacion"));
        colPresentacion.setText("Presentacion");
        colSangradoGenital.setCellValueFactory(new PropertyValueFactory<EmbarazoConsulta, String>("sangradoGenital"));
        colSangradoGenital.setText("Sangrado Genital");
        colTensionArterial.setCellValueFactory(new PropertyValueFactory<EmbarazoConsulta, String>("presionArterial"));
        colTensionArterial.setText("Tension Arterial");
        colSemanaAmenorreas.setCellValueFactory(new PropertyValueFactory<EmbarazoConsulta, String>("semanasAmenorreas"));
        colSemanaAmenorreas.setText("Semana de Amenorreas");
        gridConsulta.getColumns().addAll(colFechaConsulta, colSemanaAmenorreas, colPeso, colTensionArterial, colAlturaUterina,
                colPresentacion, colFcf, colMovimientoFetal, colEdema, colAlbuminuria, colSangradoGenital, colExaminador);

        //trabajoparto
        colHora.setCellValueFactory(new PropertyValueFactory<TrabajoParto, String>("hora"));
        colContracciones.setCellValueFactory(new PropertyValueFactory<TrabajoParto, String>("contracciones"));
        colTensionArterial.setCellValueFactory(new PropertyValueFactory<TrabajoParto, String>("tensionArterial"));
        colFcfTrabParto.setCellValueFactory(new PropertyValueFactory<TrabajoParto, String>("fcf"));
        colAltUterina.setCellValueFactory(new PropertyValueFactory<TrabajoParto, String>("altura"));
        colPosicion.setCellValueFactory(new PropertyValueFactory<TrabajoParto, String>("posicion"));
        colDilatacion.setCellValueFactory(new PropertyValueFactory<TrabajoParto, String>("dilatacion"));
        colMeconio.setCellValueFactory(new PropertyValueFactory<TrabajoParto, String>("meconio"));
        colNombreExam.setCellValueFactory(new PropertyValueFactory<TrabajoParto, String>("nombreExaminador"));
        colHora.setText("Hora");
        colNombreExam.setText("Examinador");
        colMeconio.setText("Meconio");
        colDilatacion.setText("Dilatacion");
        colContracciones.setText("contracciones");
        colPosicion.setText("Posición");
        colFcfTrabParto.setText("Fcf");
        colTensionArterial.setText("Tension Arterial");
        colAltUterina.setText("Altura Utrina");
        gridTrabParto.getColumns().addAll(colHora, colContracciones, colTensionArterial, colFcfTrabParto, colAltUterina,
                colPosicion, colDilatacion, colMeconio, colNombreExam);
        //Puerperio
        colHoraPostParto.setCellValueFactory(new PropertyValueFactory<Puerperio, String>("horaPostParto"));
        colTemperatura.setCellValueFactory(new PropertyValueFactory<Puerperio, String>("temperatura"));
        colPulso.setCellValueFactory(new PropertyValueFactory<Puerperio, String>("pulso"));
        colPresionArterial.setCellValueFactory(new PropertyValueFactory<Puerperio, String>("presionArterial"));
        colUterina.setCellValueFactory(new PropertyValueFactory<Puerperio, String>("uterina"));
        colLoquios.setCellValueFactory(new PropertyValueFactory<Puerperio, String>("caracteristicasLoquios"));
        colHoraPostParto.setText("Horas Post Parto");
        colTemperatura.setText("Temperatura");
        colPulso.setText("Pulso");
        colPresionArterial.setText("Presion Arterial");
        colUterina.setText("Uterina");
        colLoquios.setText("Caracteristicas Loquios");
        gridPuerperio.getColumns().addAll(colHoraPostParto,colTemperatura,colPulso,colPresionArterial,colUterina,
                colLoquios);
    }

    public void guardar() {
        Message m = new Message();
       // v.getValidationResult().getErrors().stream().
        try {
            em = Connection.emf.createEntityManager();
            em.getTransaction().begin();

            llenarInfo(p);

            if (switchAntecedentes.selectedProperty().getValue()) {

                llenarAntecedentes(a,p);
               // em.merge(emb);
            }
            if (switchEmbarazo.selectedProperty().getValue()) {
                llenarEmbarazo(emb, p);
                if (switchConsultaEmbarazo.selectedProperty().getValue())
                   emb.setEmbarazoConsultaCollection(listaConsulta);
                //em.merge(emb);
            }
            if(switchParto.isSelected()) {
                llenarParto(emb);
                emb.setPartoCollection(listaParto);
                if(switchTrabParto.isSelected())
                    parto.setTrabajoPartoCollection(listaTrabParto);
             //   em.merge(emb);
            }
            if(switchRecienNacido.isSelected()){
                llenarRecienNacido();
                parto.setRecienNacidoCollection(listaRecienNacido);
               // em.merge(emb);
            }
            if(switchEgreso.isSelected()){
                llenarEgreso();
                rn.setEgresoRecienNacidoCollection(listaEgresoRecienNacido);
                //em.merge(emb);
            }
            if(switchPuerperio.isSelected()){
                emb.setPuerperioCollection(listaPuerperio);
                //em.merge(emb);
            }
            em.merge(p);
            if(!txtIdentificacion.getText().trim().isEmpty())
                em.getTransaction().commit();
            m.showMessage("Info", "Datos Guardados Correctamente", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            em.getTransaction().rollback();
            m.showMessage("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
        em.close();

    }
    private void llenarInfo(Paciente p){
        if(!editar)
            p.setId(UUID.randomUUID());
        p.setIdentificacion(txtIdentificacion.getText().trim());
        p.setPrimerNombre(txtPrimerNombre.getText().trim());
        p.setSegundoNombre(txtSegundoNombre.getText().trim());
        p.setPrimerApellido(txtPrimerApellido.getText().trim());
        p.setSegundoApellido(txtSegundoApellido.getText().trim());
        p.setDireccion(txtDireccion.getText().trim());
        p.setEmail(txtEmail.getText().trim());
        p.setTelefono1(txtTelefono.getText().trim());
        p.setAlfabeta(chkAlfabeta.isSelected());
        p.setProvincia(cmbProvincia.getSelectionModel().getSelectedItem().toString());
        p.setCanton(cmbCanton.getSelectionModel().getSelectedItem().toString());
        p.setEstado('A');
        p.setEstadoCivil(cmbEstadoCivil.getSelectionModel().getSelectedItem().toString());
        p.setEstudios(cmbEstudios.getSelectionModel().getSelectedItem().toString());
        p.setFechaNacimiento( dtpFechaNac.getValue());

    }
    private void llenarAntecedentes(Antecedente a, Paciente p){

        a.setId(UUID.randomUUID());
        a.setAntecedentesPersonales(chkcmbAntecedentesPersonales.getCheckModel().getCheckedItems().toString());
        a.setAntecedentesFamiliares(chkcmbAntecedentesFamiliares.getCheckModel().getCheckedItems().toString());
        a.setAntecedentesOtros(txtAntecedentesOtros.getText().trim());
        a.setRnMenor2500(chkRn.isSelected());
        a.setCesareas(Integer.parseInt(txtCesareas.getValue().toString()));
        a.setFechaFinAnteriorEmbarazo(dtpFechaFinAnteriorEmbrazo.getValue());
        a.setGestas(Integer.parseInt(txtGestas.getValue().toString()));
        a.setMuertos1Semana(Integer.parseInt(txtMuertoPrimeraSemana.getValue().toString()));
        a.setMuertosmas1Semana(Integer.parseInt(txtMuertoDespPriSemana.getValue().toString()));
        a.setNacidosMuertos(Integer.parseInt(txtNacidosMuertos.getValue().toString()));
        a.setNacidosVivos(Integer.parseInt(txtNacidosVivos.getValue().toString()));
        a.setPartos(Integer.parseInt(txtPartos.getValue().toString()));
        if(!txtRn.getText().trim().isEmpty())
            a.setRnMayorPeso(BigDecimal.valueOf(Double.parseDouble(txtRn.getText().trim())));
        a.setVaginales(Integer.parseInt(txtVaginales.getValue().toString()));
        a.setViven(Integer.parseInt(txtViven.getValue().toString()));
        //a.setNingunoOmasEmbarazos(chk); no se incluyo en ui
        a.setGemelares(chkGemelares.isSelected());
        a.setPaciente(p);
    }
    public void llenarEmbarazo(Embarazo e,Paciente p){

        e.setId(UUID.randomUUID());
        e.setFechaRegistro(LocalDate.now());
        if(!txtPesoAnterior.getText().trim().isEmpty())
            e.setPesoAnterior(Integer.parseInt(txtPesoAnterior.getText().trim()));
        if(!txtTalla.getText().trim().isEmpty())
            e.setTalla(Integer.parseInt(txtTalla.getText().trim()));
        e.setFum(dtpFum.getValue());
        e.setFfp(dtpFpp.getValue());
        e.setDudas(chkDudas.isSelected());
        e.setAntitetanicaPrevia(chkAntitetanica.isSelected());
        if(!txtAntitetanica1Mes.getText().trim().isEmpty())
            e.setAntitetanicaActual1(Integer.parseInt(txtAntitetanica1Mes.getText().trim()));
        if(!txtAntitetanica2Mes.getText().trim().isEmpty())
            e.setAntitetanicaActual2(Integer.parseInt(txtAntitetanica2Mes.getText().trim()));
        if(!cmbGrupoSanguineo.getSelectionModel().isEmpty())
            e.setGrupoSanguineo(cmbGrupoSanguineo.getSelectionModel().getSelectedItem().toString());
        if(!cmbRh.getSelectionModel().isEmpty())
            e.setRh(cmbRh.getSelectionModel().getSelectedItem().toString());
        e.setSensibilidad(chkSensibilidad.isSelected());
        e.setFuma(chkFuma.isSelected());
        if(!txtCigarrillosPorDia.getText().trim().isEmpty())
            e.setCigarrilosPorDia(Integer.parseInt(txtCigarrillosPorDia.getText().trim()));
        e.setExClinico(chkExClinico.isSelected());
        e.setExMamas(chkExMamas.isSelected());
        e.setExOdontologico(chkExOdontologico.isSelected());
        e.setPelvis(chkPelvis.isSelected());
        e.setPapanicolao(chkPapanicolao.isSelected());
        e.setColposcopia(chkColposcopia.isSelected());
        e.setCervix(chkCervix.isSelected());
        if(!cmbVdrl.getSelectionModel().isEmpty())
            e.setVdrl(cmbVdrl.getSelectionModel().getSelectedItem().toString());
        e.setFechaVdrl(dtpFechaVdrl.getValue());
        if(!txtGlucosa.getText().trim().isEmpty())
            e.setGlucosa(Integer.parseInt(txtGlucosa.getText().trim()));
        e.setFechaGlucosa(dtpGlucosa.getValue());
        if(!txtHb1.getText().trim().isEmpty())
            e.setHb1(Integer.parseInt(txtHb1.getText().trim()));
        e.setFechaHb1(dtpHb1.getValue());
        if(!txtHb2.getText().trim().isEmpty())
            e.setHb2(Integer.parseInt(txtHb2.getText().trim()));
        e.setFechaHb2(dtpHb2.getValue());
        e.setHospitalizacion(chkHospitalizacion.isSelected());
        e.setTraslado(chkTraslado.isSelected());
        e.setLugar(txtLugarTraslado.getText().trim());
        e.setPaciente(p);
    }
    public void llenarParto(Embarazo e){

        parto.setEmbarazo(e);
        parto.setId(UUID.randomUUID());
        parto.setAborto(chkAborto.isSelected());
        parto.setAlumbEspont(chkAlumbEsponta.isSelected());
            if(!cmbAtendioNeonato.getSelectionModel().isEmpty())
                parto.setAtendioNeonatoCargo(cmbAtendioNeonato.getSelectionModel().getSelectedItem().toString());
            if(!cmbAtendioParto.getSelectionModel().isEmpty())
                parto.setAtendioPartoCargo(cmbAtendioParto.getSelectionModel().getSelectedItem().toString());
            if(!cmbPresentacion.getSelectionModel().isEmpty())
                parto.setPresentacion(cmbPresentacion.getSelectionModel().getSelectedItem().toString());
            if(!cmbInicioParto.getSelectionModel().isEmpty())
                parto.setInicio(cmbInicioParto.getSelectionModel().getSelectedItem().toString());
            if(!cmbMembranas.getSelectionModel().isEmpty())
                parto.setMembranas(cmbMembranas.getSelectionModel().getSelectedItem().toString());
            if(!chkcmbPatologiasParto.getCheckModel().isEmpty())
                parto.setPatologias(chkcmbPatologiasParto.getCheckModel().getCheckedItems().toString());
            if(!cmbTerminacion.getSelectionModel().isEmpty())
                parto.setTerminacion(cmbTerminacion.getSelectionModel().getSelectedItem().toString());
            if(!cmbMuerteIntraUte.getSelectionModel().isEmpty())
                parto.setMuerteIntegerraUt(cmbMuerteIntraUte.getSelectionModel().getSelectedItem().toString());
            if(!chkcmbMedicacionParto.getCheckModel().isEmpty())
                parto.setMedicacionParto(chkcmbMedicacionParto.getCheckModel().getCheckedItems().toString());
            if(!cmbNivelAtencion.getSelectionModel().isEmpty())
                parto.setNivelAtencion(cmbNivelAtencion.getSelectionModel().getSelectedItem().toString());
        parto.setConsultaPrenatal(Integer.parseInt(txtNConsultaPrenatal.getValue().toString()));
        parto.setEnHospital(chkHospital.isSelected());
        parto.setCarnet(chkCarnet.isSelected());
        parto.setFechaIngreso(dtpFechaIngreso.getValue());
            if(!txtTemperatura.getText().isEmpty())
                parto.setTemperatura(Float.parseFloat(txtTemperatura.getText().trim()));
            if(!txtEdadGestacional.getText().isEmpty())
                parto.setEdadGestacion(Integer.parseInt(txtEdadGestacional.getText().trim()));
        parto.setTamanoFetalAdecuado(chkTamanoFetalAdecuado.isSelected());
        parto.setFechaMembrana(dtpFechaRuptura.getValue());
        parto.setIndicacionPrincipal(txtIndicacion.getText());
        parto.setEpisiotomia(chkEpisotomia.isSelected());
        parto.setDesgarro(chkDesgarros.isSelected());
        parto.setPlacentaComp(chkPlacentaCompl.isSelected());
        parto.setNombreRn(txtnombreRn.getText().trim());
        parto.setAtendioNeonatoNombre(txtnombreAtenNeo.getText().trim());
        parto.setAtendioPartoNombre(txtnombreAtenParto.getText().trim());
            listaParto.add(parto);



    }
    private void llenarRecienNacido(){

        rn.setId(UUID.randomUUID());
        rn.setAdmisionPorParto(parto);
        rn.setAlojConjunto(chkAloj.isSelected());
        rn.setBcg(chkBcg.isSelected());
        rn.setHospitalizado(chkHospitalizado.isSelected());
        rn.setPvo(chkPvo.isSelected());
        if(!cmbSexo.getSelectionModel().isEmpty())
            rn.setSexo(cmbSexo.getSelectionModel().getSelectedItem().toString().charAt(0));
        if(!cmbPesoEg.getSelectionModel().isEmpty())
            rn.setPesoEdadGestacional(cmbPesoEg.getSelectionModel().getSelectedItem().toString());
        if(!cmbReanimacion.getSelectionModel().isEmpty())
            rn.setReaminRespir(cmbReanimacion.getSelectionModel().getSelectedItem().toString());
        if(!cmbVdrlRn.getSelectionModel().isEmpty())
            rn.setVdrl(cmbVdrlRn.getSelectionModel().getSelectedItem().toString());
        if(!chkcmbPatologiasRn.getCheckModel().isEmpty())
            rn.setPatologias(chkcmbPatologiasRn.getCheckModel().getCheckedItems().toString());
        if(!cmbExFisico.getSelectionModel().isEmpty())
            rn.setExamenFisico(cmbExFisico.getSelectionModel().getSelectedItem().toString());
        if(!cmbGrupoSanguineoRn.getSelectionModel().isEmpty())
            rn.setGrupoSanguineo(cmbGrupoSanguineoRn.getSelectionModel().getSelectedItem().toString());
        if(!cmbRhRn.getSelectionModel().isEmpty())
            rn.setRh(cmbRhRn.getSelectionModel().getSelectedItem().toString());
        if(!txtPesoNacer.getText().isEmpty())
            rn.setPesoNacer(Integer.parseInt(txtPesoNacer.getText().trim()));
        if(!txtTallaRn.getText().isEmpty())
            rn.setTalla(Integer.parseInt(txtTallaRn.getText().trim()));
        if(!txtPerCefalico.getText().isEmpty())
            rn.setPerCefalico(Integer.parseInt(txtPerCefalico.getText().trim()));
        if(!txtEdadExFisico.getText().isEmpty())
            rn.setEdadPorExFisico(Integer.parseInt(txtEdadExFisico.getText().trim()));
        if(!txtApgar1Min.getText().isEmpty())
            rn.setApgar1min(Integer.parseInt(txtApgar1Min.getText().trim()));
        if(!txtApgar6Min.getText().isEmpty())
            rn.setApgar5min(Integer.parseInt(txtApgar6Min.getText().trim()));
        if(!txtObservacionesRn.getText().isEmpty())
            rn.setObservaciones(txtObservacionesRn.getText().trim());
        listaRecienNacido.add(rn);
    }
    private void llenarEgreso(){

        eg.setId(UUID.randomUUID());
        eg.setRecienNacido(rn);
        if(!cmbAlimento.getSelectionModel().isEmpty())
            eg.setAlimento(cmbAlimento.getSelectionModel().getSelectedItem().toString());
        if(!cmbEstadoRn.getSelectionModel().isEmpty())
            eg.setEstadoRn(cmbEstadoRn.getSelectionModel().getSelectedItem().toString());
        if(!cmbEstado.getSelectionModel().isEmpty())
            eg.setEstadoMaterno(cmbEstado.getSelectionModel().getSelectedItem().toString());
        if(!cmbAnticoncepcion.getSelectionModel().isEmpty())
            eg.setAnticoncepcion(cmbAnticoncepcion.getSelectionModel().toString());
        eg.setFechaEgresoRn(dtpFechaEgresoRn.getValue());
        eg.setFechaEgresoMaterno(dtpFechaEgreso.getValue());
        if(!txtPesoEgresoRn.getText().isEmpty())
            eg.setPesoEgresoRn(Integer.parseInt(txtPesoEgresoRn.getText().trim()));
        if(!txtResponsableRn.getText().isEmpty())
            eg.setResponsableEgresoRn(txtResponsableRn.getText().trim());
        if(!txtResponsableMadre.getText().isEmpty())
            eg.setResponsableEgresoRn(txtResponsableMadre.getText().trim());
        listaEgresoRecienNacido.add(eg);
    }
    public void agregarPuerperio(){
        try {
            Puerperio pu = new Puerperio();
            pu.setId(UUID.randomUUID());
            pu.setEmbarazo(emb);
            if(!txtTemperatura.getText().isEmpty())
                pu.setTemperatura(Float.parseFloat(txtTemperatura.getText().trim()));
            pu.setCaracteristicasLoquios(txtCaracteristicasLoquios.getText().trim());
            //pu.setFechaPostParto(dtpFechaPuerperio.getValue());
            if(!txtHoraPostParto.getText().isEmpty())
                pu.setHoraPostParto(txtHoraPostParto.getText().trim());
            pu.setPresionArterial(txtTensionArterialPuerperio.getText().trim());
            pu.setPulso(txtPulso.getText().trim());
            if (!txtTemperatura.getText().isEmpty())
                pu.setTemperatura(Float.parseFloat(txtTemperatura.getText().trim()));
            pu.setUterina(txtInvoUterina.getText().trim());
            listaPuerperio.add(pu);
            gridPuerperio.setItems(listaPuerperio);
        }   catch (Exception ex ){
            Message m = new Message();
            m.showMessage("Error",ex.getCause().getMessage(),Alert.AlertType.ERROR);
        }
    }
    public void borrarPuerperio() {
        if(gridPuerperio.getSelectionModel().isEmpty()){
            Message m = new Message();
            m.showMessage("Info","Seleccione una fila primero",Alert.AlertType.INFORMATION);
        }else{
            gridPuerperio.getItems().remove(gridPuerperio.getSelectionModel().getSelectedIndex());
        }
    }
    public void agregarTrabParto(){
        try {
            TrabajoParto tp = new TrabajoParto();
            tp.setId(UUID.randomUUID());
            tp.setAdmisionPorParto(parto);
            tp.setHora(txtHoraTrabParto.getText().trim());
            tp.setAltura(txtAlturaUteTrabParto.getText().trim());
            if (!txtContracciones.getText().trim().isEmpty())
                tp.setContracciones(Integer.parseInt(txtContracciones.getText()));
            if (!txtTensionArterial.getText().trim().isEmpty())
                tp.setTensionArterial(txtTensionArterial.getText().trim());
            if (!txtFcfTrabParto.getText().isEmpty())
                tp.setFcf(Integer.parseInt(txtFcfTrabParto.getText().trim()));
            if (!txtPosicionTrabParto.getText().isEmpty())
                tp.setPosicion(txtPosicionTrabParto.getText().trim());
            if (!txtDilatacionCerv.getText().isEmpty())
                tp.setDilatacion(Integer.parseInt(txtDilatacionCerv.getText().trim()));
            if (!txtMeconioTrabParto.getText().isEmpty())
                tp.setMeconio(txtMeconioTrabParto.getText().trim());
            if (!txtNombreExaminador.getText().isEmpty())
                tp.setNombreExaminador(txtNombreExaminador.getText().trim());
            listaTrabParto.add(tp);
            gridTrabParto.setItems(listaTrabParto);
        }
        catch (Exception ex ){
            Message m = new Message();
            m.showMessage("Error",ex.getCause().getMessage(),Alert.AlertType.ERROR);
        }
    }
    public void borrarTrabParto(){
        if(gridTrabParto.getSelectionModel().isEmpty()){
            Message m = new Message();
            m.showMessage("Info","Seleccione una fila primero",Alert.AlertType.INFORMATION);
        }else{
            gridTrabParto.getItems().remove(gridTrabParto.getSelectionModel().getSelectedIndex());
        }
    }
    public void agregarConsulta(){
        try{
            EmbarazoConsulta c = new EmbarazoConsulta();
            c.setEmbarazo(emb);
            c.setId(UUID.randomUUID());
            c.setPresionArterial(txtTensionArterialConsulta.getText().trim());
            c.setSangradoGenital(txtSangradoGenital.getText().trim());
            c.setAlbuminuria(txtAlbuminuria.getText().trim());
            if(!txtAltUterina.getText().trim().isEmpty())
                c.setAlturaUterina(Integer.parseInt(txtAltUterina.getText().trim()));
            c.setEdema(txtEdema.getText().trim());
            c.setFcf(txtFcf.getText().trim());
            c.setFecha(dtpFechaConsulta.getValue());
            c.setMovFetal(txtMovFetal.getText().trim());
            if(!txtPeso.getText().trim().isEmpty())
                c.setPeso(BigDecimal.valueOf(Double.parseDouble(txtPeso.getText().trim())));
            c.setNombreExaminador(txtExaminador.getText().trim());
            if(!cmbPresentacion.getSelectionModel().isEmpty())
                c.setPresentacion(cmbPresentacion.getSelectionModel().getSelectedItem().toString());
            if(!txtSemanaAmenorreas.getText().trim().isEmpty())
                c.setSemanasAmenorreas(Integer.parseInt(txtSemanaAmenorreas.getText().trim()));
            listaConsulta.add(c);
            gridConsulta.setItems(listaConsulta);}
        catch (Exception ex ){
            Message m = new Message();
            m.showMessage("Error",ex.getCause().getMessage(),Alert.AlertType.ERROR);
        }
    }
    public void borrarConsulta(){
        if(gridConsulta.getSelectionModel().isEmpty()){
            Message m = new Message();
            m.showMessage("Info","Seleccione una fila primero",Alert.AlertType.INFORMATION);
        }else{
            gridConsulta.getItems().remove(gridConsulta.getSelectionModel().getSelectedIndex());
        }
    }

    public void init(UUID IdPaciente) {
        try {
                em = Connection.emf.createEntityManager();
                p = em.find(Paciente.class, IdPaciente);
                txtIdentificacion.setText(p.getIdentificacion());
                txtPrimerNombre.setText(p.getPrimerNombre());
                txtPrimerApellido.setText(p.getPrimerApellido());
                em.close();
                editar=true;
        }catch(Exception ex){
            Message m = new Message();
            m.showMessage("Error",ex.getMessage(),Alert.AlertType.ERROR);
        }
    }

}
