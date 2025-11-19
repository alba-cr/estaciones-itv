package is1205.iei.extractor;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import is1205.iei.dto.CATEstacionDto;
import is1205.iei.dto.CATResponseDto;
import is1205.iei.model.Provincia;
import is1205.iei.repository.EstacionRepository;
import is1205.iei.repository.LocalidadRepository;
import is1205.iei.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class CATExtractor {

    private final XmlMapper xmlMapper = new XmlMapper();

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private LocalidadRepository localidadRepository;

    @Autowired
    private EstacionRepository estacionRepository;

    public void ExtractorCATService(ProvinciaRepository provinciaRepository,
                               LocalidadRepository localidadRepository,
                               EstacionRepository estacionRepository) {
        this.provinciaRepository = provinciaRepository;
        this.localidadRepository = localidadRepository;
        this.estacionRepository = estacionRepository;
    }

    public List<CATEstacionDto> leerCAT() throws Exception {
        ClassPathResource resource = new ClassPathResource("fuentes/ITV-CAT.xml");
        try (InputStream inputStream = resource.getInputStream()) {
            CATResponseDto responseDto = xmlMapper.readValue(inputStream, CATResponseDto.class);
            return responseDto.getEstaciones();
        }
    }

    private void procesarEstacion(CATEstacionDto dto) {
        // MAPPINGS
        // 1). PROVINCIA
        // 2). LOCALIDAD
        // 3). ESTACIÓN
    }
}
