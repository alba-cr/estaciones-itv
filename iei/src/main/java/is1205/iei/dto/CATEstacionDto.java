package is1205.iei.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CATEstacionDto {

    @JacksonXmlProperty(localName = "denominaci")
    private String denominaci;

    @JacksonXmlProperty(localName = "operador")
    private String operador;

    @JacksonXmlProperty(localName = "adre_a")
    private String adre_a;

    @JacksonXmlProperty(localName = "cp")
    private String cp;

    @JacksonXmlProperty(localName = "municipi")
    private String municipi;

    @JacksonXmlProperty(localName = "lat")
    private String latOrigen;

    @JacksonXmlProperty(localName = "long")
    private String longOrigen;

    @JacksonXmlProperty(localName = "horari_de_servei")
    private String horari_de_servei;

    @JacksonXmlProperty(localName = "correu_electr_nic")
    private String correu_electr_nic;

    @JacksonXmlProperty(localName = "web")
    private WebDto web;

    public String getUrl() {
        return web != null ? web.getUrl() : null;
    }

    @Getter
    @Setter
    public static class WebDto {

        @JacksonXmlProperty(isAttribute = true, localName = "url")
        private String url;
    }
}
