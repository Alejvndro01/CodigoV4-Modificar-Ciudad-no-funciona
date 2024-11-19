package Modelo;

public class Idioma {
    private int idIdioma;
    private String nombreIdioma;
    private int oficial;
    private String codigoPais;
    private float porcentaje; // Nuevo atributo

    // Constructor por defecto
    public Idioma() {
    }

    // Constructor con parámetros
    public Idioma(int idIdioma, String nombreIdioma, int oficial, String codigoPais, float porcentaje) {
        this.idIdioma = idIdioma;
        this.nombreIdioma = nombreIdioma;
        this.oficial = oficial;
        this.codigoPais = codigoPais;
        this.porcentaje = porcentaje; // Inicializando el nuevo atributo
    }

    // Getters y Setters
    public int getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNombreIdioma() {
        return nombreIdioma;
    }

    public void setNombreIdioma(String nombreIdioma) {
        this.nombreIdioma = nombreIdioma;
    }

    public int getOficial() {
        return oficial;
    }

    public void setOficial(int oficial) {
        this.oficial = oficial;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public float getPorcentaje() {
        return porcentaje; // Getter para el nuevo atributo
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje; // Setter para el nuevo atributo
    }
}