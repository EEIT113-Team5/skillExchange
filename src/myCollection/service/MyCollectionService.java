package myCollection.service;

import java.util.List;
import java.util.Map;

import myCollection.model.CollectionBean;
import myCollection.model.UpdateCollectionsException;

public interface MyCollectionService {
	public Map<Long, String> queryCollectionGroups(Integer memberRegNo);
	Map<Integer, List<CollectionBean>> queryCollections(Integer memberRegNo);
	void updateCollectionGroup(String newCollectGName,Integer collectGNo) throws UpdateCollectionsException;
	void delCollectionGroup(Integer collectGNo) throws UpdateCollectionsException;
	void insertCollectionGroup(Integer memberRegNo,String newCollectGName);
	void delCollectionDetail(Integer collectNo) throws UpdateCollectionsException;
	void insertCollection(Integer memberRegNo,Integer publishNo);
	void delCollectionDetailBySkill(Integer memberRegNo,Integer publishNo) throws UpdateCollectionsException;
	void changeCollectionGroup(Integer collectNo,Integer newCollectGNo) throws UpdateCollectionsException;
	
}