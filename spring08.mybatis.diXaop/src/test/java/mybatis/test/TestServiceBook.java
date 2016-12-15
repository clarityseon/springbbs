package mybatis.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.model.ModelBook;
import mybatis.service.IServiceBook;
import mybatis.service.ServiceBook;

public class TestServiceBook {
    // SLF4J Logging
    private static Logger logger = LoggerFactory
            .getLogger(TestServiceBook.class);
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testgetSQLSelectAll() {
        
        IServiceBook service= new ServiceBook();
        List<ModelBook> result= service.getSQLSelectAll();
        
        assertSame(result.size(), 4);
      
    }
    @Test
    public void testgetSQLSelectLike() {
        
        IServiceBook service= new ServiceBook();
        List<ModelBook> result= service.getSQLSelectLike("SQL");
        
        assertSame(result.size(), 2);
      
    }
    @Test
    public void testgetSQLSelectEqual() {
        
        IServiceBook service= new ServiceBook();
        List<ModelBook> result= service.getSQLSelectEqual("JAVA");
        
        assertSame(result.size(), 1);
      
    }
    @Test
    public void testsetSQLInsert() {
        
        ModelBook book= new ModelBook();
        book.setAuthid(10);
        book.setBookname("test");
        book.setDtm("2016-12-06"); 
        book.setPrice(10000);
        book.setPublisher("CP");
        book.setUse_yn(true);
        book.setYear("2016");
        
        IServiceBook service= new ServiceBook();
        int result= service.setSQLInsert(book);
        
        assertSame(result , 1);
      
    }
    @Test
    public void testsetSQLUpdateWithBookid() {
        
        ModelBook updateValue= new ModelBook();
        
        updateValue.setAuthid(10);
        updateValue.setBookname("test");
        updateValue.setDtm("2016-12-06"); 
        updateValue.setPrice(10000);
        updateValue.setPublisher("CP");
        updateValue.setUse_yn(true);
        updateValue.setYear("2016");
        
        ModelBook searchValue= new ModelBook();
        searchValue.setBookid(2);
        
        
        IServiceBook service= new ServiceBook();
        int result= service.setSQLUpdate(updateValue,searchValue);
        
        assertSame(result , 1);
      
    }
    @Test
    public void testsetSQLUpdateWithAuthidAndBookname() {
        
        ModelBook updateValue= new ModelBook();
        
        updateValue.setAuthid(10);
        updateValue.setBookname("Smile");
        updateValue.setDtm("2016-12-06"); 
        updateValue.setPrice(10000);
        updateValue.setPublisher("CP");
        updateValue.setUse_yn(true);
        updateValue.setYear("2016");
        
        ModelBook searchValue= new ModelBook();
        searchValue.setBookid(3);
        searchValue.setBookname("JAVA");
        
        IServiceBook service= new ServiceBook();
        int result= service.setSQLUpdate(updateValue,searchValue);
        
        assertSame(result , 1);
      
    }
    @Test
    public void testsetSQLDelete() {
        
        ModelBook book = new ModelBook();
        book.setBookid(2);
        
        IServiceBook service= new ServiceBook();
        int result= service.setSQLDelete(book);
        
        assertSame(result, 1);
      
    }
    @Test
    public void testsetTransCommit() {
        
        ModelBook delbook= new ModelBook();
        delbook.setBookid(1);
        
        ModelBook insbook= new ModelBook();
        insbook.setAuthid(10);
        insbook.setBookname("trans test insert");
        insbook.setDtm("2016-11-12"); 
        insbook.setPrice(10000);
        insbook.setPublisher("trans test insert");
        insbook.setUse_yn(true);
        insbook.setYear("2016");
        
        
        ModelBook upbook = new ModelBook();
        upbook.setAuthid(10);
        upbook.setBookname("trans test update");
        upbook.setDtm("2016-11-12"); 
        upbook.setPrice(10000);
        upbook.setPublisher("trans test update");
        upbook.setUse_yn(true);
        upbook.setYear("2016");
       
        ModelBook searchbook= new ModelBook();
        searchbook.setBookid(3);
        
        
        IServiceBook service= new ServiceBook();
        int result= service.setTransCommit(delbook,upbook,insbook,searchbook);
        
        assertSame(result , 1);
      
    }
    @Test
    public void testsetTransRollback() {
        
        ModelBook delbook= new ModelBook();
        delbook.setBookid(1);
        
        ModelBook insbook= new ModelBook();
        insbook.setAuthid(10);
        insbook.setBookname("trans test insert");
        insbook.setDtm("2016-11-12"); 
        insbook.setPrice(10000);
        insbook.setPublisher("trans test insert");
        insbook.setUse_yn(true);
        insbook.setYear("2016");
        
        
        ModelBook upbook = new ModelBook();
        upbook.setAuthid(10);
        upbook.setBookname("trans test update");
        upbook.setDtm("2016-11-12"); 
        upbook.setPrice(10000);
        upbook.setPublisher("trans test update");
        upbook.setUse_yn(true);
        upbook.setYear("2016");
       
        ModelBook searchbook= new ModelBook();
        searchbook.setBookid(3);
        
        
        IServiceBook service= new ServiceBook();
        int result= service.setTransRollback(delbook,upbook,insbook,searchbook);
        
        assertSame(result ,-1);
      
    }
    @Test
    public void testsetSQLInsertMulti() {
        
        
        List<ModelBook> books= new ArrayList<ModelBook>();
        
        for(int i=0; i<10 ;i=i+1){
        
        ModelBook book= new ModelBook();
        book.setAuthid(11);
        book.setBookname("test insert multi"+ i);
        book.setDtm("2016-12-06"); 
        book.setPrice(10000);
        book.setPublisher("test insert multi"+ i);
        book.setUse_yn(true);
        book.setYear("2016");
        
        
        books.add(book);
        }
        
        IServiceBook service= new ServiceBook();
        int result= service.setSQLInsertMulti(books);
        
        assertSame(result , 10);
      
    }
}
