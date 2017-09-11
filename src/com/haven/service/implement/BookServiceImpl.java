package com.haven.service.implement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haven.bean.PageBean;
import com.haven.dao.BookCommentDAO;
import com.haven.dao.BookDAO;
import com.haven.model.Book;
import com.haven.model.BookComment;
import com.haven.service.interfaces.BookService;

@Service("bookService")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class BookServiceImpl implements BookService {

	@Resource(name="bookDao")
	private BookDAO bookDao;
//	public void setBookDao(BookDAO bookDao) {
//		this.bookDao = bookDao;
//	}
	
	@Override
	public boolean addBook(List<Book> bookList) {
		if(bookList == null || bookList.size() == 0)
			return false;
		boolean flag = false;
		if(bookList.size() == 1) {
			// ��������
			Book book = bookList.get(0);
			// �ж�ͼ���Ƿ����
			Book b = isExisted(book);
			int retCount = 0;
			if(b != null) {
				// ���ڣ��޸Ŀ����
				retCount = bookDao.update(b);
			} else {
				// �����ڣ�����ͼ��
				retCount = bookDao.insertOne(book);
			}
			flag = retCount>0 ? true : false;
		} else {
			// ��������
			int length = bookList.size();
			for (int i = length-1; i >=0; i--) {
				Book book = bookList.get(i);
				Book b = isExisted(book);
				if(b != null) {
					// ���ڣ��޸Ŀ�������Ƴ�
					if(bookDao.update(b) <= 0)
						return false;// ���޸�ʧ�ܣ�����false��
					bookList.remove(i);
				}
			}
			// �������Ѵ��ڵ�ͼ�飬��ʽ��������
			flag = bookDao.insertBatch(bookList)==bookList.size() ? true : false;
		}
		
		return flag;
	}
	
	// �ж�ͼ���Ƿ���ڣ��������޸�ͼ������������
	private Book isExisted(Book book) {
		Book b = bookDao.isExisted(book);
		if(b != null) {
			// ���ڣ��޸Ŀ����������
			b.setBookSumNum(b.getBookSumNum() + book.getBookSumNum());
			return b;
		}
		
		return null;
	}

	@Override
	public boolean deleteBook(String[] ids) {
		if(ids == null || ids.length <=0)
			return false;
		boolean flag = false;
		if(ids.length == 1) {
			// ����ɾ��
			int id = Integer.parseInt(ids[0]);
			flag = bookDao.deleteOne(id)>0 ? true : false;
		} else {
			// ����ɾ��
			int[] idss = new int[ids.length];
			for(int i = 0; i < ids.length; i++)
				idss[i] = Integer.parseInt(ids[i]);
			flag = bookDao.deleteBatch(idss)==ids.length ? true : false;
		}
		
		return flag;
	}

	@Override
	public boolean updateBook(Book book) {
		int retCount = bookDao.update(book);
		return retCount>0 ? true : false;
	}

	@Override
	public Map<String, List<Book>> getInitBook(String storeName) {
		Map<String, List<Book>> map = new HashMap<String, List<Book>>();
		List<Book> newList = bookDao.getBookWithNew(storeName);
		List<Book> hotList = bookDao.getBookWithHotSale(storeName);
		if(newList != null && !newList.isEmpty() && hotList != null && !hotList.isEmpty()) {
			map.put("new", newList);
			map.put("hot", hotList);
			return map;
		}

		return null;
	}

	@Override
	public List<Book> searchBookByPage(String storeName, String bookName, String bookClass, String currentPage) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		PageBean pb = new PageBean();	// ������ҳ����
		pb.setCurrentPage(Integer.parseInt(currentPage));	// ���õ�ǰҳ
		Book book = new Book();	// ����ͼ�����
		book.setStoreName(storeName);	// ���ò�ѯ����
		book.setBookName(bookName);
		book.setBookClass(bookClass);
		// ��Ӳ���
		parameter.put("book", book);
		parameter.put("page", pb);
		// ��ѯͼ��
		List<Book> bookList = bookDao.getBookByPage(parameter);
		if(bookList != null && !bookList.isEmpty())
			return bookList;
		return null;
	}

	@Override
	public Book getBookInfo(String bookId) {
		return bookDao.getBookInfo(Integer.parseInt(bookId));
	}

	// ��ͼ�����۱�Ĳ���
	
	@Resource(name="commentDao")
	private BookCommentDAO commentDao;
//	public void setCommentDao(BookCommentDAO commentDao) {
//		this.commentDao = commentDao;
//	}
	
	@Override
	public List<BookComment> getComment(String userName, String bookId) {
		BookComment comment = new BookComment();
		comment.setUserName(userName);
		comment.setBookId(Integer.parseInt(bookId));
		List<BookComment> commentList = commentDao.getComment(comment);
		if(commentList != null && !commentList.isEmpty())
			return commentList;
		return null;
	}

	@Override
	public boolean addComment(BookComment comment) {
		int retCount = commentDao.insert(comment);
		return retCount>0 ? true : false;
	}

	@Override
	public boolean deleteComment(String[] ids) {
		if(ids == null || ids.length <= 0)
			return false;
		boolean flag = false;
		if(ids.length == 1) {
			// ����ɾ��
			int id = Integer.parseInt(ids[0]);
			flag = commentDao.deleteOne(id)>0 ? true : false;
		} else {
			// ����ɾ��
			int[] idss = new int[ids.length];
			for(int i = 0; i < ids.length; i++)
				idss[i] = Integer.parseInt(ids[i]);
			flag = commentDao.deleteBatch(idss)==ids.length ? true : false;
		}
		
		return flag;
	}
	
}
