package com.wanxp.blog.dao.impl;


import com.wanxp.blog.dao.BaseDaoI;
import com.wanxp.blog.model.IEntity;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class BaseDaoImpl<T> implements BaseDaoI<T>{
    @Autowired
    private SessionFactory sessionFactory;
    /**
     * 获取当前事物的session
     */
    public Session getCurrentSession(){
        Session session = this.sessionFactory.getCurrentSession();
        return session;
    }

    public Serializable save(T o) {
        if(o != null) {
            if (o instanceof IEntity) {
                IEntity entity =(IEntity) o;
                if (entity.getAddtime() == null) entity.setAddtime(new Date());
                entity.setUpdatetime(new Date());
            }
            return  this.getCurrentSession().save(o);
        }
        return null;
    }

    public void delete(T o) {
        if (o !=null) {
            this.getCurrentSession().delete(o);
        }
    }

    public void update(T o) {
        if (o != null) {
            this.getCurrentSession().update(o);
        }
    }

    public void saveOrUpdate(T o) {
        if (o != null){
            this.getCurrentSession().saveOrUpdate(o);
        }
    }

    public T get(Class<T> c, Serializable id) {
        return (T)this.getCurrentSession().get(c, id);
    }

    public T get(String hql) {
        Query q = this.getCurrentSession().createQuery(hql);
        List<T> l = q.list();
        if (l != null && l.size() >0) {
            return l.get(0);
        }
        return null;
    }

    public T get(String hql, Map<String, Object> params) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
        }
        List<T> l= q.list();
        if(l != null && l.size() >0) {
            return l.get(0);
        }
        return null;
    }

    public List<T> find(String hql) {
        return this.getCurrentSession().createQuery(hql).list();
    }

    public List<T> find(String hql, Map<String, Object> params) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() instanceof Object[]) {
                    q.setParameterList(entry.getKey(), (Object[])entry.getValue());
                }else {
                    q.setParameter(entry.getKey(), entry.getValue());
                }
            }
            return q.list();
        }
        return null;
    }

    public List<T> find(String hql, int page, int rows) {
        Query q = this.getCurrentSession().createQuery(hql);
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() instanceof Object[]) {
                    q.setParameterList(entry.getKey(), (Object[])entry.getValue());
                }else {
                    q.setParameter(entry.getKey(), entry.getValue());
                }
            }
            return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
        }
        return null;
    }

    public Long count(String hql) {
        return (Long)this.getCurrentSession().createQuery(hql).uniqueResult() ;
   }

    public Long count(String hql, Map<String, Object> params) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() instanceof Object[]) {
                    q.setParameterList(entry.getKey(), (Object[])entry.getValue());
                }else {
                    q.setParameter(entry.getKey(), entry.getValue());
                }
            }
            return (Long)q.uniqueResult();
        }
        return null;
    }

    public int executeHql(String hql) {
        return this.getCurrentSession().createQuery(hql).executeUpdate();
    }

    public int executeHql(String hql, Map<String, Object> params) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return q.executeUpdate();
    }

    public List<Object[]> findBySql(String sql) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        return q.list();
    }

    public List<Object[]> findBySql(String sql, int page, int rows) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    public List<Object[]> findBySql(String sql, Map<String, Object> params) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return q.list();
    }

    public List<Object[]> findBySql(String sql, Map<String, Object> params, int page, int rows) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    public List<Map> findBySql2Map(String sql) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return q.list();
    }

    public List<Map> findBySql2Map(String sql, int page, int rows) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    public List<Map> findBySql2Map(String sql, Map<String, Object> params) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
        }
        q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return q.list();
    }

    public List<Map> findBySql2Map(String sql, Map<String, Object> params, int page, int rows) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
        }
        q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    public int executeSql(String sql) {
        return this.getCurrentSession().createSQLQuery(sql).executeUpdate();

    }

    public int executeSql(String sql, Map<String, Object> params) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return q.executeUpdate();
    }

    public BigInteger countBySql(String sql) {
        return (BigInteger)this.getCurrentSession().createSQLQuery(sql).uniqueResult();
    }

    public BigInteger countBySql(String sql, Map<String, Object> params) {
        SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                q.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return (BigInteger)q.uniqueResult();
    }
}
