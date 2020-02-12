package com.udemy.curso.leccion221;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversiones {
    private static final String FORMATO_FECHA = "dd-MM";
    
    public static String format(Date date){
        final SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(date);
    }
    
    public static String format(String date){
        final SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(date);
    }
}
