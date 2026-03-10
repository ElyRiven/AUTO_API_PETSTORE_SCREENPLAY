package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.example.models.Mascota;
import org.example.utils.Constantes;

public class CrearMascota implements Task {

    private final Mascota mascota;

    private CrearMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public static Performable conDatos(Mascota mascota) {
        return new CrearMascota(mascota);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Post.to(Constantes.ENDPOINT_MASCOTAS)
                .with(requestSpecification -> requestSpecification
                    .contentType("application/json")
                    .body(mascota))
        );
    }
}
