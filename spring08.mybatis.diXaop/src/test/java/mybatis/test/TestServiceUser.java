package mybatis.test;

import static org.junit.Assert.*;

import org.junit.runners.MethodSorters;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybatis.model.ModelUser;
import mybatis.service.IServiceUser;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceUser {
    
    private static ApplicationContext context = null;
    private static IServiceUser service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context= new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        service=context.getBean("userService", IServiceUser.class);
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
    public void insertUser() {
       
        ModelUser user= new ModelUser();
        
        user.setUserid("insert SSSS");
        user.setEmail("seon0314@hanmail.net");
        user.setPasswd("1234");
        user.setName("Sophie");
        user.setMobile("010-1234-5678");
        user.setRetireYN(true);
        user.setInsertUID("");
        user.setInsertDT(new Date());
        user.setUpdateUID("");
        user.setUpdateDT(new Date());
        
        
        ////IServiceUser service = new ServiceUser (session);
        int result= service.insertUser(user);
        assertSame(result , 1);
    }
    
    
    @Test
    public void login() {
        
        ModelUser user= new ModelUser();
        
        user.setUserid("SS");
        user.setPasswd("updatepasswd");
        
        //IServiceUser service = new ServiceUser(session);
        ModelUser result= service.login(user);
        
        assertEquals(result.getPasswd(),"updatepasswd" );
        
       
    }
    @Test
    public void updateUserInfo(){
        
        ModelUser updatevalue= new ModelUser();
        
        updatevalue.setPasswd("123");
        updatevalue.setEmail("update@hanmail.net");
        updatevalue.setRetireYN(true);
        updatevalue.setMobile("010-9876-5432");
        updatevalue.setUpdateUID("");
        updatevalue.setUpdateDT(new Date());
      
        
        ModelUser searchvalue= new ModelUser();
        searchvalue.setUserid("SS");
               
        ////IServiceUser service= new ServiceUser(session)
        int result= service.updateUserInfo(updatevalue,searchvalue);
        
        assertSame(result , 1);
        
    }
    @Test
    public void updatePasswd(){
        
        ModelUser updatevalue= new ModelUser();
        updatevalue.setPasswd("updatepasswd");
        
        ModelUser searchvalue= new ModelUser();
        searchvalue.setUserid("SS");
               
        //IServiceUser service= new ServiceUser(session)
        int result= service.updatePasswd(updatevalue,searchvalue);
        
        assertSame(result , 1);
        
    }
  
    @Test
    public void deleteUser() throws SQLException  {
        
        ModelUser user= new ModelUser();
        user.setUserid("SSSSS");
        
        //IServiceUser service= new ServiceUser(session)
        int result= service.deleteUser(user);
        
        assertEquals(result, 1);
    }
    
    
    @Test
    public void  selectUserOne(){
      
        //IServiceUser service= new ServiceUser(session)
        ModelUser result= service.selectUserOne("SS");
        
        assertEquals(result.getEmail(), "update@hanmail.net");
        
        
    }
    
  @Test
    public void selectUserList(){
        
      ModelUser user= new ModelUser();
      user.setUserid("SSS");
      
      //IServiceUser service= new ServiceUser(session)
      List<ModelUser> result= service.selectUserList(user);
      
      assertEquals(result.size(), 1);
    }
}
