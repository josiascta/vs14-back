package tasks;

import java.time.LocalDateTime;

public class TerminoDeJogo {

    private int horas;
    private int minutos;
    private boolean proximoDia;

    public TerminoDeJogo(int horas, int minutos, boolean proximoDia){
        this.horas = horas;
        this.minutos = minutos;
        this.proximoDia = proximoDia;
    }

    public LocalDateTime horarioDeTermino(){
        LocalDateTime horario = LocalDateTime.now();
        if(proximoDia){
            horario = horario.plusDays(1);
        }
        return LocalDateTime.of(horario.getYear(), horario.getMonth(), horario.getDayOfMonth(), horas, minutos);

    }
}
