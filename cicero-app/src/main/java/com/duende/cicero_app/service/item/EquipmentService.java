package com.duende.cicero_app.service.item;

import com.duende.cicero_app.dto.item.equipment.EquipmentCreateDTO;
import com.duende.cicero_app.dto.item.equipment.EquipmentResponseDTO;
import com.duende.cicero_app.model.item.EquipmentModel;
import com.duende.cicero_app.model.item.QualityModel;
import com.duende.cicero_app.repository.item.EquipmentRepository;
import com.duende.cicero_app.repository.item.QualityRepository;
import com.duende.cicero_app.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final QualityRepository qualityRepository;

    @Autowired
    public EquipmentService (
            EquipmentRepository equipmentRepository,
            QualityRepository qualityRepository)
    {
        this.equipmentRepository = equipmentRepository;
        this.qualityRepository = qualityRepository;
    }

    // GET ALL
    public List<EquipmentResponseDTO> findAllEquipments() {

        return equipmentRepository.findAll()
                .stream()
                .map(EquipmentResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public EquipmentResponseDTO findEquipmentById(Long id) {

        EquipmentModel equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        return EquipmentResponseDTO.fromEntity(equipment);
    }

    // CREATE
    public EquipmentModel createEquipment(EquipmentCreateDTO dto) {

        EquipmentModel equipment = new EquipmentModel();
        equipment.setName(dto.name());
        equipment.setPoints(dto.points());
        equipment.setUsesTotal(dto.usesTotal() != null ? dto.usesTotal() : 4);
        equipment.setUsesCurrent(equipment.getUsesCurrent());
        equipment.setSize(dto.size() != null ? dto.size() : 1);
        equipment.setBroken(dto.broken() != null ? dto.broken() : false);

        if (dto.qualityIds() != null && !dto.qualityIds().isEmpty()) {
            Set<QualityModel> qualities = qualityRepository
                    .findAllById(dto.qualityIds())
                    .stream()
                    .collect(Collectors.toSet());
            equipment.setQualities(qualities);
        }

        return equipmentRepository.save(equipment);
    }

    // UPDATE
    public EquipmentModel updateEquipment (Long id, EquipmentCreateDTO dto) {

        EquipmentModel equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        Utils.copyNonNullProperties(dto, equipment);

        if (dto.qualityIds() != null && !dto.qualityIds().isEmpty()) {
            Set<QualityModel> qualities = new HashSet<>(qualityRepository
                    .findAllById(dto.qualityIds()));
            equipment.setQualities(qualities);
        }

        return equipmentRepository.save(equipment);

    }

    // DELETE
    public void deleteEquipment (Long id) {

        if (!equipmentRepository.existsById(id)) {
            throw new RuntimeException("Equipamento não encontrado");
        }

        equipmentRepository.deleteById(id);
    }

    //criar um update caso o equipamento quebre

}
