package dev.briiiqtt.shorturl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID> {

    default void deleteIfExists(T entity) {
        try {
            delete(entity);
        } catch (EmptyResultDataAccessException ignored) {
            // 없으면무시
        }
    }
}
