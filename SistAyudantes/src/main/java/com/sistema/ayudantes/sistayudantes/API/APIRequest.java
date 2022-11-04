package com.sistema.ayudantes.sistayudantes.API;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistema.ayudantes.sistayudantes.API.DataInterfaces.IAyudante;
import com.sistema.ayudantes.sistayudantes.API.DataInterfaces.IMateria;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIRequest {

    public static List<IMateria> getMaterias() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:4567/materias")
                .build();

        Response response = client.newCall(request).execute();

        String jsonResponse = response.body().string().replaceAll("\"", "\\\"");
        List<IMateria> materias = mapper.readValue(jsonResponse, new TypeReference<List<IMateria>>(){});

        return materias;
    }

    public static List<IAyudante> getAyudantes(String idMateria) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:4567//ayudantes-materia?id_materia="+idMateria)
                .build();

        Response response = client.newCall(request).execute();

        String jsonResponse = response.body().string().replaceAll("\"", "\\\"");
        List<IAyudante> ayudantes = mapper.readValue(jsonResponse, new TypeReference<List<IAyudante>>(){});

        return ayudantes;
    }
}
