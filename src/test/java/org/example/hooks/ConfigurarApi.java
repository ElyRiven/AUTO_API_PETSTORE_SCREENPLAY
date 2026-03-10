package org.example.hooks;

import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.example.utils.Constantes;

public class ConfigurarApi implements Task {

  private final String urlApi;
  
  public ConfigurarApi( String urlApi ) {
    this.urlApi = urlApi;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.whoCan(
      CallAnApi.at(urlApi)
    );
  }

  public static ConfigurarApi comoBase() {
    return new ConfigurarApi(Constantes.URL_BASE);
  }
  
}
