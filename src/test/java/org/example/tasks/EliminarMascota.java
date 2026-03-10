package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import org.example.utils.Constantes;

public class EliminarMascota implements Task {

    private final long idMascota;
    private final String apiKey;

    private EliminarMascota(long idMascota, String apiKey) {
        this.idMascota = idMascota;
        this.apiKey = apiKey;
    }

    public static Performable eliminarMascota(long idMascota, String apiKey) {
        return new EliminarMascota(idMascota, apiKey);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Delete.from(Constantes.ENDPOINT_MASCOTAS + "/" + idMascota)
                .with(requestSpecification -> requestSpecification
                    .header("api_key", apiKey))
        );
    }
}
