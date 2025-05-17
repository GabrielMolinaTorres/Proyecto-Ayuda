package logica;

import java.awt.Color;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Semaforo {


    public static long calcularDiasHabiles(LocalDate inicio, LocalDate fin) {
        long diasTotales = ChronoUnit.DAYS.between(inicio, fin) + 1;
        long finesDeSemana = 0;

        LocalDate fecha = inicio;
        while (!fecha.isAfter(fin)) {
            if (fecha.getDayOfWeek().getValue() >= 6) {
                finesDeSemana++;
            }
            fecha = fecha.plusDays(1);
        }

        return diasTotales - finesDeSemana;
    }


    public static Color determinarColorDiasHabiles(LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaActual) {
        if (fechaActual.isAfter(fechaFin)) {
            return Color.RED;
        }

        long diasHabilesTotales = calcularDiasHabiles(fechaInicio, fechaFin);
        long diasHabilesTranscurridos = calcularDiasHabiles(fechaInicio, fechaActual);
        long diasHabilesRestantes = diasHabilesTotales - diasHabilesTranscurridos;

        double porcentajeRestante = (double) diasHabilesRestantes / diasHabilesTotales;

        if (porcentajeRestante > 0.5) {
            return Color.GREEN;
        } else if (porcentajeRestante > 0.25) {
            return Color.YELLOW;
        } else {
            return Color.RED;
        }
    }
