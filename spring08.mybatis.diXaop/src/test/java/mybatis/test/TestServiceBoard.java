package mybatis.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybatis.dao.DaoBoard;
import mybatis.dao.IDaoBoard;

import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelBook;
import mybatis.model.ModelComments;
import mybatis.service.IServiceBoard;
import mybatis.service.IServiceBook;
import mybatis.service.IServiceUser;
import mybatis.service.ServiceBoard;
import mybatis.service.ServiceBook;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceBoard {
    

    private static ApplicationContext context = null;
    private static IServiceBoard service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context= new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        service=context.getBean("boardService", IServiceBoard.class);
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
    public void testgetBoardName() {
       
       
        String result = service.getBoardName("free");
        assertEquals(result, "자유게시판");
       
    }
  
    @Test
    public void  getBoardOne() {
       
     
        ModelBoard result = service.getBoardOne("free");
        assertEquals(result.getBoardnm(), "자유게시판");
    }
    
    @Test
    public void getBoardTotalRecord() {
        
    }
    
    @Test
    public void getBoardList() {
        
        ModelBoard board= new ModelBoard();
        
        List<ModelBoard> result = service.getBoardList();
        assertSame(result.size(), 13);
        assertSame(result.get(0).getBoardcd(), "qna");
        
    }
    
    @Test
    public  void  getBoardListResultMap() {
        
        
        Map<String, ModelBoard> result = service.getBoardListResultMap();
        assertSame(result.get("free").getBoardnm(), "자유게시판");
        assertSame(result.size(), 13);
    }
    
    @Test
    public  void insertBoard() throws SQLException  {
        
        
        ModelBoard board= new ModelBoard();
       
        board.setBoardcd("data");
        board.setBoardnm("데이터");
        board.setUseYN(true);
        
        
        int result= service.insertBoard(board);
        
        assertSame(result , 1);
    }
    
    @Test
    public void updateBoard() throws SQLException  {
        
        
        ModelBoard updatevalue= new ModelBoard();
        
        updatevalue.setBoardnm("질문과 답변");
        updatevalue.setUseYN(true);
      
        
        ModelBoard searchvalue= new ModelBoard();
        searchvalue.setBoardcd("qna");
        
        
        
        int result= service.updateBoard(updatevalue,searchvalue);
        
        assertSame(result , 1);
    }
    
    @Test
    public void deleteBoard() throws SQLException  {
        
        ModelBoard board= new ModelBoard();
        board.setBoardcd("data");
        
        
        int result= service.deleteBoard(board);
        
        assertSame(result, 1);
    }
    
    @Test
    public  void  getBoardSearch() {
        
        ModelBoard board= new ModelBoard();
        board.setBoardcd("a");
        
        
        List<ModelBoard> result= service.getBoardSearch(board);
        
        assertSame(result.size(), 1);
    }
    
    @Test
    public void  getBoardPaging() {
        
        String boardcd="";
        String searchword="";
        int start = 1;
        int end=10;
        
        List<ModelBoard> result = service.getBoardPaging(boardcd, searchword, start, end);
        assertSame(result.size() ,10);
    }
    
    @Test
    public void insertBoardList() {
       
        ModelBoard board= null;
        List<ModelBoard> list= new ArrayList<ModelBoard>();
        Date dtm= new Date();
        SimpleDateFormat dt= new SimpleDateFormat("yyyy-MM-dd");
        String sd = dt.format(dtm);
        
        
        for(int i=0; i<10; i=i+1){
            
            board= new ModelBoard();
            
            board.setBoardcd("notice"+sd+ i);
            board.setBoardnm("공지사항");
            board.setInsertDT(new Date());
            board.setInsertUID("insertUID"+sd+i);
            board.setUpdateDT(new Date());
            board.setUpdateUID("updateUID"+sd+i);
            board.setUseYN(true);
            
            list.add(board);
            
        }
      
        
        int result= service.insertBoardList(list);
        
        assertSame(result , 10);
    }
    
    @Test
    public void getArticleList() {

        
        String boardcd="free";
        String searchword="article";
        int start = 2;
        int end=7;
        
        List<ModelArticle> result = service.getArticleList(boardcd, searchword, start, end);
        assertSame(result.size() ,6);
    }
   
    @Test
    public void getArticleTotalRecord() {
        
        String boardcd="free";
        String searchword="art";
        
        int result= service.getArticleTotalRecord(boardcd, searchword);
        assertSame(result ,14);
        
    }
    
    @Test
    public void  getArticle() {
        
        ModelArticle result= service.getArticle(1);
        assertEquals(result, 1);
       
        
    }
    
    @Test
    public void insertArticle() {
       
        ModelArticle article= new ModelArticle();
        
        article.setBoardcd("free");
        article.setTitle("test");
        article.setContent("article test");
        article.setEmail("clarityseon@naver.com");
        article.setHit(0);
        article.setRegdate(new Date());
        
        
        
        int result= service.insertArticle(article);
        
        assertSame(result , 1);
    }
    
    @Test
    public void updateArticle() {
        
        ModelArticle updatevalue= new ModelArticle();
        
        updatevalue.setTitle("Test update");
        updatevalue.setContent("article update");
        updatevalue.setUseYN(false);
        updatevalue.setUPDATEUID("");
        updatevalue.setUPDATEDT(new Date());
        
        
        ModelArticle searchvalue= new ModelArticle();
        
        searchvalue.setArticleno(2);
        
        
        
        int result= service.updateArticle(updatevalue,searchvalue);
        
        assertSame(result , 1);
      
    }
    
    @Test
    public void deleteArticle() {

        ModelArticle article= new ModelArticle();
        article.setArticleno(70);
        
        
        int result= service.deleteArticle(article);
        
        assertSame(result, 1);
    }
    
    @Test
    public void increaseHit() {
        
        int articleno =1;
        
        
        
        ModelArticle bfarticle= service.getArticle(articleno);
        service.increaseHit(articleno);
        ModelArticle afarticle= service.getArticle(articleno);
        
        
        assertSame(bfarticle.getHit()+2, afarticle.getHit());
        
        
        
    }
    
    @Test
    public void getNextArticle() {
        
        
        ModelArticle result=service.getNextArticle(1, "free", "");
        
        assertSame(result.getArticleno(), 2);
       
        
    }
    
    @Test
    public void getPrevArticle() {
        
        ModelArticle result=service.getPrevArticle(3, "free", "");
        
        assertSame(result.getArticleno(), 2);
        
      
    }
    
    @Test
    public void  getAttachfileList() {

        
        List<ModelAttachfile> result = service.getAttachfileList(1);
        assertSame(result.size(),7);
        
    }
    
    @Test
    public void  getAttachfile() {
        
        
        
        ModelAttachfile result= service.getAttachfile(1);
        
        assertSame(result, 1);
    }
    
    @Test
    public void insertAttachfile() {
        
        ModelAttachfile af= new ModelAttachfile();
        
        af.setFilename("어태치파일 insert");   
        af.setFiletype("파일타입");  
        af.setFilesize(10);   
        af.setArticleno(1);    
        af.setInsertdt(new Date());   
        af.setInsertuid("Attachfile");    
        af.setUpdatedt(new Date());
        af.setUpdateuid("filetype");   
        
        
        int result= service.insertAttachfile(af);
        
        assertSame(result , 1);
    }
    
    @Test
    public void deleteAttachfile() {
       
        ModelAttachfile af= new ModelAttachfile();
        af.setAttachfileno(3);
        
        
        int result= service.deleteAttachfile(af);
        
        assertSame(result, 1);
        
    }
    
    @Test
    public void getCommentList() {
       
        
        
        List<ModelComments> result = service.getCommentList(1);
        assertSame(result.size() ,1);
        
    }
    
    @Test
    public void getComment() {
        
        ModelComments cm= new ModelComments();
        cm.setCommentno(1);
       
        
        ModelComments result= service.getComment(cm);
        
        assertSame(result, 1); 
        
    }
    
    @Test
    public void insertComment() {
       
        ModelComments cm= new ModelComments();
        
        cm.setArticleno(2);
        cm.setEmail("clarityseon@hotmail.com");
        cm.setMemo("comment insert test");
        cm.setRegdate(new Date());
        cm.setInsertUID("");
        cm.setInsertDT(new Date());
        cm.setUpdateUID("");
        cm.setUpdateDT(new Date());
        
        
        
        int result= service.insertComment(cm);
        
        assertSame(result , 1);
        
    }
    
    @Test
    public void updateComment() {
        
        ModelComments updatevalue= new ModelComments();
        
        updatevalue.setMemo("comment update test");
        updatevalue.setEmail("cc@cc.co.kr");
        updatevalue.setUseYN(true);
        
        
        ModelComments searchvalue= new ModelComments();
        
        searchvalue.setCommentno(22);
        
        
        
        int result= service.updateComment(updatevalue,searchvalue);
        
        assertSame(result , 1);
      
        
    }
    
    @Test
    public void deleteComment() {
        
        ModelComments cm= new ModelComments();
        cm.setCommentno(21);
        
        
        int result= service.deleteComment(cm);
        
        assertSame(result, 1); 
    }
}
