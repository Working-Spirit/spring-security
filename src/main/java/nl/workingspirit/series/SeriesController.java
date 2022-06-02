package nl.workingspirit.series;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {

    private final SeriesService seriesService;

    @Autowired
    public SeriesController(
        final SeriesService seriesService
    ) {
        this.seriesService = seriesService;
    }

    @GetMapping
    public ResponseEntity<List<Series>> getAllSeries() {
        return ResponseEntity.ok(
            this.seriesService.getAllSeries()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Series> getSeriesById(
        @PathVariable("id") final Long id
    ) {
        return ResponseEntity.ok(
            this.seriesService.getSeriesById(id)
        );
    }

}
