package nl.workingspirit.series;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class SeriesService {

    private final List<Series> series;

    public SeriesService() {
        this.series = asList(
            new Series(1L, "Breaking Bad", "https://media.pathe.nl/nocropthumb/620x955/gfx_content/posters/breakingbad1.jpg", 52),
            new Series(2L, "Mr. Robot", "https://i.pinimg.com/originals/5c/b1/ed/5cb1edca75dbc35da8336392482fedce.jpg", 10),
            new Series(3L, "Stranger Things", "https://m.media-amazon.com/images/M/MV5BODZlYjQ4NzYtZTg1MC00NGY4LTg4NjQtNGE3ZjRkMjk3YjMyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg", 1),
            new Series(4L, "The Walking Dead", "https://media.comicbook.com/2018/09/twd-rick-key-art-1132038.jpeg", 100)
        );
    }

    public List<Series> getAllSeries() {
        return this.series;
    }

    public Series getSeriesById(final Long id) {
        return this.series
            .stream()
            .filter(s -> s.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> HttpClientErrorException.create("Series not found", HttpStatus.BAD_REQUEST, null, null, null, null));
    }

}
