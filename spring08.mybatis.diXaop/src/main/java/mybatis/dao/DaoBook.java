package mybatis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelBook;;

@Repository("bookDao")
public class DaoBook implements IDaoBook {
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    public SqlSession getSession() {
        return session;
    }

    public void setSession(SqlSession session) {
        this.session = session;
    }

    public DaoBook(SqlSession session) {
        super();
        this.session = session;
    }

    public DaoBook() {
        super();
    }

    @Override
    public List<ModelBook> getSQLSelectAll() throws SQLException {
        
        return session.selectList("mybatis.mapper.mapperBook.getSQLSelectAll");
       
    }
    
    @Override
    public List<ModelBook> getSQLSelectLike(String bookname)
            throws SQLException {
        
        return session.selectList("mybatis.mapper.mapperBook.getSQLSelectLike",
                bookname);
       
    }
    
    @Override
    public List<ModelBook> getSQLSelectEqual(String bookname)
            throws SQLException {
        
        return session.selectList("mybatis.mapper.mapperBook.getSQLSelectEqual",
                bookname);
        
    }
    
    @Override
    public int setSQLInsert(ModelBook book) throws SQLException {
        
        return session.insert("mybatis.mapper.mapperBook.setSQLInsert", book);
        
    }
    
    @Override
    public int setSQLInsertMulti(ModelBook books) throws SQLException {
        
        return session.insert("mybatis.mapper.mapperBook.setSQLInsertMulti",
                books);
        
    }
        
    @Override
    public int setSQLUpdate(ModelBook updatevalue, ModelBook searchvalue)
            throws SQLException {
        
        Map<String, ModelBook> parameter = new HashMap<String, ModelBook>();
        
        parameter.put("updatevalue", updatevalue);
        parameter.put("searchvalue", searchvalue);
        
        return session.update("mybatis.mapper.mapperBook.setSQLUpdate",
                parameter);
        
    }
    
    @Override
    public int setSQLDelete(ModelBook book) {
       
        
        Map<String, ModelBook> parameter = new HashMap<String, ModelBook>();
        
        parameter.put("book", book);
        return session.delete("mybatis.mapper.mapperBook.setSQLDelete",
                parameter);
        
        
    }
   

    
}
