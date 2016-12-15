package mybatis.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.model.ModelBook;

public interface IServiceBook {
    

    public List<ModelBook> getSQLSelectAll();
    
    public List<ModelBook> getSQLSelectLike(String expr);

    public List<ModelBook> getSQLSelectEqual(String expr);

    public int setSQLInsert(ModelBook book) ;

    public int setSQLUpdate( ModelBook updateValue, ModelBook searchValue ) ;

    public int setSQLDelete(ModelBook book) ;
    
    public int setTransCommit( ModelBook delbook,ModelBook insbook, ModelBook upbook, ModelBook searchbook);

    public int setTransRollback(ModelBook delbook,ModelBook insbook, ModelBook upbook, ModelBook searchbook);

    int setSQLInsertMulti(List<ModelBook> books);

    
   
}
