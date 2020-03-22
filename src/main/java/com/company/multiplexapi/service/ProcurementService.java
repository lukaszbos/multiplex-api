package com.company.multiplexapi.service;

import com.company.multiplexapi.dto.ProcurementDto;
import com.company.multiplexapi.mapper.ClientMapper;
import com.company.multiplexapi.mapper.ProcurementMapper;
import com.company.multiplexapi.model.Client;
import com.company.multiplexapi.model.Procurement;
import com.company.multiplexapi.repository.ClientRepository;
import com.company.multiplexapi.repository.ProcurementRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProcurementService {
    private final ProcurementRepository procurementRepository;
    private final ProcurementMapper procurementMapper;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    ProcurementService(ProcurementRepository procurementRepository, ProcurementMapper procurementMapper, ClientRepository clientRepository, ClientMapper clientMapper){
        this.procurementRepository = procurementRepository;
        this.procurementMapper = procurementMapper;
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }


    public ProcurementDto placeProcurement(ProcurementDto procurementDto) {
        Procurement procurement = procurementMapper.toModel(procurementDto);
        Client client = new Client(procurementDto.getClient().getName(),procurementDto.getClient().getSurname(),procurementDto.getClient().getTypeOfTicket());
        Client addedClient = clientRepository.save(client);

        procurement.setClient(addedClient);
        Procurement addedProcurement = procurementRepository.save(procurement);

        return procurementMapper.toDto(addedProcurement);
    }
}
