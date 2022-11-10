package org.teemyroom.yontaverse.plot.domain;

import org.springframework.stereotype.Service;
import org.teemyroom.yontaverse.common.BaseQueryService;
import org.teemyroom.yontaverse.common.VisitType;
import org.teemyroom.yontaverse.common.exception.ResourceNotFoundException;

@Service
public class PlotQueryService extends BaseQueryService<Plot> {

    private final PlotRepository plotRepository;

    public PlotQueryService(PlotRepository plotRepository) {
        super(plotRepository);
        this.plotRepository = plotRepository;
    }
}
