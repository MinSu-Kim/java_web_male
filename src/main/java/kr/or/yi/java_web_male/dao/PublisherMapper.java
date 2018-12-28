package kr.or.yi.java_web_male.dao;

import java.util.List;

import kr.or.yi.java_web_male.dto.Publisher;

public interface PublisherMapper {
	List<Publisher> selectPublisherByAll();

	Publisher selectPublisherByNo(Publisher publisher);

	Publisher selectPublisherByName(Publisher publisher);

	int insertPublisher(Publisher publisher);
}
