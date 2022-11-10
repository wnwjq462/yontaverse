package org.teemyroom.yontaverse.place.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teemyroom.yontaverse.place.domain.PlaceQueryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/place")
@RequiredArgsConstructor
public class PlaceQueryController {
    private final PlaceQueryService queryService;

    @GetMapping
    public List<PlaceQueryResponse> queryAll() {
        return queryService.findAll().stream().map(
                place -> new PlaceQueryResponse(
                        place.getName(),
                        place.getPosition(),
                        place.getDescription(),
                        place.getImagePath()
                )
        ).collect(Collectors.toList());
    }
}
