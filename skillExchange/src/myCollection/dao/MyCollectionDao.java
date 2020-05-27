package myCollection.dao;

import java.util.List;
import java.util.Map;

import myCollection.model.CollectionBean;
import myCollection.model.UpdateCollectionsException;

public interface MyCollectionDao {

	public Map<Long, String> queryCollectionGroups(Integer memberRegNo);
	Integer queryUncatogryColletions(Integer memberRegNo);
	Map<Integer, List<CollectionBean>> queryCollections(Integer memberRegNo);
	void updateCollectionGroup(String newCollectGName, Integer collectGNo) throws UpdateCollectionsException;
	void delCollectionGroup(Integer collectGNo) throws UpdateCollectionsException;
	void delCollectionDetail(Integer collectNo) throws UpdateCollectionsException;
	void delCollectionDetailBySkill(Integer memberRegNo,Integer publishNo);
	void insertCollectionGroup(Integer memberRegNo,String newCollectGName);
	void insertCollection(Integer memberRegNo,Integer publishNo);
	void changeCollectionGroup(Integer collectNo,Integer newCollectGNo) throws UpdateCollectionsException;

}