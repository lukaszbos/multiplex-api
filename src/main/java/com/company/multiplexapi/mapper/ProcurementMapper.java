package com.company.multiplexapi.mapper;

import com.company.multiplexapi.dto.ProcurementDto;
import com.company.multiplexapi.model.Procurement;
import org.springframework.stereotype.Component;

@Component
public class ProcurementMapper {
    public Procurement toModel(ProcurementDto procurementDto){
        return new Procurement(procurementDto.getTotalPrice(),procurementDto.getProcurementTime(), procurementDto.getClient());
    }

    public ProcurementDto toDto(Procurement procurement){
        return new ProcurementDto(procurement.getProcurementId(),procurement.getTotalPrice(),procurement.getProcurementTime(),procurement.getClient());
    }
}
