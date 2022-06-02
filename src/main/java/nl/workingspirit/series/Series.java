package nl.workingspirit.series;

public class Series {

    private final Long id;

    private final String title;

    private final String cover;

    private final int numberOfEpisodes;

    public Series(
        final Long id,
        final String title,
        final String cover,
        final int numberOfEpisodes
    ) {
        this.id = id;

        this.title = title;
        this.cover = cover;

        this.numberOfEpisodes = numberOfEpisodes;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

}
