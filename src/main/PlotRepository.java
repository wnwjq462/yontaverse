package org.teemyroom.yontaverse.plot.domain;

import org.teemyroom.yontaverse.common.BaseRepository;
import org.teemyroom.yontaverse.common.VisitType;

import java.util.Optional;

public interface PlotRepository extends BaseRepository<Plot> {

    Optional<Plot> findByPlaceIdAndVisitType(Long placeId, VisitType visitType);
}
