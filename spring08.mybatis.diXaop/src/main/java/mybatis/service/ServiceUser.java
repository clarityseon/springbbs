package mybatis.service;

import java.sql.SQLException;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.dao.DaoBoard;
import mybatis.dao.DaoUser;
import mybatis.dao.IDaoBoard;
import mybatis.dao.IDaoUser;
import mybatis.model.ModelBoard;
import mybatis.model.ModelUser;

@Service("userService")
public class ServiceUser implements IServiceUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceUser.class);
    
    @Autowired
    @Qualifier("userDao")
   
    IDaoUser dao;
    
    public IDaoUser getDao() {
        return dao;
    }

    public void setDao(IDaoUser dao) {
        this.dao = dao;
    }

    public ServiceUser() {
        super();
    }

    public ServiceUser(IDaoUser dao) {
        super();
        this.dao = dao;
    }

    @Override
    public int insertUser(ModelUser user) {
        
        int result= 0;
        
        try {
            result = dao.insertUser( user);
        } catch (Exception e) {
           
            logger.error("insertUser" + e.getMessage() );
      
        }
        return result;
    }
    
    @Override
    public ModelUser login(ModelUser user) {
               
        ModelUser result=null;
        
        try {
            result = dao.login(user);
        } catch (Exception e) {
            
            logger.error("login" + e.getMessage() );
         }
        
        return result;
    }
    
    @Override
    public ModelUser logout(String userid) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int updateUserInfo(ModelUser updatevalue, ModelUser searchvalue) {
        
         int result= 0;
         
         try {
             result = dao.updateUserInfo( updatevalue ,searchvalue);
            
         } catch (Exception e) {
            
             logger.error("updateUserInfo" + e.getMessage() );
         } 
         return result;
    }
    
    @Override
    public int updatePasswd(ModelUser updatevalue, ModelUser searchvalue) {
        
        int result= 0;
        
        try {
            result = dao.updatePasswd( updatevalue ,searchvalue);
            
        } catch (Exception e) {
           
            logger.error("updatePasswd" + e.getMessage() );
            
        } 
        return result;
    }
    
    @Override
    public int deleteUser(ModelUser user) {
        
        int result= 0;
        
        try {
            result = dao.deleteUser( user );
            
        } catch (Exception e) {
           
            logger.error("deleteUser" + e.getMessage() );
           
        }
        return result;
    }
    
    @Override
    public ModelUser selectUserOne(String userid) {
        
        ModelUser result= null;
        
        try {
            result = dao.selectUserOne(userid);
        } catch (Exception e) {
            logger.error("selectUserOne" + e.getMessage() );
            
        }return result;
    }
    
    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        
        
        List<ModelUser> result=null;
        
        try {
            result = dao.selectUserList(user);
        } catch (Exception e) {
           
            logger.error("selectUserList" + e.getMessage() );
            
        }
        
        return result;
    }

  
}
