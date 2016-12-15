package mybatis.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.dao.*;
import mybatis.model.ModelBook;

@Service("bookService")
public class ServiceBook implements IServiceBook {
    
    private static Logger logger = LoggerFactory.getLogger(ServiceBook.class);
    
    @Autowired
    @Qualifier("bookDao")
    IDaoBook dao;
    
    private SqlSession session;
    
    public SqlSession getSession() {
        return session;
    }

    public void setSession(SqlSession session) {
        this.session = session;
    }
   
    public ServiceBook() {
    super();
    }

    public ServiceBook(SqlSession session){
        super();
        this.session= session;
    }
    
    @Override
    public List<ModelBook> getSQLSelectAll() {
       
        List<ModelBook> result= null;
        
        
        try {
            result = dao.getSQLSelectAll();
        } catch (SQLException e) {
            
            logger.error("getSQLSelectAll" + e.getMessage() );
            
        }
       
        return result;
    }
    @Override
    public List<ModelBook> getSQLSelectLike(String expr) {
       
        List<ModelBook> result= null;
        
        
        try {
            result = dao.getSQLSelectLike( expr);
        } catch (SQLException e) {
            
            logger.error("getSQLSelectLike" + e.getMessage() );
            
        }
        
       
        return result;
    }
    @Override
    public List<ModelBook> getSQLSelectEqual(String expr) {
        
        
        List<ModelBook> result= null;
        
        
        try {
            result = dao.getSQLSelectEqual( expr);
        } catch (SQLException e) {
            
            logger.error("getSQLSelectEqual" + e.getMessage() );
            
        }
        
        return result;
    }
    @Override
    public int setSQLInsert(ModelBook book) {
        
        int result= 0;
        
        try {
            result = dao.setSQLInsert( book);
        } catch (SQLException e) {
           
            logger.error("setSQLInsert" + e.getMessage() );
           
        }
        return result;
    }
    @Override
    public int setSQLUpdate( ModelBook updateValue, ModelBook searchValue) {
        
        int result= 0;
        
        try {
            result = dao.setSQLUpdate( updateValue,searchValue);
        } catch (SQLException e) {
           
            logger.error("setSQLUpdate" + e.getMessage() );
            
        }
        return result;
    }
    @Override
    public int setSQLDelete(ModelBook book) {
        
        int result= 0;
        
        try {
            result = dao.setSQLDelete( book );
        } catch (SQLException e) {
           
            logger.error("setSQLDelete" + e.getMessage() );
            
        }
        return result;
    }
 
    @Override
    public int setTransCommit(ModelBook delbook,ModelBook insbook, ModelBook upbook, ModelBook searchbook) {
       
        int result= -1;
        
        try {
            dao.setSQLDelete( delbook);
            dao.setSQLInsert( insbook);
            dao.setSQLUpdate( insbook, searchbook);
           
            result = 1;
            
        } catch (SQLException e) {
           
            logger.error("setTransCommit" + e.getMessage() );
            
            
        }
        return result;
    
    }
    @Override
    public int setTransRollback(ModelBook delbook,ModelBook insbook, ModelBook upbook, ModelBook searchbook) {
        
        int result= -1;
        
        try {
            dao.setSQLDelete( delbook);
            dao.setSQLInsert( insbook);
            dao.setSQLUpdate( insbook, searchbook);
            
            result = 1;
            
            throw new SQLException("rollback test");
            
        } catch (SQLException e) {
           
            logger.error("setTransCommit" + e.getMessage() );
            
            result= -1;
            
        }
        return result;
    
    }
    @Override
    public int setSQLInsertMulti(List<ModelBook> books) {
        
        
        int result= 0;
        
        try {
            for(int i=0; i<books.size();i++){
            result += dao.setSQLInsert( books.get(i));
            }
        } catch (SQLException e) {
           
            logger.error("setSQLInsert" + e.getMessage() );
           
           
        }
        
        return result;
    }
}
