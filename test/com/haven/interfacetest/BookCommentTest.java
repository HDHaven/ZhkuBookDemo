package com.haven.interfacetest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.haven.interfaces.BookCommentInterface;
import com.haven.model.BookComment;
import com.haven.util.MyBatisUtil;

public class BookCommentTest {

	private SqlSession sqlSession = null;
	private BookCommentInterface ci = null;
	
	@Test
	public void testComment_insert() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ci = sqlSession.getMapper(BookCommentInterface.class);
			BookComment comment = new BookComment(1, 3, "Jayin", 4, "���Ż��У�������׷����");
			int count = ci.insert(comment);
			System.out.println("�����������"+ count);
			System.out.println("��������۱�ţ�"+ comment.getCommentId());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testComment_deleteOne() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ci = sqlSession.getMapper(BookCommentInterface.class);
			int count = ci.deleteOne(1);
			System.out.println("ɾ��������"+ count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testComment_deleteBatch() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ci = sqlSession.getMapper(BookCommentInterface.class);
			List<Integer> ids = new ArrayList<Integer>();
			ids.add(2);
			ids.add(3);
			ids.add(4);
			int count = ci.deleteBatch(ids);
			System.out.println("ɾ��������"+ count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testComment_getComment() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ci = sqlSession.getMapper(BookCommentInterface.class);
			List<BookComment> commentList = ci.getComment("Haven");
			if(commentList != null && !commentList.isEmpty()) {
				for (BookComment comment : commentList) {
					System.out.println("���۱�ţ�"+ comment.getCommentId());
					System.out.println("�����ţ�"+ comment.getOrderId());
					System.out.println("ͼ���ţ�"+ comment.getBookId());
					System.out.println("���۷�����"+ comment.getCommentScore());
					System.out.println("�������ݣ�"+ comment.getCommentContent());
					System.out.println("============================");
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
}
