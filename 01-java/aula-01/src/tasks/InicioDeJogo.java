package tasks;

import java.time.LocalDateTime;

public class InicioDeJogo {

    private int horas;
    private int minutos;

    public InicioDeJogo(int horas, int minutos){
        this.horas = horas;
        this.minutos = minutos;
    }

    public LocalDateTime horarioDeInicio(){
        LocalDateTime horario = LocalDateTime.now();
        return LocalDateTime.of(horario.getYear(), horario.getMonth(), horario.getDayOfMonth(), horas, minutos);
    }
}
