package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.example.models.Mascota;
import org.example.utils.Constantes;

public class ActualizarMascota implements Task {

    private final Mascota mascota;

    private ActualizarMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public static Performable conDatos(Mascota mascota) {
        return new ActualizarMascota(mascota);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Put.to(Constantes.ENDPOINT_MASCOTAS)
                .with(requestSpecification -> requestSpecification
                    .contentType("application/json")
                    .body(mascota))
        );
    }
}
