package br.com.bthirtyeight.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *Essa classe serve como um ponto central de configuração do Spring. Você pode usá-la para configurar bibliotecas externas (Jackson, Gson, etc.),
 * registrar beans próprios ou até customizar o comportamento do framework (CORS, mensagens, validação, interceptadores...).
 */
@Configuration // Indica ao Spring que esta classe contém configurações e beans que devem ser gerenciados pelo container.
public class ObjectMapperConfig {

    /**
     * Cria e disponibiliza no contexto do Spring uma instância de ObjectMapper.
     * Assim, outras partes do sistema podem utilizá-la automaticamente.
     */
    @Bean // Diz ao Spring que este método retorna um bean gerenciado.
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        // Criação de um provedor de filtros que será aplicado na serialização do JSON.
        // Aqui definimos um filtro chamado "person_filter" que vai ignorar o campo "sensitiveData".
        SimpleFilterProvider filters = new SimpleFilterProvider()
                .addFilter("person_filter", SimpleBeanPropertyFilter.serializeAllExcept("sensitiveData"));
                     //nome da config do filtro/  tipo do filtro

        // Configura o ObjectMapper para usar os filtros definidos acima.
        mapper.setFilterProvider(filters);
        return mapper;
    }
}
