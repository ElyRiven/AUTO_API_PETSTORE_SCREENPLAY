package org.example.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.example.models.Mascota;
import org.example.questions.CodigoRespuesta;
import org.example.questions.NombreMascotaEnRespuesta;
import org.example.tasks.ActualizarMascota;
import org.example.tasks.ConsultarMascota;
import org.example.tasks.CrearMascota;
import org.example.tasks.EliminarMascota;
import org.example.utils.Constantes;

import java.util.Collections;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CrudMascotaStepDefinitions {

    private Actor actor;
    private Mascota mascota;

    @Before
    public void inicializar() {
        actor = null;
        mascota = null;
    }

    @Given("que el usuario se prepara para gestionar mascotas en la API PetStore")
    public void elUsuarioSePrepara() {
        actor = Actor.named(Constantes.ACTOR)
                .whoCan(CallAnApi.at(Constantes.URL_BASE));
    }

    @When("el usuario registra una nueva mascota con id {string}, categoria {string}, nombre {string} y etiqueta {string}")
    public void elUsuarioRegistraUnaNuevaMascota(String idMascota, String categoria, String nombreMascota, String etiqueta) {
        mascota = new Mascota(
                Long.parseLong(idMascota),
                new Mascota.Categoria(0, categoria),
                nombreMascota,
                Collections.singletonList("string"),
                Collections.singletonList(new Mascota.Etiqueta(0, etiqueta)),
                "available"
        );
        actor.attemptsTo(CrearMascota.conDatos(mascota));
    }

    @And("realiza una nueva consulta al sistema con el id {string} de la mascota creada")
    public void realizaConsultaMascotaCreada(String idMascota) {
        actor.attemptsTo(ConsultarMascota.consultarMascota(Long.parseLong(idMascota)));
    }

    @Then("el usuario comprueba que la mascota {string} ha sido creada en el sistema")
    public void compruebaQueLosDatosDeCreacionSonCorrectos(String nombreMascota) {
        actor.should(
                seeThat(CodigoRespuesta.obtenida(), equalTo(200)),
                seeThat(NombreMascotaEnRespuesta.obtenido(), equalTo(nombreMascota))
        );
    }

    @When("el usuario modifica la mascota con id {string} actualizando la categoria a {string}, el nombre a {string} y la etiqueta a {string}")
    public void elUsuarioModificaLaMascota(String idMascota, String categoriaActualizada, String nombreActualizado, String etiquetaActualizada) {
        mascota = new Mascota(
                Long.parseLong(idMascota),
                new Mascota.Categoria(0, categoriaActualizada),
                nombreActualizado,
                Collections.singletonList("string"),
                Collections.singletonList(new Mascota.Etiqueta(0, etiquetaActualizada)),
                "available"
        );
        actor.attemptsTo(ActualizarMascota.conDatos(mascota));
    }

    @And("realiza una nueva consulta al sistema con el id {string} de la mascota modificada")
    public void realizaConsultaMascotaModificada(String idMascota) {
        actor.attemptsTo(ConsultarMascota.consultarMascota(Long.parseLong(idMascota)));
    }

    @Then("el usuario comprueba que la mascota ha sido modificada con el nombre {string} correctamente en el sistema")
    public void compruebaQueLosDatosDeModificacionSonCorrectos(String nombreMascotaActualizada) {
        actor.should(
                seeThat(CodigoRespuesta.obtenida(), equalTo(200)),
                seeThat(NombreMascotaEnRespuesta.obtenido(), equalTo(nombreMascotaActualizada))
        );
    }

    @When("el usuario elimina el registro de la mascota con id {string} del sistema")
    public void elUsuarioEliminaElRegistroDeLaMascota(String idMascota) {
        actor.attemptsTo(EliminarMascota.eliminarMascota(Long.parseLong(idMascota), Constantes.API_KEY));
    }

    @And("realiza una nueva consulta al sistema con el id {string} de la mascota eliminada")
    public void realizaConsultaMascotaEliminada(String idMascota) {
        actor.attemptsTo(ConsultarMascota.consultarMascota(Long.parseLong(idMascota)));
    }

    @Then("el sistema devuelve una respuesta 404 debido a que el registro ha sido eliminado correctamente")
    public void elSistemaDevuelveError404() {
        actor.should(seeThat(CodigoRespuesta.obtenida(), equalTo(404)));
    }
}
