package com.myWeb.www.repository;

import java.util.List;


import com.myWeb.www.domain.fileVO;

public interface FileDAO {

	int insertFile(fileVO fvo);

	List<fileVO> getFlist(int bno);

	int fileRemove(String uuid);

	int removeAllFile(int bno);

	List<fileVO> selectListAllFiles();

	

}
