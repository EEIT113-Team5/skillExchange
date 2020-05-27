package myPublish.Service;

import java.util.List;

import myPublish.Model.MyPublishBean;

public interface imyPublishService {

	List<MyPublishBean> myPublish(int memberRegNo);

	boolean myPubDele(int myPubNo);

	MyPublishBean selUpdatePublish(int myPubNo);

	MyPublishBean datePublish(MyPublishBean bean);

	List<MyPublishBean> myPublishImformation(int publishNo);

}