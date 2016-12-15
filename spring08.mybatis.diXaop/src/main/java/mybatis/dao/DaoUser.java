package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelBoard;
import mybatis.model.ModelUser;

@Repository("userDao")
public class DaoUser implements IDaoUser {
    
    @Autowired
    @Qualifier("sqlSession")
    
    private SqlSession session;
    
    public SqlSession getSession() {
        return session;
    }
    
    public void setSession(SqlSession session) {
        this.session = session;
    }
    
    public DaoUser(SqlSession session) {
        super();
        this.session = session;
    }

    public DaoUser() {
        super();
    }

    
    @Override
    public int insertUser(ModelUser user) {
       
        return session.insert("mybatis.mapper.mapperUser.insertUser", user);
       
    }
    
    @Override
    public ModelUser login(ModelUser user) {
       return session.selectOne("mybatis.mapper.mapperUser.login", user);
      
    }
    
    @Override
    public ModelUser logout(String userid) {
        
        return session.selectOne("mybatis.mapper.mapperUser.logout", userid);
        
    }
    
    @Override
    public int updateUserInfo(ModelUser updatevalue, ModelUser searchvalue) {
        
              
        Map<String, ModelUser> parameter = new HashMap<String, ModelUser>();
        
        parameter.put("updatevalue", updatevalue);
        parameter.put("searchvalue", searchvalue);
        
        return session.update("mybatis.mapper.mapperUser.updateUserInfo", parameter);
        
    }
    
    @Override
    public int updatePasswd(ModelUser updatevalue, ModelUser searchvalue) {
       
        Map<String, ModelUser> parameter = new HashMap<String, ModelUser>();
        
        parameter.put("updatevalue", updatevalue);
        parameter.put("searchvalue", searchvalue);
        
        return session.update("mybatis.mapper.mapperUser.updatePasswd", parameter);
        
    }
    
    @Override
    public int deleteUser(ModelUser user) {
       
        return session.delete("mybatis.mapper.mapperUser.deleteUser", user);
        
    }
    
    @Override
    public ModelUser selectUserOne(String userid) {
      
        return session.selectOne("mybatis.mapper.mapperUser.selectUserOne", userid);
        
    }
    
    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
     
        return session.selectList("mybatis.mapper.mapperUser.selectUserList",user);
         
    }


   
}
