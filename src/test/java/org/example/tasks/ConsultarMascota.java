package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.example.utils.Constantes;

public class ConsultarMascota implements Task {

    private final long idMascota;

    private ConsultarMascota(long idMascota) {
        this.idMascota = idMascota;
    }

    public static Performable consultarMascota(long idMascota) {
        return new ConsultarMascota(idMascota);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Get.resource(Constantes.ENDPOINT_MASCOTAS + "/" + idMascota)
        );
    }
}
