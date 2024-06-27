import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscaMoneda(double valorAConvertir, String monedaInicial, String monedaFinal){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/696ec12a8cbf53675eb60fe1/pair/"+monedaInicial+"/"+monedaFinal+"/"+valorAConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException("No encontré esa moneda."+ e.getMessage());
        }
    }

}
