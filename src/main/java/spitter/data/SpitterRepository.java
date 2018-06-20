package spitter.data;

public interface SpitterRepository {
    List<Spittle> findSpittles(final long max, final int count);

}
