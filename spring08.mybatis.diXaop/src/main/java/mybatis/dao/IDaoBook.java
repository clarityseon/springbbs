package mybatis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.model.ModelBook;

public interface IDaoBook {
    
    List<ModelBook> getSQLSelectAll() throws SQLException;
    
    List<ModelBook> getSQLSelectLike( String bookname)
            throws SQLException;
    
    List<ModelBook> getSQLSelectEqual( String bookname)
            throws SQLException;
    
    int setSQLInsert(ModelBook book)
            throws SQLException;
  
    int setSQLUpdate( ModelBook updateValue, ModelBook searchValue)
            throws SQLException;
    
        
    int setSQLDelete( ModelBook book) throws SQLException;

    int setSQLInsertMulti( ModelBook books)
            throws SQLException;

    
    
  
    
   
}
