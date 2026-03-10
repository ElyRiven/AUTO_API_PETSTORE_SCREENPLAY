package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class NombreMascotaEnRespuesta implements Question<String> {

    public static Question<String> obtenido() {
        return new NombreMascotaEnRespuesta();
    }

    @Override
    public String answeredBy(Actor actor) {
        return lastResponse().jsonPath().getString("name");
    }
}
