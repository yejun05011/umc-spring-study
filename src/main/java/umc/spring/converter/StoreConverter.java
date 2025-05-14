package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.CreateDTO dto, Region region) {
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .region(region)
                .build();
    }

    public static StoreResponseDTO toStoreResponse(Store store) {
        return new StoreResponseDTO(
                store.getId(),
                store.getName(),
                store.getAddress(),
                store.getRegion().getName()
        );
    }
}
