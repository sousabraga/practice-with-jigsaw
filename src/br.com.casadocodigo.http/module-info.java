module br.com.casadocodigo.http {
    requires java.net.http;
    requires transitive br.com.casadocodigo.domain;

    exports br.com.casadocodigo.http.data;
}