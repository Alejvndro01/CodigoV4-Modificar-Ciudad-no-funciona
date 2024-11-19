package Modelo;

public class Pais {
    private String codigoPais;
    private String nombrePais;
    private String continentePais;
    private int poblacionPais;
    private int tipoGobierno;
    private String region;
    private float superficie;
    private int anioIndependencia;
    private float expectativaVida;
    private float pnb;
    private String jefeEstado;
    private int ciudadCapital; 
    private String idiomaPais;

    // Constructor por defecto
    public Pais() {
    }

    // Constructor con parámetros
    public Pais(String codigoPais, String nombrePais, String continentePais, int poblacionPais, int tipoGobierno,
                String region, float superficie, int anioIndependencia, float expectativaVida, float pnb,
                String jefeEstado, int ciudadCapital, String idiomaPais) {
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.continentePais = continentePais;
        this.poblacionPais = poblacionPais;
        this.tipoGobierno = tipoGobierno;
        this.region = region;
        this.superficie = superficie;
        this.anioIndependencia = anioIndependencia;
        this.expectativaVida = expectativaVida;
        this.pnb = pnb;
        this.jefeEstado = jefeEstado;
        this.ciudadCapital = ciudadCapital;
        this.idiomaPais = idiomaPais;
    }

    // Getters y Setters
    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getContinentePais() {
        return continentePais;
    }

    public void setContinentePais(String continentePais) {
        this.continentePais = continentePais;
    }

    public int getPoblacionPais() {
        return poblacionPais;
    }

    public void setPoblacionPais(int poblacionPais) {
        this.poblacionPais = poblacionPais;
    }

    public int getTipoGobierno() {
        return tipoGobierno;
    }

    public void setTipoGobierno(int tipoGobierno) {
        this.tipoGobierno = tipoGobierno;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public int getAnioIndependencia() {
        return anioIndependencia;
    }

    public void setAnioIndependencia(int anioIndependencia) {
        this.anioIndependencia = anioIndependencia;
    }

    public float getExpectativaVida() {
        return expectativaVida;
    }

    public void setExpectativaVida(float expectativaVida) {
        this.expectativaVida = expectativaVida;
    }

    public float getPnb() {
        return pnb;
    }

    public void setPnb(float pnb) {
        this.pnb = pnb;
    }

    public String getJefeEstado() {
        return jefeEstado;
    }

    public void setJefeEstado(String jefeEstado) {
        this.jefeEstado = jefeEstado;
    }

    public int getCiudadCapital() {
        return ciudadCapital;
    }

    public void setCiudadCapital(int ciudadCapital) {
        this.ciudadCapital = ciudadCapital;
    }

    public String getIdiomaPais() {
        return idiomaPais;
    }

    public void setIdiomaPais(String idiomaPais) {
        this.idiomaPais = idiomaPais;
    }
}