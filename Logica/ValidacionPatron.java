class ValidacionPatron {
    public boolean esValido(PatronAcceso patron, IntentoAcceso intento) {
        return patron.getSecuenciaCorrecta() == intento.getSecuenciaIngresada();
    }
}