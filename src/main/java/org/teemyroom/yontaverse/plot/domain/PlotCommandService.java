package org.teemyroom.yontaverse.plot.domain;

import org.teemyroom.yontaverse.common.BaseCommandService;
import org.springframework.stereotype.Service;

@Service
public class PlotCommandService extends BaseCommandService<Plot> {
    
    public PlotCommandService(PlotRepository plotRepository) {
        super(plotRepository);
    }
}
