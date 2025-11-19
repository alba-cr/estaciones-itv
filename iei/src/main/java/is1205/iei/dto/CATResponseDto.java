package is1205.iei.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@JacksonXmlRootElement(localName = "response")
public class CATResponseDto {

    @JacksonXmlProperty(localName = "row")
    private RowWrapper rowWrapper;

    public List<CATEstacionDto> getEstaciones() {
        if (rowWrapper != null && rowWrapper.getRows() != null) {
            return rowWrapper.getRows();
        }
        return Collections.emptyList();
    }

    @Getter
    @Setter
    public static class RowWrapper {

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "row")
        private List<CATEstacionDto> rows;
    }
}
