package ru.niyaz.forumserver.repository.news;

import org.hibernate.Criteria;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.niyaz.forumserver.entity.news.News;
import ru.niyaz.forumserver.entity.news.attachment.Attachment;
import ru.niyaz.forumserver.repository.AbstractRepository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by Нияз on 01.02.2017.
 */

@Repository
public class NewsRepositoryImpl extends AbstractRepository implements NewsRepository {

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveNews(List<News> news) throws Exception {
        Session session = getCurrentSession();
        for (News n : news) {
            News exist = get(n.getNewsId());
            if (exist != null) {
                n.setId(exist.getId());
                Query query = session.createNativeQuery("DELETE FROM attachment WHERE news_id=:newsId");
                query.setParameter("newsId", exist.getId());
                query.executeUpdate();
                session.flush();
                session.saveOrUpdate(n);
            } else {
                session.saveOrUpdate(n);
            }

            if (n.getAttachments() != null) {
                for (Attachment at : n.getAttachments()) {
                    session.saveOrUpdate(at);
                    at.setNews(n);
                }
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<News> getNews(Instant from, Instant to) throws Exception {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<News> query = builder.createQuery(News.class);
        Root<News> root = query.from(News.class);
        Predicate predicate = builder.greaterThan(root.get("date"), new Date(from.toEpochMilli()));
        Predicate predicate2 = builder.lessThan(root.get("date"), new Date(to.toEpochMilli()));
        query.select(root).where(builder.and(predicate, predicate2));
        List<News> newsList = session.createQuery(query).list();
        return newsList;
    }

    private News get(Long newsId) {
        Session session = getNewSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<News> query = builder.createQuery(News.class);
        Root<News> root = query.from(News.class);
        Predicate predicate = builder.equal(root.get("newsId"), newsId);
        query.select(root).where(predicate);
        List<News> existNews = session.createQuery(query).list();
        session.close();
        if (existNews.size() == 1) {
            return existNews.get(0);
        } else {
            return null;
        }
    }
}
