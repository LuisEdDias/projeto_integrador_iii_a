package database.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class ConverterData {
    public static Date converterData(String dataNasc){
        try {
            return new Date(
                    new SimpleDateFormat("dd/MM/yyyy")
                            .parse(dataNasc)
                            .getTime()
            );
        } catch (ParseException e) {
            throw new RuntimeException("Data em formato inválido!");
        }
    }
}
