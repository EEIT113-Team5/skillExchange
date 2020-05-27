package myPublish.Model;

import java.util.List;

public interface iMyPublishDao {

	List<MyPublishBean> myPublish(int memberRegNo);

	boolean myPubDele(int myPubNo);

	MyPublishBean selUpdatePublish(int myPubNo);

	MyPublishBean datePublish(MyPublishBean bean);

	List<MyPublishBean> myPublishImformation(int publishNo);

}