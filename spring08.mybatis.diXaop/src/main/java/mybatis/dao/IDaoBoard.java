package mybatis.dao;

import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelComments;

public interface IDaoBoard {

    /*
     * 특정 게시판의 총 게시물 갯수 구하기
     */
    public abstract int getBoardTotalRecord( HashMap<String, String> hashmap);
    
    /*
     * 게시판이름 구하기
     */
    public abstract String getBoardName( String boardcd);

    /*
     * 게시판 모델 객체 구하기
     */
    public abstract ModelBoard getBoardOne( String boardcd);
    
    /*
     * 게시판종류 리스트 구하기
     */
    public abstract List<ModelBoard> getBoardList();
    
    /*
     * 게시판종류 리스트 구하기
     */
    public abstract Map<String, ModelBoard> getBoardListResultMap();
    
    /*
     * 게시판  추가
     */
    public abstract int insertBoard( ModelBoard board) throws SQLException;
    
    /*
     * 게시판  수정
     */
    public abstract int updateBoard(ModelBoard updatevalue, ModelBoard searchvalue) throws SQLException;
    
    /*
     * 게시판  삭제
     */
    public abstract int deleteBoard( ModelBoard board) throws SQLException;
    
    /*
     * 
     */
    public abstract List<ModelBoard> getBoardSearch( ModelBoard board);
    
    /*
     * 
     */
    public abstract List<ModelBoard> getBoardPaging(String boardcd, String searchword,
            int start, int end);
    
    /*
     * 
     */
    public abstract int insertBoardList( List<ModelBoard> list);
    
    
    
    
    

    /*
     * 특정 게시판의 총 게시물 갯수 구하기
     */
    public abstract int getArticleTotalRecord( String boardcd, String searchword);

    /*
     * 게시판 목록
     */
    public abstract List<ModelArticle> getArticleList( String boardcd, String searchword, int start, int end);

    /*
     * 게시글 상세보기
     */
    public abstract ModelArticle getArticle( int articleno);

    /*
     * 새로운 게시글  추가
     */
    public abstract int insertArticle( ModelArticle article);

    /*
     * 게시글 수정
     */
    public abstract int updateArticle(ModelArticle updatevalue, ModelArticle searchvalue);

    /*
     * 게시글 삭제
     */
    public abstract int deleteArticle( ModelArticle article);

    /*
     * 조회수 증가
     */
    public abstract int increaseHit( int articleno);
    
    /*
     * 다음글 보기 articleNo,boardCd,searchWord->HahMap 에 담는다
     */
    public abstract ModelArticle getNextArticle( Map<String, Object> hashmap);

    /*
     * 이전글 보기 articleNo,boardCd,searchWord->HahMap 에 담는다
     */
    public abstract ModelArticle getPrevArticle( Map<String, Object> hashmap);

    /*
     * 첨부파일
     */
    public abstract ModelAttachfile getAttachfile( int attachfileno);
    
    /*
     * 게시글의 첨부파일 리스트
     */
    public abstract List<ModelAttachfile> getAttachfileList( int articleno);

    /*
     * 새로운 첨부파일 추가 
     */
    public abstract int insertAttachfile( ModelAttachfile attachfile);

    /*
     * 첨부파일 삭제
     */
    public abstract int deleteAttachfile(  ModelAttachfile attachfile);
    
    /*
     * 덧글쓰기
     */
    public abstract int insertComment( ModelComments comment);

    /*
     * 덧글수정
     */
    public abstract int updateComment( ModelComments updatevalue,ModelComments searchvalue);

    /*
     * 덧글삭제
     */
    public abstract int deleteComment( ModelComments comment);

    /*
     * 덧글가져오기
     */
    public abstract ModelComments getComment( ModelComments comment);

    /*
     * 게시글의 덧글리스트 구하기
     */
    public abstract List<ModelComments> getCommentList( int articleno);

    

}