package mybatis.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.dao.DaoBoard;
import mybatis.dao.DaoBook;
import mybatis.dao.IDaoBoard;
import mybatis.dao.IDaoBook;
import mybatis.dao.IDaoUser;
import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelBook;
import mybatis.model.ModelComments;

@Service("boardService")
public class ServiceBoard implements IServiceBoard {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceBoard.class);
   
    @Autowired
    @Qualifier("boardDao")
    
    IDaoBoard dao;
    
    public IDaoBoard getDao() {
        return dao;
    }

    public void setDao(IDaoBoard dao) {
        this.dao = dao;
    }
    
    public ServiceBoard() {
        super();
    }

    public ServiceBoard(IDaoBoard dao) {
        super();
        this.dao = dao;
    }

    @Override
    public String getBoardName(String boardcd) {
 
        String result=null;
        
        try {
            result = dao.getBoardName(boardcd);
        } catch (Exception e) {
           
            logger.error("getSQLSelectAll" + e.getMessage() );
            
        }
         
        return result;
       
    }
    
    @Override
    public ModelBoard getBoardOne(String boardcd) {
       
        ModelBoard result=null;
        
        try {
            result = dao.getBoardOne(boardcd);
        } catch (Exception e) {
           
            logger.error("getBoardOne" + e.getMessage() );
            
        }
        
        return result;
       
    }
   
    
    @Override
    public int getBoardTotalRecord(String boardcd, String searchword) {
     
        return 0;
    }
    
    @Override
    public List<ModelBoard> getBoardList() {
       
        List<ModelBoard> result=null;
        
        try {
            result = dao.getBoardList();
        } catch (Exception e) {
           
            logger.error("getSQLSelectAll" + e.getMessage() );
            
        }
       
        return result;
    }
    
    @Override
    public Map<String, ModelBoard> getBoardListResultMap() {
        
        
        Map<String, ModelBoard> result=null;
        
        try {
            result = dao.getBoardListResultMap();
        } catch (Exception e) {
            
            
            logger.error("getSQLSelectAll" + e.getMessage() );
            
        }
        
        return result;
    }
    
    @Override
    public int insertBoard(ModelBoard board) throws SQLException {
       
        int result= 0;
        
        try {
            result = dao.insertBoard( board);
        } catch (SQLException e) {
           
            logger.error("setSQLInsert" + e.getMessage() );
          
        }
        return result;
    }
    
    @Override
    public int updateBoard(ModelBoard updatevalue, ModelBoard searchvalue) throws SQLException {
        
        
        int result= 0;
        
        try {
            result = dao.updateBoard( updatevalue ,searchvalue);
        } catch (SQLException e) {
           
            logger.error("setSQLUpdate" + e.getMessage() );
           
        }
        return result;
    }
    
    @Override
    public int deleteBoard(ModelBoard board) throws SQLException {
        
        int result= 0;
        
        try {
            result = dao.deleteBoard( board );
           
        } catch (SQLException e) {
           
            logger.error("setSQLDelete" + e.getMessage() );
           
        }
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        
        List<ModelBoard> result= null;
        
        
        try {
            result = dao.getBoardSearch( board);
        } catch (Exception e) {
            
            
            logger.error("getBoardSearch" + e.getMessage() );
           
        }
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchword,
            int start, int end) {
        
        List<ModelBoard> result= null;
       
        
        try {
            result = dao.getBoardPaging(boardcd,searchword,start,end);
            
            
        } catch (Exception e) {
           
            logger.error("getBoardPaging" + e.getMessage() );
          
        }
        return result;
    }
   
    
    @Override
    public int insertBoardList(List<ModelBoard> list) {

        int result= 0;
        
        try {
            result = dao.insertBoardList(list);
        } catch (Exception e) {
           
            logger.error("setSQLInsert" + e.getMessage() );
          
        }
        return result;
    }
    
    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchword,
            int start, int end) {
       
        List<ModelArticle> result= null;
       
        
        try {
            result = dao.getArticleList(boardcd,searchword,start,end);
            
            
        } catch (Exception e) {
           
            logger.error("getArticleList" + e.getMessage() );
          
        }
        return result;

    }
    
    @Override
    public ModelArticle getArticle(int articleno) {
        
        ModelArticle result = null;
        
        
        try {
            result = dao.getArticle( articleno);
            dao.increaseHit(result.getArticleno());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            
            logger.error("getArticle" + e.getMessage() );
           
        }
      return result;
    }
    
    @Override
    public int getArticleTotalRecord(String boardcd, String searchword) {
        
        int result= 0;
        
        try {
            result = dao.getArticleTotalRecord(boardcd, searchword);
        } catch (Exception e) {
            
            logger.error("getSQLSelectAll" + e.getMessage() );
            
        }
        
        return result;
    }
    
    @Override
    public int insertArticle(ModelArticle article) {
       
        int result= 0;
        
        try {
            result = dao.insertArticle( article);
            
           
        } catch (Exception e) {
           
            logger.error("insertArticle" + e.getMessage() );
          
          
        }
        return result;
    }
    
    @Override
    public int updateArticle(ModelArticle updatevalue, ModelArticle searchvalue) {
        
        
        int result= 0;
        
        try {
            result = dao.updateArticle( updatevalue ,searchvalue);
           
        } catch (Exception e) {
           
            logger.error("updateArticle" + e.getMessage() );
           
        }
        return result;
    }
    
    @Override
    public int deleteArticle(ModelArticle article) {
        
        
        int result= 0;
        
        try {
            result = dao.deleteArticle( article );
           
        } catch (Exception e) {
           
            logger.error("deleteArticle" + e.getMessage() );
           
        }
        return result;
        
    }
    
    @Override
    public int increaseHit( int articleno) {
        
        
        int result= 0;
        
        try {
            result = dao.increaseHit( articleno );
           
        } catch (Exception e) {
           
            logger.error("increaseHit" + e.getMessage() );
           
        }
        return result;
        
    }
  
    
    @Override
    public ModelArticle getNextArticle(int articleno, String boardcd, String searchword) {
        
        Map<String, Object> map= new HashMap<String, Object>();
        map.put("articleno", articleno);
        map.put("boardcd", boardcd);
        map.put("searchword", searchword);
        
       
        ModelArticle result = null;
        
        
        try {
            result = dao.getNextArticle( map);
            
        } catch (Exception e) {
            
            logger.error("getNextArticle" + e.getMessage() );
        }
      return result;
        
    }
    
    @Override
    public ModelArticle getPrevArticle(int articleno, String boardcd, String searchword) {
        
        Map<String, Object> map= new HashMap<String, Object>();
        map.put("articleno", articleno);
        map.put("boardcd", boardcd);
        map.put("searchword", searchword);
        
       
        ModelArticle result = null;
       
        try {
            result = dao.getPrevArticle( map);
            
        } catch (Exception e) {
            
            logger.error("getPrevArticle" + e.getMessage() );
        }
      return result;
    }
    
    @Override
    public List<ModelAttachfile> getAttachfileList(int articleno) {
       
        List<ModelAttachfile> result= null;
       
        
        try {
            result = dao.getAttachfileList(articleno);
            
            
        } catch (Exception e) {
           
            logger.error("getArticleList" + e.getMessage() );
          
        }
        return result;
    }
    
    @Override
    public ModelAttachfile getAttachfile(int attachfileno) {
        
        
        ModelAttachfile result = null;
        
        
        try {
            result = dao.getAttachfile( attachfileno);
        } catch (Exception e) {
            
            logger.error("getAttachfile" + e.getMessage() );
            
        }
      return result;
    }
    
    @Override
    public int insertAttachfile(ModelAttachfile attachfile) {
        
        int result= 0;
        
        try {
            result = dao.insertAttachfile( attachfile);
            
           
        } catch (Exception e) {
           
            logger.error("insertAttachfile" + e.getMessage() );
          
          
        }
        return result;
    }
    
    @Override
    public int deleteAttachfile( ModelAttachfile attachfile) {
        
        int result= 0;
        
        try {
            result = dao.deleteAttachfile( attachfile );
           
        } catch (Exception e) {
           
            logger.error("deleteAttachfile" + e.getMessage() );
           
        }
        return result;
    }
    
    @Override
    public List<ModelComments> getCommentList(int articleno) {
        
        List<ModelComments> result= null;
       
        
        try {
            result = dao.getCommentList(articleno);
            
            
        } catch (Exception e) {
           
            logger.error("getCommentList" + e.getMessage() );
          
        }
        return result;
    }
    
    @Override
    public ModelComments getComment(ModelComments comment) {
        
        ModelComments result = null;
        
        
        try {
            result = dao.getComment( comment);
        } catch (Exception e) {
            
            logger.error("getComment" + e.getMessage() );
            
        }
      return result;
    }
    
    @Override
    public int insertComment(ModelComments comment) {
        
        int result= 0;
        
        try {
            result = dao.insertComment( comment);
            
           
        } catch (Exception e) {
           
            logger.error("insertComment" + e.getMessage() );
          
          
        }
        return result;
    }
    
    @Override
    public int updateComment(ModelComments updatevalue,ModelComments searchvalue) {

        int result= 0;
        
        try {
            result = dao.updateComment( updatevalue ,searchvalue);
           
        } catch (Exception e) {
           
            logger.error("updateComment" + e.getMessage() );
           
        }
        return result;
    }
    
    @Override
    public int deleteComment(ModelComments comment) {
        
        int result= 0;
        
        try {
            result = dao.deleteComment( comment );
           
        } catch (Exception e) {
           
            logger.error("deleteComment" + e.getMessage() );
           
        }
        return result;
    }

  

}
