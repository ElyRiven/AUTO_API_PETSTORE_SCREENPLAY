package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class CodigoRespuesta implements Question<Integer> {

    public static Question<Integer> obtenida() {
        return new CodigoRespuesta();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().getStatusCode();
    }
}
