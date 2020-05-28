package myCollection.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import myCollection.dao.MyCollectionDao;
import myCollection.model.CollectionBean;
import myCollection.model.UpdateCollectionsException;

@Service
@Transactional
@EnableTransactionManagement
public class MyCollectionServiceImpl implements MyCollectionService {
	
	@Autowired
	private MyCollectionDao collectionDao;


	@Override
	public Map<Integer, List<CollectionBean>> queryCollections(Integer memberRegNo) {
		return collectionDao.queryCollections(memberRegNo);
	}

	@Override
	public void updateCollectionGroup(String newCollectGName, Integer collectGNo) throws UpdateCollectionsException {
		collectionDao.updateCollectionGroup(newCollectGName, collectGNo);
	}

	@Override
	public void delCollectionGroup(Integer collectGNo) throws UpdateCollectionsException {
		 collectionDao.delCollectionGroup(collectGNo);
	}

	@Override
	public Map<Long, String> queryCollectionGroups(Integer memberRegNo) {
		return collectionDao.queryCollectionGroups(memberRegNo);
	}

	@Override
	public void insertCollectionGroup(Integer memberRegNo, String newCollectGName) {
		collectionDao.insertCollectionGroup(memberRegNo, newCollectGName);
	}

	@Override
	public void delCollectionDetail(Integer collectNo) throws UpdateCollectionsException {
		collectionDao.delCollectionDetail(collectNo);
	}

	@Override
	public void insertCollection(Integer memberRegNo, Integer publishNo) {
		collectionDao.insertCollection(memberRegNo, publishNo);
		
	}

	@Override
	public void delCollectionDetailBySkill(Integer memberRegNo, Integer publishNo) throws UpdateCollectionsException {
		collectionDao.delCollectionDetailBySkill(memberRegNo, publishNo);
		int collectGNo = collectionDao.queryUncatogryColletions(memberRegNo);
		if(collectGNo!=0) {
			collectionDao.delCollectionGroup(collectGNo);
		}
	}

	@Override
	public void changeCollectionGroup(Integer collectNo, Integer newCollectGNo) throws UpdateCollectionsException {
		collectionDao.changeCollectionGroup(collectNo, newCollectGNo);
	};

}
