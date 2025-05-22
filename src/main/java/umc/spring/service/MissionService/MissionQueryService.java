package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;

public interface MissionQueryService {
    Page<Mission> getMissionListByStore(Store store, int page);
}
