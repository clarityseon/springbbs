package mybatis.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelBook;
import mybatis.model.ModelComments;

@Repository("boardDao")
public class DaoBoard implements IDaoBoard {
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
   
    public SqlSession getSession() {
        return session;
    }

    public void setSession(SqlSession session) {
        this.session = session;
    }
    public DaoBoard() {
        super();
    }

    public DaoBoard(SqlSession session) {
    super();
    this.session = session;
}


    @Override
    public int getBoardTotalRecord(HashMap<String, String> hashmap) {
        
        return 0;
    }

    @Override
    public String getBoardName(String boardcd) {
              
        return session.selectOne("mybatis.mapper.mapperBoard.getBoardName", boardcd);
       
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {
        
        return session.selectOne("mybatis.mapper.mapperBoard.getBoardOne", boardcd);
        
    }

    @Override
    public List<ModelBoard> getBoardList() {

        return session.selectList("mybatis.mapper.mapperBoard.getBoardList");
  
    }

    @Override
    public Map<String, ModelBoard> getBoardListResultMap() {
        
        return session.selectMap("mybatis.mapper.mapperBoard.getBoardListResultMap","boardcd");
        
    }

    @Override
    public int insertBoard(ModelBoard board) throws SQLException {
        
      
        return session.insert("mybatis.mapper.mapperBoard.insertBoard", board);
        
        
    }

    @Override
    public int updateBoard(ModelBoard updatevalue, ModelBoard searchvalue) throws SQLException {
       
       
        Map<String, ModelBoard> parameter = new HashMap<String, ModelBoard>();
        
        parameter.put("updatevalue", updatevalue);
        parameter.put("searchvalue", searchvalue);
        
        return session.update("mybatis.mapper.mapperBoard.updateBoard",
                parameter);
        
    }

    @Override
    public int deleteBoard(ModelBoard board) throws SQLException {
        
        
        Map<String, ModelBoard> parameter = new HashMap<String, ModelBoard>();
        
        parameter.put("board", board);
        return session.delete("mybatis.mapper.mapperBoard.deleteBoard",
                parameter);
        
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        
        return session.selectList("mybatis.mapper.mapperBoard.getBoardSearch",
                board);
        
    }

    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchword,
            int start, int end) {
        
            
        Map<String, Object> map= new HashMap<String, Object>();
        
         map.put("boardcd", boardcd);
         map.put("searchword", searchword);
         map.put("start", start);
         map.put("end", end);
     
        return session.selectList("mybatis.mapper.mapperBoard.getBoardPaging", map);
        
        
    }

    @Override
    public int insertBoardList(List<ModelBoard> list) {
        
        return session.insert("mybatis.mapper.mapperBoard.insertBoardList",
               list);
        
        
    }

    @Override
    public int getArticleTotalRecord(String boardcd, String searchword) {
        
        
        Map<String, String> parameter = new HashMap<String, String>();
        parameter.put("boardcd", boardcd);
        parameter.put("searchword", searchword);
        
        return session.selectOne("mybatis.mapper.mapperBoard.getArticleTotalRecord",
              parameter);
        
        
    }

    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchword,
            int start, int end) {
                
        Map<String, Object> map= new HashMap<String, Object>();
        
         map.put("boardcd", boardcd);
         map.put("searchword", searchword);
         map.put("start", start);
         map.put("end", end);
     
        return session.selectList("mybatis.mapper.mapperBoard.getArticleList", map);
        
    }

    @Override
    public ModelArticle getArticle( int articleno) {
        
        
        return session.selectOne("mybatis.mapper.mapperBoard.getArticle", articleno);
        
        
    }

    @Override
    public int insertArticle(ModelArticle article) {
        
       
        return session.insert("mybatis.mapper.mapperBoard.insertArticle", article);
        
        
    }

    @Override
    public int updateArticle(ModelArticle updatevalue, ModelArticle searchvalue) {

      
       
        Map<String, ModelArticle> parameter = new HashMap<String, ModelArticle>();
        
        parameter.put("updatevalue", updatevalue);
        parameter.put("searchvalue", searchvalue);
        
        return session.update("mybatis.mapper.mapperBoard.updateArticle", parameter);
        
    }

    @Override
    public int deleteArticle( ModelArticle article) {
       

        
       
        return session.delete("mybatis.mapper.mapperBoard.deleteArticle",
                article);
        
    }

    @Override
    public int increaseHit( int articleno) {
        

        
        
        
        return session.selectOne("mybatis.mapper.mapperBoard.increaseHit",
                articleno);
        
        
        
        }

    @Override
    public ModelArticle getNextArticle(Map<String, Object> hashmap) {
        
     

        return session.selectOne("mybatis.mapper.mapperBoard.getNextArticle", hashmap);
        
        
    }

    @Override
    public ModelArticle getPrevArticle(Map<String, Object> hashmap) {

        return session.selectOne("mybatis.mapper.mapperBoard.getPrevArticle", hashmap);
       
    }

    @Override
    public ModelAttachfile getAttachfile(int attachfileno) {
        
        return session.selectOne("mybatis.mapper.mapperBoard.getAttachfile",attachfileno);
        
        
    }

    @Override
    public List<ModelAttachfile> getAttachfileList(int articleno) {
       
        return session.selectList("mybatis.mapper.mapperBoard.getAttachFileList", articleno);
        
    }

    @Override
    public int insertAttachfile(ModelAttachfile attachfile) {
        
        return session.insert("mybatis.mapper.mapperBoard.insertAttachfile", attachfile);
        
    }

    @Override
    public int deleteAttachfile( ModelAttachfile attachfile) {
        
        return session.delete("mybatis.mapper.mapperBoard.deleteAttachfile",
                attachfile);
        
    }

    @Override
    public ModelComments getComment(ModelComments comment) {
        
        return session.selectOne("mybatis.mapper.mapperBoard.getComment",comment);
        
    }

    @Override
    public List<ModelComments> getCommentList(int articleno) {
         
        return session.selectList("mybatis.mapper.mapperBoard.getCommentList", articleno);
        
        
    }

    @Override
    public int insertComment(ModelComments comment) {
       
        return session.insert("mybatis.mapper.mapperBoard.insertComment", comment);
        
    }

    @Override
    public int updateComment(ModelComments updatevalue,ModelComments searchvalue ) {
        
        Map<String, ModelComments> parameter = new HashMap<String, ModelComments>();
        
        parameter.put("updatevalue", updatevalue);
        parameter.put("searchvalue", searchvalue);
        
        return session.update("mybatis.mapper.mapperBoard.updateComment", parameter);
        
    }

    @Override
    public int deleteComment(ModelComments comment) {
       
        return session.delete("mybatis.mapper.mapperBoard.deleteComment",
                comment);
        
    }


}
