package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterReactApp;
import com.mycompany.myapp.domain.PartnerAllocatedQuota;
import com.mycompany.myapp.repository.PartnerAllocatedQuotaRepository;
import com.mycompany.myapp.service.PartnerAllocatedQuotaService;
import com.mycompany.myapp.service.dto.PartnerAllocatedQuotaDTO;
import com.mycompany.myapp.service.mapper.PartnerAllocatedQuotaMapper;
import com.mycompany.myapp.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static com.mycompany.myapp.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link PartnerAllocatedQuotaResource} REST controller.
 */
@SpringBootTest(classes = JhipsterReactApp.class)
public class PartnerAllocatedQuotaResourceIT {

    private static final Integer DEFAULT_QUANTITY = 1;
    private static final Integer UPDATED_QUANTITY = 2;

    private static final LocalDate DEFAULT_START_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_START_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_EXPIRY_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_EXPIRY_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_LAST_UPDATE_TIMESTAMP = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LAST_UPDATE_TIMESTAMP = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_LAST_UPDATE_ID = "AAAAAAAAAA";
    private static final String UPDATED_LAST_UPDATE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    @Autowired
    private PartnerAllocatedQuotaRepository partnerAllocatedQuotaRepository;

    @Autowired
    private PartnerAllocatedQuotaMapper partnerAllocatedQuotaMapper;

    @Autowired
    private PartnerAllocatedQuotaService partnerAllocatedQuotaService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restPartnerAllocatedQuotaMockMvc;

    private PartnerAllocatedQuota partnerAllocatedQuota;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final PartnerAllocatedQuotaResource partnerAllocatedQuotaResource = new PartnerAllocatedQuotaResource(partnerAllocatedQuotaService);
        this.restPartnerAllocatedQuotaMockMvc = MockMvcBuilders.standaloneSetup(partnerAllocatedQuotaResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PartnerAllocatedQuota createEntity(EntityManager em) {
        PartnerAllocatedQuota partnerAllocatedQuota = new PartnerAllocatedQuota()
            .quantity(DEFAULT_QUANTITY)
            .startDate(DEFAULT_START_DATE)
            .expiryDate(DEFAULT_EXPIRY_DATE)
            .lastUpdateTimestamp(DEFAULT_LAST_UPDATE_TIMESTAMP)
            .lastUpdateId(DEFAULT_LAST_UPDATE_ID)
            .status(DEFAULT_STATUS);
        return partnerAllocatedQuota;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PartnerAllocatedQuota createUpdatedEntity(EntityManager em) {
        PartnerAllocatedQuota partnerAllocatedQuota = new PartnerAllocatedQuota()
            .quantity(UPDATED_QUANTITY)
            .startDate(UPDATED_START_DATE)
            .expiryDate(UPDATED_EXPIRY_DATE)
            .lastUpdateTimestamp(UPDATED_LAST_UPDATE_TIMESTAMP)
            .lastUpdateId(UPDATED_LAST_UPDATE_ID)
            .status(UPDATED_STATUS);
        return partnerAllocatedQuota;
    }

    @BeforeEach
    public void initTest() {
        partnerAllocatedQuota = createEntity(em);
    }

    @Test
    @Transactional
    public void createPartnerAllocatedQuota() throws Exception {
        int databaseSizeBeforeCreate = partnerAllocatedQuotaRepository.findAll().size();

        // Create the PartnerAllocatedQuota
        PartnerAllocatedQuotaDTO partnerAllocatedQuotaDTO = partnerAllocatedQuotaMapper.toDto(partnerAllocatedQuota);
        restPartnerAllocatedQuotaMockMvc.perform(post("/api/partner-allocated-quotas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(partnerAllocatedQuotaDTO)))
            .andExpect(status().isCreated());

        // Validate the PartnerAllocatedQuota in the database
        List<PartnerAllocatedQuota> partnerAllocatedQuotaList = partnerAllocatedQuotaRepository.findAll();
        assertThat(partnerAllocatedQuotaList).hasSize(databaseSizeBeforeCreate + 1);
        PartnerAllocatedQuota testPartnerAllocatedQuota = partnerAllocatedQuotaList.get(partnerAllocatedQuotaList.size() - 1);
        assertThat(testPartnerAllocatedQuota.getQuantity()).isEqualTo(DEFAULT_QUANTITY);
        assertThat(testPartnerAllocatedQuota.getStartDate()).isEqualTo(DEFAULT_START_DATE);
        assertThat(testPartnerAllocatedQuota.getExpiryDate()).isEqualTo(DEFAULT_EXPIRY_DATE);
        assertThat(testPartnerAllocatedQuota.getLastUpdateTimestamp()).isEqualTo(DEFAULT_LAST_UPDATE_TIMESTAMP);
        assertThat(testPartnerAllocatedQuota.getLastUpdateId()).isEqualTo(DEFAULT_LAST_UPDATE_ID);
        assertThat(testPartnerAllocatedQuota.getStatus()).isEqualTo(DEFAULT_STATUS);
    }

    @Test
    @Transactional
    public void createPartnerAllocatedQuotaWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = partnerAllocatedQuotaRepository.findAll().size();

        // Create the PartnerAllocatedQuota with an existing ID
        partnerAllocatedQuota.setId(1L);
        PartnerAllocatedQuotaDTO partnerAllocatedQuotaDTO = partnerAllocatedQuotaMapper.toDto(partnerAllocatedQuota);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPartnerAllocatedQuotaMockMvc.perform(post("/api/partner-allocated-quotas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(partnerAllocatedQuotaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PartnerAllocatedQuota in the database
        List<PartnerAllocatedQuota> partnerAllocatedQuotaList = partnerAllocatedQuotaRepository.findAll();
        assertThat(partnerAllocatedQuotaList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllPartnerAllocatedQuotas() throws Exception {
        // Initialize the database
        partnerAllocatedQuotaRepository.saveAndFlush(partnerAllocatedQuota);

        // Get all the partnerAllocatedQuotaList
        restPartnerAllocatedQuotaMockMvc.perform(get("/api/partner-allocated-quotas?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(partnerAllocatedQuota.getId().intValue())))
            .andExpect(jsonPath("$.[*].quantity").value(hasItem(DEFAULT_QUANTITY)))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].expiryDate").value(hasItem(DEFAULT_EXPIRY_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastUpdateTimestamp").value(hasItem(DEFAULT_LAST_UPDATE_TIMESTAMP.toString())))
            .andExpect(jsonPath("$.[*].lastUpdateId").value(hasItem(DEFAULT_LAST_UPDATE_ID)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)));
    }
    
    @Test
    @Transactional
    public void getPartnerAllocatedQuota() throws Exception {
        // Initialize the database
        partnerAllocatedQuotaRepository.saveAndFlush(partnerAllocatedQuota);

        // Get the partnerAllocatedQuota
        restPartnerAllocatedQuotaMockMvc.perform(get("/api/partner-allocated-quotas/{id}", partnerAllocatedQuota.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(partnerAllocatedQuota.getId().intValue()))
            .andExpect(jsonPath("$.quantity").value(DEFAULT_QUANTITY))
            .andExpect(jsonPath("$.startDate").value(DEFAULT_START_DATE.toString()))
            .andExpect(jsonPath("$.expiryDate").value(DEFAULT_EXPIRY_DATE.toString()))
            .andExpect(jsonPath("$.lastUpdateTimestamp").value(DEFAULT_LAST_UPDATE_TIMESTAMP.toString()))
            .andExpect(jsonPath("$.lastUpdateId").value(DEFAULT_LAST_UPDATE_ID))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS));
    }

    @Test
    @Transactional
    public void getNonExistingPartnerAllocatedQuota() throws Exception {
        // Get the partnerAllocatedQuota
        restPartnerAllocatedQuotaMockMvc.perform(get("/api/partner-allocated-quotas/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePartnerAllocatedQuota() throws Exception {
        // Initialize the database
        partnerAllocatedQuotaRepository.saveAndFlush(partnerAllocatedQuota);

        int databaseSizeBeforeUpdate = partnerAllocatedQuotaRepository.findAll().size();

        // Update the partnerAllocatedQuota
        PartnerAllocatedQuota updatedPartnerAllocatedQuota = partnerAllocatedQuotaRepository.findById(partnerAllocatedQuota.getId()).get();
        // Disconnect from session so that the updates on updatedPartnerAllocatedQuota are not directly saved in db
        em.detach(updatedPartnerAllocatedQuota);
        updatedPartnerAllocatedQuota
            .quantity(UPDATED_QUANTITY)
            .startDate(UPDATED_START_DATE)
            .expiryDate(UPDATED_EXPIRY_DATE)
            .lastUpdateTimestamp(UPDATED_LAST_UPDATE_TIMESTAMP)
            .lastUpdateId(UPDATED_LAST_UPDATE_ID)
            .status(UPDATED_STATUS);
        PartnerAllocatedQuotaDTO partnerAllocatedQuotaDTO = partnerAllocatedQuotaMapper.toDto(updatedPartnerAllocatedQuota);

        restPartnerAllocatedQuotaMockMvc.perform(put("/api/partner-allocated-quotas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(partnerAllocatedQuotaDTO)))
            .andExpect(status().isOk());

        // Validate the PartnerAllocatedQuota in the database
        List<PartnerAllocatedQuota> partnerAllocatedQuotaList = partnerAllocatedQuotaRepository.findAll();
        assertThat(partnerAllocatedQuotaList).hasSize(databaseSizeBeforeUpdate);
        PartnerAllocatedQuota testPartnerAllocatedQuota = partnerAllocatedQuotaList.get(partnerAllocatedQuotaList.size() - 1);
        assertThat(testPartnerAllocatedQuota.getQuantity()).isEqualTo(UPDATED_QUANTITY);
        assertThat(testPartnerAllocatedQuota.getStartDate()).isEqualTo(UPDATED_START_DATE);
        assertThat(testPartnerAllocatedQuota.getExpiryDate()).isEqualTo(UPDATED_EXPIRY_DATE);
        assertThat(testPartnerAllocatedQuota.getLastUpdateTimestamp()).isEqualTo(UPDATED_LAST_UPDATE_TIMESTAMP);
        assertThat(testPartnerAllocatedQuota.getLastUpdateId()).isEqualTo(UPDATED_LAST_UPDATE_ID);
        assertThat(testPartnerAllocatedQuota.getStatus()).isEqualTo(UPDATED_STATUS);
    }

    @Test
    @Transactional
    public void updateNonExistingPartnerAllocatedQuota() throws Exception {
        int databaseSizeBeforeUpdate = partnerAllocatedQuotaRepository.findAll().size();

        // Create the PartnerAllocatedQuota
        PartnerAllocatedQuotaDTO partnerAllocatedQuotaDTO = partnerAllocatedQuotaMapper.toDto(partnerAllocatedQuota);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPartnerAllocatedQuotaMockMvc.perform(put("/api/partner-allocated-quotas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(partnerAllocatedQuotaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PartnerAllocatedQuota in the database
        List<PartnerAllocatedQuota> partnerAllocatedQuotaList = partnerAllocatedQuotaRepository.findAll();
        assertThat(partnerAllocatedQuotaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePartnerAllocatedQuota() throws Exception {
        // Initialize the database
        partnerAllocatedQuotaRepository.saveAndFlush(partnerAllocatedQuota);

        int databaseSizeBeforeDelete = partnerAllocatedQuotaRepository.findAll().size();

        // Delete the partnerAllocatedQuota
        restPartnerAllocatedQuotaMockMvc.perform(delete("/api/partner-allocated-quotas/{id}", partnerAllocatedQuota.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<PartnerAllocatedQuota> partnerAllocatedQuotaList = partnerAllocatedQuotaRepository.findAll();
        assertThat(partnerAllocatedQuotaList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
